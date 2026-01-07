package bot;

import bot.services.AgeGuessService;
import bot.services.CountingService;
import bot.services.QuizService;
import bot.utils.InputHelper;

import java.util.Scanner;

public class CodeMate {

    private static final String BOT_NAME = "CodeMate";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        QuizService quizService = new QuizService();
        AgeGuessService ageGuessService = new AgeGuessService();
        CountingService countingService = new CountingService();

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
                case 1:
                    int age = ageGuessService.guessAge(scanner, userName);
                    System.out.println(userName + ", I guess your age is: " + age + " years!");
                    break;

                case 2:
                    countingService.countNumbers(scanner, userName);
                    break;

                case 3:
                    quizService.runQuiz(scanner, userName);
                    break;

                case 4:
                    System.out.println("\nYour final quiz score: " + quizService.getQuizScore());
                    System.out.println("Goodbye! Keep practicing Java");
                    running = false;
                    break;

                default:
                    System.out.println("Wrong choice. Try again.");
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\nChoose an option:");
        System.out.println("1. Age Guessing Game");
        System.out.println("2. Counting Demo");
        System.out.println("3. Programming Quiz");
        System.out.println("4. Exit");
        System.out.print("Your choice: ");
    }
}
