import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.core.WorldHandler;
import javax.swing.*;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
/**
 * Write a description of class StartScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreen extends World
{
    JPanel Pan = WorldHandler.getInstance().getWorldCanvas();  
    /** The new Cursor */
    Cursor NewCursor;
    
    /**
     * Constructor for objects of class StartScreen.
     * 
     */
    public StartScreen()
    {    
        super(1280, 769, 1, false);
        GreenfootImage image = new GreenfootImage("crosshair.png");//creates the greenfoot image 
        ChangeMouseImage(image, 15,15);//sets the image
        addObject(new StartButton(), 675, 400);//adds the start button 
        addObject(new HelpButton(), 675, 300);//adds the help button
    }
    

    public void act()
    {
        /** Sets the Cursor Image to the New Cursor */
        Pan.setCursor(NewCursor);//sets the cursor
    }
    
    
    /** Or you use this Method: 
     * The image is the image, that you want the mouse to have.(The mouse has a maximum width and height for her image, if the image is too large it will be scaled on the right size)
     * XClick and YClick is the Location on the Picture where the mouse will Click */
    public void ChangeMouseImage(GreenfootImage image, int XClick, int yClick)//used to set the crosshair image
    {
        JPanel Panel = WorldHandler.getInstance().getWorldCanvas();
        Cursor Cursor;
        Toolkit Tk = Toolkit.getDefaultToolkit();
        Point CursorPoint= new Point(XClick,yClick);
        Cursor = Tk.createCustomCursor(image.getAwtImage(),CursorPoint,"Crosshair");
        NewCursor = Cursor;
        Panel.setCursor(Cursor);
    }
}
