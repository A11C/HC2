package com.fiuady.hadp.homecontrol;

import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.NumberPicker;
import android.widget.Switch;
import android.widget.TextView;
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
    private Switch vent2, luzhab2, venti2s, venticonts;
    private NumberPicker tempmin, tempmax;
    private String color = "R2255255255.";
    private TextView temp;
    private BluetoothSocket connectedSocket;

    private float valtemp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        connectedSocket = ((MainActivity) getActivity()).Socket();
        SendCommand("T2a.");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_hab2, container, false);

        view = rootView.findViewById(R.id.color_picker2);

        vent2 = (Switch) rootView.findViewById(R.id.ventana2_switch);
        luzhab2 = (Switch) rootView.findViewById(R.id.luz_hab2_switch);
        venti2s = (Switch) rootView.findViewById(R.id.ventilador_hab2_switch);
        venticonts = (Switch) rootView.findViewById(R.id.ventilador_hab2_control);
        tempmin = (NumberPicker) rootView.findViewById(R.id.minhab2);
        tempmin.setMinValue(0);
        tempmin.setMaxValue(30);
        tempmin.setValue(10);
        tempmin.setWrapSelectorWheel(true);
        tempmax = (NumberPicker) rootView.findViewById(R.id.maxhab2);
        tempmax.setMinValue(31);
        tempmax.setMaxValue(50);
        tempmax.setValue(35);
        tempmax.setWrapSelectorWheel(true);
        temp = (TextView) rootView.findViewById(R.id.temp_hab2);

        luzhab2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (luzhab2.isChecked()) {
                    SendCommand(color);
                } else {
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

        venti2s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (venti2s.isChecked()) {
                    SendCommand("V2a.");

                } else {
                    SendCommand("V2d.");
                }
            }
        });

        venticonts.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(venticonts.isChecked()){
                    String min ="";
                    if (tempmin.getValue() < 10) {
                        min="0" + String.valueOf(tempmin.getValue());
                    } else {
                        min = String.valueOf(tempmin.getValue());
                    }
                    SendCommand("C2a"+min+tempmax.getValue()+".");
                }else{
                    SendCommand("C2d.");
                    SendCommand("V2d.");
                }
            }
        });

        tempmin.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                if (venticonts.isChecked()) {
                    String min ="";
                    if (tempmin.getValue() < 10) {
                        min="0" + String.valueOf(tempmin.getValue());
                    } else {
                        min = String.valueOf(tempmin.getValue());
                    }
                    SendCommand("C2a"+min+tempmax+".");
                }
            }
        });

        tempmax.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                if (venticonts.isChecked()) {
                    String min ="";
                    if (tempmin.getValue() < 10) {
                        min="0" + String.valueOf(tempmin.getValue());
                    } else {
                        min = String.valueOf(tempmin.getValue());
                    }
                    SendCommand("C2a"+min+tempmax+".");
                }
            }
        });


        return rootView;

    }

    public void state_change(String text){
        if(text.equals("RS3A")) {
            vent2.setText("Abierta");
            vent2.setChecked(true);
        }else if(text.equals("RS3C")){
            vent2.setText("Cerrada");
            vent2.setChecked(false);
        }
    }

    public void temp_change(String valor) {
        temp.setText(valor + " °C");
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

        color = "R2" + rojo + verde + azul + ".";
        if (luzhab2.isChecked()) {
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
        SendCommand("T2d.");
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
