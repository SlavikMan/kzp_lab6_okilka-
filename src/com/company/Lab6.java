package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

//package com.company;

/**
 * Main class for Lab6
 *
 * @author Yaroslav Okilka
 * @version 1.0.0
 **/
public class Lab6 {
    StringBuilder sb = new StringBuilder();

    /**
     * Result field
     **/
    private static double result;

    /**
     * main method for Lab6
     *
     * @param args for main method
     * @throws IOException when file was not found
     **/
    public static void main(String[] args) throws IOException {

        Lab6 calculator = new Lab6();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter data: ");
        double data = sc.nextDouble();

        calculator.calculate(data);

        System.out.println("Result is: " + calculator.getResult());
        calculator.writeText("textRes.txt");
        calculator.writeBin("BinRes.bin");

        calculator.readBin("BinRes.bin");
        calculator.readText("textRes.txt");

    }

   
    /**
     * getter for result field
     *
     * @return double
     **/
    public double getResult() {
        return result;
    }

    /**
     * method for solving equation
     *
     * @param x as variable for equation
     **/
    public void calculate(double x) {
        result = Math.sin(x) / (1 / Math.tan(8 * x));
    }

    /**
     * method for reading text from file
     *
     * @param file for reading from custom file
     * @throws IOException when file was not found
     **/
    public void readText(String file) throws IOException {
        try {
            File f = new File(file);

            if (f.exists()) {
                Scanner s = new Scanner(f);

                while(s.hasNextDouble())
                    System.out.println(s.nextDouble() + " from txt file");
            } else
                throw new FileNotFoundException("File " + file + "not found");
        } catch (FileNotFoundException ex) {
            System.out.print(ex.getMessage());
        }
    }

    /**
     * method for writing text to file
     *
     * @param file for writing to custom file
     * @throws IOException when file was not found
     **/
    public void writeText(String file) throws IOException {
        PrintWriter f=  new PrintWriter(file);
        result = Double.parseDouble(Double.toString(result).replace(",",".")) ;
        f.println(result);
        f.close();
    }

    /**
     * method for writing binary cod to file
     *
     * @param file for writing to custom file
     * @throws IOException when file was not found
     **/
    public void writeBin(String file) throws IOException {
        DataOutputStream f = new DataOutputStream(new FileOutputStream(file));
        f.writeDouble(result);
        f.close();
    }

    /**
     * method for reading binary cod from file
     *
     * @param file for reading from custom file
     * @throws IOException when file was not found
     **/
    public void readBin(String file) throws IOException {
        DataInputStream f = new DataInputStream(new FileInputStream(file));
        result = f.readDouble();
        System.out.println(result + " from bin file");
        f.close();
    }


}


