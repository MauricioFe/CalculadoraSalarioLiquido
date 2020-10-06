package com.example.calculadoradesalario;

import java.text.DecimalFormat;
import java.util.List;

public class CalculoSalarioUtil {
    public static double descontoInss(double salarioBruto) {
        double descontoInss = 0;
        double resto = 0;
        double valorDescontado = 0;

        if (salarioBruto > 0 && salarioBruto <= 1045) {
            valorDescontado = salarioBruto * 0.075;
            descontoInss =valorDescontado;
        } else if (salarioBruto > 1045.01 && salarioBruto <= 2089.6) {
            resto = salarioBruto - 1045;
            valorDescontado += resto * 0.09;
            valorDescontado += 1045 * 0.075;
            descontoInss = valorDescontado;
        }
        return descontoInss;
    }

    public static double descontoIRRF(double baseCalculo) {
        return 0;
    }

}
