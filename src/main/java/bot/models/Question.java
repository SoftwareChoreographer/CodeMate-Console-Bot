package bot.models;

public interface Question {

    String getQuestion();
    boolean checkAnswer(String answer);
}
