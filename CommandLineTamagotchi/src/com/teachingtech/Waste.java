package com.teachingtech;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Waste {

    private boolean petSick = false;
    private boolean cleaned = false;

    Waste(){
        System.out.println("Waste made");
        Toolkit.getDefaultToolkit().beep(); // beep

        Timer wasteAgeTimer = new Timer();
        int timeTilSick = 5000; //5 secs from waste to sick

        wasteAgeTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (cleaned){ //checks to see if waste has been cleaned up, otherwise makes pet sick
                    wasteAgeTimer.cancel();//cancel timer if cleaned up
                }
                else {
                    petSick = true; // pet gets sick after 5s of waste arriving
                }

            }
        }, timeTilSick, 10000); //keeps making pet sick if not cleaned up
    }

    public boolean makePetSick(){ //getter
        return petSick;
    }

    public void resetPetSick(){ //setter
        petSick = false;
    }

    public void setClean(){
        cleaned = true;
    }

}
