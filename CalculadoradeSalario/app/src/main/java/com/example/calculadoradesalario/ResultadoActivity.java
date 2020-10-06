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
        Toast.makeText(this, "teste " + realizaCalculo(), Toast.LENGTH_LONG).show();
    }

    private double realizaCalculo() {
        if (salariobruto <= 1045.00) {
            salarioLiquido = (salariobruto - (salariobruto * 0.075)) - (salariobruto * dependentes);
        } else if (salariobruto <= 1045.01 && salariobruto <= 2089.60) {
            salarioLiquido = (salariobruto - (salariobruto * 0.09 - 15.67)) - (salariobruto * dependentes);
        } else if (salariobruto <= 2089.61 && salariobruto <= 3134.40) {
            salarioLiquido = (salariobruto - (salariobruto * 0.12 - 78.36)) - (salariobruto * dependentes);
        } else if (salariobruto <= 3134.41 && salariobruto <= 6101.06) {
            salarioLiquido = (salariobruto - (salariobruto * 0.14 - 141.05)) - (salariobruto * dependentes);
        }
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