package bot.services;

import bot.data.QuestionSource;
import bot.data.QuestionData;
import bot.factories.QuestionFactory;
import bot.models.Question;
import bot.models.QuestionType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * QuizService manages quiz sessions for a specific QuestionType.
 * Features:
 * - Loads and filters questions from a QuestionSource
 * - Converts raw data to Question objects via QuestionFactory
 * - Randomizes questions and limits to 5 per session
 * - Delegates answer checking to each Question
 */
public class QuizService {

    private final List<Question> questions;
    private int currentIndex;

    public QuizService(QuestionSource source, QuestionFactory factory, QuestionType questionType) {
        List<QuestionData> data = source.loadQuestions();

        List<QuestionData> filtered = new ArrayList<>();
        for (QuestionData qd : data) {
            if (qd.getQuestionType() == questionType) {
                filtered.add(qd);
            }
        }

        List<Question> tempQuestions = new ArrayList<>();
        for (QuestionData qd : filtered) {
            tempQuestions.add(factory.createQuestion(qd));
        }

        Collections.shuffle(tempQuestions);

        if (tempQuestions.size() > 5) {
            this.questions = new ArrayList<>(tempQuestions.subList(0, 5));
        } else {
            this.questions = tempQuestions;
        }
        this.currentIndex = 0;
    }

    public boolean hasNextQuestion() {
        return currentIndex < questions.size();
    }

    public Question nextQuestion() {
        if (!hasNextQuestion()) {
            throw new IllegalStateException("No more questions available.");
        }
        return questions.get(currentIndex++);
    }

    public boolean checkAnswer(Question question, String answer) {
        return question.checkAnswer(answer);
    }

    public int totalQuestions() {
        return questions.size();
    }
}
