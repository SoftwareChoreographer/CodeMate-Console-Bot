package bot.models;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class MathQuestionTest {

    @ParameterizedTest
    @CsvSource({
            // Arithmetic: left,right,operator,expectedQuestion,expectedAnswer
            "5,3,ADD,5 + 3,8",
            "5,3,MULTIPLY,5 * 3,15",
            "10,2,DIVIDE,10 / 2,5",
            "7,4,MODULO,7 % 4,3",
            // Boolean: left,right,operator,expectedQuestion,expectedAnswer
            "true,true,AND,true && true,true",
            "true,false,AND,true && false,false",
            "false,true,OR,false || true,true",
            "true,false,XOR,true ^ false,true",
            "true,true,XOR,true ^ true,false"
    })
    void testMathQuestion(String leftStr, String rightStr, Operator operator,
                          String expectedQuestion, String expectedAnswerStr) {

        Object left;
        Object right;
        Object expectedAnswer;

        // Decide if operands are boolean or integer
        if ("true".equalsIgnoreCase(leftStr) || "false".equalsIgnoreCase(leftStr)) {
            left = Boolean.parseBoolean(leftStr);
            right = Boolean.parseBoolean(rightStr);
            expectedAnswer = Boolean.parseBoolean(expectedAnswerStr);
        } else {
            left = Integer.parseInt(leftStr);
            right = Integer.parseInt(rightStr);
            expectedAnswer = Integer.parseInt(expectedAnswerStr);
        }

        MathQuestion question = new MathQuestion(left, right, operator);

        // Check question formatting
        assertEquals(expectedQuestion, question.getQuestion());

        // Check correct answer
        assertTrue(question.checkAnswer(expectedAnswer.toString()));

        // Check incorrect answer
        if (expectedAnswer instanceof Integer) {
            assertFalse(question.checkAnswer(String.valueOf((Integer) expectedAnswer + 1)));
        } else {
            assertFalse(question.checkAnswer(String.valueOf(!(Boolean) expectedAnswer)));
        }
    }
}
