package com.teachingtech;

import java.awt.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Pet {
    private int age;
    private int hunger;
    private int happiness;
    private int health;
    private boolean isSick;
    private int clean;
    String name;
    boolean sleep;


    Pet(){
        age = 0;
        hunger = 0;
        happiness = 100;
        health = 100;
        isSick = false;
        clean = 0; //default clean state, 1 is dirty
        sleep = false;

        this.growUp(); //start timers when created
        this.makeWaste();

    }

    private void makeWaste(){ //make waste at random intervals

        Random rand = new Random();
        int max = 500000; //500s
        int min = 100000; //100s
        int n = rand.nextInt((max - min) + 1) + min;

        Timer wasteTimer = new Timer();

        wasteTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                if (!sleep) { //only make waste if pet is not asleep
                Waste waste = new Waste(); //makes waste
                clean = 1; //dirty
                //System.out.println("clean = " + clean);

                Timer wasteChecker = new Timer(); //checks every 10 seconds to see if waste has made pet sick

                wasteChecker.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        if (waste.makePetSick()) {
                            isSick = true;//change the value for the pet
                            Toolkit.getDefaultToolkit().beep(); // beep
                            System.out.println("Pet is sick");
                            waste.resetPetSick(); //waste can make pet sick more than once
                        }

                        if (clean == 0) {//for some reason boolean going back to true, now int
                            //System.out.println("clean = " + clean);
                            wasteChecker.cancel();
                            waste.setClean();
                        }
                    }
                }, 1000, 1000);
            }
            }
        }, 10000, 30000); //make a waste at a random time between a min and max value in ms

    }

    void growUp(){

        Timer ageTimer = new Timer();

        ageTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                age = age + 10; //age increases by 10 every second

                if (sleep){
                    ageTimer.cancel();
                    System.out.println(name + " is asleep, age is paused at " + age);
                }

                if (age % 100 == 0) { //increase hunger by 10 every 10 seconds
                    hunger = hunger + 10;
                    happiness = happiness - 10; //pet gets sadder (change rates of change later)
                    if (hunger == 80)
                    {
                        Toolkit.getDefaultToolkit().beep(); //beep
                        System.out.println(name + " is very hungry!");
                    }
                    else if (hunger == 100)
                    {
                        Toolkit.getDefaultToolkit().beep();
                        System.out.println(name + " died of hunger. Age was " + age);
                        System.exit(0);
                    }
                    if (isSick){
                        health = health - 10; //decrease health if sick every 10 seconds
                        if (health ==0){
                            Toolkit.getDefaultToolkit().beep();
                            System.out.println(name + " died of sickness. Age was " + age);
                            System.exit(2);
                        }
                    }
                }
            }
        }, 1000, 1000); //starts after one second then repeats every second
    }

    void setName(String input){
        this.name = input;
    }

    int[] getStats(){
        int[] stats = {age, hunger, happiness, health};
        return stats;
    }

    void feed(){
        if(happiness <= 30){
            System.out.println(name + " is too sad to eat :(");
        }
        else{
            if (hunger <= 0){
                System.out.println(name + " is full");
            }
            else{
                hunger = hunger - 10;
                System.out.println("Yum! " + name + " hunger now = " + hunger);
                if (health < 100){
                    health = health + 5;
                    System.out.println(name + " is feeling a bit better now. Health = " + health);
                }
            }
        }
    }

    int setHappiness(){
        if (happiness >= 100){
            System.out.println(name + " is happy as can be");
            return happiness; // pet is happy
        }
        else {
            happiness = happiness + 10;
            return happiness;
        }
    }

    void sendToBed(){
        if (sleep){
            System.out.println(name + " is already asleep");
        }
        else{
            if (clean == 1){
                System.out.println(name + " cannot sleep now, this place is filthy!");
            }
            else {
                sleep = true;
                System.out.println(name + " has gone to bed. All systems paused");
                System.out.println("Type 'wake up' to get pet up");
            }
        }
    }

    void cure(){
        isSick = false;
    }

    boolean checkIsSick(){
        return isSick;
    }

    void cleanWaste(){
        clean = 0;
        System.out.println("Everything is nice and clean");
    }

}
