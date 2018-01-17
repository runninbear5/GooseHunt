import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Balloon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Balloon extends Actor
{ 
    public int getLastX(){//used to place next balloon
        return getX();
    }
    public void removeObject(){//removes current object
        ((PlayScreen)getWorld()).removeObject(this);
    }
}
