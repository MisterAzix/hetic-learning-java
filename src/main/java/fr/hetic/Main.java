package fr.hetic;

import fr.hetic.domain.Calculator;
import fr.hetic.domain.FileProcessor;
import fr.hetic.infrastructure.OperatorFactory;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("You must provide the directory path as an argument (<directory-path>)");
            System.exit(1);
        }

        String directoryPath = args[0];

        OperatorFactory operatorFactory = new OperatorFactory();
        Calculator calculator = new Calculator(operatorFactory);
        FileProcessor fileProcessor = new FileProcessor(calculator);

        fileProcessor.processDirectory(directoryPath);
    }
}