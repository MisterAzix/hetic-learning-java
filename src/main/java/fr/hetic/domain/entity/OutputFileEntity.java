package fr.hetic.domain.entity;

import fr.hetic.domain.valueObject.OutputLineValueObject;

import java.util.List;

public record OutputFileEntity(String name, String type, List<OutputLineValueObject> lines) {
}