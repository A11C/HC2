package com.fiuady.hadp.homecontrol;

import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CocheraFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class CocheraFragment extends Fragment implements mDialogFragment.mDialogFragmentListener {

    //   private OnFragmentInteractionListener mListener;

    public CocheraFragment() {
        // Required empty public constructor
    }

    private Switch puerta;
    private TextView estado;
    private BluetoothSocket connectedSocket;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        connectedSocket = ((MainActivity) getActivity()).Socket();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_cochera, container, false);
        puerta = (Switch) rootView.findViewById(R.id.cochera_switch);
        estado = (TextView) rootView.findViewById(R.id.cochera_estadotext);

        puerta.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (puerta.isChecked()) {
                    mDialogFragment fragment = mDialogFragment.newInstance();
                    fragment.setTargetFragment(CocheraFragment.this, 0);
                    fragment.show(getFragmentManager(), "PIN");
                } else {
                    SendCommand("S2c.");
                }
            }
        });


        return rootView;
    }

    @Override
    public void pinswitch(String pin) {
        if (pin.equals("1234")) {
            SendCommand("S2a.");
        } else {
            puerta.setChecked(false);
        }
    }

    public void state_change(String text) {
        if (text.equals("RS5A")) {
            estado.setText("Cerrada");
        } else if (text.equals("RS5C")) {
            estado.setText("Abierta");
        }
    }

    public void SendCommand(String command) {
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


    //   // TODO: Rename method, update argument and hook method into UI event
    //   public void onButtonPressed(Uri uri) {
    //       if (mListener != null) {
    //           mListener.onFragmentInteraction(uri);
    //       }
    //   }
//
    //   @Override
    //   public void onAttach(Context context) {
    //       super.onAttach(context);
    //       if (context instanceof OnFragmentInteractionListener) {
    //           mListener = (OnFragmentInteractionListener) context;
    //       } else {
    //           throw new RuntimeException(context.toString()
    //                   + " must implement OnFragmentInteractionListener");
    //       }
    //   }
//
    //   @Override
    //   public void onDetach() {
    //       super.onDetach();
    //       mListener = null;
    //   }
//
    //   /**
    //    * This interface must be implemented by activities that contain this
    //    * fragment to allow an interaction in this fragment to be communicated
    //    * to the activity and potentially other fragments contained in that
    //    * activity.
    //    * <p>
    //    * See the Android Training lesson <a href=
    //    * "http://developer.android.com/training/basics/fragments/communicating.html"
    //    * >Communicating with Other Fragments</a> for more information.
    //    */
    //   public interface OnFragmentInteractionListener {
    //       // TODO: Update argument type and name
    //       void onFragmentInteraction(Uri uri);
    //   }
}
