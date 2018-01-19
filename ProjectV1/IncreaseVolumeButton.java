import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IncreaseVolumeButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IncreaseVolumeButton extends Actor
{
    /**
     * Act - do whatever the IncreaseVolumeButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       if(Greenfoot.mouseClicked(this)){//if clicked on go back to start screen
            ((StartScreen)getWorld()).increaseVolume();
        }
    }    
}
