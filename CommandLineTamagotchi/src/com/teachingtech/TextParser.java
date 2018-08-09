package com.teachingtech;


public class TextParser {

    String instruction;
    Pet myPet = new Pet();

    public TextParser() {

    }

    public void read(String instruction) {
        //System.out.println("instruction is" + instruction);

        switch (instruction.toLowerCase()){
            case "feed":
                System.out.println(instruction);
                myPet.feed();
                break;
            case "check":
                System.out.println(instruction);
                int[] stats = myPet.getStats();

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
                if (myPet.isSick){
                    myPet.isSick = false;
                    System.out.println("Pet is cured");
                }
                else{
                    System.out.println("Pet does not need to be cured");
                }
                break;
            case "play":
                System.out.println(instruction);
                Game myGame = new Game();
                System.out.println(myGame.getResult());
                System.out.println("Happiness is now " + myPet.setHappiness());
                break;
            case "clean up waste":
                System.out.println(instruction);
                myPet.cleanWaste();
                break;
            case "send to boarding house":
                System.out.println(instruction);
                myPet.sendToBoardinghouse();
                break;
            case "return pet":
                System.out.println(instruction);
                System.out.println(myPet.name + " is back from boarding house");
                myPet.boarding = false;
                myPet.growUp();
                break;
            default:
                System.out.println("Please try again");
                break;
        }
    }


    public int playGame(int guessedNumber){
        return 0;
    }

    public void sendBoardingHouse(){

    }

    public void setName(String name){
        myPet.setName(name);
    }


}
