package com.ifp;

import com.ifp.cifradoPropio.CifradoPropio;
import com.ifp.cifradoDES.CifradoDES;

import javax.crypto.*;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        Scanner scanner = new Scanner(in);
        int respuesta = 0;

        while (respuesta != 3) {
            out.println("|=============================|" + lineSeparator() +
                    "|1) Cifrado Propio             |" + lineSeparator() +
                    "|2) Cifrado DES               |" + lineSeparator() +
                    "|3) Salir                     |" + lineSeparator() +
                    "|=============================|");
            out.println("Introduce una respuesta: ");
            respuesta = scanner.nextInt();

            switch (respuesta) {
                case 1 -> CifradoPropio.cifradoPropio();
                case 2 -> CifradoDES.cifradoDES();
            }
        }
    }
}
