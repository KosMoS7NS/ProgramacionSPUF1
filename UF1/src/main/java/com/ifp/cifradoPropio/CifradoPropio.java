package com.ifp.cifradoPropio;

import java.util.Scanner;

import static java.lang.Math.E;
import static java.lang.Math.PI;
import static java.lang.System.lineSeparator;
import static java.lang.System.out;

public class CifradoPropio {

    public static void cifradoPropio() {

        Scanner scanner = new Scanner(System.in);
        int respuesta = 0;
        String texto = "";
        double cifrado = 0;
        double key = 1 * (PI / E);
        int i = 0;
        String letras = "";
        String descifrado = "";
        double ascii = 0;

        while (respuesta != 3) {
            out.println(lineSeparator() +
                    "|====================================|" + lineSeparator() +
                    "|1) Cifrar Propio                    |" + lineSeparator() +
                    "|2) Descifrar Propio                 |" + lineSeparator() +
                    "|3) Salir                            |" + lineSeparator() +
                    "|====================================|");

            out.println("Introduce una respuesta: ");
            respuesta = scanner.nextInt();

            switch (respuesta) {
                case 1:
                    out.println("Introduce el texto a cifrar: ");
                    scanner.nextLine();
                    texto = scanner.nextLine();

                    while (i < texto.length()) {
                        letras += texto.charAt(i);
                        ascii += texto.charAt(i);
                        cifrado += texto.charAt(i) * key;

                        out.println("LETRAS: " + letras);
                        out.println("LETRAS SUM ASCII: " + ascii);
                        out.println("CIFRADO: " + cifrado);

                        i++;
                    }
//                    out.print("CIFRADO: " + prueba);
                    break;

                case 2:
                    out.println("Descifrando texto...");
                    double sum_ASCII_values = cifrado / key;
                    out.println("ASCII DESCIFRADO: " + sum_ASCII_values);

                    i = 0;
                    while (i < texto.length()) {
                        descifrado += texto.charAt(i) / key;
                        out.println("DESCIFRADO: " + letras);
                        i++;
                    }
//
//                    i = texto.length();
//                    while (i > 0) {
////                        prueba += texto.charAt(i);
//                        cifrado -=  texto.charAt(i - 1) / key;
//                        descifrado += (char) cifrado;
//                        out.println("DESCIFRADO BUCLE: " + descifrado);
//                        i--;
//                    }

//                    while (i < texto.length()) {
//                        var letraCifrado = String.valueOf(cifrado).charAt(i) / key;
//
//                        double numberText = cifrado / key;
//                        char descifrado = (char) numberText;
//
//                        out.print(letraCifrado);
////                        out.print(descifrado);
//                        i++;
//                    }

                    i++;

                    break;
            }

        }
    }

}
