import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Unicorn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Unicorn extends Actor
{
    int currentImage = 1; 
    int counter = 0; 
    /**
     * Act - do whatever the Deer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        walk(); 
    }   
    public void walk () { //move deer across the screen 
        int x = getX(); 
        int y = getY(); 
        x+=5; //add level multiplier 
        counter++; 
        if (counter == 5) { 
            setImage(); 
            counter = 0; 
        }
        setLocation(x, y); 
    }
    public int giveScore () { //score per deer is 10
        return 10; 
    } 
    public void setImage() { //change image to create moving gif
        currentImage++; //increment image
        if (currentImage == 12) { //loop through graphics 
            currentImage = 1; 
        } 
        setImage("Unicorn" + currentImage + ".fw.png"); //call antler file
    } 
}
