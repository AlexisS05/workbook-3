package org.example;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter date = null;

        // Date 1
        date = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(date.format(today));
        // Date 2
        System.out.println(LocalDate.now());
        // Date 3
        date = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        System.out.println(date.format(today));
        // Date 4
        date = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy, HH:mm");
        System.out.println(date.format(today));
        // Date 5
        date = DateTimeFormatter.ofPattern("HH:mm, 'on' dd-MMM-yyyy");
        System.out.println(date.format(today));


    }
}