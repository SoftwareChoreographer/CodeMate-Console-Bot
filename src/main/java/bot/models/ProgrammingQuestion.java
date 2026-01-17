package bot.models;

public class ProgrammingQuestion implements Question {

    private final String question;
    private final String correctAnswer;

    public ProgrammingQuestion(String question, String correctAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer.trim();
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public boolean checkAnswer(String answer) {
        if (answer == null) return false;
        return answer.trim().equalsIgnoreCase(correctAnswer);
    }
}
