package fr.hetic.domain.valueObject;

import fr.hetic.domain.type.OperatorType;

public record InputLineValueObject(int operand1, int operand2, OperatorType operator, int position) {
}