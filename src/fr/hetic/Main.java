package fr.hetic;

import fr.hetic.domain.Operator;
import fr.hetic.infrastructure.OperatorFactory;

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

        try (FileWriter writer = new FileWriter(outputFilePath);) {
            List<String> lines = Files.readAllLines(Paths.get(inputFilePath));
            OperatorFactory operatorFactory = new OperatorFactory();

            for (String line : lines) {
                String[] tokens = line.split(" ");
                if (tokens.length != 3) {
                    writer.write("Invalid input");
                    writer.write(System.lineSeparator());
                    continue;
                }

                try {
                    int a = Integer.parseInt(tokens[0]);
                    int b = Integer.parseInt(tokens[1]);
                    String operatorSymbol = tokens[2];

                    Operator operator = operatorFactory.getOperator(operatorSymbol);
                    String result = operator.execute(a, b);

                    writer.write(String.valueOf(result));
                    writer.write(System.lineSeparator());
                } catch (IllegalArgumentException e) {
                    writer.write("Invalid input");
                    writer.write(System.lineSeparator());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}