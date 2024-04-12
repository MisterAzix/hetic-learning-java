package fr.hetic.infrastructure.adapter;

import fr.hetic.domain.entity.InputFileEntity;
import fr.hetic.domain.entity.OutputFileEntity;
import fr.hetic.domain.repository.FileRepository;
import fr.hetic.infrastructure.adapter.mapper.LocalFileMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LocalFileRepositoryAdapter implements FileRepository {
    private final String directoryPath;
    private final LocalFileMapper localFileMapper;

    public LocalFileRepositoryAdapter(String directoryPath) {
        this.directoryPath = directoryPath;
        this.localFileMapper = new LocalFileMapper();
    }

    @Override
    public List<InputFileEntity> getFiles() {
        try (Stream<Path> paths = Files.walk(Paths.get(directoryPath))) {
            return paths.filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(".op"))
                    .map(this::createFileEntity)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private InputFileEntity createFileEntity(Path path) {
        String inputFilePath = path.toString();

        try {
            List<String> lines = Files.readAllLines(path);
            return localFileMapper.mapToFileEntity(inputFilePath, "op", lines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveFile(OutputFileEntity fileEntity) {
        Path outputFilePath = Path.of(fileEntity.name().replace(".op", ".res"));

        try {
            Files.write(outputFilePath, localFileMapper.mapToFileContent(fileEntity));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}