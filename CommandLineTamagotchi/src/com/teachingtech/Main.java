package com.teachingtech;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        TextParser textParser = new TextParser();
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter your pet's name: ");
        String name = scan.nextLine();

        System.out.println("Your pet's name is " + name);
        textParser.setName(name);

        System.out.println("What would you like to do?");

        while (true){
            String text = scan.nextLine();
            textParser.read(text);
        }
    }
}

