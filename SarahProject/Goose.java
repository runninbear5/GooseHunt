import greenfoot.*;// (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Unicorn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Goose extends Actor
{
    int currentImage = 1; 
    int counter = 0; 
    int x; 
    int y; 
    boolean right; 
    long deathTime = System.currentTimeMillis();  
    boolean dead = false; 
    boolean atBottom = false; 
    /**
     * Act - do whatever the Deer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        x = getX(); 
        y = getY(); 
        if (right) {//goose spawned on right side 
            if(Greenfoot.mouseClicked(this)){
                ((PlayScreen)getWorld()).animalHit("Goose");//change to help screen when created
                deathTime = System.currentTimeMillis(); 
                setImage("goose10.fw.png"); 
                getImage().mirrorHorizontally(); 
                death(); 
            }
        } else {
            if(Greenfoot.mouseClicked(this)){
                ((PlayScreen)getWorld()).animalHit("Goose");//change to help screen when created
                deathTime = System.currentTimeMillis(); 
                System.out.println("shot");
                setImage("goose10.fw.png"); 
                death(); 
            }
        }
        if (!dead) { //continue movement if not shot 
            walk(); 
            deathTime = System.currentTimeMillis(); 
                            System.out.println("walk");
        }
    }   

    public Goose (boolean right) {
        this.right = right;
        //System.out.println(stop); 
    }

    public void walk () { //pretend this method is FLY 
        if(!right){
            x+=(int)(Math.random() * 10); //add level multiplier 
            y-= (int)(Math.random() * 5); 
            counter++;
            if (counter == 5) { 
                setImageLeft(); 
                counter = 0; 
            }
            if (x >= 1265) {
                makeDissapear(); 
            } 
            setLocation(x, y); 
        } else {
            x-=(int)(Math.random() * 10); //add level multiplier 
            y-= (int)(Math.random() * 5);
            counter++; 
            if (counter == 5) { 
                setImageRight(); 
                counter = 0; 
            }
            if (x <= 10) {
                makeDissapear(); 
            } 
            setLocation(x, y); 
        }
    }
    
    public void death() {
        if (dead) {
            setImage("goose11.fw.png"); 
            if (755 <= y) {
                makeDissapear();  
            } 
            y -= 15; 
        } 
    } 

    public void makeDissapear () {
        ((PlayScreen)getWorld()).removeObject(this); 
    }

    public void setImageLeft() { //change image to create moving gif
        currentImage++; //increment image
        if (currentImage == 10) { //loop through graphics 
            currentImage = 1; 
        } 
        setImage("goose" + currentImage + ".fw.png"); //call antler file
    } 

    public void setImageRight () { 
        currentImage++; //increment image
        if (currentImage == 10) { //loop through graphics 
            currentImage = 1; 
        } 
        setImage("goose" + currentImage + ".fw.png"); //call antler file
        getImage().mirrorHorizontally(); 
    }
}