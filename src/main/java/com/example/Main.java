package com.example;

import com.jcraft.jsch.KeyPair;
import java.io.ByteArrayOutputStream;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Starting KeyPair generation...");
            KeyPair kp = KeyPair.genKeyPair(null, KeyPair.RSA, 4096);

            if (kp == null) {
                System.out.println("KeyPair generation failed.");
            } else {
                System.out.println("KeyPair generated successfully.");

                // Write public key to byte array
                ByteArrayOutputStream pubOut = new ByteArrayOutputStream();
                kp.writePublicKey(pubOut, "");

                // Write private key to byte array
                ByteArrayOutputStream privOut = new ByteArrayOutputStream();
                kp.writePrivateKey(privOut);

                // Print keys
                System.out.println("Public Key: " + pubOut.toString());
                System.out.println("Private Key: " + privOut.toString());
            }
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
