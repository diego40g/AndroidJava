package com.dipaz.navegacionactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView et1Ac2;
    private TextView et2Ac2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        et1Ac2 = findViewById(R.id.txwEmailEnv);
        et2Ac2 = findViewById(R.id.txwPassEnv);

        Bundle bundle = getIntent().getExtras();
        et1Ac2.setText(bundle.getString("email"));
        et2Ac2.setText(bundle.getString("password"));
    }

    public void Cerrar (View v)
    {
        finish();
    }
}