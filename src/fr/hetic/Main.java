package fr.hetic;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("You must provide the input and output file paths as arguments (<input-file> <output-file>)");
            System.exit(1);
        }

        String inputFilePath = args[0];
        String outputFilePath = args[1];

        try {
            List<String> lines = Files.readAllLines(Paths.get(inputFilePath));
            Calculator calculator = new Calculator();

            try (FileWriter writer = new FileWriter(outputFilePath)) {
                for (String line : lines) {
                    String[] tokens = line.split(" ");
                    int a = Integer.parseInt(tokens[0]);
                    int b = Integer.parseInt(tokens[1]);
                    String operation = tokens[2];

                    String result = null;
                    switch (operation) {
                        case "+":
                            result = String.valueOf(calculator.add(a, b));
                            break;
                        case "-":
                            result = String.valueOf(calculator.substract(a, b));
                            break;
                        case "*":
                            result = String.valueOf(calculator.multiply(a, b));
                            break;
                        case "/":
                            result = String.valueOf(calculator.divide(a, b));
                            break;
                        default:
                            System.out.println("Invalid operator");
                    }

                    writer.write(String.valueOf(result));
                    writer.write(System.lineSeparator());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}