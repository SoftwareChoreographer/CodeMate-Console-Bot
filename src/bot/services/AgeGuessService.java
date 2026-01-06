package bot.services;

import java.util.Scanner;

import static bot.utils.InputHelper.readInt;

public class AgeGuessService {

    public void guessAge(Scanner scanner, String userName) {
        System.out.println("\n" + userName + ", let's guess your age using a math trick!");

        System.out.print("Remainder when your age is divided by 3: ");
        int rem3 = readInt(scanner);

        System.out.print("Remainder when your age is divided by 5: ");
        int rem5 = readInt(scanner);

        System.out.print("Remainder when your age is divided by 7: ");
        int rem7 = readInt(scanner);

        int age = (rem3 * 70 + rem5 * 21 + rem7 * 15) % 105;
        System.out.println("I guess your age is: " + age + " years old!");
    }
}
