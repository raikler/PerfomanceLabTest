package com.company;

import java.awt.*;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        File rect = new File(args[0]);
        File points = new File(args[1]);
        Scanner scan = new Scanner(new FileReader(rect));
        ArrayList<PointQuad> quad = new ArrayList<PointQuad>();
        while(scan.hasNext()){
            String s = scan.nextLine();
            s = s.replace("\\n","");
            String[] mass = s.split(" ");
            quad.add(new PointQuad(Double.parseDouble(mass[0]),Double.parseDouble(mass[1])));
        }
        Scanner scan2 = new Scanner(new FileReader(points));
        while(scan2.hasNext()){
            String s = scan2.nextLine();
            s = s.replace("\\n","");
            String[] mass = s.split(" ");
            PointQuad point = new PointQuad(Double.parseDouble(mass[0]),Double.parseDouble(mass[1]));
            System.out.println(pointIn(quad,point));
        }
    }
    public static int pointIn(ArrayList<PointQuad> quad,PointQuad point){
        int result = 3;
        int j = 3;
        for (PointQuad p : quad) {
            if (point.equals(p))
                return 0;
        }
        for (int i = 0;i<quad.size();i++) {
            double minX,maxX,minY,maxY;
            if (i+1 == quad.size()){
                if (quad.get(i).getX()>quad.get(0).getX()) {
                    maxX = quad.get(i).getX();
                    minX = quad.get(0).getX();
                }
                else {
                    maxX = quad.get(0).getX();
                    minX = quad.get(i).getX();
                }
                if (quad.get(i).getY()>quad.get(0).getY()) {
                    maxY = quad.get(i).getY();
                    minY = quad.get(0).getY();
                }
                else {
                    maxY = quad.get(0).getY();
                    minY = quad.get(i).getY();
                }
                if((point.getX()-quad.get(i).getX())*
                        (quad.get(0).getY()-quad.get(i).getY())-
                        (quad.get(0).getX()-quad.get(i).getX())*
                                (point.getY()-quad.get(i).getY()) ==0 &&
                        point.getX()>=minX &&
                        point.getY()>=minY &&
                        point.getX()<=maxX &&
                        point.getX()<=maxY )
                    return 1;
                break;
            }
            if (quad.get(i).getX()>quad.get(i+1).getX()) {
                maxX = quad.get(i).getX();
                minX = quad.get(i+1).getX();
            }
            else {
                maxX = quad.get(i+1).getX();
                minX = quad.get(i).getX();
            }
            if (quad.get(i).getY()>quad.get(i+1).getY()) {
                maxY = quad.get(i).getY();
                minY = quad.get(i+1).getY();
            }
            else {
                maxY = quad.get(i+1).getY();
                minY = quad.get(i).getY();
            }
            if((point.getX()-quad.get(i).getX())*
                    (quad.get(i+1).getY()-quad.get(i).getY())-
                    (quad.get(i+1).getX()-quad.get(i).getX())*
                            (point.getY()-quad.get(i).getY()) == 0 &&
                    point.getX()>=minX &&
                    point.getY()>=minY &&
                    point.getX()<=maxX &&
                    point.getX()<=maxY )
                return 1;
        }
        for (int i = 0; i < 4; i++) {
            if ( (quad.get(i).getY() < point.getY() && quad.get(j).getY() >= point.getY() || quad.get(j).getY() < point.getY() && quad.get(i).getY() >= point.getY()) &&
                    (quad.get(i).getX() + (point.getY() - quad.get(i).getY()) / (quad.get(j).getY() - quad.get(i).getY()) * (quad.get(j).getX() - quad.get(i).getX()) < point.getX()) )
                return 2;
            j = i;
        }



        return result;
    }
}
