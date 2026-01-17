package bot;

import bot.services.AgeGuessService;
import bot.services.CountingService;
import bot.services.QuizService;
import bot.data.CsvQuestionSource;
import bot.factories.QuestionFactory;
import bot.models.QuestionType;
import bot.models.Question;
import bot.utils.InputHelper;

import java.util.Scanner;

public class CodeMate {

    // ANSI colors for aesthetics
    private static class ConsoleColors {
        public static final String RESET = "\033[0m";
        public static final String BOLD = "\033[1m";
        public static final String UNDERLINE = "\033[4m";
        public static final String CYAN_BOLD = "\033[1;36m";
        public static final String GREEN = "\033[0;32m";
        public static final String RED = "\033[0;31m";
        public static final String YELLOW = "\033[0;33m";
        public static final String MAGENTA = "\033[0;35m";
        public static final String BLUE_BOLD = "\033[1;34m";
    }

    private static final String BOT_NAME = "CodeMate";

    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Services
        AgeGuessService ageGuessService = new AgeGuessService();
        CountingService countingService = new CountingService();
        CsvQuestionSource source = new CsvQuestionSource("questions.csv");
        QuestionFactory factory = new QuestionFactory();
        QuizService mathQuiz = new QuizService(source, factory, QuestionType.MATH);
        QuizService programmingQuiz = new QuizService(source, factory, QuestionType.PROGRAMMING);

        // Welcome, Banner
        printBanner();

        System.out.print(ConsoleColors.YELLOW + "What's your name? " + ConsoleColors.RESET);
        String userName = scanner.nextLine().trim();
        System.out.println(ConsoleColors.GREEN + "\nNice to meet you, " + userName + "!" + ConsoleColors.RESET);

        boolean running = true;
        while (running) {
            printMainMenu();
            int choice = InputHelper.readInt(scanner);

            switch (choice) {
                case 1 -> {
                    int age = ageGuessService.guessAge(scanner, userName);
                    printBoxedMessage(userName + ", I guess your age is: " + age + " years!", ConsoleColors.MAGENTA);
                }
                case 2 -> countingService.countNumbers(scanner, userName);
                case 3 -> runQuiz(scanner, mathQuiz, programmingQuiz, userName);
                case 4 -> {
                    printBoxedMessage("Goodbye, " + userName + "! See you next time!", ConsoleColors.BLUE_BOLD);
                    running = false;
                }
                default -> printBoxedMessage("Invalid choice. Please try again.", ConsoleColors.RED);
            }
        }

        scanner.close();
    }

    private static void printBanner() {
        String line = "=".repeat(50);
        System.out.println(ConsoleColors.CYAN_BOLD + line + ConsoleColors.RESET);
        System.out.println(ConsoleColors.CYAN_BOLD + " Welcome to " + BOT_NAME + " - Your Learning Companion " + ConsoleColors.RESET);
        System.out.println(ConsoleColors.CYAN_BOLD + " Practice Programming & Basic Math in a Fun Way " + ConsoleColors.RESET);
        System.out.println(ConsoleColors.CYAN_BOLD + line + ConsoleColors.RESET);
    }

    private static void printMainMenu() {
        System.out.println("\n" + ConsoleColors.UNDERLINE + ConsoleColors.BOLD + "Main Menu" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + "1. Age Guessing Game" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + "2. Counting Demo" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + "3. Take a Quiz" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + "4. Exit" + ConsoleColors.RESET);
        System.out.print(ConsoleColors.YELLOW + "Your choice: " + ConsoleColors.RESET);
    }

    private static void runQuiz(Scanner scanner, QuizService mathQuiz, QuizService programmingQuiz, String userName) {
        System.out.println("\n" + ConsoleColors.UNDERLINE + ConsoleColors.BOLD + "Quiz Selection" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + "1. Math Quiz" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + "2. Programming Quiz" + ConsoleColors.RESET);
        System.out.print(ConsoleColors.YELLOW + "Choose a quiz: " + ConsoleColors.RESET);

        int quizChoice = InputHelper.readInt(scanner);
        QuizService selectedQuiz = quizChoice == 1 ? mathQuiz : programmingQuiz;

        printBoxedMessage("Starting the quiz! Answer the following questions:", ConsoleColors.CYAN_BOLD);

        int score = 0;
        int total = Math.min(5, selectedQuiz.totalQuestions());

        for (int i = 0; i < total && selectedQuiz.hasNextQuestion(); i++) {
            Question question = selectedQuiz.nextQuestion();
            System.out.print(ConsoleColors.YELLOW + "Q" + (i + 1) + ": " + question.getQuestion() + " = " + ConsoleColors.RESET);
            String answer = scanner.nextLine().trim();

            if (selectedQuiz.checkAnswer(question, answer)) {
                printInlineFeedback("Correct!", ConsoleColors.GREEN);
                score++;
            } else {
                printInlineFeedback("Wrong!", ConsoleColors.RED);
            }
        }

        printBoxedMessage(userName + ", your quiz score: " + score + "/" + total, ConsoleColors.MAGENTA);
    }

    private static void printBoxedMessage(String message, String color) {
        String line = "=".repeat(message.length() + 4);
        System.out.println(color + line + ConsoleColors.RESET);
        System.out.println(color + "| " + message + " |" + ConsoleColors.RESET);
        System.out.println(color + line + ConsoleColors.RESET);
    }

    private static void printInlineFeedback(String message, String color) {
        System.out.println(color + message + ConsoleColors.RESET);
    }
}
