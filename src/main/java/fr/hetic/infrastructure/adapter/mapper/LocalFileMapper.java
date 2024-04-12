package fr.hetic.infrastructure.adapter.mapper;

import fr.hetic.domain.entity.InputFileEntity;
import fr.hetic.domain.entity.OutputFileEntity;
import fr.hetic.domain.exception.OperationFormatException;
import fr.hetic.domain.type.OperatorType;
import fr.hetic.domain.valueObject.InputLineValueObject;
import fr.hetic.domain.valueObject.OutputLineValueObject;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.apache.commons.lang3.StringUtils.SPACE;

public class LocalFileMapper {

    public InputFileEntity mapToFileEntity(String fileName, String extension, List<String> lines) {
        List<InputLineValueObject> lineValueObjects = IntStream.range(0, lines.size())
                .mapToObj(i -> createLineValueObject(lines.get(i), i))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        return new InputFileEntity(fileName, extension, lineValueObjects);
    }

    private InputLineValueObject createLineValueObject(String line, int position) {
        try {
            String[] parts = line.split(SPACE);
            if (parts.length != 3) {
                throw new OperationFormatException();
            }
            int operand1 = Integer.parseInt(parts[0]);
            int operand2 = Integer.parseInt(parts[1]);
            OperatorType operator = OperatorType.fromSymbol(parts[2]);
            return new InputLineValueObject(operand1, operand2, operator, position);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public List<String> mapToFileContent(OutputFileEntity fileEntity) {
        return fileEntity.lines().stream()
                .map(OutputLineValueObject::line)
                .collect(Collectors.toList());
    }
}