package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> inventory = readInventory();
        Scanner scanner = new Scanner(System.in);
        System.out.println("We carry the following inventory: ");
        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            System.out.printf("id: %d, %s - Price: $%.2f\n",
                    p.getId(), p.getName(), p.getPrice());
        }
        for (Product p : inventory
             ) {
            System.out.println(p.getId()+ " " + p.getName() + " " +p.getPrice());
        }
        inventory.sort((o1, o2) -> o1.getId() - o2.getId());
    }

    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<>();

        inventory.add(new Product(1, "Crayons", 5.00));
        inventory.add(new Product(2, "Pens", 3.00));
        inventory.add(new Product(3, "Pencils", 3.00));
        inventory.add(new Product(4, "Eraser", 2.00));

        return inventory;
    }

    public static ArrayList<Product> readInventory(){
        ArrayList<Product> inventory = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("products.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String input = null;
            while ((input = bufferedReader.readLine())!=null){
                String[] fields = input.split(",");
                Product product = new Product(Integer.parseInt(fields[0]), fields[1].trim(), Double.parseDouble(fields[2]));
                inventory.add(product);

            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return inventory;
    }
}