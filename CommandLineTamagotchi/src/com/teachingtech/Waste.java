package com.teachingtech;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Waste {

    int timeTilSick = 5000;
    boolean petSick = false;
    boolean cured = false;

    Waste(){
        System.out.println("Waste made");
        Toolkit.getDefaultToolkit().beep(); // beep

        Timer wasteAgeTimer = new Timer();

        wasteAgeTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (cured){
                    wasteAgeTimer.cancel();
                }
                petSick = true; // pet gets sick after 5s of waste arriving - can be random
                Toolkit.getDefaultToolkit().beep(); // beep
                System.out.println("Pet is sick");

            }
        }, timeTilSick, 10000); //keeps making pet sick if not cleaned up

    }

    public boolean makePetSick(){ //getter
        return petSick;

    }

    public void resetPetSick(){ //setter
        petSick = false;

    }

}
