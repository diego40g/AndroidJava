package ec.edu.espe.deber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class impresionDatos extends AppCompatActivity {
    private Button btnActivity1;
    private ListView listView;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_impresion_datos);

        btnActivity1 = (Button)findViewById(R.id.btnActivity1);
        listView = (ListView)findViewById(R.id.listView);
        ArrayList<String> list = (ArrayList<String>) getIntent().getStringArrayListExtra("list");
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, list);

        listView.setAdapter(adapter);


        btnActivity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}