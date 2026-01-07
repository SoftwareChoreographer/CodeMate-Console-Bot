package bot.services;

import java.util.Scanner;
import static bot.utils.InputHelper.readInt;

public class AgeGuessService {

    public int calculateAge(int rem3, int rem5, int rem7) {
        return (rem3 * 70 + rem5 * 21 + rem7 * 15) % 105;
    }

    // Returns the calculated age instead of printing
    public int guessAge(Scanner scanner, String userName) {
        System.out.println("\nWelcome " + userName + " to The Age Oracle!\n");
        System.out.println("\nLet's guess your age using a math trick!");

        System.out.print("Remainder when your age is divided by 3: ");
        int rem3 = readInt(scanner);

        System.out.print("Remainder when your age is divided by 5: ");
        int rem5 = readInt(scanner);

        System.out.print("Remainder when your age is divided by 7: ");
        int rem7 = readInt(scanner);

        return calculateAge(rem3, rem5, rem7);
    }
}
