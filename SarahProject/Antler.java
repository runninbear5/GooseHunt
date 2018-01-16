import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Deer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Antler extends Actor
{
    int currentImage = 1; 
    int counter = 0; 
    long timeStop = 0; 
    int stop = 0; 
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
        
        if ((x - 10 <= stop)&&(x + 10 >= stop)) {
            setImage("Antler1.fw.png"); 
            if(timeStop + 1500 <= System.currentTimeMillis()){
                x = stop + 11;  
                walk(); 
            }
        } else {
            walk(); 
        } 
        if (Greenfoot.mouseClicked(this)){
            //((PlayScreen)getWorld().animalHit("Antler")); 
        }
    }   
    public Antler () {
        stop = (int)(Math.random() * 1280); 
        //System.out.println(stop); 
    }
    public void walk () { //move deer across the screen 
        x+=5; //add level multiplier 
        counter++;
        if (counter == 5) { 
            setImage(); 
            counter = 0; 
        }
        if (x >= 1270) {
            makeDissapear(); 
        } 
        if ((x - 10 <= stop)&&(x + 10 >= stop)) { 
            timeStop = System.currentTimeMillis(); 
            setImage("Antler1.fw.png"); 
        } 
        setLocation(x, y); 
    }
    public void makeDissapear () {
        ((PlayScreen)getWorld()).removeObject(this); 
    }
    public void setImage() { //change image to create moving gif
        currentImage++; //increment image
        if (currentImage == 12) { //loop through graphics 
            currentImage = 1; 
        } 
        setImage("Antler" + currentImage + ".fw.png"); //call antler file
    } 
}
