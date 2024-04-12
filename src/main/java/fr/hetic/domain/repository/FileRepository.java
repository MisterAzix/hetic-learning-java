package fr.hetic.domain.repository;

import fr.hetic.domain.entity.InputFileEntity;
import fr.hetic.domain.entity.OutputFileEntity;
import fr.hetic.domain.exception.OperationFormatException;

import java.io.IOException;
import java.util.List;

public interface FileRepository {
    List<InputFileEntity> getFiles() throws OperationFormatException;

    void saveFile(OutputFileEntity fileEntity);
}
