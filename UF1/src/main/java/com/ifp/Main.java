package com.ifp;

import com.ifp.cifradoDES.CifradoDES;
import com.ifp.cifradoPropio.CifradoPropio;

import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException {
        Scanner scanner = new Scanner(in);
        int respuesta = 0;
        while (respuesta != 3) {
            out.println(lineSeparator() +
                    "|===================================|" + lineSeparator() +
                    "|1) Custom encrypt                  |" + lineSeparator() +
                    "|2) DES Encrypt                     |" + lineSeparator() +
                    "|3) Exit                            |" + lineSeparator() +
                    "|===================================|");

            out.println("Introduce una respuesta: ");
            respuesta = scanner.nextInt();

            if (respuesta == 1) break;
            if (respuesta == 2) break;
        }

        if (respuesta == 1) CifradoPropio.cifradoPropio();
        if (respuesta == 2) CifradoDES.cifradoDES();

    }
}