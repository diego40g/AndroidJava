package com.dipaz.pazdiego_helpdesk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Pago extends AppCompatActivity {

    private TextView et1, et2, et3;
    private String dato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pago);
        et1 = findViewById(R.id.txtViewPago);
        et2 = findViewById(R.id.textView5);
        et3 = findViewById(R.id.txtHoras);
        Bundle bundle = getIntent().getExtras();
        dato = bundle.getString("codigo");
    }

    public void calcular(View v) {
        AdminSQLOpenHelper admin = new AdminSQLOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod = dato;
        Cursor fila = bd.rawQuery(
                "select descripcion,precio from help_desk where codigo=" + cod, null);
        if (fila.moveToFirst()) {
            et1.setText(fila.getString(0));
            double total= Double.parseDouble(fila.getString(1));
            total = total * Double.parseDouble(et3.getText().toString());
            et2.setText(Double.toString(total));
        } else
            Toast.makeText(this, "No existe un servicio con dicho código",
                    Toast.LENGTH_SHORT).show();
        bd.close();
    }

    public void ir_atras(View v) {
        Intent intent = new Intent(Pago.this, MainActivity.class);
        startActivity(intent);
    }
}