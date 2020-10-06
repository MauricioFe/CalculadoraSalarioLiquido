package com.example.calculadoradesalario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.Objects;

public class ResultadoActivity extends AppCompatActivity {
    double salariobruto = 0;
    double salarioLiquido = 0;
    int dependentes = 0;
    double outro = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        recebeDados();
        realizaCalculo();
    }

    private double realizaCalculo() {
        return salarioLiquido;
    }

    private void recebeDados() {
        Intent intent = getIntent();

        if (intent != null) {
            salariobruto = Double.parseDouble(Objects.requireNonNull(intent.getStringExtra(MainActivity.SALARIO_BRUTO)));
            dependentes = Integer.parseInt(Objects.requireNonNull(intent.getStringExtra(MainActivity.NUMERO_DEPENDENTES)));
            outro = Double.parseDouble(Objects.requireNonNull(intent.getStringExtra(MainActivity.OUTROS)));
        }
    }
}