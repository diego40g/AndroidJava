package com.dipaz.pazdiego_helpdesk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1,et2,et3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=findViewById(R.id.txtCodigo);
        et2=findViewById(R.id.txtAyuda);
        et3=findViewById(R.id.txtPago);
    }

    public void crea(View v){
        AdminSQLOpenHelper admin = new AdminSQLOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd= admin.getWritableDatabase();
        String cod = et1.getText().toString();
        String ayu = et2.getText().toString();
        String pag = et3.getText().toString();

        ContentValues registro = new ContentValues();
        registro.put("codigo", cod);
        registro.put("ayuda", ayu);
        registro.put("pago",pag);

        bd.insert("help_desk",null,registro);
        bd.close();
        et1.setText("");
        et2.setText("");
        et3.setText("");

        Toast.makeText(this, "Se cargaron los datos del help desk",
                Toast.LENGTH_SHORT).show();
    }

    public void eliminar(View v) {
        AdminSQLOpenHelper admin = new AdminSQLOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod= et1.getText().toString();
        int cant = bd.delete("help_desk", "codigo=" + cod, null);
        bd.close();
        et1.setText("");
        et2.setText("");
        et3.setText("");
        if (cant == 1)
            Toast.makeText(this, "Se borró el artículo con dicho código",
                    Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "No existe un artículo con dicho código",
                    Toast.LENGTH_SHORT).show();
    }

    public void modificar(View v) {
        AdminSQLOpenHelper admin = new AdminSQLOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod = et1.getText().toString();
        String ayu = et2.getText().toString();
        String pag = et3.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("codigo", cod);
        registro.put("ayuda", ayu);
        registro.put("pago", pag);
        int cant = bd.update("help_desk", registro, "codigo=" + cod, null);
        bd.close();
        if (cant == 1)
            Toast.makeText(this, "se modificaron los datos", Toast.LENGTH_SHORT)
                    .show();
        else
            Toast.makeText(this, "no existe un artículo con el código ingresado",
                    Toast.LENGTH_SHORT).show();
    }

    public void mostrar(View v) {

        Intent intent = new Intent(MainActivity.this, ListActivity.class);
        startActivity(intent);

    }

    public void pago(View v) {
        Intent intent = new Intent(MainActivity.this, Pago.class);
        intent.putExtra("codigo",et1.getText().toString());
        startActivity(intent);
    }
}