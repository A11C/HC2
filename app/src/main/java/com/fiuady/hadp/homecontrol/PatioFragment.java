package com.fiuady.hadp.homecontrol;

import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PatioFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class PatioFragment extends Fragment {

  //  private OnFragmentInteractionListener mListener;

    public PatioFragment() {
        // Required empty public constructor
    }

    private Switch exts, piscs, vents;
    private SeekBar extsb, piscsb;
    private CheckBox extchk, piscchk;
    private TextView temptext;
    private int intext = 255, intpisc = 255;

    private BluetoothSocket connectedSocket;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_patio, container, false);
        exts = (Switch) rootView.findViewById(R.id.luz_ext_sw);
        piscs = (Switch) rootView.findViewById(R.id.luz_pisc_sw);
        vents = (Switch) rootView.findViewById(R.id.ventana1_switch);

        extsb = (SeekBar) rootView.findViewById(R.id.int_ext_bar);
        extsb.setMax(255);
        piscsb = (SeekBar) rootView.findViewById(R.id.int_pisc_bar);
        piscsb.setMax(255);

        extchk = (CheckBox) rootView.findViewById(R.id.luz_amb_ext_chk);
        piscchk = (CheckBox) rootView.findViewById(R.id.luz_amb_pisc_chk);

        temptext =(TextView) rootView.findViewById(R.id.act_temp_patio_text);

        exts.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (exts.isChecked()){

                }else{

                }
            }
        });

        piscs.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (piscs.isChecked()){

                }else{

                }
            }
        });

        vents.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(vents.isChecked()){

                }else{

                }
            }
        });

        extsb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (exts.isChecked()){

                }
                intext = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        piscsb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if(piscs.isChecked()){

                }
                intpisc = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        extchk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(extchk.isChecked()){

                }else{

                }
            }
        });

        piscchk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (piscchk.isChecked()){

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

  //  // TODO: Rename method, update argument and hook method into UI event
  //  public void onButtonPressed(Uri uri) {
  //      if (mListener != null) {
  //          mListener.onFragmentInteraction(uri);
  //      }
  //  }
//
  //  @Override
  //  public void onAttach(Context context) {
  //      super.onAttach(context);
  //      if (context instanceof OnFragmentInteractionListener) {
  //          mListener = (OnFragmentInteractionListener) context;
  //      } else {
  //          throw new RuntimeException(context.toString()
  //                  + " must implement OnFragmentInteractionListener");
  //      }
  //  }
//
  //  @Override
  //  public void onDetach() {
  //      super.onDetach();
  //      mListener = null;
  //  }
//
  //  /**
  //   * This interface must be implemented by activities that contain this
  //   * fragment to allow an interaction in this fragment to be communicated
  //   * to the activity and potentially other fragments contained in that
  //   * activity.
  //   * <p>
  //   * See the Android Training lesson <a href=
  //   * "http://developer.android.com/training/basics/fragments/communicating.html"
  //   * >Communicating with Other Fragments</a> for more information.
  //   */
  //  public interface OnFragmentInteractionListener {
  //      // TODO: Update argument type and name
  //      void onFragmentInteraction(Uri uri);
  //  }
}
