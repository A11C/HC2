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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.fiuady.db.Area_cochera;
import com.fiuady.db.Area_frente;
import com.fiuady.db.Area_hab1;
import com.fiuady.db.Area_hab2;
import com.fiuady.db.Area_patio;
import com.fiuady.db.Area_sala;
import com.fiuady.db.Home;
import com.fiuady.db.Perfiles;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PerfilFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class PerfilFragment extends Fragment {

  //  private OnFragmentInteractionListener mListener;

    private Home home;

    public PerfilFragment() {
        // Required empty public constructor
    }

    private BluetoothSocket connectedSocket;
    private ListView listView;
    private int userid;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userid = getArguments().getInt("userid");
        connectedSocket = ((MainActivity)getActivity()).Socket();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_perfil, container, false);
        home = new Home(getContext());

        listView = (ListView) rootView.findViewById(R.id.perfil_list);

        ArrayList<Perfiles> arrayList = new ArrayList<>(home.getAllPerfiles(((MainActivity)getActivity()).getuserid()));
        ArrayList<String> arrayList1 = new ArrayList<>();
        for(Perfiles perfiles : arrayList){
            arrayList1.add(perfiles.getDescripcion());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_checked,arrayList1);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int perfid = home.getIdPerfil(listView.getItemAtPosition(i).toString(),userid);
            //    ArrayList<Area_cochera> ac = new ArrayList<Area_cochera>( home.getAllCochera(perfid));
                ((MainActivity)getActivity()).setPerf_id(perfid);
            //    Area_cochera area_cochera = ac.get(0);
            //    SendCommand(area_cochera.getPuerta());
            //    ArrayList<Area_frente> af = new ArrayList<Area_frente>( home.getAllFrente(perfid));
            //    Area_frente area_frente = af.get(0);
            //    SendCommand(area_frente.getPuerta());
            //    SendCommand(area_frente.getLuz());
            //    SendCommand(area_frente.getSensor());
            //    SendCommand(area_frente.getIntensidad());
            //    ArrayList<Area_hab1> ah1 = new ArrayList<Area_hab1>(home.getAllHabitacion1(perfid));
            //    Area_hab1 area_hab1 = ah1.get(0);
            //    SendCommand(area_hab1.getLuz()+area_hab1.getVentilador());
            //    ArrayList<Area_hab2> ah2 = new ArrayList<Area_hab2>(home.getAllHabitacion2(perfid));
            //    Area_hab2 area_hab2 = ah2.get(0);
            //    SendCommand(area_hab2.getLuz()+ area_hab2.getVentilador());
            //    ArrayList<Area_patio> ap = new ArrayList<Area_patio>(home.getAllPatio(perfid));
            //    Area_patio area_patio = ap.get(0);
            //    SendCommand(area_patio.getLuzext()+area_patio.getSensorext()+area_patio.getLuzpisci());
            //    ArrayList<Area_sala> as = new ArrayList<Area_sala>(home.getAllSala(perfid));
            //    Area_sala area_sala = as.get(0);
            //    SendCommand(area_sala.getPuerta());
//

            }
        });

        return rootView;
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

 /*   // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    *//**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     *//*
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }*/
}
