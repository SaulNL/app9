package com.example.act9;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] nombresFiguras = {"Triángulo Escaleno", "cilindro", "Pentágono", "cubo"};
        int[] listaImagenes = {R.drawable.triangulo,
                R.drawable.cilindro, R.drawable.pentagono, R.drawable.cubo};

        final ListView listView = findViewById(R.id.listviewPersonalizado);

        BaseAdapterSaul adapter = new BaseAdapterSaul (getApplicationContext(), nombresFiguras, listaImagenes);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String figura = nombresFiguras[position];
                Intent intent = obtenerIntent(figura);

                if (intent != null) {
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "No se encontró la actividad para " + figura, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private Intent obtenerIntent(String figura) {
        Intent intent = null;

        switch (figura) {
            case "Triángulo Escaleno":
                intent = new Intent(MainActivity.this, Triangulo.class);
                break;
            case "cilindro":
                intent = new Intent(MainActivity.this, Cilindro.class);
                break;
            case "Pentágono":
                intent = new Intent(MainActivity.this, Pentagono.class);
                break;
            case "cubo":
                intent = new Intent(MainActivity.this, Cubo.class);
                break;
            default:
                break;
        }

        if (intent != null) {
            intent.putExtra("figura", figura);
        }

        return intent;
    }
}
