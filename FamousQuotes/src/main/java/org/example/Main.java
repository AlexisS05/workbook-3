package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Scanner scanner = new Scanner(System.in);
        String[] quotes = {
                "You snooze, you lose",
                "When the going gets tough, the tough get going",
                "Always smile! It will make a difference!",
                "Never give up! You aren't alone.",
                "Keep pushing forward. You got this!",
                "Believe in yourself! Always reach out!",
                "Don't stop! Keep going!",
                "Take it one step at a time.",
                "There is always light at the end of the tunnel.",
                "Be open! It can lead to new paths."

        };
        try {
            char choice = tryAgainInput(scanner, "Would you like to enter a number for a quote? if yes, type (Y), if no you will generate a random quote. type(N): ");
            switch (choice) {
                case 'Y': {
                    boolean isValid = false;
                    int userValue = 0;
                    while (!isValid) {
                        userValue = getIntegerInput(scanner, "Enter a number between 1 and 10: ");
                        if (userValue >= 1 && userValue <= quotes.length) {
                            System.out.println("You selected: " + quotes[userValue - 1]);
                            isValid = true;
                        } else {
                            System.out.println("Sorry, that's not a valid number between 1 and 10. Please try again.");
                        }
                    }
                }
                case 'N': {
                    int randomNum = getRandomNumber(1, 10);
                    System.out.println("You got: " + quotes[randomNum - 1]);
                    break;
                }
                default:
                    System.out.println("Something happened!");
            }
            repromptUser(scanner);
        } catch (Exception e) {
            System.out.println("Sorry I couldn't get that. Please try again. ");
        }
    }

    public static int getIntegerInput(Scanner scanner, String userInput) {
        System.out.print(userInput);
        return scanner.nextInt();
    }

    public static char tryAgainInput(Scanner scanner, String userInput) {
        System.out.print(userInput);
        return scanner.nextLine().toUpperCase().charAt(0);
    }

    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static char repromptUser(Scanner scanner) {
        char exitChoice = tryAgainInput(scanner, "Do you want to continue? Type (Y) to continue, (N) to exit: ");
        return exitChoice;
    }
}