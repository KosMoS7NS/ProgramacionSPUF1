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

        try {
            while (respuesta != 3) {
                out.println("|====================================|" + lineSeparator() +
                        "|1) Encrypt                          |" + lineSeparator() +
                        "|2) Decrypt                          |" + lineSeparator() +
                        "|3) Exit                             |" + lineSeparator() +
                        "|====================================|");

                out.println("Introduce una respuesta: ");
                respuesta = scanner.nextInt();

                switch (respuesta) {
                    case 1:
                        out.println("Introduce el texto a cifrar: ");
                        scanner.nextLine();
                        texto = scanner.nextLine();

                        while (i < texto.length()) {
                            cifrado += texto.charAt(i) * key;
                            i++;
                        }
                        out.println("ENCRYPTED: " + cifrado);
                        break;

                    case 2:
                        String letras = "";
                        String descifrado = null;

                        i = texto.length();
                        double sum_ASCII_values = cifrado / key;

                        while (i > 0) {
                            letras += (char) (sum_ASCII_values - (sum_ASCII_values - texto.charAt(i - 1)));
                            descifrado = new StringBuilder(letras).reverse().toString();
                            i--;
                        }
                        out.println(descifrado != null ? "DECRYPTED: " + descifrado : "Encrypt the data first");

                        i++;
                        break;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
