package com.dipaz.pazdiego_helpdesk;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.TextView;
import android.os.Bundle;
import android.content.Intent;
import android.database.Cursor;

public class ListActivity extends AppCompatActivity {
    private TextView te1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        te1=findViewById(R.id.txtViewList);
        AdminSQLOpenHelper admin = new AdminSQLOpenHelper(this,
                "administracion",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        Cursor fila =bd.rawQuery(
                "select * from helpDesk", null);
        double number = 0.0;
        String cadena="Codigo\tDescripción\tPrecio\tIva\tTotal\n";
        fila.moveToFirst();
        while (true){
            if(fila.moveToNext()){
                System.out.println("Ayuda: "+fila.getString(1));
                cadena = cadena + fila.getString(0).toString();
                cadena = cadena + "\t";
                cadena = cadena + fila.getString(1).toString();
                cadena = cadena + "\t $";
                cadena = cadena + fila.getString(2).toString();
                cadena = cadena + "\t $";
                number = Double.parseDouble(fila.getString(2).toString())*0.12;
                cadena = cadena + Double.toString(number) + "\t $";
                number = number + Double.parseDouble(fila.getString(2).toString());
                cadena = cadena + Double.toString(number) + "\n";
            }else{
                break;
            }
        }
        te1.setText(cadena);
        bd.close();
    }
    public void ir_atras(View v) {
        Intent intent = new Intent(ListActivity.this, MainActivity.class);
        startActivity(intent);
    }
}