package com.fiuady.hadp.homecontrol;

import android.app.AlertDialog;
import android.app.Dialog;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.fiuady.db.Area_sala;
import com.fiuady.db.Home;
import com.fiuady.db.Pin_puerta;

import org.w3c.dom.Text;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SalaFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class SalaFragment extends Fragment implements mDialogFragment.mDialogFragmentListener{

    public SalaFragment() {
        // Required empty public constructor
    }

    private BluetoothSocket connectedSocket;

    private Switch puertas, vents;
    private TextView pir, temp;
    private int perfid;
    private Home home;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        connectedSocket = ((MainActivity)getActivity()).Socket();
        perfid = getArguments().getInt("perfid");
        home = new Home(getContext());
        SendCommand("T4a.");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sala, container, false);

        puertas = (Switch) rootView.findViewById(R.id.sala_frente_sw);
        vents = (Switch) rootView.findViewById(R.id.ventana_sala_switch);

        pir = (TextView) rootView.findViewById(R.id.sensor_mov_text);
        temp = (TextView) rootView.findViewById(R.id.act_temp_sala_text);

        ArrayList<Area_sala> area_salas = new ArrayList<>(home.getAllSala(perfid));
        Area_sala area_sala = area_salas.get(0);

        if(area_sala.getPuerta().equals("S1c.")){
            puertas.setChecked(false);
        }else{
            puertas.setChecked(true);
        }

        puertas.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(puertas.isChecked()){
                    mDialogFragment fragment = mDialogFragment.newInstance();
                    fragment.setTargetFragment(SalaFragment.this,0);
                    fragment.show(getFragmentManager(), "PIN");
                }else{
                    SendCommand("S1c.");
                }
            }
        });

        return rootView;
    }

    public void state_change(String text){
        if(text.equals("RS4A")) {
            vents.setText("Abierta");
        }else if(text.equals("RS4C")){
            vents.setText("Cerrada");
        }
    }

    public void temp_change(String text){
        temp.setText(text + " °C");
    }

    public void pir_change(String text){
        if (text.equals("PIRa")){
            pir.setText("Hay movimiento");
        }else{
            pir.setText("No hay movimiento");
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
    public void pinswitch(String pin) {
        ArrayList<Pin_puerta> pin_puertas = new ArrayList<>(home.getAllPines(((MainActivity)getActivity()).getuserid()));
        Pin_puerta pin_puerta = pin_puertas.get(0);
        if(pin.equals(pin_puerta.getPin())){
            SendCommand("S1a.");
        }else{
            puertas.setChecked(false);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        SendCommand("T4d.");
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
