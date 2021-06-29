package com.dipaz.contenedoresvisaules;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;

public class LinerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liner);
    }


    public void btnLL_2(View view) {
        Intent intent = new Intent(LinerActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void btnTL_2(View view) {
        Intent intent = new Intent(LinerActivity.this, TablelActivity.class);
        startActivity(intent);
    }

    public void btnGL_2(View view) {
        Intent intent = new Intent(LinerActivity.this, GridActivity.class);
        startActivity(intent);
    }
}