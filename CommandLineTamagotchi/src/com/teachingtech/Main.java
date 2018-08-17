package com.teachingtech;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to your Command line Tamagotchi!");

        System.out.println("Enter your pet's name: ");
        String name = scan.nextLine();

        TextParser textParser = new TextParser();

        System.out.println("Your pet's name is " + name);
        textParser.setName(name);

        System.out.println("Commands you can use are feed, check, check is sick, cure, clean, play and send to bed.");
        System.out.println("If you want a reminder of these, type 'help'. ");

        System.out.println("What would you like to do?");

        while (true){
            String text = scan.nextLine();
            textParser.read(text);
        }
    }
}

