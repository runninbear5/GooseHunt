import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DecreaseVolumeButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DecreaseVolumeButton extends Actor
{
    /**
     * Act - do whatever the DecreaseVolumeButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){//if clicked on decrease the volume
            ((StartScreen)getWorld()).decreaseVolume();
        }
    }    
}
