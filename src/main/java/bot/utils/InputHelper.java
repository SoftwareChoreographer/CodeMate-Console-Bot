package bot.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHelper {

    public static int readInt(Scanner scanner) {
        while (true) {
            try {
                int value = scanner.nextInt();
                scanner.nextLine(); // consume newline
                return value;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.print("Please enter a number: ");
            }
        }
    }
}
