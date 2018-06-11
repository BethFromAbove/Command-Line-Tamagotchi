package com.teachingtech;

import java.lang.reflect.Array;

public class Pet {
    int age;
    int hunger;
    int happiness;
    int health;
    boolean isSick;
    Waste waste;

    void Pet(){

    }

    void makeWaste(){

    }

    void growUp(int age){

    }

    public int getAge(int age){
        return 0;

    }

    public int[] getStats(int age, int hunger, int happiness, int health){
        int[] stats = {0, 0, 0, 0};
        return stats;

    }

    public int setHunger(){
        return 0;

    }

    public int setHappiness(){
        return 0;

    }

    public int setHealth(){
        return 0;

    }

    public boolean checkIsSick(){
        return true;

    }

    public Waste checkWaste(){
        return waste;

    }

}
