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
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AlarmsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class AlarmsFragment extends Fragment {

    // private OnFragmentInteractionListener mListener;

    public AlarmsFragment() {
        // Required empty public constructor
    }

    private Switch all, prtaf, cochera, vents, vent1, vent2, pir;
    private BluetoothSocket connectedSocket;
    private String ini = "Aa000000.";
    private Button off;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        connectedSocket = ((MainActivity) getActivity()).Socket();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_alarms, container, false);
        all = (Switch) rootView.findViewById(R.id.all_sw);

        prtaf = (Switch) rootView.findViewById(R.id.p_princ_sw);
        cochera = (Switch) rootView.findViewById(R.id.cochera_sw);
        vents = (Switch) rootView.findViewById(R.id.vent_sala_sw);
        vent1 = (Switch) rootView.findViewById(R.id.vent_hab1_sw);
        vent2 = (Switch) rootView.findViewById(R.id.vent_hab2_sw);
        pir = (Switch) rootView.findViewById(R.id.sens_mov_sw);
        off = (Button) rootView.findViewById(R.id.btn_desact);

        all.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (all.isChecked()) {
                    prtaf.setEnabled(false);
                    cochera.setEnabled(false);
                    vents.setEnabled(false);
                    vent1.setEnabled(false);
                    vent2.setEnabled(false);
                    pir.setEnabled(false);
                    ini = "Aa111111.";
                    SendCommand(ini);
                } else {
                    prtaf.setEnabled(true);
                    cochera.setEnabled(true);
                    vents.setEnabled(true);
                    vent1.setEnabled(true);
                    vent2.setEnabled(true);
                    pir.setEnabled(true);

                    if (prtaf.isChecked()) {
                        newcommand(7, true);
                    } else {
                        newcommand(7, false);
                    }
                    if (cochera.isChecked()) {
                        newcommand(6, true);
                    } else {
                        newcommand(6, false);
                    }
                    if (vents.isChecked()) {
                        newcommand(5, true);
                    } else {
                        newcommand(5, false);
                    }
                    if (vent1.isChecked()) {
                        newcommand(4, true);
                    } else {
                        newcommand(4, false);
                    }
                    if (vent2.isChecked()) {
                        newcommand(3, true);
                    } else {
                        newcommand(3, false);
                    }
                    if (pir.isChecked()) {
                        newcommand(2, true);
                    } else {
                        newcommand(2, false);
                    }
                }
            }
        });

        prtaf.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (prtaf.isChecked()) {
                    newcommand(7, true);
                } else {
                    newcommand(7, false);
                }
            }
        });

        cochera.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (cochera.isChecked()) {
                    newcommand(6, true);
                } else {
                    newcommand(6, false);
                }
            }
        });

        vents.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (vents.isChecked()) {
                    newcommand(5, true);
                } else {
                    newcommand(5, false);
                }
            }
        });

        vent1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (vent1.isChecked()) {
                    newcommand(4, true);
                } else {
                    newcommand(4, false);
                }
            }
        });

        vent2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (vent2.isChecked()) {
                    newcommand(3, true);
                } else {
                    newcommand(3, false);
                }
            }
        });

        pir.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (pir.isChecked()) {
                    newcommand(2, true);
                } else {
                    newcommand(2, false);
                }
            }
        });

        off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SendCommand("Ad.");
            }
        });

        return rootView;
    }

    public void newcommand(int n, boolean chk) {
        String aux = "";
        for (int i = 0; i < ini.length(); i++) {
            if (i != n) {
                aux += ini.charAt(i);
            } else {
                if (chk) {
                    aux += "1";
                } else {
                    aux += "0";
                }
            }
        }
        ini = aux;
        SendCommand(ini);
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

    //// TODO: Rename method, update argument and hook method into UI event
    //public void onButtonPressed(Uri uri) {
    //    if (mListener != null) {
    //        mListener.onFragmentInteraction(uri);
    //    }
    //}
//
    //@Override
    //public void onAttach(Context context) {
    //    super.onAttach(context);
    //    if (context instanceof OnFragmentInteractionListener) {
    //        mListener = (OnFragmentInteractionListener) context;
    //    } else {
    //        throw new RuntimeException(context.toString()
    //                + " must implement OnFragmentInteractionListener");
    //    }
    //}
//
    //@Override
    //public void onDetach() {
    //    super.onDetach();
    //    mListener = null;
    //}
//
    ///**
    // * This interface must be implemented by activities that contain this
    // * fragment to allow an interaction in this fragment to be communicated
    // * to the activity and potentially other fragments contained in that
    // * activity.
    // * <p>
    // * See the Android Training lesson <a href=
    // * "http://developer.android.com/training/basics/fragments/communicating.html"
    // * >Communicating with Other Fragments</a> for more information.
    // */
    //public interface OnFragmentInteractionListener {
    //    // TODO: Update argument type and name
    //    void onFragmentInteraction(Uri uri);
    //}
}
