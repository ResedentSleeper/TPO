package edu.IOutils;

import edu.math.baseFunctions.Ln;
import edu.math.baseFunctions.Sin;
import edu.math.compoundExpression.CompoundSystem;
import edu.math.nextLevelFunctions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Printer {

    public static void printSysToCsv(double argMin, double argMax, double argStep) {
        String filename = "sys_print.csv";
        double x = argMin;
        double result =0;
        CompoundSystem cSys = new CompoundSystem(new Log5(), new Ln(),new Lg(), new Cot(), new Sec(), new Csc(), new Sin());
        try {
            Path resultFile = Paths.get(filename);
            if (Files.exists(resultFile))
                Files.delete(resultFile);
            Files.createFile(resultFile);

            do {
                try{
                    result = cSys.systemSolve(x);
                    Files.write(resultFile, String.format("%f;%f\n", x, cSys.systemSolve(x)).getBytes(), StandardOpenOption.APPEND);
                } catch (IllegalArgumentException e){
                    Files.write(resultFile, String.format("%f;%f\n", x, Double.NaN).getBytes(), StandardOpenOption.APPEND);
                }
                x += argStep;
            } while (x <= argMax);
        } catch (IOException error) {
            System.out.println(error.getMessage());
        }
    }

    public static void printSinToCsv(double argMin, double argMax, double argStep) {
        String filename = "sin_print.csv";
        Sin sin = new Sin();
        try {
            Path resultFile = Paths.get(filename);
            if (Files.exists(resultFile))
                Files.delete(resultFile);
            Files.createFile(resultFile);
            double x = argMin;
            do {
                Files.write(resultFile, String.format("%f;%f\n", x, sin.calculate(x)).getBytes(), StandardOpenOption.APPEND);
                x += argStep;
            } while (x <= argMax);
        } catch (IOException error) {
            System.out.println(error.getMessage());
        }
    }


    public static void printLnToCsv(double argMin, double argMax, double argStep) {
        String filename = "ln_print.csv";
        Ln ln = new Ln();
        try {
            Path resultFile = Paths.get(filename);
            if (Files.exists(resultFile))
                Files.delete(resultFile);
            Files.createFile(resultFile);
            double x = argMin;
            do {
                Files.write(resultFile, String.format("%f;%f\n", x, ln.calculate(x)).getBytes(), StandardOpenOption.APPEND);
                x += argStep;
            } while (x <= argMax);
        } catch (IOException error) {
            System.out.println(error.getMessage());
        }
    }

}