package com.example.calculadoradesalario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

public class ResultadoActivity extends AppCompatActivity {
    double salariobruto = 0;
    double salarioLiquido = 0;
    double baseCalculo = 0;
    int dependentes = 0;
    double outro = 0;
    Button btnVoltar;
    TextView txvSalarioLiquido;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        recebeDados();
        btnVoltar = findViewById(R.id.resultado_btn_voltar);
        txvSalarioLiquido = findViewById(R.id.resultado_txv_result_liquido);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultadoActivity.this, MainActivity.class));
            }
        });

        baseCalculo = salariobruto - CalculoSalarioUtil.descontoInss(salariobruto);
        baseCalculo -= dependentes * 189.59;
        salarioLiquido = salariobruto - CalculoSalarioUtil.descontoInss(salariobruto) - CalculoSalarioUtil.descontoIRRF(baseCalculo);
        NumberFormat formatoBR = DecimalFormat.getCurrencyInstance(new Locale("pt", "br"));
        txvSalarioLiquido.setText(formatoBR.format(salarioLiquido));
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