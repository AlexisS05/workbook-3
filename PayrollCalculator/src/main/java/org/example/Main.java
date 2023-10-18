package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("employees.csv");

            BufferedReader bufReader = new BufferedReader(fileReader);
            String input;

            while((input = bufReader.readLine()) != null) {

                String[] tokens = input.split("\\|");

                Employee employee = new Employee(Integer.parseInt(tokens[0]), tokens[1], Integer.parseInt(tokens[2]), d[3]);

            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}