import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.core.WorldHandler;
import javax.swing.*;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;

public class PlayScreen  extends World
{
    JPanel Pan = WorldHandler.getInstance().getWorldCanvas();  
    /** The new Cursor */
    Cursor NewCursor;

    public PlayScreen()
    {
        super(1280, 769, 1, false);
        GreenfootImage image = new GreenfootImage("crosshair.png");
        ChangeMouseImage(image, 15,15);
        addObject(new ScoreBar(), 650, 720);
    }

    public void act()
    {
        /** Sets the Cursor Image to the New Cursor */
        Pan.setCursor(NewCursor);
    }
    
    
    /** Or you use this Method: 
     * The image is the image, that you want the mouse to have.(The mouse has a maximum width and height for her image, if the image is too large it will be scaled on the right size)
     * XClick and YClick is the Location on the Picture where the mouse will Click */
    public void ChangeMouseImage(GreenfootImage image, int xClick, int yClick)
    {
        JPanel Panel = WorldHandler.getInstance().getWorldCanvas();
        Cursor Cursor;
        Toolkit Tk = Toolkit.getDefaultToolkit();
        Point CursorPoint= new Point(xClick,yClick);
        Cursor = Tk.createCustomCursor(image.getAwtImage(),CursorPoint,"Crosshair");
        NewCursor = Cursor;
        Panel.setCursor(Cursor);
    }
    
    public void animalHit(String animal){
        
    }
}