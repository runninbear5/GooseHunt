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
    int stop; 
    int x; 
    int y; 
    /**
     * Act - do whatever the Deer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        x = getX(); 
        y = getY();
        
        if (x == stop) {
            long cTime = System.currentTimeMillis(); 
            System.out.println("CTIME: " + cTime); 
            long endPause = cTime + 2000; 
            while (System.currentTimeMillis() != endPause){
                setImage("Unicorn1.fw.png"); 
            }//pause 
        } 
        walk(); 
    }   
    public Unicorn () {
        stop = 555; 
        //System.out.println(stop); 
    }
    public void walk () { //move deer across the screen 

        x+=5; //add level multiplier 
        counter++;
        if (counter == 5) { 
            setImage(); 
            counter = 0; 
        }
        if (x == 1280) {
            ((PlayScreen)getWorld()).removeObject(this); 
        } 
        if (x == stop) { 
            setImage("Unicorn1.fw.png"); 
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
