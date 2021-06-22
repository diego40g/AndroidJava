package com.example.morales_michael_juguetes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class datosActivity extends AppCompatActivity {

    private Button btnRegresar;
    private Button btnFlujos;
    private EditText txtMarcaList;
    private EditText txtTipoList;
    private EditText txtCantidadList;
    private ListView listviewcito;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        data = new ArrayList<String>();

        btnRegresar=(Button) findViewById(R.id.btnRegresar);
//        btnFlujos=(Button) findViewById(R.id.btnFlujos);
        txtMarcaList=(EditText) findViewById(R.id.txtMarcaList);
        txtTipoList=(EditText) findViewById(R.id.txtTipoList);
        txtCantidadList=(EditText) findViewById(R.id.txtCantidadList);
        listviewcito=(ListView) findViewById(R.id.listView) ;

        ArrayList<String> list = (ArrayList<String>) getIntent().getStringArrayListExtra("list");
        adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        listviewcito.setAdapter(adapter);

        String[] archivos = fileList();
        if(existe(archivos, "notas.txt"))
        {
            try {
                InputStreamReader archivo = new InputStreamReader(openFileInput("notas.txt"));
                BufferedReader br = new BufferedReader(archivo);
                String linea = br.readLine();
                String todo = "";

                while (linea != null)
                {
                    data.add(linea);
                    linea = br.readLine();
                }
                br.close();
                archivo.close();
//                adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
//                listviewcito.setAdapter(adapter);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        listviewcito.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                String cadena;
                cadena= (listviewcito.getItemAtPosition(i) + "");
                String[] partes = cadena.split("/");
                txtMarcaList.setText(partes[0]);
                txtTipoList.setText(partes[1]);
                txtCantidadList.setText(partes[2]);
            }
        });

    }

    private boolean existe(String[] archivos, String archbusca)
    {
        for (int f=0; f< archivos.length; f++)
        {
            if (archbusca.equals(archivos[f]))
            {
                return true;
            }
        }
        return false;
    }

    public void regresar(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}
