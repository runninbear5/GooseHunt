import greenfoot.*;// (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Unicorn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Unicorn extends Actor
{
    //instance variables 
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
        //declare vars 
        x = getX(); 
        y = getY();
        if (!right) { //comes in from left 
            if ((x - 10 <= stop)&&(x + 10 >= stop)) { //if is w/in the randomly selected stop window
                setImage("Unicorn11.fw.png"); 
                if(timeStop + 500 <= System.currentTimeMillis()){//stops for # or milliseconds
                    x = stop + 11;  //gets out of the stop window 
                    walk(); //keeps moving 
                }
            } else {
                walk(); //keeps moving if not in that window 
            } 
        } else {
            if ((x - 10 <= stop)&&(x + 10 >= stop)) {//if creature is w/in zone 
                setImage("Unicorn11.fw.png"); 
                getImage().mirrorHorizontally(); //reflect b/c opposite side entrance 
                if(timeStop + 500 <= System.currentTimeMillis()){ //stop for set time 
                    x = stop - 11;  //get out of stop zone 
                    walk(); //keep moving 
                }
            } else {
                walk(); //keep moving 
            } 
        }
       
        if(Greenfoot.mouseClicked(this)){//if shot 
            ((PlayScreen)getWorld()).animalHit("Unicorn");//chnage to help screen when created
            makeDisappear(); 
        }
    }   

    public Unicorn (boolean right) {//which side does it spawn on? 
        this.right = right;
        stop = (int)(Math.random() * 1280); 
        //System.out.println(stop); debug 
    }

    public void walk () { //move across the screen 
        if(!right){//start left 
            x+=5; //add level multiplier 
            counter++;//slow movement (so visible) 
            if (counter == 5) { 
                setImageLeft(); //specific to left side 
                counter = 0; 
            }
            if (x >= 1265) {//if at boundary 
                makeDisappear(); 
            } 
            if ((x - 10 <= stop)&&(x + 10 >= stop)) { //w/in this zone, stop and keep going 
                timeStop = System.currentTimeMillis(); 
                setImage("Unicorn11.fw.png"); //stop image 
            } 
            setLocation(x, y); //set to above increment (x+=5) 
        } else {//start right 
            x-=5; //move left
            counter++; //slow movement for visibility 
            if (counter == 5) { 
                setImageRight(); //call for right entrance 
                counter = 0; //restart counter 
            }
            if (x <= 10) {//if reached boundary 
                makeDisappear(); 
            } 
            if ((x - 10 <= stop)&&(x + 10 >= stop)) { //if w/in window, stop and continue 
                timeStop = System.currentTimeMillis(); 
                setImageRightArg("Unicorn11.fw.png"); //stopping image 
                //getImage().mirrorHorizontally(); 
            } 
            setLocation(x, y); //set location to the above increment 
        }
    }

    public void makeDisappear () {//if shot or reached boundary 
        ((PlayScreen)getWorld()).removeObject(this); 
    }

    public void setImageLeft() { //change image to create moving gif
        currentImage++; //increment image
        if (currentImage == 12) { //loop through graphics 
            currentImage = 1; 
        } 
        setImage("Unicorn" + currentImage + ".fw.png"); //call antler file
    } 

    public void setImageRight () { //if spawned on right 
        currentImage++; //increment image
        if (currentImage == 12) { //loop through graphics 
            currentImage = 1; 
        } 
        setImage("Unicorn" + currentImage + ".fw.png"); //call file
        getImage().mirrorHorizontally(); 
    }
    
    public void setImageRightArg (String file){//face the right way when stopped
        setImage(file); 
        getImage().mirrorHorizontally(); 
    }
}
