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
    int timeBetweenAnimals = 5000;
    ArrayList animalsInRound = new ArrayList<String>();
    ArrayList animalHitCounters = new ArrayList<AnimalCounter>();
    ArrayList balloons = new ArrayList<Balloon>();
    String[] goodAnimals = {"duck", "horse", "deer"};
    String[] badAnimals = {"goose","cat", "lion"};
    Score playerScore = new Score(0);
    Round roundCount = new Round();
    boolean lionUsed = false;
    boolean lastAnimalShot = false;
    long lastTime = 0;
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
        if(animalHitCounters.size() == 10 ||(animalsInRound.size() == 0 && animalHitCounters.size()>5 && lastAnimalShot)){
            newRound();
        }
        if(Greenfoot.mouseClicked(this)){
            removeBalloon();
        }
        if(balloons.size() == 0 && animalHitCounters.size() <= 5){
            Greenfoot.setWorld(new GameOver());
        }
        if(lastTime+(timeBetweenAnimals-secondsTakenOff) <= System.currentTimeMillis()){
            if(animalsInRound.size() != 0){
                if(animalsInRound.get(0).equals("cat")){
                    addObject(new Cat(), 500, 500);
                    System.out.println("Cat");
                    lastTime = System.currentTimeMillis();
                }else if(animalsInRound.get(0).equals("deer")){
                    addObject(new Cat(), 500, 500);
                    lastTime = System.currentTimeMillis();
                }else if(animalsInRound.get(0).equals("goose")){
                    addObject(new Cat(), 500, 500);
                    System.out.println("Goose");
                    lastTime = System.currentTimeMillis();
                }else if(animalsInRound.get(0).equals("horse")){
                    addObject(new Cat(), 500, 500);
                    lastTime = System.currentTimeMillis();
                }else if(animalsInRound.get(0).equals("duck")){
                    addObject(new Cat(), 500, 500);
                    lastTime = System.currentTimeMillis();
                }else if(animalsInRound.get(0).equals("lion")){
                    addObject(new Cat(), 500, 500);
                    System.out.println("Lion");
                    lastTime = System.currentTimeMillis();
                }
                animalsInRound.remove(0);
            }
        }
        if(animalsInRound.size() == 0 && animalHitCounters.size() <=5){
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
        animalsInRound.clear();
        animalHitCounters.clear();
        for(int i=0; i<10; i++){
            int animal = (int)(Math.random() * 11);
            if(animal <= 5){
                animalsInRound.add(badAnimals[0]);
            }else if(animal >= 8){
                animalsInRound.add(badAnimals[1]);
            }else if ((animal == 6 || animal == 7) && !lionUsed){
                animalsInRound.add(badAnimals[2]);
                lionUsed = true;
            }else if (animal == 6 || animal == 7){
                animalsInRound.add(badAnimals[0]);
            }
            //animalsInRound.add("cat");
            balloons.add(new Balloon());
        }
        placeBalloons();
        roundCount.increaseRound();
        lastTime = System.currentTimeMillis();
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
        if(animalsInRound.size() == 0){
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
}