package com.fiuady.hadp.homecontrol;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.InputFilter;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.widget.EditText;

/**
 * Created by Wilberth on 21/05/2017.
 */

public class mDialogFragment extends DialogFragment {

    private mDialogFragmentListener callback;

    public interface mDialogFragmentListener {
        public void pinswitch(String pin);
    }

    static mDialogFragment newInstance(){
        mDialogFragment dF = new mDialogFragment();
        return dF;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try{
            callback = (mDialogFragmentListener)getTargetFragment();
        }catch (ClassCastException e){
            throw new ClassCastException("Calling Fragment must implement mDialogFragmentListener");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final EditText et = new EditText(getContext());
        et.setInputType(InputType.TYPE_CLASS_NUMBER);
        et.setTransformationMethod(PasswordTransformationMethod.getInstance());
        et.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
        return new AlertDialog.Builder(getActivity())
                .setTitle("Escriba su PIN")
                .setView(et)
                .setIcon(R.drawable.ic_key)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        callback.pinswitch(et.getText().toString());
                    }
                })
                .setCancelable(false)
                .create();
    }
}