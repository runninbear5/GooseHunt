import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Deer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Deer extends Actor
{
    int currentImage = 1; 
    int counter = 0; 
    int x; 
    int y; 
    int stop; 
    /**
     * Act - do whatever the Deer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        // Add your action code here.
        x = getX(); 
        y = getY();
        
        if (x == stop) {
            long cTime = System.currentTimeMillis(); 
            System.out.println("CTIME: " + cTime); 
            long endPause = cTime + 2000; 
            while (System.currentTimeMillis() != endPause){
                setImage("Antler1.fw.png"); 
            }//pause 
        } 
        if (Greenfoot.mouseClicked(this)){
        }
        walk();  
    }   
    public void Unicorn () {
        stop = 260; 
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
        if (x == 1280) {
            ((PlayScreen)getWorld()).removeObject(this); 
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
        setImage("Antler" + currentImage + ".fw.png"); //call antler file
    } 
}
