package com.fiuady.hadp.homecontrol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fiuady.db.Home;
import com.fiuady.db.Cuenta;

public class LoginActivity extends AppCompatActivity {

    private Button btnlogin;
    private EditText user_name;
    private EditText pass_name;

    private int check;
    private int id_cuenta;

    private Home home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnlogin = (Button) findViewById(R.id.btn_login);
        user_name = (EditText) findViewById(R.id.user_text);
        pass_name = (EditText) findViewById(R.id.pass_text);

        home = new Home(getApplicationContext());

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                check = home.checkCuenta(user_name.getText().toString(), pass_name.getText().toString());
                if (check == 1) {
                    id_cuenta = home.getIdCuenta(user_name.getText().toString());
                    Toast.makeText(LoginActivity.this, "Cuenta Aceptada " + id_cuenta, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(LoginActivity.this, "Cuenta Rechazada", Toast.LENGTH_LONG).show();
                }
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                i.putExtra(MainActivity.EXTRA_ID,id_cuenta);
                startActivity(i);
            }
        });
    }
}
