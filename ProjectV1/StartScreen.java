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
    int currentSong = 0;//keeps track of current song
    boolean musicPlaying = false;//used to check if music playing
    int currentVolume = 25;//used to set the volume
    String[] songs = {"24k_Puffs_-_Reeces_Puffs_24k_Magic_remix[Mp3Converter.net].mp3", "Nyan_Cat_original[Mp3Converter.net].mp3",
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
        addObject(new MuteMusicButton(), 300, 700);//adds muute button
        addObject(new UnmuteButton(), 450, 700);//adds unmute button
        addObject(new ChangeSongButton(), 100, 700);//adds change song button
        addObject(new DecreaseVolumeButton(), 120, 650);//adds decrease volume
        addObject(new IncreaseVolumeButton(), 350, 650);//adds increase volume
    }
    

    public void act()
    {
        /** Sets the Cursor Image to the New Cursor */
       Pan.setCursor(NewCursor);//sets the cursor
       if(!musicPlaying){//checks if they should play the music
           startMusic();
           musicPlaying = true;
       }
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
    
    public void changeSong(){//used to change the song
        currentSong++;
        if(currentSong == 5) currentSong = 0;
        backgroundMusic.stop();
        backgroundMusic = new GreenfootSound(songs[currentSong]);
        backgroundMusic.setVolume(currentVolume);
        backgroundMusic.playLoop();
    }
    
    public void muteMusic(){//used to mute the music
        backgroundMusic.stop();
    }
    
    public void decreaseVolume(){//used to decrease volume
        currentVolume -= 5;
        if(currentVolume < 0) currentVolume = 0;
        backgroundMusic.setVolume(currentVolume);
    }
    
    public void increaseVolume(){//used to increase volume
        currentVolume += 5;
        if(currentVolume > 100) currentVolume = 100;
        backgroundMusic.setVolume(currentVolume);
    }
    
    public void startMusic(){//used to start music again
        backgroundMusic.playLoop();
    }
}
