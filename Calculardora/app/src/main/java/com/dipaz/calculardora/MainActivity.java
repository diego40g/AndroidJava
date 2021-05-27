package com.dipaz.calculardora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et1,et2;
    private RadioButton r1,r2;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        tv1=findViewById(R.id.tv1);
        r1=findViewById(R.id.r1);
        r2=findViewById(R.id.r2);
    }

    //función al presionar el boton
    public void sumar(View view){
        String valor1 = et1.getText().toString();
        String valor2 = et2.getText().toString();
        int nro1 = Integer.parseInt(valor1);
        int nro2 = Integer.parseInt(valor2);
        int suma;
        String resu;
        if (r1.isChecked()){
            suma= nro1+nro2;
            resu = String.valueOf(suma);
        }else {
            if(r2.isChecked()){
                suma= nro1-nro2;
                resu= String.valueOf(suma);
            }else{
                resu= "Sin seleccionar opción";
            }
        }

        tv1.setText(resu);
    }
}