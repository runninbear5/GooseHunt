import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Deer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Deer extends Actor
{
    /**
     * Act - do whatever the Deer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        walk(); 
    }   
    public void walk () { //move deer across the screen 
        int x = getX(); 
        int y = getY(); 
        x+=1; //add level multiplier  
        setLocation(x, y); 
    }
    public void giveScore () {} 
    
}
