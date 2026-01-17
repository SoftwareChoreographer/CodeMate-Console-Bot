package bot.data;

import bot.models.Operator;
import bot.models.QuestionType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CsvQuestionSourceTest {

    @Test
    void shouldLoadAllQuestionsFromCsv() {
        QuestionSource source =
                new CsvQuestionSource("test-questions.csv");

        List<QuestionData> questions = source.loadQuestions();

        assertEquals(3, questions.size());
    }

    @Test
    void shouldParseMathQuestionCorrectly() {
        QuestionSource source =
                new CsvQuestionSource("test-questions.csv");

        QuestionData question = source.loadQuestions().getFirst();

        assertEquals(QuestionType.MATH, question.getQuestionType());
        assertEquals("5", question.getLeftOperand());
        assertEquals("3", question.getRightOperand());
        assertEquals(Operator.ADD, question.getOperator());
        assertEquals("8", question.getExpectedAnswer());
    }

    @Test
    void shouldParseLogicalOperatorCorrectly() {
        QuestionSource source =
                new CsvQuestionSource("test-questions.csv");

        QuestionData question = source.loadQuestions().get(1);

        assertEquals(Operator.AND, question.getOperator());
        assertEquals("false", question.getExpectedAnswer());
    }

    @Test
    void shouldAllowNullOperatorForProgrammingQuestions() {
        QuestionSource source =
                new CsvQuestionSource("test-questions.csv");

        QuestionData question = source.loadQuestions().get(2);

        assertEquals(QuestionType.PROGRAMMING, question.getQuestionType());
        assertNull(question.getOperator());
        assertEquals("true", question.getExpectedAnswer());
    }
}
