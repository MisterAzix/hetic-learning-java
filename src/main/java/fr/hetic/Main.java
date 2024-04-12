package fr.hetic;

import fr.hetic.domain.Calculator;
import fr.hetic.infrastructure.adapter.LocalFileRepositoryAdapter;
import fr.hetic.domain.entity.InputFileEntity;
import fr.hetic.infrastructure.factory.OperatorFactory;
import fr.hetic.infrastructure.middleware.ErrorMiddleware;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                System.out.println("You must provide the directory path as an argument (<directory-path>)");
                System.exit(1);
            }

            String directoryPath = args[0];

            OperatorFactory operatorFactory = new OperatorFactory();
            LocalFileRepositoryAdapter localFileRepositoryAdapter = new LocalFileRepositoryAdapter(directoryPath);

            Calculator calculator = new Calculator(operatorFactory, localFileRepositoryAdapter);
            calculator.execute();
        } catch (Exception e) {
            new ErrorMiddleware().handle(e);
        }
    }
}