package bot;

import bot.data.CsvQuestionSource;
import bot.factories.QuestionFactory;
import bot.models.QuestionType;
import bot.models.Question;
import bot.services.AgeGuessService;
import bot.services.CountingService;
import bot.services.QuizService;
import bot.utils.InputHelper;

import java.util.Scanner;

public class CodeMate {

    private static final String BOT_NAME = "CodeMate";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AgeGuessService ageGuessService = new AgeGuessService();
        CountingService countingService = new CountingService();

        CsvQuestionSource questionSource = new CsvQuestionSource("questions.csv");
        QuestionFactory questionFactory = new QuestionFactory();

        System.out.println("==================================");
        System.out.println("Hello! My name is " + BOT_NAME);
        System.out.println(BOT_NAME + " helps you practice programming and basic math.");
        System.out.println("==================================");

        System.out.print("What's your name? ");
        String userName = scanner.nextLine().trim();
        System.out.println("Nice to meet you, " + userName + "!");

        boolean running = true;
        while (running) {
            printMenu();
            int choice = InputHelper.readInt(scanner);

            switch (choice) {
                case 1 -> {
                    int age = ageGuessService.guessAge(scanner, userName);
                    System.out.println(userName + ", I guess your age is: " + age + " years!");
                }
                case 2 -> countingService.countNumbers(scanner, userName);
                case 3 -> startQuiz(scanner, questionSource, questionFactory, userName);
                case 4 -> {
                    System.out.println("Goodbye, " + userName + "! See you next time.");
                    running = false;
                }
                default -> System.out.println("Wrong choice. Try again.");
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\nChoose an option:");
        System.out.println("1. Age Guessing Game");
        System.out.println("2. Counting Demo");
        System.out.println("3. Quiz");
        System.out.println("4. Exit");
        System.out.print("Your choice: ");
    }

    private static void startQuiz(Scanner scanner, CsvQuestionSource source, QuestionFactory factory, String userName) {
        System.out.println("\nSelect quiz type: 1 = Math, 2 = Programming");
        int quizChoice = InputHelper.readInt(scanner);

        QuestionType type = switch (quizChoice) {
            case 1 -> QuestionType.MATH;
            case 2 -> QuestionType.PROGRAMMING;
            default -> {
                System.out.println("Invalid choice, returning to main menu.");
                yield null;
            }
        };

        if (type == null) return;

        QuizService quizService = new QuizService(source, factory, type);

        System.out.println("\nStarting " + type + " Quiz for " + userName + "!");
        int score = 0;

        while (quizService.hasNextQuestion()) {
            Question q = quizService.nextQuestion();
            System.out.println("\nQuestion: " + q.getQuestion());
            System.out.print("Your answer: ");
            String answer = scanner.nextLine();

            if (quizService.checkAnswer(q, answer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect!");
            }
        }

        System.out.println("\nQuiz finished!");
        System.out.println(userName + ", your score: " + score + "/" + quizService.totalQuestions());
    }
}
