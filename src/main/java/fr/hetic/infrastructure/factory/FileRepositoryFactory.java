package fr.hetic.infrastructure.factory;

import fr.hetic.domain.repository.FileRepository;
import fr.hetic.domain.type.FileRepositoryType;
import fr.hetic.infrastructure.adapter.LocalFileRepositoryAdapter;
import fr.hetic.infrastructure.adapter.PostgresqlFileRepositoryAdapter;

import java.io.InputStream;
import java.util.Properties;

public class FileRepositoryFactory {
    public FileRepository createRepository(String directoryPath) {
        Properties properties = new Properties();
        String propFileName = "application.properties";

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

        if (inputStream != null) {
            try {
                properties.load(inputStream);
                String repositoryType = properties.getProperty("fileRepository.implementation");
                if (repositoryType.equals(FileRepositoryType.LOCAL.getType())) {
                    return new LocalFileRepositoryAdapter(directoryPath);
                } else if (repositoryType.equals(FileRepositoryType.POSTGRESQL.getType())) {
                    return new PostgresqlFileRepositoryAdapter(directoryPath);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
