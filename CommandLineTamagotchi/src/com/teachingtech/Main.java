package com.teachingtech;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        TextParser textParser;
        //Pet pet;
        Game game;
        BoardingHouse boardinghouse;

        textParser = new TextParser();
        //Pet myPet = new Pet();
        game = new Game();
        boardinghouse = new BoardingHouse();

        Scanner scan = new Scanner(System.in);

        String name;
        System.out.println("Enter your pet's name: ");
        name = scan.nextLine();



        System.out.println("Your pet's name is "+name);

        System.out.println("What would you like to do?");

        int i = 0;
        while (i < 10){
            String text = scan.nextLine();
            textParser.read(text);
        }

    }

    public void newTamagotchi(){


    }
}

