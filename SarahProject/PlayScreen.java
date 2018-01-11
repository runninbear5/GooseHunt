import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayScreen extends World
{

    /**
     * Constructor for objects of class StartScreen.
     * 
     */
    public PlayScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 769, 1); 
        addObject(new Deer(), 10, 475); 
        addObject(new Unicorn(), 10, 300); 
    }
}
