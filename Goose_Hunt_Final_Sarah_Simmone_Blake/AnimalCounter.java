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
        getImage().scale(45,45);//scales the image
    } 
    public int getLastX(){//returns last x used to place the counters
        return getX();
    }
    public void removeObject(){//removes the current object
        ((PlayScreen)getWorld()).removeObject(this);
    }
}
