package com.ifp;

import com.ifp.cifradoAES.CifradoAES;

import javax.crypto.*;
import java.util.Scanner;

import static java.lang.System.*;
import static javax.crypto.Cipher.*;
import static javax.crypto.Cipher.DECRYPT_MODE;
import static javax.crypto.Cipher.ENCRYPT_MODE;

public class Main {
    public static void main(String[] args) {
        CifradoAES.cifradoAES();
    }
}
