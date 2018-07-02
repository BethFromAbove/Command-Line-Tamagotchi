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
    Waste waste;

    Pet(){
        age = 0;
        hunger = 100;
        happiness = 100;
        health = 100;
        isSick = false;

        this.growUp(); //start timers when created
        this.makeWaste();

    }

    void makeWaste(){ //make waste at random intervals

        Random rand = new Random();
        int max = 5000;
        int min = 2000;
        int n = rand.nextInt((max - min) + 1) + min;

        Timer wasteTimer = new Timer();

        wasteTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                Waste waste = new Waste();
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
                if (age % 100 == 0) { //reduce hunger (confusing?) by 10 every 10 seconds
                    hunger = hunger - 10;
                }
            }
        }, 1000, 1000);//age increases by 10 every second



    }

    public int getAge(){
        return age;
    }

    public int[] getStats(){
        //int[] stats = {0, 0, 0, 0};
        int[] stats = {age, hunger, happiness, health};
        return stats;

    }

    public int setHunger(){
        if (hunger >= 100){
            return 200; // pet is full
        }
        else{
            hunger = hunger + 10;
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

    public boolean checkIsSick(){ // included in original plan, but seems pointless. will re-address later
        if (isSick == true){
            return true;
        }
        else {
            return false;
        }
    }

    public Waste checkWaste(){
        return waste;

    }

}
