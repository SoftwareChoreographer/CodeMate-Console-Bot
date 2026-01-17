package bot.services;

import bot.data.CsvQuestionSource;
import bot.data.QuestionData;
import bot.factories.QuestionFactory;
import bot.models.Question;
import bot.models.QuestionType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class QuizServiceTest {

    private QuizService mathQuiz;
    private QuizService programmingQuiz;
    private List<QuestionData> allQuestions;

    @BeforeEach
    void setup() {
        CsvQuestionSource source = new CsvQuestionSource("test-questions.csv");
        QuestionFactory factory = new QuestionFactory();

        // Load all CSV data
        allQuestions = source.loadQuestions();

        // Filter and create quizzes
        mathQuiz = new QuizService(source, factory, QuestionType.MATH);
        programmingQuiz = new QuizService(source, factory, QuestionType.PROGRAMMING);
    }

    @Test
    void testMathQuiz() {
        while (mathQuiz.hasNextQuestion()) {
            Question q = mathQuiz.nextQuestion();
            assertNotNull(q.getQuestion());

            // Find corresponding QuestionData by matching question text
            QuestionData data = allQuestions.stream()
                    .filter(d -> d.getQuestionType() == QuestionType.MATH
                            && d.getQuestionText().equals(q.getQuestion()))
                    .findFirst()
                    .orElseThrow();

            assertTrue(q.checkAnswer(data.getExpectedAnswer()));
        }
    }

    @Test
    void testProgrammingQuiz() {
        while (programmingQuiz.hasNextQuestion()) {
            Question q = programmingQuiz.nextQuestion();
            assertNotNull(q.getQuestion());

            QuestionData data = allQuestions.stream()
                    .filter(d -> d.getQuestionType() == QuestionType.PROGRAMMING
                            && d.getQuestionText().equals(q.getQuestion()))
                    .findFirst()
                    .orElseThrow();

            assertTrue(q.checkAnswer(data.getExpectedAnswer()));
        }
    }
}
