package com.teachingtech;


public class TextParser {

    Pet myPet = new Pet();

    TextParser() {

    }

    public void read(String instruction) {
        //System.out.println("instruction is" + instruction);

        switch (instruction.toLowerCase()){
            case "help":
                System.out.println("Commands are feed, check, check is sick, cure, clean, play, send to bed");
                break;
            case "feed":
                myPet.feed();
                break;
            case "check":
                int[] stats = myPet.getStats();

                System.out.println("Age = " +stats[0]);
                System.out.println("Hunger = " +stats[1]);
                System.out.println("Happiness = " +stats[2]);
                System.out.println("Health = " +stats[3]);
                break;
            case "check is sick":
                System.out.println(myPet.checkIsSick());
                break;
            case "cure":
                if (myPet.checkIsSick()){
                    myPet.cure();
                    System.out.println("Pet is cured");
                }
                else{
                    System.out.println("Pet does not need to be cured");
                }
                break;
            case "play":
                Game myGame = new Game();
                System.out.println(myGame.getResult());
                System.out.println("Happiness is now " + myPet.setHappiness());
                break;
            case "clean":
                myPet.cleanWaste();
                break;
            case "send to bed":
                myPet.sendToBed();
                break;
            case "wake up":
                System.out.println(myPet.name + " is awake!");
                myPet.sleep = false;
                myPet.growUp();
                break;
            default:
                System.out.println("Please try again");
                break;
        }
    }

    public void setName(String name){
        myPet.setName(name);
    }
}
