package com.fiuady.hadp.homecontrol;

import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.NumberPicker;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.flask.colorpicker.ColorPickerPreference;
import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Hab1Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class Hab1Fragment extends Fragment {

    // private OnFragmentInteractionListener mListener;

    public Hab1Fragment() {
        // Required empty public constructor
    }

    private View view;
    private Switch vent1, luzhab1, venti1s, venticonts;
    private NumberPicker tempmin, tempmax;
    private String color = "R1255255255.";
    private TextView temp;
    private BluetoothSocket connectedSocket;

    private int valtemp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        connectedSocket = ((MainActivity) getActivity()).Socket();
        SendCommand("T1.");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_hab1, container, false);

        view = rootView.findViewById(R.id.color_picker1);
        vent1 = (Switch) rootView.findViewById(R.id.ventana1_switch);
        luzhab1 = (Switch) rootView.findViewById(R.id.luz_hab1_switch);
        venti1s = (Switch) rootView.findViewById(R.id.ventilador_hab1_switch);
        venticonts = (Switch) rootView.findViewById(R.id.ventilador_hab1_control);
        tempmin = (NumberPicker) rootView.findViewById(R.id.minhab1);
        tempmin.setMinValue(0);
        tempmin.setMaxValue(30);
        tempmin.setValue(10);
        tempmin.setWrapSelectorWheel(true);
        tempmax = (NumberPicker) rootView.findViewById(R.id.maxhab1);
        tempmax.setMinValue(31);
        tempmax.setMaxValue(50);
        tempmax.setValue(35);
        tempmax.setWrapSelectorWheel(true);
        temp = (TextView) rootView.findViewById(R.id.temp_hab1);

        luzhab1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (luzhab1.isChecked()) {
                    SendCommand(color);
                } else {
                    SendCommand("R1d.");
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

        venti1s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (venti1s.isChecked()) {
                    SendCommand("V1a.");
                } else {
                    SendCommand("V1d.");
                }
            }
        });

        tempmin.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                if (venticonts.isChecked()) {
                    SendCommand("V1M" + valtemp + ".");
                }
            }
        });

        tempmax.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                if (venticonts.isChecked()) {
                    if (valtemp<10) {
                        SendCommand("V1m0" + valtemp + ".");
                    }else {
                        SendCommand("V1m" + valtemp + ".");
                    }
                }
            }
        });

        return rootView;

    }

    public void state_change(String text){
        if(text.equals("RS1A")) {
            vent1.setText("Abierta");
            vent1.setChecked(true);
        }else if(text.equals("RS1C")){
            vent1.setText("Cerrada");
            vent1.setChecked(false);
        }
    }

    public void temp_change(String valor) {
        temp.setText(valor + " °C");
/*        valtemp = Integer.valueOf(valor);
        if (venticonts.isChecked()) {
            if (valtemp == tempmax.getValue()) {
                SendCommand("V1a.");
            } else if (valtemp == tempmin.getValue()) {
                SendCommand("V1d.");
            }
        }*/
    }

    public void change_color(int colorSelected) {
        view.setBackgroundColor(colorSelected);
    }

    public void colorString(int selectedColor) {
        int r = Integer.valueOf(((Integer.toHexString(selectedColor)).substring(2, 4)), 16);
        int v = Integer.valueOf(((Integer.toHexString(selectedColor)).substring(4, 6)), 16);
        int a = Integer.valueOf(((Integer.toHexString(selectedColor)).substring(6)), 16);
        String rojo, verde, azul;

        if (r < 100) {
            rojo = "0" + Integer.toString(r);
        } else {
            rojo = Integer.toString(r);
        }
        if (v < 100) {
            verde = "0" + Integer.toString(v);
        } else {
            verde = Integer.toString(v);
        }
        if (a < 100) {
            azul = "0" + Integer.toString(a);
        } else {
            azul = Integer.toString(a);
        }

        color = "R1" + rojo + verde + azul + ".";
        if (luzhab1.isChecked()) {
            SendCommand(color);
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        SendCommand("T1d.");
    }

    //    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
//    /**
//     * This interface must be implemented by activities that contain this
//     * fragment to allow an interaction in this fragment to be communicated
//     * to the activity and potentially other fragments contained in that
//     * activity.
//     * <p>
//     * See the Android Training lesson <a href=
//     * "http://developer.android.com/training/basics/fragments/communicating.html"
//     * >Communicating with Other Fragments</a> for more information.
//     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
}
