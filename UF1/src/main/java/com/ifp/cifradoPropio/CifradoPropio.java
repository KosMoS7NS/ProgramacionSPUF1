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
        char letras = 0;
        double cifrado = 0;
        double key = 1 * (PI / E);
        int i = 0;

        while (respuesta != 3) {
            out.println(lineSeparator() +
                    "|=============================|" + lineSeparator() +
                    "|1) Cifrar                    |" + lineSeparator() +
                    "|2) Descifrar                 |" + lineSeparator() +
                    "|3) Salir                     |" + lineSeparator() +
                    "|=============================|");

            out.println("Introduce una respuesta: ");
            respuesta = scanner.nextInt();

            switch (respuesta) {
                case 1:
                    out.println("Introduce el texto a cifrar: ");
                    scanner.nextLine();
                    texto = scanner.nextLine();

                    while (i < texto.length()) {
                        cifrado = texto.charAt(i) * key;
                        out.print(cifrado);
                        i++;
                    }
                    break;

                case 2:
                    out.println("Introduce el texto a descifrar: ");
                    scanner.nextLine();
                    texto = scanner.nextLine();

                    while (i < texto.length()) {
                        cifrado = texto.charAt(i) * key;
                        double numberText = cifrado / key;

                        char descifrado = (char) numberText;
                        out.print(descifrado);

                        i++;
                    }
                    break;
            }

        }
    }

}
