package fr.hetic;

import fr.hetic.domain.Calculator;
import fr.hetic.infrastructure.OperatorFactory;

import java.io.IOException;
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

        OperatorFactory operatorFactory = new OperatorFactory();
        Calculator calculator = new Calculator(operatorFactory);

        try {
            List<String> lines = Files.readAllLines(Paths.get(inputFilePath));
            List<String> results = calculator.processLines(lines);
            Files.write(Paths.get(outputFilePath), results);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}