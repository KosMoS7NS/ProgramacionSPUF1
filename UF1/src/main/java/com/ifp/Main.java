package com.ifp;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Cipher cipher = null;
        SecretKey secretKey = null;
        Scanner scanner = new Scanner(in);
        int respuesta = 0;
        String mensaje;
        byte[] cifrado = null;

        while (respuesta != 3) {
            out.println("|=============================|" + lineSeparator() +
                    "|1) Cifrar                    |" + lineSeparator() +
                    "|2) Descifrar                 |" + lineSeparator() +
                    "|3) Salir                     |" + lineSeparator() +
                    "|=============================|");
            out.println("Introduce una respuesta: ");
            respuesta = scanner.nextInt();

            if (respuesta >= 1 || respuesta <= 3) {
                switch (respuesta) {
                    case 1:
                        out.println("Introduce el texto a cifrar: ");
                        scanner.nextLine();
                        mensaje = scanner.nextLine();

                        secretKey = KeyGenerator
                                .getInstance("AES")
                                .generateKey();

                        cipher = Cipher.getInstance("AES");
                        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
                        cifrado = cipher.doFinal(mensaje.getBytes());

                        out.println("|=============================|");
                        out.println("Mensaje cifrado: " + cifrado);
                        break;

                    case 3:
                        break;
                }

            } else throw new Exception("Introduce correctamente los datos");
        }

    }
}
