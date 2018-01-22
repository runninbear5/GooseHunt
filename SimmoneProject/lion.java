import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class is for the lion in Goose Hunt which walks across the screen and back before changing to face the user and run toward them.
 * After one second, the screen fills with an image of a lion mouth and the game is over. The lion has the ability to spawn on either side
 * of the screen and, walking in the correct direction accordingly
 * @author (Simmone Stearn) 
 * @version (a version number or a date)
 */
public class Lion extends Actor
{
    /**
     * Act - do whatever the lion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   int counter = 0; //variable used later for setting speed of image changes
   int currentImage = 0; //variable used later for setting image of object
   int position = 0; //variable used later to dictate the timr at which the object changes direction
   int x = 0;
   int y = 0;
   boolean walk = true;
   boolean hunt = false;
   boolean comeBack = false;
   boolean right;
   long timeJumpCalled = 0;
    
   public Lion(boolean right)
    {
      this.right = right; //boolean given to Lion class to let the object know whether or not it is spawning on the L or R
    }
    
   public void size(int width, int height) //method increased size of the images, called throughout the code
    {                                      //has int arguments because the scales differ depending the lion is walking or staring
      GreenfootImage image = getImage();
      image.scale(width, height);
      setImage(image);
    }
    
    public void act() 
   { 
      if(walk)
      { //if boolean walk is true, the walk class is continously called
         walk();   
        }
        
      if(hunt)
      { //if boolean hunt is true, the startStaring class is called
            startStaring(false);
        }
    }
    
    public void walk() 
    { //this method is called continuosly while the walk boolean is true
      if (!right) 
      { //if the cat spawns from the left side of the screen, this if statement is executed
      int x = getX(); //gets the current horizontal orientation of the object
      int y = getY(); //gets the current verticle orientation of the object
      int width2 = 210; //scale for walking images
      int height2 = 180;
      int starePosition = 640; //the lion will stare when x is 640 pixels
      position++;
      if (position < 190) //lion walks forward until position reaches 190 (a certain amount of time)
       { 
         x += 5;
        }
        
      if (position >= 190) //when postion is greater than 190, the lion walks in the opposite direction
      { 
        x -= 5;
        }
      
      setLocation(x, y); 
      counter++;
       if (counter == 10) //this slows the speed at which the images of the lion walking change
      {  
        setImage(); //calls the setImage method which dictates the images that will depict the lion walking
         counter = 0;  //on the left side of the screen
      }
       
      if (x >= 800 && x <= 850) //this boolean and if statement make it so the lion walks across the screen and back before
      {
        comeBack = true;        //it stops and faces forward at x = 640
        }
      
      if ((comeBack == true) && (x >= starePosition - 30 && x <= starePosition + 30))
      { 
        walk = false; //if the lion has walked accross the screen and back to the middle, the walk method ceases to be called
        hunt = true; //and the hunt boolean becomes true, allowing method startStaring to be executed
        timeJumpCalled = System.currentTimeMillis(); //amount of time since startStaring is called
        startStaring(true); //calls method startStaring
        }
     }
     else
     {
      int x = getX(); //gets the current horizontal orientation of the object
      int y = getY(); //gets the current verticle orientation of the object
      int width2 = 210; //scale for walking images
      int height2 = 180;
      int starePosition = 640; //the lion will stare when x is 640 pixels
      position++;
      if (position < 190) 
       {
         x -= 5;
        }
        
      if (position >= 190)
      {
        x += 5;
        }
      
      setLocation(x, y); 
      counter++;
       if (counter == 10)  //this slows the speed at which the images of the lion walking change
      { 
        setImage(); //calls the setImage method which dictates the images that will depict the lion walking
         getImage().mirrorHorizontally(); //flips the images so that they face the opposite direction
         counter = 0;
      }
       
      if (x >= 0 && x <= 500)//this boolean and if statement make it so that the lion walks across the screen and back before
      { 
        comeBack = true;     //it stops and faces forward at x = 640
        }
      
      if ((comeBack == true) && (x >= starePosition - 30 && x <= starePosition + 30))
      { 
        walk = false; //if the lion has walked across the screen and back to the middle, the walk method ceases to be called
        hunt = true; //and the hunt boolean becomes true, allowing the method startStaring to be executed
        timeJumpCalled = System.currentTimeMillis(); //amount of time since startStaring is called
        startStaring(true); //calls method startStaring
      }
     }
   }
   
   public void setImage() 
    { 
        if (!right) //if the lion spawns on the left, this if statment is executed
        {
       if ( position < 190) 
       { //when the variable position is less than 190 (walking to the right if spawned on the left or to the left
        currentImage++;      // if spawned on the right) the object switches between the images LionRight(1,2,3).fw.png
        if (currentImage == 4) 
       {
         currentImage = 1; //starts at LionRight1.fw.png
        }       
       setImage("LionRight" + currentImage + ".fw.png"); //file name
       size(210, 180); //calls size method and scales it
      }
      
      if ( position >= 190) 
      { //when the variable position is less than 190 (walking to the right if spawned on the left or to the left
        currentImage++;       // if spawned on the right) the object switches between the images LionLeft(1,2,3).fw.png
        if (currentImage == 4) 
       {
         currentImage = 1; //starts at LionLeft1.fw.png
        }       
       setImage("LionLeft" + currentImage + ".fw.png"); //file name
       size(210, 180); //calls size method and scales it
      }
     }
      else
      { //if the lion spawns on the right, this else statement is executed
       if ( position < 190) 
       {    //when the variable position is less than 190 (walking to the right if spawned on the left or to the left
        currentImage++;         // if spawned on the right) the object switches between the images LionRight(1,2,3).fw.png
        if (currentImage == 4) 
       { 
         currentImage = 1; //starts at LionRight1.fw.png
        }       
       setImage("LionLeft" + currentImage + ".fw.png"); //file name
       getImage().mirrorHorizontally(); //flips images
       size(210, 180); //calls size method and scales it
      }
      
      if ( position >= 190) 
       {      //when the variable position is less than 190 (walking to the right if spawned on the left or to the left
        currentImage++;       // if spawned on the right) the object switches between the images LionLeft(1,2,3).fw.png
        if (currentImage == 4) 
       {
         currentImage = 1; //starts at LionLeft1.fw.png
        }       
       setImage("LionRight" + currentImage + ".fw.png"); //file name
       getImage().mirrorHorizontally(); //flips images
       size(210, 180); //calls sizemethod and scales it
      }
     }
   }
  
   public void startStaring(boolean first) //when first is true (in walk method) the cat stops walking and this method is executed
   {
      int x = getX(); //gets current horizontal orientation of the object
      int y = getY(); //gets current verticle orientation of the object
      counter++;
      
      if (counter == 10) //slows the speed at which the images of the lion change
      { 
        setStareImage(); //calls method setStareImage below which changes the images of the cat
        counter = 0;
          }
      if (first) 
      { 
        setLocation(x, y + 30); //moves the cat down 30 pixels when it begins to stare
          }
          
      if(timeJumpCalled + 1000 <= System.currentTimeMillis())
      {                                               //after 1/3 second (300 milliseconds), stare boolean becomes false and startStaring 
          hunt = false;                              //ceases to be called and the attcked method from PlayScreen is called indicating that the
          setGameOverImage();                       //animal has attacked after the 1/3 second of "staring"
      }  //sets screen to new image
    }
   
   public void setStareImage() //sets the images for the cat when it is staring and no longer walking
     {                        //switches between the images LionFront(1,2,3).fw.png
      int width1 = 180; //new scale for front images of the lion
      int height1 = 250;
      currentImage++;
      if (currentImage == 4) 
      { 
        currentImage = 1; //begins at LionFront1.fw.png
          }
      setImage("LionFront" + currentImage + ".fw.png"); //file name
      size(width1 ++, height1 ++); //increases size of image
    }
    
   public void setGameOverImage()
   {
      setImage("lionmouthcorrect"); //sets screen to image of lion mouth
      size(1280, 769); //rescaled to fill the entire screen
      setLocation (640, 385); //located to the middle of the screen
        if(timeJumpCalled + 300 <= System.currentTimeMillis())
      { //after 1/3 scecond, the staring ceases and attcked is called from playscreen
        hunt = false;
        //((PlayScreen)getWorld()).attacked("Lion"); //called from playScreen
      }
   }
    
   public int getScore(int score) 
    {
      return score; //changes score
    }
}
