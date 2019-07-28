package com.javarush.task.task32.task3212;

import com.javarush.task.task32.task3212.service.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.io.RandomAccessFile;

/* 
Service Locator
*/

public class Solution {
    public static void main(String[] args) {
        Service service = ServiceLocator.getService("EJBService");
        service.execute();
        System.out.println();
        service = ServiceLocator.getService("JMSService");
        service.execute();
        System.out.println();
        service = ServiceLocator.getService("EJBService");
        service.execute();
        System.out.println();
        service = ServiceLocator.getService("JMSService");
        service.execute();

    }

}
