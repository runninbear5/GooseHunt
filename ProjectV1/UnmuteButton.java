import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UnmuteButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UnmuteButton extends Actor
{
    /**
     * Act - do whatever the UnmuteButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){//if clicked start music
            ((StartScreen)getWorld()).startMusic();
        }
    }    
}
