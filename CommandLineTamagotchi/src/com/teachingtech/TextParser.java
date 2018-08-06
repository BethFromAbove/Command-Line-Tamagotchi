package com.teachingtech;

import java.util.Arrays;

public class TextParser {

    String instruction;
    Pet myPet = new Pet();


    public TextParser() {

    }

    public void read(String instruction) {
        //instruction = text;
        //System.out.println("instruction is" + instruction);

        switch (instruction.toLowerCase()){
            case "feed":
                System.out.println(instruction);
                this.feedPet();
                break;
            case "check":
                System.out.println(instruction);
                int[] stats = this.checkStats();

                System.out.println("Age = " +stats[0]);
                System.out.println("Hunger = " +stats[1]);
                System.out.println("Happiness = " +stats[2]);
                System.out.println("Health = " +stats[3]);
                break;
            case "check is sick":
                System.out.println(instruction);
                System.out.println(myPet.checkIsSick());
                break;
            case "cure":
                System.out.println(instruction);
                if (myPet.isSick == true){
                    myPet.isSick = false;
                    //this.curePet();
                    System.out.println("Pet is cured");
                }
                else{
                    System.out.println("Pet does not need to be cured");
                }
                break;
            case "play":
                System.out.println(instruction);
                break;
            case "clean up waste":
                System.out.println(instruction);
                myPet.cleanWaste();
                //this.clearUpWaste();
                break;
            default:
                System.out.println("Please try again");
                break;
        }




    }


    public int playGame(int guessedNumber){
        return 0;

    }

    public void feedPet(){
        int hunger = myPet.feed();

        if (hunger == 200){
            System.out.println("Pet is full");
        }
        else{
            System.out.println("Yum! Pet hunger now = " + hunger);
        }


    }

    public void curePet(){
        myPet.isSick = false;
    }

    public int[] checkStats(){

        int[] myStats = myPet.getStats();
        return myStats;

    }

    public void makeSick(){
        myPet.isSick = true;
    }

    public void clearUpWaste(){

    }

    public void sendBoardingHouse(){

    }


}
