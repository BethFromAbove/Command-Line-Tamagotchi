package com.teachingtech;

import java.util.Random;
import java.util.Scanner;

public class Game {

    private String result;

    Game(){

        Scanner scan = new Scanner(System.in);
        System.out.println("Choose rock, paper or scissors: ");
        String choice = scan.nextLine();
        result = this.playGame(choice);
    }
    String getResult(){
        return result;
    }

    private String playGame(String playerChoice){
        Random rand = new Random();
        int n = rand.nextInt(3) + 1; //random number between 1 and 3
        //1 is rock, 2 is paper, 3 is scissors

        switch (playerChoice.toLowerCase()) {
            case "rock":
                if (n == 1) {
                    return "You draw!";
                } else if (n == 2) {
                    return "You lose!";
                } else if (n == 3) {
                    return "You win!";
                }
            case "paper":
                if (n == 1) {
                    return "You win!";
                } else if (n == 2) {
                    return "You draw!";
                } else if (n == 3) {
                    return "You lose!";
                }
            case "scissors":
                if (n == 1) {
                    return "You lose!";
                } else if (n == 2) {
                    return "You win!";
                } else if (n == 3) {
                    return "You draw!";
                }
            default:
                return "Play properly!";
        }
    }

}
