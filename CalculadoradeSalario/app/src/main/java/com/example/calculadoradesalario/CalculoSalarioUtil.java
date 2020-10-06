package com.example.calculadoradesalario;

import java.text.DecimalFormat;
import java.util.List;

public class CalculoSalarioUtil {
    private  static double descontoInss = 0;
    private static double valorDescontado = 0;
    private static double descontoIrrf = 0;
    public static double descontoInss(double salarioBruto) {
        if (salarioBruto > 0 && salarioBruto <= 1045) {
            valorDescontado = salarioBruto * 0.075;
            descontoInss = valorDescontado;
        } else if (salarioBruto >= 1045.01 && salarioBruto <= 2089.60) {
            valorDescontado = salarioBruto * 0.09;
            valorDescontado -= 15.67;
            descontoInss = valorDescontado;
        } else if (salarioBruto >= 2089.61 && salarioBruto <= 3134.40) {
            valorDescontado = salarioBruto * 0.12;
            valorDescontado -= 78.36;
            descontoInss = valorDescontado;
        } else if (salarioBruto >= 3134.41 && salarioBruto <= 6101.06) {
            valorDescontado = salarioBruto * 0.14;
            valorDescontado -= 141.05;
            descontoInss = valorDescontado;
        } else if (salarioBruto > 6101.06) {
            descontoInss = 713.10;
        }
        return descontoInss;
    }

    public static double descontoIRRF(double baseCalculo) {
        if (baseCalculo <= 1903.98) {
             descontoIrrf = 0;
        }else if (baseCalculo >= 1903.99 && baseCalculo <=2826.65) {
            descontoIrrf = (baseCalculo * 0.075) - 142.80;
        }else if (baseCalculo >= 2826.66 && baseCalculo <=3751.05) {
            descontoIrrf = (baseCalculo * 0.15) - 354.80;
        }else if (baseCalculo >= 3751.06 && baseCalculo <=4664.68) {
            descontoIrrf = (baseCalculo * 0.225) - 636.13;
        }
        else if (baseCalculo > 4664.68) {
            descontoIrrf = (baseCalculo * 0.275) - 869.36;
        }
        return descontoIrrf;
    }

}
