import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ChangeSongButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChangeSongButton extends Actor
{

    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){//if clicked on go back to start screen
            ((StartScreen)getWorld()).changeSong();
        }
    }    
}
