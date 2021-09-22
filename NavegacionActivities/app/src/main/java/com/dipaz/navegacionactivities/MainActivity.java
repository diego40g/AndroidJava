package com.dipaz.navegacionactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView et1;
    private TextView et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.txtEmail);
        et2 = findViewById(R.id.txtPassword);
    }

    public void SiguienteActividad (View v){
        Intent i = new Intent(this, MainActivity2.class);
        i.putExtra("email", et1.getText().toString());
        i.putExtra("password", et2.getText().toString());

        startActivity(i);
    }
}