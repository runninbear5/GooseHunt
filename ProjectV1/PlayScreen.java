import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.core.WorldHandler;
import javax.swing.*;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.*;

public class PlayScreen  extends World
{
    JPanel Pan = WorldHandler.getInstance().getWorldCanvas();  
    /** The new Cursor */
    Cursor NewCursor;//used to change mouse cursor
    int timeBetweenBadAnimals = 5000;//used for spawning bad animals and later multipled by round count
    int timeBetweenGoodAnimals = 7500;//used for spawning good animals and later multipled by round count
    ArrayList badAnimalsInRound = new ArrayList<String>();//list of all bad animals
    ArrayList goodAnimalsInRound = new ArrayList<String>();//list of all good animals
    ArrayList allAnimals = new ArrayList<Actor>();//all animal actors so everything can be removed
    ArrayList animalHitCounters = new ArrayList<AnimalCounter>();//hit counters to know total amount of animals attacked
    ArrayList balloons = new ArrayList<Balloon>();//total number of balloons
    String[] goodAnimals = {"Duck", "Unicorn", "Antler"};//good animal names saved to be recreated
    String[] badAnimals = {"Goose","Cat", "Lion"};//bad animal names saved to be recreated
    Score playerScore = new Score(0);//to place player score 
    Round roundCount = new Round();//to have the round count and place it
    boolean lionUsed = false;// so lion can only be used once
    boolean lastAnimalShot = false;// to know if all the animals are shot
    long lastTimeBadAnimalPlaced = 0;//time of last bad animal placed
    long lastTimeGoodAnimalPlaced = 0;//time of last good animal placed
    public PlayScreen()
    {
        super(1280, 769, 1, false);//creates the world
        newRound();//starts the new round
        GreenfootImage image = new GreenfootImage("crosshair.png");//creates the a crosshair image
        ChangeMouseImage(image, 15,15);//sets the mouse image to the cursor
        addObject(playerScore, 1150, 700);//adds the player score
        addObject(roundCount, 44, 712);//adds the player round
        //addObject(new Dog(), 10, 500);
    }

    public void act()
    {
        /** Sets the Cursor Image to the New Cursor */
        Pan.setCursor(NewCursor);//used to set the cursor image
        int secondsTakenOff = 150*(roundCount.getRoundNumber()-1);//used to decrease time of animal spawning as rounds increase
        if(animalHitCounters.size() == 10 ||(badAnimalsInRound.size() == 0 && animalHitCounters.size()>5 && lastAnimalShot)){//checks if a new round can start
            newRound();
        }
        if(Greenfoot.mouseClicked(this)){//checks if the world is clicked on to decrease water balloons
            removeBalloon();//removes a water balloon
        }
        if(balloons.size() == 0 && animalHitCounters.size() <= 5){//checks if a game should be over
            Greenfoot.setWorld(new GameOver());
        }
        if(lastTimeBadAnimalPlaced+(timeBetweenBadAnimals-secondsTakenOff) <= System.currentTimeMillis()){//checks if a new animal should be created
            int x = ((int)(Math.random() * 2)) + 1;//creates random side placement
            if(x == 1) x = 50 ;//sets x to actuall placement location
            else if(x == 2) x = 1280;//sets x to actuall placement location
            if(badAnimalsInRound.size() != 0){//checks if there are still bad animals to be placed
                if(badAnimalsInRound.get(0).equals("Cat")){//checks what animal is being placed and adds it and sets last time animal placed
                    Cat cat = new Cat();
                    allAnimals.add(cat);
                    addObject(cat, x, 500);
                    System.out.println("Cat");
                    lastTimeBadAnimalPlaced = System.currentTimeMillis();
                }else if(badAnimalsInRound.get(0).equals("Goose")){
                   // Goose goose = new Goose();
                    allAnimals.add(new Cat());
                    addObject(new Cat(), x, 500);
                    System.out.println("Goose");
                    lastTimeBadAnimalPlaced = System.currentTimeMillis();
                }else if(badAnimalsInRound.get(0).equals("Lion")){
                    Lion lion = new Lion();
                    allAnimals.add(lion);
                    addObject(lion, x, 500);
                    System.out.println("Lion");
                    lastTimeBadAnimalPlaced = System.currentTimeMillis();
                }
                badAnimalsInRound.remove(0);//remove the animal that was placed
            }
        }
        if(lastTimeGoodAnimalPlaced+(timeBetweenGoodAnimals-secondsTakenOff) <= System.currentTimeMillis()){//checks if a new animal should be placed
            int x = ((int)(Math.random() * 2)) + 1;//creates random x location to place animal
            if(x == 1) x = 50; //sets x to actual x location
            else if(x == 2) x = 1280;//sets x to actual x location
            if(goodAnimalsInRound.size() != 0){//checks if there are animals to place still
                if(goodAnimalsInRound.get(0).equals("Antler")){//checks what animal is being placed and adds it and sets last time animal placed
                    Antler antler = new Antler();
                    allAnimals.add(antler);
                    addObject(antler, x, 500);
                    System.out.println("Antler");
                    lastTimeGoodAnimalPlaced = System.currentTimeMillis();
                }else if(goodAnimalsInRound.get(0).equals("Unicorn")){
                    Unicorn unicorn = new Unicorn(x>=1280);
                    allAnimals.add(unicorn);
                    addObject(unicorn, x, 500);
                    System.out.println("Unicorn");
                    lastTimeGoodAnimalPlaced = System.currentTimeMillis();
                }else if(goodAnimalsInRound.get(0).equals("Duck")){
                   // Duck duck = new Duck();
                    allAnimals.add(new Cat());
                    addObject(new Cat(), x, 500);
                    System.out.println("Duck");
                    lastTimeGoodAnimalPlaced = System.currentTimeMillis();
                }
                goodAnimalsInRound.remove(0);//remove the animal that was placed
            }
        }
        if(badAnimalsInRound.size() == 0 && animalHitCounters.size() <=5){//checks if the game should end
            Greenfoot.setWorld(new GameOver());
        }
        Joystick stick = new Joystick();
        System.out.println(stick.getX());
    }
        
    public void newRound(){
        lionUsed = false;//resests the lion used boolean
        lastAnimalShot = false;//resets if the last animal was shot
        for(int i=0; i<animalHitCounters.size(); i++){//removes the animal hit counters from the screen
            AnimalCounter counter = (AnimalCounter)(AnimalCounter)animalHitCounters.get(i);
            counter.removeObject();
        }
        badAnimalsInRound.clear();//clears all the bad animals
        goodAnimalsInRound.clear();//clears all the good animals
        animalHitCounters.clear();//clears the animal hit counter
        for(int i=0; i<10; i++){//refills the good and bad animals randomly
            int badAnimal = (int)(Math.random() * 11);//randomly chooses what bad animals to spawn with a weight on each animal
            int goodAnimal = (int)(Math.random() * 3);//randomly chooses what good animal to spawn
            if(badAnimal <= 5){//chooses what annimal to create accoding to the weight
                badAnimalsInRound.add(badAnimals[0]);
            }else if(badAnimal >= 8){
                badAnimalsInRound.add(badAnimals[1]);
            }else if ((badAnimal == 6 || badAnimal == 7) && !lionUsed){
                badAnimalsInRound.add(badAnimals[2]);
                lionUsed = true;
            }else if (badAnimal == 6 || badAnimal == 7){
                badAnimalsInRound.add(badAnimals[0]);
            }
            
            if(goodAnimal == 0){//chooses what good animal to screate
                goodAnimalsInRound.add(goodAnimals[0]);
            }else if(goodAnimal == 1){
                goodAnimalsInRound.add(goodAnimals[1]);
            }else if ((goodAnimal == 2)){
                goodAnimalsInRound.add(goodAnimals[2]);
            }
            //badAnimalsInRoundanimalsInRound.add("cat");
            balloons.add(new Balloon());
        }
        placeBalloons();
        roundCount.increaseRound();//method in round count to increment
        lastTimeBadAnimalPlaced = System.currentTimeMillis();//resets when an animal was placed
        lastTimeGoodAnimalPlaced = System.currentTimeMillis();//resets when an animal was placed
    }
    
    /** Or you use this Method: 
     * The image is the image, that you want the mouse to have.(The mouse has a maximum width and height for her image, if the image is too large it will be scaled on the right size)
     * XClick and YClick is the Location on the Picture where the mouse will Click */
    public void ChangeMouseImage(GreenfootImage image, int xClick, int yClick)//used to change mouse image
    {
        JPanel Panel = WorldHandler.getInstance().getWorldCanvas();
        Cursor Cursor;
        Toolkit Tk = Toolkit.getDefaultToolkit();
        Point CursorPoint= new Point(xClick,yClick);
        Cursor = Tk.createCustomCursor(image.getAwtImage(),CursorPoint,"Crosshair");
        NewCursor = Cursor;
        Panel.setCursor(Cursor);
    }
    
    public void animalHit(String animal){//gives score and hit counter to bad animals
        if(animal.equals("Goose")){//adds score according to the animal or negative screo if it is a good animal
            playerScore.addTotal(100);
            addHitCount();//adds the hit counter if the animal is bad
        }else if(animal.equals("Duck")){
            playerScore.addTotal(-100);
        }else if(animal.equals("Lion")){
            playerScore.addTotal(75);
            addHitCount();
        }else if(animal.equals("Antler")){
            playerScore.addTotal(-75);
        }else if(animal.equals("Cat")){
            playerScore.addTotal(50);
            addHitCount();  
        }else{
            playerScore.addTotal(-50);
        }
        if(badAnimalsInRound.size() == 0){
            lastAnimalShot = true;
        }//used to know when the last animal was shot
        removeBalloon();//removes a balloon when an animal is shot
    }
    
    public void addHitCount(){//used to place and create hitCounters
        AnimalCounter counter = new AnimalCounter();//creates new hit counter
        if(animalHitCounters.size() == 0){//places first counter
            addObject( counter, 445, 720);
        }else{//places the rest of the counters
            AnimalCounter oldCounter = (AnimalCounter)animalHitCounters.get(animalHitCounters.size()-1);
            addObject(counter, oldCounter.getLastX()+45, 720);
        }
        animalHitCounters.add(counter);//adds new counter to array
    }
    
    public void placeBalloons(){//places balloons according to the balloons in the array
        for(int i=0; i<balloons.size(); i++){
            if(i == 0){
                addObject((Balloon)balloons.get(i), 102, 710);
            }else{  
                Balloon oldBalloon = (Balloon)balloons.get(i-1);
                addObject((Balloon)balloons.get(i), oldBalloon.getLastX()+20, 710);
            }
        }
    }
    
    public void removeBalloon(){//removes the last balloon in the array
        if(balloons.size() > 1){
            for(int i=0; i<balloons.size(); i++){
                removeObject((Balloon)balloons.get(i));
            }       
            balloons.remove(balloons.size()-1);
            placeBalloons();
        }
    }
    
    public void attacked(String animal){//is called when an animal attacks the player
        if(animal.equals("Cat")){//decides what to do depending on the animal
            balloons.remove(balloons.size());
            balloons.remove(balloons.size());
        }else if(animal.equals("Lion")){
            Greenfoot.setWorld(new GameOver());
        }
    }

}