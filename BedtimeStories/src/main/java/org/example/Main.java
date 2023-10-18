package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try{
            FileInputStream file1 = new FileInputStream("goldilocks.txt");
            FileInputStream file2 = new FileInputStream("hansel_and_gretel.txt");
            FileInputStream file3 = new FileInputStream("mary_had_a_little_lamb.txt");

            Scanner scanner = new Scanner(System.in);

            System.out.println("Hi! Welcome. We have 3 stories you can choose from: \n 1. Goldilocks.txt \n 2. Hansel and Gretel \n 3. Mary had a little lamb ");

            String input = "";
            int lineNum = 0;
            while (true) {
                char choice = getStringInput(scanner, "Enter the number of a story to read: ");
                switch (choice) {
                    case '1':
                        displayOutput(input, lineNum, file1);
                        break;
                    case '2':
                        displayOutput(input, lineNum, file2);
                        break;
                    case '3':
                        displayOutput(input, lineNum, file3);
                        break;
                    default:
                        System.out.println("Sorry I couldn't get that. Please try again.");
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static char getStringInput(Scanner scanner, String prompt){
        System.out.print(prompt);
        return scanner.nextLine().charAt(0);
    }

    public static void displayOutput(String input, int lineNum, FileInputStream file){
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()) {
            input = scanner.nextLine();
            System.out.println(++lineNum+". " + input);
        }
    }
}