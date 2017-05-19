package com.fiuady.hadp.homecontrol;

import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Hab2Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class Hab2Fragment extends Fragment {

   // private OnFragmentInteractionListener mListener;

    public Hab2Fragment() {
        // Required empty public constructor
    }

    private View view;
    private Switch vent2, luzhab2;
    private String color = "R2255255255.";
    private BluetoothSocket connectedSocket;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View rootView = inflater.inflate(R.layout.fragment_hab2, container, false);

        view = rootView.findViewById(R.id.color_picker2);
        luzhab2 = (Switch) rootView.findViewById(R.id.luz_hab1_switch);

        luzhab2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(luzhab2.isChecked()){
                    SendCommand(color);
                }
                else{
                    SendCommand("R2d.");
                }
            }
        });



        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ColorPickerDialogBuilder
                        .with(getContext())
                        .setTitle("Choose color")
                        .initialColor(0xffffffff)
                        .lightnessSliderOnly()
                        .wheelType(ColorPickerView.WHEEL_TYPE.FLOWER)
                        .density(15)
                        .setOnColorSelectedListener(new OnColorSelectedListener() {
                            @Override
                            public void onColorSelected(int selectedColor) {
                                colorString(selectedColor);
                            }
                        })
                        .setPositiveButton("ok", new ColorPickerClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int selectedColor, Integer[] allColors) {
                                change_color(selectedColor);
                                colorString(selectedColor);
                            }
                        })
                        .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .build()
                        .show();

            }
        });
        return rootView;

    }

    public void change_color(int colorSelected){
        view.setBackgroundColor(colorSelected);
    }

    public void colorString(int selectedColor){
        int r = Integer.valueOf(((Integer.toHexString(selectedColor)).substring(2,4)),16);
        int v = Integer.valueOf(((Integer.toHexString(selectedColor)).substring(4,6)),16);
        int a = Integer.valueOf(((Integer.toHexString(selectedColor)).substring(6)),16);
        String rojo, verde, azul;

        if (r<100){
            rojo = "0"+Integer.toString(r);
        }else{rojo = Integer.toString(r);}
        if(v<100){
            verde = "0"+Integer.toString(v);
        }else{ verde = Integer.toString(v);}
        if (a<100){
            azul = "0"+Integer.toString(a);
        }else{ azul = Integer.toString(a);}

        color = "R2"+rojo+verde+azul+".";
        if(luzhab2.isChecked()) {
            SendCommand(color);
        }else{SendCommand("R2d.");}
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
