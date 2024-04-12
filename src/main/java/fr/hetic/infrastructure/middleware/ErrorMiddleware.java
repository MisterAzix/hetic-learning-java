package fr.hetic.infrastructure.middleware;

import fr.hetic.domain.exception.OperationFormatException;

import javax.management.OperationsException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ErrorMiddleware {
    private static final Logger LOGGER = Logger.getLogger(ErrorMiddleware.class.getName());

    public void handle(Exception e) {
        if (e instanceof NumberFormatException) {
            LOGGER.log(Level.WARNING, "Operands must be integers");
        } else if (e instanceof ArithmeticException) {
            LOGGER.log(Level.WARNING, "Division by zero is not allowed");
        } else if (e instanceof OperationsException) {
            LOGGER.log(Level.WARNING, "Operator must be one of: + - * /");
        } else if (e instanceof OperationFormatException) {
            LOGGER.log(Level.WARNING, "Operation must be in the format: <operand1> <operand2> <operator>");
        } else {
            throw new RuntimeException(e);
        }
    }
}
