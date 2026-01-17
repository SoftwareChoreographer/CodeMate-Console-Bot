package bot.models;

public class MathQuestion implements Question {

    private final Object leftOperand;
    private final Object rightOperand;
    private final Operator operator;

    public MathQuestion(Object leftOperand, Object rightOperand, Operator operator) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.operator = operator;
    }

    @Override
    public String getQuestion() {
        String left = leftOperand.toString();
        String right = rightOperand.toString();

        return switch (operator) {
            case ADD -> left + " + " + right;
            case SUBTRACT -> left + " - " + right;
            case MULTIPLY -> left + " * " + right;
            case DIVIDE -> left + " / " + right;
            case MODULO -> left + " % " + right;
            case AND -> left + " && " + right;
            case OR -> left + " || " + right;
            case XOR -> left + " ^ " + right;
        };
    }

    @Override
    public boolean checkAnswer(String answer) {
        return switch (operator) {
            case ADD, SUBTRACT, MULTIPLY, DIVIDE, MODULO ->
                    Integer.parseInt(answer) == calculateArithmetic();
            case AND, OR, XOR ->
                    Boolean.parseBoolean(answer) == calculateBoolean();
        };
    }

    private int calculateArithmetic() {
        int left = (Integer) leftOperand;
        int right = (Integer) rightOperand;

        return switch (operator) {
            case ADD -> left + right;
            case SUBTRACT -> left - right;
            case MULTIPLY -> left * right;
            case DIVIDE -> left / right;
            case MODULO -> left % right;
            default -> throw new IllegalStateException("Unexpected operator: " + operator);
        };
    }

    private boolean calculateBoolean() {
        boolean left = (Boolean) leftOperand;
        boolean right = (Boolean) rightOperand;

        return switch (operator) {
            case AND -> left && right;
            case OR -> left || right;
            case XOR -> left ^ right;
            default -> throw new IllegalStateException("Unexpected operator: " + operator);
        };
    }
}
