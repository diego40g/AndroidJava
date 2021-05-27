package com.dipaz.login_pazdiego;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView et1, et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        et1 = findViewById(R.id.txtUsuario2);
        et2 = findViewById(R.id.txtContraseña2);

        Bundle bundle = getIntent().getExtras();
        String email = bundle.getString("dirreccion");
        String password = bundle.getString("contrasenia");
        et1.setText(email);
        et2.setText(password);
    }

    public void salir (View view){
        finish();
    }
}