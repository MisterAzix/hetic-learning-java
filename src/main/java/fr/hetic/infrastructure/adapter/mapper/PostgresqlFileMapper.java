package fr.hetic.infrastructure.adapter.mapper;

import fr.hetic.domain.entity.InputFileEntity;
import fr.hetic.domain.entity.OutputFileEntity;
import fr.hetic.domain.exception.OperationFormatException;
import fr.hetic.domain.type.OperatorType;
import fr.hetic.domain.valueObject.InputLineValueObject;
import fr.hetic.domain.valueObject.OutputLineValueObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.apache.commons.lang3.StringUtils.SPACE;

public class PostgresqlFileMapper {

    public InputFileEntity mapToFileEntity(ResultSet fileResultSet, ResultSet lineResultSet) throws SQLException {
        List<InputLineValueObject> lines = new ArrayList<>();

        while (lineResultSet.next()) {
            InputLineValueObject lineValueObject = createLineValueObject(lineResultSet);
            lines.add(lineValueObject);
        }

        String name = fileResultSet.getString("nom");
        String type = fileResultSet.getString("type");
        return new InputFileEntity(name, type, lines);
    }

    private InputLineValueObject createLineValueObject(ResultSet lineResultSet) throws SQLException {
        int operand1 = lineResultSet.getInt("param1");
        int operand2 = lineResultSet.getInt("param2");
        OperatorType operator = OperatorType.fromSymbol(lineResultSet.getString("operateur"));
        int position = lineResultSet.getInt("position");
        return new InputLineValueObject(operand1, operand2, operator, position);
    }

    public List<String> mapToFileContent(OutputFileEntity fileEntity) {
        return fileEntity.lines().stream()
                .map(OutputLineValueObject::line)
                .collect(Collectors.toList());
    }
}