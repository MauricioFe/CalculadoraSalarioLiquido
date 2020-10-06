package com.example.calculadoradesalario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edtSalario;
    EditText edtDependentes;
    EditText edtOutros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtSalario = findViewById(R.id.main_edt_salario_bruto);
        edtDependentes = findViewById(R.id.main_edt_dependentes);
        edtOutros = findViewById(R.id.main_edt_outros);
    }
}