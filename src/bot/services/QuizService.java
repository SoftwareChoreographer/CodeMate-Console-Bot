package bot.services;

import java.util.Scanner;

import static bot.utils.InputHelper.readInt;

public class QuizService {
    private int quizScore = 0;

    public void runQuiz(Scanner scanner, String userName) {
        System.out.println("\n--- Programming Quiz ---");
        System.out.println("Why do we use methods in programming?");
        System.out.println("1. To repeat code without writing it again");
        System.out.println("2. To make code run faster");
        System.out.println("3. To organize code into reusable blocks");
        System.out.println("4. Just for fun");
        System.out.print(userName + ", your answer: ");

        int answer = readInt(scanner);

        if (answer == 3) {
            quizScore++;
            System.out.println("Correct! 🎉");
        } else {
            System.out.println("Incorrect. The correct answer is 3.");
        }

        System.out.println("Current quiz score: " + quizScore);
    }

    public int getQuizScore() {
        return quizScore;
    }
}
