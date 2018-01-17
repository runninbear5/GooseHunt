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
    long timeStop = 0; 
    int stop = 0; 
    int x; 
    int y; 
    boolean right; 
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
            setImage("Unicorn11.fw.png"); 
            if(timeStop + 1500 <= System.currentTimeMillis()){
                x = stop + 11;  
                walk(); 
            }
        } else {
            walk(); 
        } 
        if (Greenfoot.mouseClicked(this)){
            ((PlayScreen)getWorld()).animalHit("Antler"); 
        }

    }   

    public Unicorn (boolean right) {
        right = this.right;
        stop = (int)(Math.random() * 1280); 
        
        //System.out.println(stop); 
    }

    public void walk () { //move deer across the screen 
        if(!right){
            x+=5; //add level multiplier 
            counter++;
            if (counter == 5) { 
                setImageLeft(); 
                counter = 0; 
            }
            if (x >= 1270) {
                makeDissapear(); 
            } 
            if ((x - 10 <= stop)&&(x + 10 >= stop)) { 
                timeStop = System.currentTimeMillis(); 
                setImage("Unicorn1.fw.png"); 
            } 
            setLocation(x, y); 
        } else {
            x-=5; 
            counter++; 
            if (counter == 5) { 
                setImageLeft(); 
                counter = 0; 
            }
            if (x <= 10) {
                makeDissapear(); 
            } 
            if ((x - 10 <= stop)&&(x + 10 >= stop)) { 
                timeStop = System.currentTimeMillis(); 
                setImage("Unicorn11.fw.png"); 
                getImage().mirrorHorizontally(); 
            } 
            setLocation(x, y); 
        }
    }

    public void makeDissapear () {
        ((PlayScreen)getWorld()).removeObject(this); 
    }

    public void setImageLeft() { //change image to create moving gif
        currentImage++; //increment image
        if (currentImage == 12) { //loop through graphics 
            currentImage = 1; 
        } 
        setImage("Unicorn" + currentImage + ".fw.png"); //call antler file
    } 
    public void setImageRight () { 
        currentImage++; //increment image
        if (currentImage == 12) { //loop through graphics 
            currentImage = 1; 
        } 
        setImage("Unicorn" + currentImage + ".fw.png"); //call antler file
        getImage().mirrorHorizontally(); 
    }
}
