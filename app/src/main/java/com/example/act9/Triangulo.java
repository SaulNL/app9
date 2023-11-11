package com.example.act9;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class Triangulo extends AppCompatActivity {

    private EditText editTextLadoA, editTextLadoB, editTextLadoC;
    private TextView textViewResultado;
    private Button btnCalcular, btnLimpiar, btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.triangulo);

        // Obtener referencias a las vistas
        editTextLadoA = findViewById(R.id.editTextLadoA);
        editTextLadoB = findViewById(R.id.editTextLadoB);
        editTextLadoC = findViewById(R.id.editTextLadoC);
        textViewResultado = findViewById(R.id.textViewResultado);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnRegresar = findViewById(R.id.btnRegresar);

        // Configurar el evento clic para el botón Calcular
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularTriangulo();
            }
        });

        // Configurar el evento clic para el botón Limpiar
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiarCampos();
            }
        });

        // Configurar el evento clic para el botón Regresar
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Cierra esta actividad y vuelve a la actividad anterior (MainActivity)
            }
        });
    }

    private void calcularTriangulo() {
        // Obtener los valores de los lados desde los EditTexts
        double ladoA = Double.parseDouble(editTextLadoA.getText().toString());
        double ladoB = Double.parseDouble(editTextLadoB.getText().toString());
        double ladoC = Double.parseDouble(editTextLadoC.getText().toString());

        // Calcular el perímetro
        double perimetro = ladoA + ladoB + ladoC;

        // Calcular el área utilizando la fórmula de Herón
        double semiperimetro = perimetro / 2;
        double area = Math.sqrt(semiperimetro * (semiperimetro - ladoA) * (semiperimetro - ladoB) * (semiperimetro - ladoC));

        // Mostrar los resultados en el TextView
        String resultado = "Perímetro: " + perimetro + "\nÁrea: " + area;
        textViewResultado.setText(resultado);
    }

    private void limpiarCampos() {
        // Limpiar los valores en los EditTexts y el TextView
        editTextLadoA.setText("");
        editTextLadoB.setText("");
        editTextLadoC.setText("");
        textViewResultado.setText("");
    }
}
