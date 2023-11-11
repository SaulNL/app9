package com.example.act9;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class Pentagono extends AppCompatActivity{

    private EditText editTextLongitudLado;
    private TextView textViewResultado;
    private Button btnCalcular, btnLimpiar, btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pentagono);

        // Obtener referencias a las vistas
        editTextLongitudLado = findViewById(R.id.editTextLongitudLado);
        textViewResultado = findViewById(R.id.textViewResultadoPentagono);
        btnCalcular = findViewById(R.id.btnCalcularPentagono);
        btnLimpiar = findViewById(R.id.btnLimpiarPentagono);
        btnRegresar = findViewById(R.id.btnRegresarPentagono);

        // Configurar el evento clic para el botón Calcular
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularPentagono();
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

    private void calcularPentagono() {
        double longitudLado = Double.parseDouble(editTextLongitudLado.getText().toString());
        double perimetro = 5 * longitudLado;
        double area = (0.25) * Math.sqrt(5 * (5 + 2 * Math.sqrt(5))) * Math.pow(longitudLado, 2);
        String resultado = "Perímetro: " + perimetro + "\nÁrea: " + area;
        textViewResultado.setText(resultado);
    }

    private void limpiarCampos() {
        editTextLongitudLado.setText("");
        textViewResultado.setText("");
    }
}
