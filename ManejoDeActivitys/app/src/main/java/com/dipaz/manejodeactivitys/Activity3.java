package com.dipaz.manejodeactivitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {

    private TextView nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        nombre = findViewById(R.id.lblNombreA);
        Bundle bundle = getIntent().getExtras();
        String dato = bundle.getString("nombre");
        nombre.setText(dato);
    }

}