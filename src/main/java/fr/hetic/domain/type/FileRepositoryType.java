package fr.hetic.domain.type;

public enum FileRepositoryType {
    LOCAL("LOCAL"),
    POSTGRESQL("POSTGRESQL");

    private final String type;

    FileRepositoryType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
