package fr.hetic.domain.entity;

import fr.hetic.domain.valueObject.InputLineValueObject;

import java.util.List;

public record InputFileEntity(String name, String type, List<InputLineValueObject> lines) {
}