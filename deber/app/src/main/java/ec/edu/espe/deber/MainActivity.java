package ec.edu.espe.deber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText txtName;
    private EditText txtLastName;
    private EditText txtCi;
    private EditText txtEmail;
    private EditText txtTime;
    private ArrayList<String> data =new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = findViewById(R.id.txtName);
        txtLastName = findViewById(R.id.txtLastName);
        txtCi = findViewById(R.id.txtCI);
        txtEmail = findViewById(R.id.txtEmail);
        txtTime = findViewById(R.id.txtTime);
    }

    public void guardarDatos(View view){
        String name = txtName.getText().toString().trim();
        String lastName = txtLastName.getText().toString().trim();
        String ci = txtCi.getText().toString().trim();
        String email = txtEmail.getText().toString().trim();
        String time = txtTime.getText().toString().trim();
        if(name.length() == 0 || lastName.length() == 0 || ci.length() == 0 || email.length() == 0 || time.length() == 0){
            Toast.makeText(this, "ERROR: Debe llenar todos los campos.", Toast.LENGTH_SHORT).show();
        } else {
            llenarArray(name, lastName, ci, email, time);
        }
    }
    public void enviarDatos(View view){
        Intent intent = new Intent(this, impresionDatos.class);
        intent.putStringArrayListExtra("list", data);
        startActivity(intent);
    }

    private void llenarArray(String name, String lastName, String ci, String email, String time){
        data.add(name + "/" + lastName + "/" + ci + "/" + email + "/" + time);
        if (txtName != null) txtName.setText("");
        if (txtLastName != null) txtLastName.setText("");
        if (txtCi != null) txtCi.setText("");
        if (txtEmail != null) txtEmail.setText("");
        if (txtTime != null) txtTime.setText("");
        Toast.makeText(this, "Elemento Guardado", Toast.LENGTH_SHORT).show();
    }
}