package com.ifp.cifradoDES;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import static java.lang.System.*;
import static java.lang.System.out;
import static javax.crypto.Cipher.*;

public class CifradoDES {
    public static void cifradoDES() throws IOException, NoSuchAlgorithmException {
        Cipher cipher = null;
        SecretKey secretKey = null;
        Scanner scanner = new Scanner(in);
        String lineaTextoFichero = "";
        String totalLineas = "";
        int respuesta = 0;
        String mensaje;
        String ruta;
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

                            out.println("Introduce el fichero a cifrar");
                            ruta = scanner.next();

                            out.println("Introduce el texto a cifrar: ");
                            scanner.nextLine();
                            mensaje = scanner.nextLine();

                            out.println("|=============================|");
                            out.println("Mensaje a encriptar: " + mensaje);

                            secretKey = KeyGenerator.getInstance("DES").generateKey();

                            cipher = getInstance("DES");
                            cipher.init(ENCRYPT_MODE, secretKey);
                            cifrado = cipher.doFinal(mensaje.getBytes());

                            FileOutputStream fileOutputStream =
                                    new FileOutputStream(new File(ruta), true);

                            fileOutputStream.write(cifrado);
                            fileOutputStream.close();

                            out.println("|=============================|");
                            out.println("Mensaje cifrado: " + cifrado);
                            break;

                        case 2:
                            out.println("Introduce el fichero a descifrar");
                            ruta = scanner.next();

                            byte[] data = Files.readAllBytes(Path.of(ruta));

                            cipher = getInstance("DES");
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

                } catch (Exception e) {
                    out.println("Encrypt the data first");
                }
            }

        } catch (Exception e) {
            out.println("Enter the data correctly");
        }
    }
}
