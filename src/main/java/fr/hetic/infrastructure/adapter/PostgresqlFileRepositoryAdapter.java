package fr.hetic.infrastructure.adapter;

import fr.hetic.domain.entity.InputFileEntity;
import fr.hetic.domain.entity.OutputFileEntity;
import fr.hetic.domain.repository.FileRepository;
import fr.hetic.infrastructure.adapter.mapper.PostgresqlFileMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PostgresqlFileRepositoryAdapter implements FileRepository {
    private final String directoryPath;
    private final DatabaseConnection databaseConnection;
    private final PostgresqlFileMapper postgresqlFileMapper;

    public PostgresqlFileRepositoryAdapter(String directoryPath) {
        this.directoryPath = directoryPath;
        this.databaseConnection = new DatabaseConnection();
        this.postgresqlFileMapper = new PostgresqlFileMapper();
    }

    @Override
    public List<InputFileEntity> getFiles() {
        Connection connection = databaseConnection.connect();
        List<InputFileEntity> files = new ArrayList<>();

        try (Statement fileStatement = connection.createStatement()) {
            String fileQuery = "SELECT * FROM FICHIER WHERE TYPE = 'OP'";
            ResultSet fileResultSet = fileStatement.executeQuery(fileQuery);

            while (fileResultSet.next()) {
                Statement lineStatement = connection.createStatement();
                String lineQuery = "SELECT * FROM LIGNE WHERE FICHIER_ID = " + fileResultSet.getInt("ID") + " ORDER BY position ASC";
                ResultSet lineResultSet = lineStatement.executeQuery(lineQuery);

                InputFileEntity fileEntity = postgresqlFileMapper.mapToFileEntity(fileResultSet, lineResultSet);
                files.add(fileEntity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        databaseConnection.close();
        return files;
    }

    @Override
    public void saveFile(OutputFileEntity fileEntity) {
        Path outputFilePath = Path.of(directoryPath, fileEntity.name());

        try {
            Files.write(outputFilePath, postgresqlFileMapper.mapToFileContent(fileEntity));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}