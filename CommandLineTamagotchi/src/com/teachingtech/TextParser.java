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
        if (instruction.equals("feed")){
            System.out.println(instruction);
            this.feedPet();

        }
        else if (instruction.equals("play")){
            System.out.println(instruction);

        }
        else if (instruction.equals("cure")){
            System.out.println(instruction);
        }
        else if (instruction.equals("check")){
            System.out.println(instruction);
            //System.out.println(Arrays.toString(this.checkStats()));

            int[] stats = this.checkStats();

            System.out.println("Age = " +stats[0]);
            System.out.println("Hunger = " +stats[1]);
            System.out.println("Happiness = " +stats[2]);
            System.out.println("Health = " +stats[3]);
        }
        else if (instruction.equals("tidy")){
            System.out.println(instruction);
            this.clearUpWaste();
        }



    }


    public int playGame(int guessedNumber){
        return 0;

    }

    public void feedPet(){
        int hunger = myPet.setHunger();

        if (hunger == 200){
            System.out.println("Pet is full");
        }
        else{
            System.out.println("Yum! Pet hunger now = " + hunger);
        }


    }

    public void curePet(){

    }

    public int[] checkStats(){

        int[] myStats = myPet.getStats();
        return myStats;

    }

    public void inspectWaste(Waste waste){

    }

    public void clearUpWaste(){

    }

    public void sendBoardingHouse(){

    }


}
