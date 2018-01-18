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
    int currentSong = 0;
    String[] songs = {"24k_Puffs_-_Reeces_Puffs_24k_Magic_remix[Mp3Converter.net].mp3", "Gustav_Holst_-_The_Planets_-_Mars_the_Bringer_of_War[Mp3Converter.net].mp3", "Nyan_Cat_original[Mp3Converter.net].mp3",
        "Pirates_Of_The_Caribbean_Theme_Song[Mp3Converter.net].mp3", "Rick_Astley_-_Never_Gonna_Give_You_Up[Mp3Converter.net].mp3", "Star_Wars-_The_Imperial_March_Darth_Vaders_Theme[Mp3Converter.net].mp3"};
    GreenfootSound backgroundMusic = new GreenfootSound(songs[currentSong]);
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
        backgroundMusic.playLoop();
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
    
    public void changeSong(){
        
    }
}
