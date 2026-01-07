package bot.services;

import java.util.Scanner;

import static bot.utils.InputHelper.readInt;

public class CountingService {

    public void countNumbers(Scanner scanner, String userName) {
        System.out.println("\nI can count up to any positive number!");
        System.out.print(userName + ", enter a positive number: ");

        int num = readInt(scanner);

        if (num < 0) {
            System.out.println("Please enter a positive number.");
            return;
        }

        for (int i = 0; i <= num; i++) {
            System.out.println(i);
        }

        System.out.println(userName + ", we finished counting up to " + num + "!");
    }

}
