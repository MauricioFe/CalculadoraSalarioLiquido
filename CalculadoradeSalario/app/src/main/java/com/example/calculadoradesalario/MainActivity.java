package com.example.calculadoradesalario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String SALARIO_BRUTO = "salario_bruto";
    public static final String NUMERO_DEPENDENTES = "numero_dependentes";
    public static final String OUTROS = "outros";
    EditText edtSalario;
    EditText edtDependentes;
    EditText edtOutros;
    Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtSalario = findViewById(R.id.main_edt_salario_bruto);
        edtDependentes = findViewById(R.id.main_edt_dependentes);
        edtOutros = findViewById(R.id.main_edt_outros);
        btnCalcular = findViewById(R.id.main_btn_calcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ResultadoActivity.class);
                intent.putExtra(SALARIO_BRUTO, edtSalario.getText().toString());
                intent.putExtra(NUMERO_DEPENDENTES, edtDependentes.getText().toString());
                intent.putExtra(OUTROS, edtOutros.getText().toString());

                startActivity(intent);
            }
        });
    }
}