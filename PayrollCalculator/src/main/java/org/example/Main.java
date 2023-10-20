package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileWriter fileWriter = null;
        try {
            Scanner scanner = new Scanner(System.in);
            FileReader fileReader = new FileReader("employees.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);
            bufReader.readLine();
            String input;
            boolean done = false;
            while (!done) {
                char fileName = getCharInput(scanner, "Enter the name of the file employee file to process: ");
                switch (fileName) {
                    case 'E':
                        StringBuilder employeeData = new StringBuilder();
                        StringBuilder employeeJson = new StringBuilder();
                        while ((input = bufReader.readLine()) != null) {
                            String[] tokens = input.split("\\|");
                            Employee employee = new Employee(Integer.parseInt(tokens[0]), tokens[1], Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
//                            System.out.printf("Here is the Employee ID: %d%nHere is the employee name: %s%nHere is the employee gross pay: %.2f%n",
//                                    employee.getEmployeeId(), employee.getName(), employee.getGrossPay());
                            employeeData.append(String.format("\nEmployee ID: %d%nEmployee name: %s%nEmployee gross pay: %.2f%n",
                                    employee.getEmployeeId(), employee.getName(), employee.getGrossPay()));
                            employeeJson.append(String.format("{\n\"Employee ID\": %d,\n\"Employee name\": \"%s\",\n\"Employee gross pay\": %.2f\n},",
                                    employee.getEmployeeId(), employee.getName(), employee.getGrossPay()));
                        }
                        if (employeeJson.length() > 0) {
                            employeeJson.setLength(employeeJson.length() - 1);
                        }
                        boolean isNotDone = false;
                        while (!isNotDone) {
                            char fileChoice;
                            System.out.println("\n1. For .csv file \n2. For .json file");
                            fileChoice = getCharInput(scanner, "Enter a number for the file type you want.");
                            switch (fileChoice) {
                                case '1':
                                    String createFileName = getStringInput(scanner, "Enter the name of the payroll file to create: ").toLowerCase();
                                    createFileName = createFileName + ".csv";
                                    fileWriter = new FileWriter(createFileName);
                                    fileWriter.write(employeeData.toString());
                                    fileWriter.close();
                                    System.out.println(createFileName);
                                    try {
                                        BufferedReader reader = new BufferedReader(new FileReader(createFileName));
                                        String line;
                                        System.out.println("Contents of " + createFileName + ":");
                                        while ((line = reader.readLine()) != null) {
                                            System.out.println(line);
                                            isNotDone = true;
                                            done = true;
                                        }
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                case '2':
                                    createFileName = getStringInput(scanner, "Enter the name of the payroll file to create: ").toLowerCase();
                                    createFileName = createFileName + ".json";
                                    fileWriter = new FileWriter(createFileName);
                                    fileWriter.write("[");
                                    fileWriter.write(employeeJson.toString());
                                    fileWriter.write("]");
                                    fileWriter.close();
                                    try {
                                        BufferedReader reader = new BufferedReader(new FileReader(createFileName));
                                        String line;
                                        System.out.println("Contents of " + createFileName + ":");
                                        while ((line = reader.readLine()) != null) {
                                            System.out.println(line);
                                            isNotDone = true;
                                            done = true;
                                        }
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                default:
                                    System.out.println("Not a valid number. Please try again.");
                            }
                        }
                        break;
                    default:
                        System.out.println("No such file. Please try again");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static char getCharInput(Scanner scanner, String prompt) {
        System.out.println(prompt);
        return scanner.next().toUpperCase().charAt(0);
    }

    public static String getStringInput(Scanner scanner, String prompt) {
        System.out.println(prompt);
        return scanner.next().toUpperCase();
    }
}