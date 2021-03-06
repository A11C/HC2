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

import com.fiuady.db.Alarmas;
import com.fiuady.db.Home;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


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

    private int perfid;
    private Home home;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        connectedSocket = ((MainActivity) getActivity()).Socket();
        perfid = getArguments().getInt("perfid");
        home = new Home(getContext());
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

        ArrayList<Alarmas> alarmases = new ArrayList<>(home.getAlmarmas(perfid));
        Alarmas alarmas = alarmases.get(0);

        ini = "Aa"+alarmas.getSensor()+alarmas.getHabitacion2()+alarmas.getHabitacion1()+alarmas.getSala()+alarmas.getCochera()+alarmas.getPuerta()+".";

        if(alarmas.getPuerta().equals("1")){
            prtaf.setChecked(true);
            newcommand(3, true);
        }else{
            prtaf.setChecked(false);
            newcommand(3, false);
        }
        if(alarmas.getCochera().equals("1")){
            cochera.setChecked(true);
            newcommand(7, true);
        }else{
            cochera.setChecked(false);
            newcommand(7, false);
        }
        if(alarmas.getSala().equals("1")){
            vents.setChecked(true);
            newcommand(5, true);
        }else{
            vents.setChecked(false);
            newcommand(5, false);
        }
        if(alarmas.getHabitacion1().equals("1")){
            vent1.setChecked(true);
            newcommand(4, true);
        }else{
            vent1.setChecked(false);
            newcommand(4, false);
        }
        if(alarmas.getHabitacion2().equals("1")){
            vent2.setChecked(true);
            newcommand(5, true);
        }else{
            vent2.setChecked(false);
            newcommand(5, false);
        }
        if(alarmas.getSensor().equals("1")){
            pir.setChecked(true);
            newcommand(2, true);
        }else{
            pir.setChecked(false);
            newcommand(2, false);
        }


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
                        newcommand(3, true);
                    } else {
                        newcommand(3, false);
                    }
                    if (cochera.isChecked()) {
                        newcommand(7, true);
                    } else {
                        newcommand(7, false);
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
                        newcommand(6, true);
                    } else {
                        newcommand(6, false);
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
                    newcommand(3, true);
                    home.updateAlarmaPuerta(perfid,"1");
                } else {
                    newcommand(3, false);
                    home.updateAlarmaPuerta(perfid,"0");
                }
            }
        });

        cochera.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (cochera.isChecked()) {
                    newcommand(7, true);
                    home.updateAlarmaCochera(perfid,"1");
                } else {
                    newcommand(7, false);
                    home.updateAlarmaCochera(perfid,"0");
                }
            }
        });

        vents.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (vents.isChecked()) {
                    newcommand(6, true);
                    home.updateAlarmaSala(perfid,"1");
                } else {
                    newcommand(6, false);
                    home.updateAlarmaSala(perfid,"0");
                }
            }
        });

        vent1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (vent1.isChecked()) {
                    newcommand(4, true);
                    home.updateAlarmaHab1(perfid,"1");
                } else {
                    newcommand(4, false);
                    home.updateAlarmaHab1(perfid,"0");
                }
            }
        });

        vent2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (vent2.isChecked()) {
                    newcommand(5, true);
                    home.updateAlarmaHab2(perfid,"1");
                } else {
                    newcommand(5, false);
                    home.updateAlarmaHab2(perfid,"0");
                }
            }
        });

        pir.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (pir.isChecked()) {
                    newcommand(2, true);
                    home.updateAlarmaSensor(perfid,"1");
                } else {
                    newcommand(2, false);
                    home.updateAlarmaSensor(perfid,"0");
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
