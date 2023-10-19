package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("employees.csv");

            BufferedReader bufReader = new BufferedReader(fileReader);
            String input = null;

            bufReader.readLine();

            while((input = bufReader.readLine()) != null) {

                String[] tokens = input.split("\\|");

                Employee employee = new Employee(Integer.parseInt(tokens[0]), tokens[1], Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
                System.out.printf("Here is the Employee ID: %d%nHere is the employee name: %s%nHere is the employee gross pay: %.2f%n",
                        employee.getEmployeeId(), employee.getName(), employee.getGrossPay());
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}