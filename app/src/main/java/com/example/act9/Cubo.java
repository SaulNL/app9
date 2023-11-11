package com.example.act9;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Cubo extends AppCompatActivity{

    private EditText editTextLado;
    private TextView textViewResultado;
    private Button btnCalcular, btnLimpiar, btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cubo);

        // Obtener referencias a las vistas
        editTextLado = findViewById(R.id.editTextLadoCubo);
        textViewResultado = findViewById(R.id.textViewResultadoCubo);
        btnCalcular = findViewById(R.id.btnCalcularCubo);
        btnLimpiar = findViewById(R.id.btnLimpiarCubo);
        btnRegresar = findViewById(R.id.btnRegresarCubo);

        // Configurar el evento clic para el botón Calcular
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularCubo();
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

    private void calcularCubo() {
        double lado = Double.parseDouble(editTextLado.getText().toString());
        double volumen = Math.pow(lado, 3);
        String resultado = "Volumen: " + volumen;
        textViewResultado.setText(resultado);
    }

    private void limpiarCampos() {
        editTextLado.setText("");
        textViewResultado.setText("");
    }
}
