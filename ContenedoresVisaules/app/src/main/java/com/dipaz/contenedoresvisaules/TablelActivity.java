package com.dipaz.contenedoresvisaules;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TablelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablel);
    }

    public void btnLLH_3(View view) {
        Intent intent = new Intent(TablelActivity.this, LinerActivity.class);
        startActivity(intent);
    }

    public void btnLLV_3(View view) {
        Intent intent = new Intent(TablelActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void btnGL_3(View view) {
        Intent intent = new Intent(TablelActivity.this, GridActivity.class);
        startActivity(intent);
    }
}