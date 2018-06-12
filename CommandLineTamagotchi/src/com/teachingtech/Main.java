package com.teachingtech;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        TextParser textParser;
        Pet pet;
        Game game;
        BoardingHouse boardinghouse;

        textParser = new TextParser();
        pet = new Pet();
        game = new Game();
        boardinghouse = new BoardingHouse();

        Scanner scan = new Scanner(System.in);

        String name;
        System.out.println("Enter your pet's name: ");
        name = scan.nextLine();
        System.out.println("Your pet's name is "+name);

    }

    public void newTamagotchi(){


    }
}

