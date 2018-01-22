import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.core.WorldHandler;
import javax.swing.*;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{
    JPanel Pan = WorldHandler.getInstance().getWorldCanvas();  
    /** The new Cursor */
    Cursor NewCursor;
    public GameOver(Round round, Score score)
    {
        super(1280, 769, 1, false);
        GreenfootImage image = new GreenfootImage("crosshair.png");//creates a image of a crosshair
        ChangeMouseImage(image, 15,15);//sets the image to a crosshair
        addObject(new PlayAgain(), 500, 600);//adds the play again button
        addObject(new Quit(), 800, 600);//adds the quit button
        addObject(round, 500, 700);
        addObject(score, 800, 700);
    }
    
    public void ChangeMouseImage(GreenfootImage image, int xClick, int yClick)//changes mouse image
    {
        JPanel Panel = WorldHandler.getInstance().getWorldCanvas();
        Cursor Cursor;
        Toolkit Tk = Toolkit.getDefaultToolkit();
        Point CursorPoint= new Point(xClick,yClick);
        Cursor = Tk.createCustomCursor(image.getAwtImage(),CursorPoint,"Crosshair");
        NewCursor = Cursor;
        Panel.setCursor(Cursor);
    }
}
