/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 *

 */
public class UserIOConsoleImpl implements UserIO {
      Scanner sc = new Scanner(System.in);

    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt);
        double num = Double.parseDouble(sc.nextLine());
        return num;

    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        System.out.println(prompt);
        double num = Double.parseDouble(sc.nextLine());
        while (min > num || max < num) {
            System.out.println("Error, number not in range");
        num = Double.parseDouble(sc.nextLine());

        }
        return num;
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        float num = Float.parseFloat(sc.nextLine());
        return num;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        System.out.println(prompt);
        float num = Float.parseFloat(sc.nextLine());
        while (min < num || max < num) {
            System.out.println("Error, number not in range");
         num = Float.parseFloat(sc.nextLine()); 

        }
        return num;
    }

    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
         int num = Integer.parseInt(sc.nextLine());
        return num;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        System.out.println(prompt);
        int num = Integer.parseInt(sc.nextLine());
        while (min > num || max < num) {
            System.out.println("Error, number not in range");
        num = Integer.parseInt(sc.nextLine());

        }
        return num;
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        long num = Long.parseLong(sc.nextLine());
        return num;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        System.out.println(prompt);
        long num = Long.parseLong(sc.nextLine());
        while (min < num || max < num) {
            System.out.println("Error, number not in range");
        num = Long.parseLong(sc.nextLine());    
        
        }
        return num;
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        String num = sc.nextLine();
        return num;
    }

    @Override
    public void print(String message) {
        System.out.println(message);

    }
    @Override
     public BigDecimal readBigDecimal(String prompt) {
        System.out.println(prompt);
        return sc.nextBigDecimal();
    

}

    @Override
    public BigDecimal readBigDecimal(String prompt, BigDecimal min, BigDecimal max) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
