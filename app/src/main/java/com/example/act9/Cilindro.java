package com.example.act9;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class Cilindro extends AppCompatActivity{

    private EditText editTextRadio, editTextAltura;
    private TextView textViewResultado;
    private Button btnCalcular, btnLimpiar, btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cilindro);

        // Obtener referencias a las vistas
        editTextRadio = findViewById(R.id.editTextRadio);
        editTextAltura = findViewById(R.id.editTextAltura);
        textViewResultado = findViewById(R.id.textViewResultadoCilindro);
        btnCalcular = findViewById(R.id.btnCalcularCilindro);
        btnLimpiar = findViewById(R.id.btnLimpiarCilindro);
        btnRegresar = findViewById(R.id.btnRegresarCilindro);

        // Configurar el evento clic para el botón Calcular
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularCilindro();
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

    private void calcularCilindro() {
        // Obtener los valores del radio y la altura desde los EditTexts
        double radio = Double.parseDouble(editTextRadio.getText().toString());
        double altura = Double.parseDouble(editTextAltura.getText().toString());

        // Calcular el volumen del cilindro
        double volumen = Math.PI * Math.pow(radio, 2) * altura;

        // Calcular el área de la superficie del cilindro
        double areaSuperficie = 2 * Math.PI * radio * (radio + altura);

        // Mostrar los resultados en el TextView
        String resultado = "Volumen: " + volumen + "\nÁrea de Superficie: " + areaSuperficie;
        textViewResultado.setText(resultado);
    }

    private void limpiarCampos() {
        // Limpiar los valores en los EditTexts y el TextView
        editTextRadio.setText("");
        editTextAltura.setText("");
        textViewResultado.setText("");
    }
}
