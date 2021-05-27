package com.dipaz.login_pazdiego;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.txtUsuario1);
        password = findViewById(R.id.txtContraseña1);
    }

    public void ingreso(View view){
        Intent i = new Intent(this, MainActivity2.class);
        i.putExtra("dirreccion",email.getText().toString());
        i.putExtra("contrasenia",password.getText().toString());
        startActivity(i);
    }

    public void salir (View view){
        finish();
    }
}