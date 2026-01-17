package bot.factories;

import bot.data.QuestionData;
import bot.models.*;

public class QuestionFactory {

    public Question createQuestion(QuestionData data) {

        return switch (data.getQuestionType()) {

            case MATH -> createMathQuestion(data);

            case PROGRAMMING -> createProgrammingQuestion(data);
        };
    }

    private Question createMathQuestion(QuestionData data) {

        Operator operator = data.getOperator();

        if (operator == null) {
            throw new IllegalArgumentException(
                    "MathQuestion requires an operator"
            );
        }

        Object leftOperand = parseOperand(data.getLeftOperand());
        Object rightOperand = parseOperand(data.getRightOperand());

        return new MathQuestion(leftOperand, rightOperand, operator);
    }

    private Question createProgrammingQuestion(QuestionData data) {

        return new ProgrammingQuestion(
                data.getQuestionText(),
                data.getExpectedAnswer()
        );
    }

    private Object parseOperand(String value) {

        if (value == null) {
            throw new IllegalArgumentException(
                    "Operand cannot be null for MathQuestion"
            );
        }

        if ("true".equalsIgnoreCase(value) || "false".equalsIgnoreCase(value)) {
            return Boolean.parseBoolean(value);
        }

        return Integer.parseInt(value);
    }
}
