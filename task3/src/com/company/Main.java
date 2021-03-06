package com.company;

import java.io.FileReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        String[] fileNames = new String[5];
        Scanner[] readers = new Scanner[5];
        float[][] timing = new float[5][16];
        for (int i = 0; i < 5; i++) {
            fileNames[i] = args[0] + "\\Cash" + (i + 1) + ".txt";
            readers[i] = new Scanner(new FileReader(fileNames[i]));
        }
        int i = 0;
        float maxLoad = 0;
        for (Scanner s : readers) {
            int j = 0;
            while (s.hasNext()) {
                timing[i][j] = Float.parseFloat(s.nextLine().replace("\\n", ""));
                j++;
            }
            i++;
        }
        for (int j = 0; j < 16; j++) {
            float currentLoad = timing[0][j]+timing[1][j]+timing[2][j]+timing[3][j]+timing[4][j];
            if (currentLoad>maxLoad){
                maxLoad = currentLoad;
                i = j+1;
            }
        }
        System.out.println(i);
    }
}
