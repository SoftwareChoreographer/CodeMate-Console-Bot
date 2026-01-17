package bot.models;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class ProgrammingQuestionTest {

    @ParameterizedTest
    @CsvSource({
            "'What is the result of 3 > 2?','true'",
            "'Which type is used for text in Java?','String'",
            "'What keyword declares a constant in Java?','final'",
            "'Is Java case-sensitive?','true'"
    })

    void testProgrammingQuestion(String questionText, String expectedAnswer) {
        ProgrammingQuestion question = new ProgrammingQuestion(questionText, expectedAnswer);

        // Check that the question text is correct
        assertEquals(questionText, question.getQuestion());

        // Check that correct answer is validated correctly
        assertTrue(question.checkAnswer(expectedAnswer));

        // Check incorrect answer fails (for robustness, we just use a wrong generic string)
        assertFalse(question.checkAnswer("wrongAnswer"));

        // Check trimming and case-insensitivity
        assertTrue(question.checkAnswer(expectedAnswer.toUpperCase()));
        assertTrue(question.checkAnswer("  " + expectedAnswer + "  "));
    }
}
