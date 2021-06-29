package com.dipaz.contenedoresvisaules;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GridActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
    }

    public void btnLLH_4(View view) {
        Intent intent = new Intent(GridActivity.this, LinerActivity.class);
        startActivity(intent);
    }

    public void btnLLV_4(View view) {
        Intent intent = new Intent(GridActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void btnTL_4(View view) {
        Intent intent = new Intent(GridActivity.this, TablelActivity.class);
        startActivity(intent);
    }
}