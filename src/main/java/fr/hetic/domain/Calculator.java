package fr.hetic.domain;

import fr.hetic.domain.entity.InputFileEntity;
import fr.hetic.domain.entity.OutputFileEntity;
import fr.hetic.domain.repository.FileRepository;
import fr.hetic.domain.valueObject.InputLineValueObject;
import fr.hetic.domain.valueObject.OutputLineValueObject;
import fr.hetic.infrastructure.factory.OperatorFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Calculator {
    private final OperatorFactory operatorFactory;
    private final FileRepository fileRepository;

    public Calculator(OperatorFactory operatorFactory, FileRepository fileRepository) {
        this.operatorFactory = operatorFactory;
        this.fileRepository = fileRepository;
    }

    public void execute() {
        List<InputFileEntity> files = fileRepository.getFiles();
        processFiles(files);
    }


    public void processFiles(List<InputFileEntity> files) {
        for (InputFileEntity file : files) {
            System.out.println("Processing file: " + file.name());
            List<InputLineValueObject> lines = file.lines();
            List<OutputLineValueObject> results = processLines(lines);
            fileRepository.saveFile(new OutputFileEntity(file.name(), file.type(), results));
        }
    }

    public List<OutputLineValueObject> processLines(List<InputLineValueObject> lines) {
        List<OutputLineValueObject> results = new ArrayList<>(
                Collections.nCopies(lines.getLast().position(), new OutputLineValueObject(""))
        );

        for (InputLineValueObject line : lines) {
            try {
                results.set(line.position() - 1, processLine(line));
            } catch (ArithmeticException e) {
                results.set(line.position() - 1, new OutputLineValueObject(""));
            }
        }

        return results;
    }

    private OutputLineValueObject processLine(InputLineValueObject line) {
        int operand1 = line.operand1();
        int operand2 = line.operand2();
        String operatorSymbol = line.operator().getSymbol();

        Operator operator = operatorFactory.getOperator(operatorSymbol);
        String result = operator.execute(operand1, operand2);
        return new OutputLineValueObject(result);
    }
}