package com.example.morales_michael_juguetes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnActivity2;
    private Button btnGuardar;
    private EditText txtMarca;
    private EditText txtTipo;
    private EditText txtCantidad;
    ArrayList<Juguetes> juguetes;
    private ArrayList<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        juguetes=new ArrayList<Juguetes>();
        btnActivity2 = (Button) findViewById(R.id.btnActivity2);
        btnGuardar = (Button)findViewById(R.id.btnGuardar);
        txtMarca = (EditText)findViewById(R.id.txtMarca);
        txtTipo = (EditText)findViewById(R.id.txtTipo);
        txtCantidad = (EditText)findViewById(R.id.txtCantidad);
        data = new ArrayList<String>();

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String marca = txtMarca.getText().toString().trim();
                String tipo = txtTipo.getText().toString().trim();
                String cantidad= txtCantidad.getText().toString().trim();
                if(txtMarca.length()== 0 || txtTipo.length()== 0 || txtCantidad.length()== 0 ) {
                    Toast.makeText(getApplicationContext(), "Llenar todos los campos", Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(getApplicationContext(), "campos llenos correctamente", Toast.LENGTH_SHORT).show(); llenarArreglo(marca, tipo, cantidad);
                }
            }
        });
    }

    public void llenarArreglo(String marca, String tipo, String cantidad){
        juguetes.add(new Juguetes(marca, tipo, cantidad));
    }

    public void irActivity2(View view){
        try{
            FileOutputStream file=openFileOutput("notas.txt", MODE_PRIVATE);
            OutputStreamWriter outputFile=new OutputStreamWriter(file);
            for(int i=0;i<juguetes.size();i++){
                outputFile.write(juguetes.get(i).getStrMarca()+","+juguetes.get(i).getStrTipo()+","+juguetes.get(i).getStrCantidad()+"\n");
                data.add(juguetes.get(i).getStrMarca() + "/" +juguetes.get(i).getStrTipo()+ "/" +juguetes.get(i).getStrCantidad());
            }
            Toast.makeText(getApplicationContext(),"ARCHIVO CREADO CON EXITO",Toast.LENGTH_SHORT).show();
            outputFile.flush();
            outputFile.close();
            Intent intent = new Intent(getApplicationContext(), datosActivity.class);
            intent.putStringArrayListExtra("list", data);
            startActivity(intent);
        }catch (IOException e){
            Toast.makeText(getApplicationContext(),"ERROR AL CREAR EL ARCHIVO",Toast.LENGTH_SHORT).show();
        }
    }

}