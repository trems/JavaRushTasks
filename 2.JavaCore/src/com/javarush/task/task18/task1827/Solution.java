package com.javarush.task.task18.task1827;

/* 
Прайсы
*/
// считать строку
// распарсить строку, сплит по пробелам
// записать результат СтринБилдером в файл
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        String filename = getFileName();

        if (args.length > 0) {
            if (args[0].equals("-c")) {
                String result = buildResultString(args, getIncrementedId(getMaxId(filename)));
                writeResultToFile(filename, result);
            }
        }

    }

    public static String getFileName() throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String filename = consoleReader.readLine();
        consoleReader.close();
        return filename;
    }
    // tested +
    public static int getMaxId(String fileName) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String currentLine;
        int maxIdInFile = 0;
        int idInCurrentLine;
        while ((currentLine = fileReader.readLine()) != null) {
            idInCurrentLine = Integer.parseInt(currentLine.substring(0,8).trim());
            if (idInCurrentLine > maxIdInFile) {
                maxIdInFile = idInCurrentLine;
            }
        }
        fileReader.close();
        return maxIdInFile;
    }
    public static String getIncrementedId(int maxId) {
        return String.valueOf(++maxId);
    }
    public static String buildResultString(String[] args, String incrementedId ) {
        StringBuilder sb = new StringBuilder();
        sb.append(incrementedId);
        while (sb.length() < 8) sb.append(" ");
        sb.append(args[1]);
        while (sb.length() < 38) sb.append(" ");
        sb.append(args[2]);
        while (sb.length() < 46) sb.append(" ");
        sb.append(args[3]);
        while (sb.length() < 50) sb.append(" ");

        return sb.toString();
    }
    public static void writeResultToFile(String filename, String resultToWrite) throws IOException {
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(filename, true));
        fileWriter.newLine();
        fileWriter.write(resultToWrite);
        fileWriter.close();
    }

}
