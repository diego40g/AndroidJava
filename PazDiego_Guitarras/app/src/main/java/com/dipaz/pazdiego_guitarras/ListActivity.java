package com.dipaz.pazdiego_guitarras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
        te1=findViewById(R.id.textView);
        AdminSQLOpenHelper admin = new AdminSQLOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        Cursor fila = bd.rawQuery(
                "select * from articulos", null);
        String cadena="codigo\tmodelo\tprecio\n";
        fila.moveToFirst();
        while (true){
            if(fila.moveToNext()){
            System.out.println("gutiarra:" + fila.getString(1));
                cadena = cadena + fila.getString(0).toString();
                cadena = cadena + "\t";
                cadena = cadena + fila.getString(1).toString();
                cadena = cadena + "\t $";
                cadena = cadena + fila.getString(2).toString();
                cadena = cadena + "\n";
            }
            else{break;}
        }
        te1.setText(cadena);
        bd.close();
    }

    public void ir_atras(View v) {
        Intent intent = new Intent(ListActivity.this, MainActivity.class);
        startActivity(intent);
    }
}