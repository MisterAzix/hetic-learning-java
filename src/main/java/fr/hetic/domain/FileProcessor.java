package fr.hetic.domain;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Stream;

public class FileProcessor {
    private final Calculator calculator;

    public FileProcessor(Calculator calculator) {
        this.calculator = calculator;
    }

    public void processDirectory(String directoryPath) {
        try (Stream<Path> paths = Files.walk(Paths.get(directoryPath))) {
            paths.filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(".op"))
                    .forEach(this::processFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void processFile(Path inputFilePath) {
        String outputFilePath = inputFilePath.toString().replace(".op", ".res");

        try {
            List<String> lines = Files.readAllLines(inputFilePath);
            List<String> results = calculator.processLines(lines);
            Files.write(Paths.get(outputFilePath), results);
        } catch (IOException e) {
            System.out.println("ERROR: An error occurred while processing the file " + inputFilePath);
            e.printStackTrace();
        }
    }
}