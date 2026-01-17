package bot.data;

import bot.models.Operator;
import bot.models.QuestionType;

public class QuestionData {
    private final QuestionType questionType;
    private final String questionText;
    private final String leftOperand;
    private final String rightOperand;
    private final Operator operator;
    private final String expectedAnswer;

    public QuestionData(QuestionType questionType, String questionText, String leftOperand, String rightOperand, Operator operator, String expectedAnswer) {
        this.questionType = questionType;
        this.questionText = questionText;
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.operator = operator;
        this.expectedAnswer = expectedAnswer;
    }

    public QuestionType getQuestionType() { return questionType; }

    public String getQuestionText() {
        return questionText;
    }

    public String getLeftOperand() {
        return leftOperand;
    }

    public String getRightOperand() {
        return rightOperand;
    }

    public Operator getOperator() { return operator; }

    public String getExpectedAnswer() { return expectedAnswer; }
}
