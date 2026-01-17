package bot.factories;

import bot.data.QuestionData;
import bot.models.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionFactoryTest {

    private final QuestionFactory factory = new QuestionFactory();

    @Test
    void createsMathQuestionFromQuestionData() {

        QuestionData data = new QuestionData(
                QuestionType.MATH,
                "What is 5 + 3?",
                "5",
                "3",
                Operator.ADD,
                "8"
        );

        Question question = factory.createQuestion(data);

        assertInstanceOf(MathQuestion.class, question);
        assertEquals("5 + 3", question.getQuestion());
        assertTrue(question.checkAnswer("8"));
    }

    @Test
    void createsBooleanMathQuestionFromQuestionData() {

        QuestionData data = new QuestionData(
                QuestionType.MATH,
                "What is true AND false?",
                "true",
                "false",
                Operator.AND,
                "false"
        );

        Question question = factory.createQuestion(data);

        assertInstanceOf(MathQuestion.class, question);
        assertEquals("true && false", question.getQuestion());
        assertTrue(question.checkAnswer("false"));
    }

    @Test
    void createsProgrammingQuestionFromQuestionData() {

        QuestionData data = new QuestionData(
                QuestionType.PROGRAMMING,
                "What is the result of 3 > 2?",
                null,
                null,
                null,
                "true"
        );

        Question question = factory.createQuestion(data);

        assertInstanceOf(ProgrammingQuestion.class, question);
        assertEquals("What is the result of 3 > 2?", question.getQuestion());
        assertTrue(question.checkAnswer("true"));
    }

    @Test
    void throwsExceptionWhenMathQuestionHasNoOperator() {

        QuestionData data = new QuestionData(
                QuestionType.MATH,
                "Invalid math question",
                "5",
                "3",
                null,
                "8"
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> factory.createQuestion(data)
        );
    }
}
