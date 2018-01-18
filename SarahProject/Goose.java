import greenfoot.*;// (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Unicorn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Goose extends Actor
{
    //instance variables 
    int currentImage = 1; 
    int counter = 0; 
    int x; 
    int y; 
    boolean right; 
    long deathTime = System.currentTimeMillis();  
    boolean dead = false; 
    boolean atBottom = false; 
    int deathCounter; 
    /**
     * Act - do whatever the Deer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //declare x and y 
        x = getX(); 
        y = getY(); 
        if (right) {//spawned on right side 
            if(Greenfoot.mouseClicked(this)){ //if shot 
                ((PlayScreen)getWorld()).animalHit("Goose");//add score  
                setImage("goose10.fw.png"); 
                resize(100,100); //scale up 
                getImage().mirrorHorizontally(); //mirror depending on side 
                dead = true; //allow death() to run 
                death(); //fall 
            }
        } else { //spawned on left 
            if(Greenfoot.mouseClicked(this)){
                ((PlayScreen)getWorld()).animalHit("Goose");//add score
                //System.out.println("shot"); debug 
                setImage("goose10.fw.png"); //set death image briefly
                resize(100,100); //scale up 
                dead = true; //to run death()
                death(); 
            }
        }
        if (!dead) { //continue movement if not shot 
            walk(); 
        }
        if (dead) { //run death sequence 
            death(); 
        }
    }   

    public Goose (boolean right) { //takes which side entering to determing mvmt patterns
        this.right = right;
        //System.out.println(stop); debug 
    }

    public void walk () { //pretend this method is FLY 
        if(!right){
            x+=(int)(Math.random() * 10); //random movement 
            y-= (int)(Math.random() * 5); 
            counter++; //counter to make movement visible 
            if (counter == 5) { //when counter is reached...
                setImageLeft(); //call image for the LEFT side 
                resize(100,100);
                counter = 0; //restart counter 
            }
            if (x >= 1265) { //dissapear on the right side of the screen 
                makeDissapear(); 
            } 
            setLocation(x, y); //set to the random vals above 
        } else {
            x-=(int)(Math.random() * 10); //random movement 
            y-= (int)(Math.random() * 5);
            counter++; //counter to make movement visible
            if (counter == 5) { //when # is reached....
                setImageRight(); //call image for the RIGHT side 
                resize(100,100);
                counter = 0; //restart counter 
            }
            if (x <= 10) {//make dissapear when left side is reached 
                makeDissapear(); 
            } 
            setLocation(x, y); //set to randomized vals above 
        }
    }
    
    public void resize (int width, int height) {//resize the too-small images 
        GreenfootImage image = getImage(); 
        image.scale(width, height); 
        setImage(image); 
    }
    
    public void death() { //run if object clicked 
        if (dead) {
            setImage("goose11.fw.png"); //upside-down image 
            resize(100,100);
            if (y >= 755) { //if reaches the bottom 
                makeDissapear();  
            } 
            if (y <= 755) {  //goose falls until it reaches the disappear zone 
                deathCounter++;
                if (deathCounter == 2) { //slows movement slightly 
                    y+=15; //moves 15 pixels down 
                    setLocation(x,y); 
                    resize(100,100);
                    deathCounter = 0; //restart counter 
                }
            }
        } 
    } 

    public void makeDissapear () { //called if shot or if reached a boundary 
        ((PlayScreen)getWorld()).removeObject(this); 
    }

    public void setImageLeft() { //change image to create moving gif
        currentImage++; //increment image
        if (currentImage == 7) { //loop through graphics 
            currentImage = 1; 
        } 
        setImage("goose" + currentImage + ".fw.png"); //call antler file
    } 

    public void setImageRight () { 
        currentImage++; //increment image
        if (currentImage == 7) { //loop through graphics 
            currentImage = 1; 
        } 
        setImage("goose" + currentImage + ".fw.png"); //call antler file
        getImage().mirrorHorizontally(); 
    }
}