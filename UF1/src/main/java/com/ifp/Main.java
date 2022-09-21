package com.ifp;

import javax.crypto.*;
import java.util.Scanner;

import static java.lang.System.*;
import static javax.crypto.Cipher.*;
import static javax.crypto.Cipher.DECRYPT_MODE;
import static javax.crypto.Cipher.ENCRYPT_MODE;

public class Main {
    public static void main(String[] args) {
        Cipher cipher = null;
        SecretKey secretKey = null;
        Scanner scanner = new Scanner(in);
        int respuesta = 0;
        String mensaje;
        byte[] cifrado = null;

        try {
            while (respuesta != 3) {
                out.println("|=============================|" + lineSeparator() +
                        "|1) Cifrar                    |" + lineSeparator() +
                        "|2) Descifrar                 |" + lineSeparator() +
                        "|3) Salir                     |" + lineSeparator() +
                        "|=============================|");
                out.println("Introduce una respuesta: ");
                respuesta = scanner.nextInt();

                try {
                    switch (respuesta) {
                        case 1:
                            out.println("Introduce el texto a cifrar: ");
                            scanner.nextLine();
                            mensaje = scanner.nextLine();

                            secretKey = KeyGenerator
                                    .getInstance("AES")
                                    .generateKey();

                            cipher = getInstance("AES");
                            cipher.init(ENCRYPT_MODE, secretKey);
                            cifrado = cipher.doFinal(mensaje.getBytes());

                            out.println("|=============================|");
                            out.println("Mensaje cifrado: " + cifrado);
                            break;

                        case 2:
                            cipher.init(DECRYPT_MODE, secretKey);
                            byte[] descifrado = cipher.doFinal(cifrado);

                            out.println("|=============================|");
                            out.println("Mensaje descifrado: " + new String(descifrado));
                            break;

                        case 3:
                            break;

                        default:
                            out.println("Enter the data correctly");
                            break;
                    }

                } catch (Exception e) {
                    out.println("Encrypt the data first");
                }
            }

        } catch (Exception e) {
            out.println("Enter the data correctly");
        }
    }
}
