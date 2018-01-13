import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Quit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Quit extends Actor
{
    /**
     * Act - do whatever the Quit wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            System.exit(0);
        }
    }    
}
