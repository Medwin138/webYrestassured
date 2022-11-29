package test;

import java.awt.*;
import java.sql.SQLOutput;

public class coordenadas {


        public static void main(String args[]) throws InterruptedException {
            Thread.sleep(10000);  // some time for user to position mouse
            Point spot = MouseInfo.getPointerInfo().getLocation();
            System.out.println(
                    String.valueOf(spot.getX())
                            +","+
                            String.valueOf(spot.getY()));

            System.out.println(spot.getX());
            System.out.println(spot.getY());

        }
    }

