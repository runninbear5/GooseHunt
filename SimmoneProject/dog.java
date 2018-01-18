import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class is for the dog in Goose Hunt which walks accross the screen once the game begins and jumps over the grass
 * At the end of each round, this class is in charge of having the dog pop up and laugh
 * @author (Simmone Stearn) 
 * @version (a version number or a date)
 */
public class Dog extends Actor
{
    /**
     * Act - do whatever the dog wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   int counter = 0; //variable used later for setting speed of image changes
   int currentImage = 1; //variable used later for setting image of object
   int position = 0; //variable used later to dictate the timr at which the object changes direction
   int x =0;
   int y = 100;
   boolean walk = true; //booleans used later to turn methods on or off
   boolean jump = false;
   boolean laugh = false;
   long timeJumpedCalled = 0;
   
    public void act() 
   {
      if(walk)
      { //if boolean walk is true, the walk class is continously called
         walk();   
        }
      if(jump)
      {
         jumpOver(false); //if boolean hunt is true, the jumpOver class is called
        }
    }
    
    public void walk() 
    {
      int x = getX(); //gets the current horizontal orientation of the object
      int y = getY(); //gets the current verticle orientation of the object
      int jumpPosition = 640; //the dog will jump at 640 pixels
      position++;
      
      if (x < 800) //the dog will always be moving in the positive direction since it will jump before x is 800
       {
         x += 5;
        }
      if (x >= 800) 
       {
         x -= 5;
        }
        
      setLocation(x, y); 
      counter++;
      
       if (counter == 10) //changes the speed at which the images of the dog walking change
      {  
         setImage();
         counter = 0;
      }
       if (x <= jumpPosition+30 && x>= jumpPosition-30) 
       {
         walk = false; //if the dog has walked to the middle of the screen, the walk boolean becomes false and walk ceases to be called
         jump = true; //jump becomes true, allowing the jumpOver method to be executed
         timeJumpedCalled = System.currentTimeMillis(); //gives the time since the jumpOver method has been called
         jumpOver(true); //calls the jumpOver method
      }
   }
   
    public void setImage() 
    {
       if ( position < 800) 
       { //if position is less than 800, the dog walks in the positive direction 
        currentImage++;
        if (currentImage == 5) //images dog(1,2,3,4).fw.png
       {
         currentImage = 1; //starts at image dog1.fw.png
        }       
       setImage("dog" + currentImage + ".fw.png"); //file name
      }
      
        if (position > 800) 
        { //this would allow the dof to go in thwe other direction, but this is never used since we decided the dog
       currentImage++;          //would jump in the middle instead
       if (currentImage == 12) //images dog(8,9,10,11).fw.png
        {
          currentImage = 8;// starts at image dog8.fw.png
        }   
        setImage("dog" + currentImage + ".fw.png"); //file name
      }
   }
    
    public void jumpOver(boolean first)
    {
      int x = getX(); //gets the current horizontal orientation of the object
      int y = getY(); //gets the current verticle orientation of the object
      setJumpImage(); //calls method setJumpImage which dictates the image of the dog jumping
      if(first)
      {
          setLocation(x, y - 50); //moves the dog up 50 pixels as it jumps
        }
      
      if(timeJumpedCalled + 300 <= System.currentTimeMillis())
      { //this if statement makes it so the dog dissapears after 300 milliseconds
          ((PlayScreen)getWorld()).removeObject(this); //after the amount of time, the object is removed
          jump = false; //jump becomes false and method jumpOver ceases to work
      }
   }
   
    public void startLaugh()
    { //this method is called when the round changes and the dog jumps up and laughs
      int x = getX(); //gets the current horizontal orientation of the object
      int y = getY(); //gets the current veticle orientation of the object
      setLaughImage(); //calls setLaughImage which dictates the image of the dog laughing
      setLocation(x, y - 50); //this if statement makes it so the dog dissapears after 300 milliseconds
      
      if(timeJumpedCalled + 300 <= System.currentTimeMillis())
      {
          ((PlayScreen)getWorld()).removeObject(this); //after the amount of time, the object is removed
          laugh = false; //laugh becomes false and method startLaugh becomes false
      }
   }
   
   public void setJumpImage() 
   {
      currentImage = 6; //the image of the dog jumping is dog6.fw.png
      setImage("dog" + currentImage + ".fw.png"); //file name
    }
    
   public void setLaughImage() 
   {
      currentImage = 7; //the image of the dog laughing is dog7.fw.png
      setImage("dog" + currentImage + ".fw.png"); //file name
    }
    
   public int getScore(int score) 
    {
       return score; //returns score
    }
}
