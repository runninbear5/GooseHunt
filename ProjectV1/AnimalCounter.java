import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AnimalCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AnimalCounter extends Actor
{
    public AnimalCounter(){
        getImage().scale(45,45);
    }
    /**
     * Act - do whatever the AnimalCounter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }   
    public int getLastX(){
        return getX();
    }
    public void removeObject(){
        ((PlayScreen)getWorld()).removeObject(this);
    }
}
