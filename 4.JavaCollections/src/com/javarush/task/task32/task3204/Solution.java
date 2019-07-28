package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Random;

/* 
Генератор паролей
*/
public class Solution {
    static ByteArrayOutputStream pass;
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
       // byte[] passBytes = new byte[8];
        Random random = new Random();
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        abc += abc.toLowerCase() + "123456789";
        for (int i = 0; i < 8; i++) {
            byteArrayOutputStream.write(abc.charAt(random.nextInt(abc.length())));
        }
        if (byteArrayOutputStream.toString().matches(".*[\\d]+.*") &&
            byteArrayOutputStream.toString().matches(".*[A-Z]+.*") &&
            byteArrayOutputStream.toString().matches(".*[a-z]+.*")) {
            pass = byteArrayOutputStream;
        } else getPassword();
        return pass;
    }
}