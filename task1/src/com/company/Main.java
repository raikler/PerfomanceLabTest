package com.company;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

     File inFile = new File(args[0]);

      Scanner abc = new Scanner(new FileReader(inFile));

      List<Short> array = new ArrayList();
      while (abc.hasNext()){
          array.add(Short.valueOf(abc.nextLine()));
      }
        System.out.println(String.format("%.2f",percentileCount(array,90)));
        System.out.println(String.format("%.2f",mediateCount(array)));
        System.out.println(String.format("%.2f",max(array)));
        System.out.println(String.format("%.2f",min(array)));
        System.out.println(String.format("%.2f",average(array)));
    }

    public static double percentileCount (List<Short> array, double percentile){
        Collections.sort(array);
        int index = (int)Math.ceil(percentile / 100.0 * array.size());
         return array.get(index-1);
    }

    public static double mediateCount (List<Short> array){
        Collections.sort(array);
        int index = array.size()/2;
        double result;
        if (array.size() % 2 == 0)
            result = (array.get(index)+ array.get(index-1))/2;
        else
                result = array.get(index);
        return result;
    }
    public static double max(List<Short> array){
        double result=array.get(0);
        for (Short s: array) {
            if (result < s)
                result = s;
        }
        return result;
    }
    public static double min(List<Short> array){
        double result=array.get(0);
        for (Short s: array) {
            if (result > s)
                result = s;
        }
        return result;
    }
    public static double average(List<Short> array) {
        double sum = 0;
    for (Short s : array){
        sum+=s;
    }
    return sum / array.size();
    }
}

