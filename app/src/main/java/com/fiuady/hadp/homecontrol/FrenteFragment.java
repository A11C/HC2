package com.fiuady.hadp.homecontrol;

import android.app.AlertDialog;
import android.app.Dialog;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentContainer;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;

import com.fiuady.db.Area_frente;
import com.fiuady.db.Home;
import com.fiuady.db.Pin_puerta;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FrenteFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class FrenteFragment extends Fragment implements mDialogFragment.mDialogFragmentListener {

    //private OnFragmentInteractionListener mListener;

    public FrenteFragment() {
        // Required empty public constructor
    }

    private Switch luzfrente, puerta;
    private SeekBar intensidad;
    private BluetoothSocket connectedSocket;
    private CheckBox chksens;
    private int valor = 255;
    private Home home;
    private int perfid;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        connectedSocket = ((MainActivity)getActivity()).Socket();
        perfid = getArguments().getInt("perf");
        home = new Home(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_frente, container, false);
        puerta = (Switch) rootView.findViewById(R.id.frente_sw);
        luzfrente = (Switch) rootView.findViewById(R.id.luz_frente_sw);
        intensidad = (SeekBar) rootView.findViewById(R.id.int_bar);
        chksens =(CheckBox) rootView.findViewById(R.id.luz_amb_chk);

        ArrayList<Area_frente> area_frentes = new ArrayList<>(home.getAllFrente(perfid));
        Area_frente area_frente = area_frentes.get(0);

        valor = Integer.valueOf(area_frente.getIntensidad());
        intensidad.setProgress(valor);
        if(area_frente.getLuz().equals("L1d.")){
            luzfrente.setChecked(false);
        }else{
            luzfrente.setChecked(true);
        }

        luzfrente.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (luzfrente.isChecked()) {
                    SendCommand("L1"+valor+".");
                    home.updateFrenteLuz(perfid,"L1a");
                } else {
                    SendCommand("L1d.");
                    home.updateFrenteLuz(perfid,"L1d.");
                }
            }
        });
        intensidad.setMax(255);
        intensidad.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (luzfrente.isChecked()) {
                    SendCommand("L1"+i+".");
                }
                home.updateFrenteIntensidad(perfid,String.valueOf(i));
                valor = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        if(area_frente.getPuerta().equals("S1c.")){
            puerta.setChecked(false);
        }else{
            puerta.setChecked(true);
        }
        puerta.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (puerta.isChecked()){
                    mDialogFragment fragment = mDialogFragment.newInstance();
                    fragment.setTargetFragment(FrenteFragment.this,0);
                    fragment.show(getFragmentManager(), "PIN");
                }else{
                    SendCommand("S1c.");
                    home.updateFrentePuerta(perfid,"S1c.");
                }
            }
        });

        if(area_frente.getSensor().equals("Dia.")){
            chksens.setChecked(true);
        }else{
            chksens.setChecked(false);
        }
        chksens.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(chksens.isChecked()){
                    SendCommand("D1a.");
                    home.updateFrenteSensor(perfid,"D1a.");
                }else{
                    SendCommand("D1d.");
                    home.updateFrenteSensor(perfid,"D1d.");
                }
            }
        });

        return rootView;
    }

    @Override
    public void pinswitch(String pin) {
        ArrayList<Pin_puerta> pin_puertas = new ArrayList<>(home.getAllPines(((MainActivity)getActivity()).getuserid()));
        Pin_puerta pin_puerta = pin_puertas.get(0);
        if(pin.equals(pin_puerta.getPin())){
            SendCommand("S1a.");
            home.updateFrentePuerta(perfid,"S1a.");
        }else{
            puerta.setChecked(false);
        }
    }


    public void SendCommand(String command){
        try {
            if ((connectedSocket != null) && (connectedSocket.isConnected())) {
                String toSend = command.trim();

                if (toSend.length() > 0) {
                    // TBI - This object "should" be a member variable
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(connectedSocket.getOutputStream()));
                    bw.write(toSend);
                    bw.write("\r\n");
                    bw.flush();

                }

            } else {
                Toast.makeText(getContext(), "[Error] La conexión no parece estar activa!", Toast.LENGTH_SHORT).show();
            }
        } catch (IOException e) {
            Toast.makeText(getContext(), "[Error] Ocurrió un problema durante el envío de datos!", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    // // TODO: Rename method, update argument and hook method into UI event
    // public void onButtonPressed(Uri uri) {
    //     if (mListener != null) {
    //         mListener.onFragmentInteraction(uri);
    //     }
    // }
//
    // @Override
    // public void onAttach(Context context) {
    //     super.onAttach(context);
    //     if (context instanceof OnFragmentInteractionListener) {
    //         mListener = (OnFragmentInteractionListener) context;
    //     } else {
    //         throw new RuntimeException(context.toString()
    //                 + " must implement OnFragmentInteractionListener");
    //     }
    // }
//
    // @Override
    // public void onDetach() {
    //     super.onDetach();
    //     mListener = null;
    // }
//
    // /**
    //  * This interface must be implemented by activities that contain this
    //  * fragment to allow an interaction in this fragment to be communicated
    //  * to the activity and potentially other fragments contained in that
    //  * activity.
    //  * <p>
    //  * See the Android Training lesson <a href=
    //  * "http://developer.android.com/training/basics/fragments/communicating.html"
    //  * >Communicating with Other Fragments</a> for more information.
    //  */
    // public interface OnFragmentInteractionListener {
    //     // TODO: Update argument type and name
    //     void onFragmentInteraction(Uri uri);
    // }
}