package fr.hetic;

import fr.hetic.domain.Calculator;
import fr.hetic.domain.repository.FileRepository;
import fr.hetic.infrastructure.adapter.LocalFileRepositoryAdapter;
import fr.hetic.infrastructure.adapter.PostgresqlFileRepositoryAdapter;
import fr.hetic.infrastructure.factory.FileRepositoryFactory;
import fr.hetic.infrastructure.factory.OperatorFactory;
import fr.hetic.infrastructure.middleware.ErrorMiddleware;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            processFromDatabase(args);
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC driver not found.");
            e.printStackTrace();
        }
    }

    private static void processFromDatabase(String[] args) {
        try {
            if (args.length != 1) {
                System.out.println("You must provide the directory path as an argument (<directory-path>)");
                System.exit(1);
            }

            String directoryPath = args[0];

            OperatorFactory operatorFactory = new OperatorFactory();
            FileRepository fileRepository = new FileRepositoryFactory().createRepository(directoryPath);

            Calculator calculator = new Calculator(operatorFactory, fileRepository);
            calculator.execute();
        } catch (Exception e) {
            new ErrorMiddleware().handle(e);
        }
    }
}