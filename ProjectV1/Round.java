import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Round here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Round extends Actor
{
    /**
     * Act - do whatever the PlayerTotal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int round = 0;
    public Round(){
        setImage(new GreenfootImage("R="+round, 50, greenfoot.Color.GREEN, greenfoot.Color.BLACK));
    }
    public void act(){
    }
    public void increaseRound(){
        round ++;
        setImage(new GreenfootImage("R="+round, 50, greenfoot.Color.GREEN, greenfoot.Color.BLACK));
    }      
}
