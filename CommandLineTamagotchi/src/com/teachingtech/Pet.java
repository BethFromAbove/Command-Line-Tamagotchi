package com.teachingtech;

import java.lang.reflect.Array;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Pet {
    int age;
    int hunger;
    int happiness;
    int health;
    boolean isSick;


    Pet(){
        age = 0;
        hunger = 0;
        happiness = 100;
        health = 100;
        isSick = false;

        this.growUp(); //start timers when created
        this.makeWaste();

    }

    public void makeWaste(){ //make waste at random intervals

        Random rand = new Random();
        int max = 5000;
        int min = 2000;
        int n = rand.nextInt((max - min) + 1) + min;

        Timer wasteTimer = new Timer();

        wasteTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                Waste waste = new Waste(); //makes waste
                Timer wasteChecker = new Timer(); //checks every 10 seconds to see if waste has made pet sick

                wasteChecker.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        if (waste.makePetSick){
                            isSick = true;//change the value for the pet
                            waste.makePetSick = false;//reset petSick so it doesn't keep triggering
                        }
                    }
                }, 1000, 1000);

            }
        }, n); //make a waste at a random time between a min and max value in ms

                //currently just makes one waste
    }

    void growUp(){

        Timer ageTimer = new Timer();

        ageTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                age = age + 10;
                if (age % 100 == 0) { //increase hunger by 10 every 10 seconds
                    hunger = hunger + 10;
                    if (isSick){
                        health = health - 10; //decrease health if sick
                    }
                }
            }
        }, 1000, 1000);//age increases by 10 every second



    }

    public int getAge(){
        return age;
    }

    public int[] getStats(){
        int[] stats = {age, hunger, happiness, health};
        return stats;

    }

    public int feed(){
        if (hunger >= 100){
            return 200; // pet is full
        }
        else{
            hunger = hunger - 10;
            return hunger;
        }

    }

    public int setHappiness(){
        if (happiness >= 100){
            return 200; // pet is happy
        }
        else {
            happiness = happiness + 10;
            return happiness;
        }

    }

    public int setHealth(){

        return 0;

    }

    public void setSick(){
        isSick = true;
    }

    public boolean checkIsSick(){
        return isSick;
    }

    public boolean checkWaste(){
        return true;

    }

}
