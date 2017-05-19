package com.fiuady.hadp.homecontrol;

import android.app.AlertDialog;
import android.app.Dialog;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FrenteFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class FrenteFragment extends Fragment {

    //private OnFragmentInteractionListener mListener;
    public static class mDialogFragment extends DialogFragment{
        static mDialogFragment newInstance(){
            mDialogFragment dF = new mDialogFragment();
            return dF;
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final EditText et = new EditText(getContext());
            et.setInputType(InputType.TYPE_CLASS_NUMBER);
            et.setTransformationMethod(PasswordTransformationMethod.getInstance());
            return new AlertDialog.Builder(getActivity())
                    .setTitle("Escriba su PIN")
                    .setView(et)
                    .setIcon(R.drawable.ic_key)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(getContext(), "PIN Introducido: " + et.getText().toString(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setCancelable(false)
                    .create();
        }
    }

    public FrenteFragment() {
        // Required empty public constructor
    }

    private Switch luzfrente, puerta;
    private SeekBar intensidad;
    private BluetoothSocket connectedSocket;
    private int valor = 255;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_frente, container, false);
        puerta = (Switch) rootView.findViewById(R.id.frente_sw);
        luzfrente = (Switch) rootView.findViewById(R.id.luz_frente_sw);
        intensidad = (SeekBar) rootView.findViewById(R.id.int_bar);

        luzfrente.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (luzfrente.isChecked()) {
                    SendCommand("L1"+valor+".");
                } else {
                    SendCommand("L1d.");
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
                valor = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        puerta.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (puerta.isChecked()){
                    mDialogFragment fragment = mDialogFragment.newInstance();
                    fragment.show(getFragmentManager(), "PIN");
                }else{

                }
            }
        });


        return rootView;
    }

    public void SendCommand(String command){
        connectedSocket = ((MainActivity)getActivity()).Socket();
        try {
            if ((connectedSocket != null) && (connectedSocket.isConnected())) {
                String toSend = command.trim();

                if (toSend.length() > 0) {
                    // TBI - This object "should" be a member variable
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(connectedSocket.getOutputStream()));
                    bw.write(toSend);
                    bw.write("\r\n");
                    bw.flush();

                    Toast.makeText(getContext(), "[Enviado] " + toSend, Toast.LENGTH_SHORT).show();
                }

            } else {
                Toast.makeText(getContext(), "[Error] La conexión no parece estar activa!", Toast.LENGTH_SHORT).show();
            }
        } catch (IOException e) {
            Toast.makeText(getContext(), "[Error] Ocurrió un problema durante el envío de datos!", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    public void PinCancel(){
        puerta.setChecked(false);
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