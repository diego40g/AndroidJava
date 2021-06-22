package com.dipaz.pazdiego_guitarras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity {

    private TextView te1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Bundle bundle = getIntent().getExtras();
        String dato = bundle.getString("guitarras");
        te1=findViewById(R.id.textView);
        te1.setText(dato);
    }

    public void mostrar(View v) {
        Intent intent = new Intent(ListActivity.this, MainActivity.class);
        startActivity(intent);
    }
}