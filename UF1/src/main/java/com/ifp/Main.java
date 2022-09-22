package com.ifp;

import com.ifp.cifradoAES.CifradoAES;
import com.ifp.cifradoDES.CifradoDES;

import javax.crypto.*;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.*;
import static javax.crypto.Cipher.*;
import static javax.crypto.Cipher.DECRYPT_MODE;
import static javax.crypto.Cipher.ENCRYPT_MODE;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(in);
        int respuesta = 0;

        while (respuesta != 3) {
            out.println("|=============================|" + lineSeparator() +
                    "|1) Cifrado AES               |" + lineSeparator() +
                    "|2) Cifrado DES               |" + lineSeparator() +
                    "|3) Salir                     |" + lineSeparator() +
                    "|=============================|");
            out.println("Introduce una respuesta: ");
            respuesta = scanner.nextInt();

            switch (respuesta) {
                case 1 -> CifradoAES.cifradoAES();
                case 2 -> CifradoDES.cifradoDES();
            }
        }
    }
}
