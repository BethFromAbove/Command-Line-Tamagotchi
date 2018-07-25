package com.teachingtech;

import java.util.Timer;
import java.util.TimerTask;

public class Waste {

    int wasteAge = 0;
    boolean makePetSick = false;

    Waste(){
        System.out.println("Waste made");


        Timer wasteAgeTimer = new Timer();

        wasteAgeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                makePetSick = true; // pet gets sick after 10s of waste arriving - can be random
                System.out.println("Pet is sick");
            }
        }, 10000);



    }

    public boolean getPetSick(){
        return makePetSick;

    }

}
