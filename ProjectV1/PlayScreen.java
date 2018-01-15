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
    Cursor NewCursor;
    int roundNumber = 0;
    int timeBetweenBadAnimals = 5000;
    int timeBetweenGoodAnimals = 10000;
    ArrayList badAnimalsInRoundanimalsInRound = new ArrayList<String>();
    ArrayList goodAnimalsInRoundanimalsInRound = new ArrayList<String>();
    ArrayList animalHitCounters = new ArrayList<AnimalCounter>();
    ArrayList balloons = new ArrayList<Balloon>();
    String[] goodAnimals = {"duck", "horse", "deer"};
    String[] badAnimals = {"goose","cat", "lion"};
    Score playerScore = new Score(0);
    Round roundCount = new Round();
    boolean lionUsed = false;
    boolean lastAnimalShot = false;
    long lastTimeBadAnimalPlaced = 0;
    long lastTimeGoodAnimalPlaced = 0;
    public PlayScreen()
    {
        super(1280, 769, 1, false);
        newRound();
        GreenfootImage image = new GreenfootImage("crosshair.png");
        ChangeMouseImage(image, 15,15);
        addObject(playerScore, 1150, 700);
        addObject(roundCount, 44, 712);
    }

    public void act()
    {
        /** Sets the Cursor Image to the New Cursor */
        Pan.setCursor(NewCursor);
        int secondsTakenOff = 150*(roundCount.getRoundNumber()-1);
        if(animalHitCounters.size() == 10 ||(badAnimalsInRoundanimalsInRound.size() == 0 && animalHitCounters.size()>5 && lastAnimalShot)){
            newRound();
        }
        if(Greenfoot.mouseClicked(this)){
            removeBalloon();
        }
        if(balloons.size() == 0 && animalHitCounters.size() <= 5){
            Greenfoot.setWorld(new GameOver());
        }
        if(lastTimeBadAnimalPlaced+(timeBetweenBadAnimals-secondsTakenOff) <= System.currentTimeMillis()){
            int x = ((int)(Math.random() * 2)) + 1;
            if(x == 1) x = 50 ;
            else if(x == 2) x = 1280;
            if(badAnimalsInRoundanimalsInRound.size() != 0){
                if(badAnimalsInRoundanimalsInRound.get(0).equals("cat")){
                    addObject(new Cat(), x, 500);
                    System.out.println("Cat");
                    lastTimeBadAnimalPlaced = System.currentTimeMillis();
                }else if(badAnimalsInRoundanimalsInRound.get(0).equals("goose")){
                    addObject(new Cat(), x, 500);
                    System.out.println("Goose");
                    lastTimeBadAnimalPlaced = System.currentTimeMillis();
                }else if(badAnimalsInRoundanimalsInRound.get(0).equals("lion")){
                    addObject(new Cat(), x, 500);
                    System.out.println("Lion");
                    lastTimeBadAnimalPlaced = System.currentTimeMillis();
                }
                badAnimalsInRoundanimalsInRound.remove(0);
            }
        }
        if(lastTimeGoodAnimalPlaced+(timeBetweenGoodAnimals-secondsTakenOff) <= System.currentTimeMillis()){
            int x = ((int)(Math.random() * 2)) + 1;
            if(x == 1) x = 50 ;
            else if(x == 2) x = 1280;
            if(goodAnimalsInRoundanimalsInRound.size() != 0){
                if(goodAnimalsInRoundanimalsInRound.get(0).equals("deer")){
                    addObject(new Cat(), x, 500);
                    System.out.println("deer");
                    lastTimeGoodAnimalPlaced = System.currentTimeMillis();
                }else if(goodAnimalsInRoundanimalsInRound.get(0).equals("horse")){
                    addObject(new Cat(), x, 500);
                    System.out.println("horse");
                    lastTimeGoodAnimalPlaced = System.currentTimeMillis();
                }else if(goodAnimalsInRoundanimalsInRound.get(0).equals("duck")){
                    addObject(new Cat(), x, 500);
                    System.out.println("duck");
                    lastTimeGoodAnimalPlaced = System.currentTimeMillis();
                }
                goodAnimalsInRoundanimalsInRound.remove(0);
            }
        }
        if(badAnimalsInRoundanimalsInRound.size() == 0 && animalHitCounters.size() <=5){
            Greenfoot.setWorld(new GameOver());
        }
    }
        
    public void newRound(){
        lionUsed = false;
        lastAnimalShot = false;
        for(int i=0; i<animalHitCounters.size(); i++){
            AnimalCounter counter = (AnimalCounter)(AnimalCounter)animalHitCounters.get(i);
            counter.removeObject();
        }
        badAnimalsInRoundanimalsInRound.clear();
        animalHitCounters.clear();
        for(int i=0; i<10; i++){
            int badAnimal = (int)(Math.random() * 11);
            int goodAnimal = (int)(Math.random() * 3);
            if(badAnimal <= 5){
                badAnimalsInRoundanimalsInRound.add(badAnimals[0]);
            }else if(badAnimal >= 8){
                badAnimalsInRoundanimalsInRound.add(badAnimals[1]);
            }else if ((badAnimal == 6 || badAnimal == 7) && !lionUsed){
                badAnimalsInRoundanimalsInRound.add(badAnimals[2]);
                lionUsed = true;
            }else if (badAnimal == 6 || badAnimal == 7){
                badAnimalsInRoundanimalsInRound.add(badAnimals[0]);
            }
            
            if(goodAnimal == 0){
                goodAnimalsInRoundanimalsInRound.add(goodAnimals[0]);
            }else if(goodAnimal == 1){
                goodAnimalsInRoundanimalsInRound.add(goodAnimals[1]);
            }else if ((goodAnimal == 2)){
                goodAnimalsInRoundanimalsInRound.add(goodAnimals[2]);
            }
            //badAnimalsInRoundanimalsInRound.add("cat");
            balloons.add(new Balloon());
        }
        placeBalloons();
        roundCount.increaseRound();
        lastTimeBadAnimalPlaced = System.currentTimeMillis();
        lastTimeGoodAnimalPlaced = System.currentTimeMillis();
    }
    
    /** Or you use this Method: 
     * The image is the image, that you want the mouse to have.(The mouse has a maximum width and height for her image, if the image is too large it will be scaled on the right size)
     * XClick and YClick is the Location on the Picture where the mouse will Click */
    public void ChangeMouseImage(GreenfootImage image, int xClick, int yClick)
    {
        JPanel Panel = WorldHandler.getInstance().getWorldCanvas();
        Cursor Cursor;
        Toolkit Tk = Toolkit.getDefaultToolkit();
        Point CursorPoint= new Point(xClick,yClick);
        Cursor = Tk.createCustomCursor(image.getAwtImage(),CursorPoint,"Crosshair");
        NewCursor = Cursor;
        Panel.setCursor(Cursor);
    }
    
    public void animalHit(String animal){
        if(animal.equals("goose")){
            playerScore.addTotal(100);
        }else if(animal.equals("duck")){
            playerScore.addTotal(-100);
        }else if(animal.equals("lion")){
            playerScore.addTotal(75);
        }else if(animal.equals("deer")){
            playerScore.addTotal(-75);
        }else if(animal.equals("cat")){
            playerScore.addTotal(50);
        }else{
            playerScore.addTotal(-50);
        }
        if(badAnimalsInRoundanimalsInRound.size() == 0){
            lastAnimalShot = true;
        }
        removeBalloon();
        addHitCount();
    }
    
    public void addHitCount(){
        AnimalCounter counter = new AnimalCounter();
        if(animalHitCounters.size() == 0){
            addObject( counter, 445, 720);
        }else{
            AnimalCounter oldCounter = (AnimalCounter)animalHitCounters.get(animalHitCounters.size()-1);
            addObject(counter, oldCounter.getLastX()+45, 720);
        }
        animalHitCounters.add(counter);
    }
    
    public void placeBalloons(){
        for(int i=0; i<balloons.size(); i++){
            if(i == 0){
                addObject((Balloon)balloons.get(i), 102, 710);
            }else{  
                Balloon oldBalloon = (Balloon)balloons.get(i-1);
                addObject((Balloon)balloons.get(i), oldBalloon.getLastX()+20, 710);
            }
        }
    }
    
    public void removeBalloon(){
        for(int i=0; i<balloons.size(); i++){
            removeObject((Balloon)balloons.get(i));
        }
        balloons.remove(balloons.size()-1);
        placeBalloons();
    }
    
    public void attacked(String animal){
        if(animal.equals("cat")){
            balloons.remove(balloons.size());
            balloons.remove(balloons.size());
        }else if(animal.equals("lion")){
            Greenfoot.setWorld(new GameOver());
        }
    }
}