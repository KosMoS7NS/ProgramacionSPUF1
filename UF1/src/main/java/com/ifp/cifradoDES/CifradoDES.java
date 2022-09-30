package com.ifp.cifradoDES;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import static java.lang.System.*;
import static javax.crypto.Cipher.*;

public class CifradoDES {
    public static void cifradoDES() throws NoSuchAlgorithmException, NoSuchPaddingException {
        Scanner scanner = new Scanner(in);
        Cipher cipher = getInstance("DES");
        SecretKey secretKey = KeyGenerator.getInstance("DES").generateKey();
        int respuesta = 0;
        String ruta;

        try {
            while (respuesta != 3) {
                out.println("|================================|" + lineSeparator() +
                        "|1) Encrypt                      |" + lineSeparator() +
                        "|2) Decrypt                      |" + lineSeparator() +
                        "|3) Exit                         |" + lineSeparator() +
                        "|================================|");
                out.println("Introduce una respuesta: ");
                respuesta = scanner.nextInt();

                switch (respuesta) {
                    case 1:
                        out.println("Introduce el fichero a cifrar: ");
                        ruta = scanner.next();

                        out.println("Introduce el texto a cifrar: ");
                        scanner.nextLine();
                        String mensaje = scanner.nextLine();

                        out.println("|================================|");
                        out.println("Mensaje a encriptar: " + mensaje);

                        cipher.init(ENCRYPT_MODE, secretKey);
                        byte[] cifrado = cipher.doFinal(mensaje.getBytes());

                        FileOutputStream fileOutputStream =
                                new FileOutputStream(new File(ruta), true);

                        fileOutputStream.write(cifrado);
                        fileOutputStream.close();

                        out.println("|================================|");
                        out.println("Mensaje cifrado: " + cifrado);
                        break;

                    case 2:
                        out.println("Introduce el fichero a descifrar");
                        ruta = scanner.next();

                        byte[] data = Files.readAllBytes(Path.of(ruta));

                        cipher.init(DECRYPT_MODE, secretKey);
                        byte[] descifrado = cipher.doFinal(data);

                        out.println("|=============================|");
                        out.println("Mensaje descifrado: " + new String(descifrado));
                        break;

                    case 3:
                        break;

                    default:
                        out.println("Enter the data correctly");
                        break;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}