package com.javarush.task.task32.task3211;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;

/* 
Целостность информации
*/

public class Solution {
    public static void main(String... args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(new String("test string"));
        oos.flush();
        System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); //true

    }

    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(byteArrayOutputStream.toByteArray());
        //получаем MD5-хеш ( без лидирующих нулей )
        String s = new BigInteger(1,messageDigest.digest()).toString(16);
        //дополняем нулями до 32 символов, в случае необходимости
        while(s.length() < 32 ){
            s = "0"+s;
        }
        System.out.println(s + "    |    "+md5);
        return MessageDigest.isEqual(md5.getBytes(),s.getBytes() );
    }
}
