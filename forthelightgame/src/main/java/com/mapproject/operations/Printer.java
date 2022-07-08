package com.mapproject.operations;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Printer {
    public static void printFromTxt(String source) {
        BufferedReader inputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader(
                    "forthelightgame\\src\\main\\java\\com\\mapproject\\resources\\archive\\" + source + ".txt"));
            String l;
            while ((l = inputStream.readLine()) != null) {
                System.out.println(l);
            }
            inputStream.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
