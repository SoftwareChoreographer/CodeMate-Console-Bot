package bot.data;

import bot.models.Operator;
import bot.models.QuestionType;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Loads quiz questions from a CSV file located in the resources' folder.
 * <p>
 * This class:
 * - Implements QuestionSource (interface)
 * - Converts raw CSV rows into QuestionData objects
 * - Contains NO quiz logic and NO user interaction
 */
public class CsvQuestionSource implements QuestionSource {

    private final String csvPath;

    public CsvQuestionSource(String csvPath) {
        this.csvPath = csvPath;
    }

    @Override
    public List<QuestionData> loadQuestions() {
        List<QuestionData> questions = new ArrayList<>();

        InputStream inputStream = getClass()
                .getClassLoader()
                .getResourceAsStream(csvPath);

        if (inputStream == null) {
            throw new IllegalStateException(
                    "CSV file not found: " + csvPath
            );
        }

        try (BufferedReader reader =
                     new BufferedReader(new InputStreamReader(inputStream))) {

            String line;
            boolean isHeader = true;

            while ((line = reader.readLine()) != null) {

                // Skip CSV header
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String[] tokens = line.split(",", -1);

                QuestionData questionData = parseLine(tokens);
                questions.add(questionData);
            }

        } catch (Exception e) {
            throw new RuntimeException(
                    "Failed to load questions from CSV", e
            );
        }

        return List.copyOf(questions);
    }

    private QuestionData parseLine(String[] tokens) {

        QuestionType questionType = QuestionType.valueOf(tokens[0]);
        String questionText = tokens[1];

        String leftOperand = normalize(tokens[2]);
        String rightOperand = normalize(tokens[3]);

        Operator operator = parseOperator(tokens[4]);
        String expectedAnswer = tokens[5];

        return new QuestionData(
                questionType,
                questionText,
                leftOperand,
                rightOperand,
                operator,
                expectedAnswer
        );
    }

    private Operator parseOperator(String value) {
        if (value == null || value.isBlank()) {
            return null; // Programming questions may not have operators
        }
        return Operator.valueOf(value);
    }

    private String normalize(String value) {
        return value == null || value.isBlank() ? null : value;
    }
}
