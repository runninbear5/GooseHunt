import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class is for the cat in Goose Hunt. The cat walks accross the screen and back before changing to face the user and walk toward them. 
 * If, after one second of the cat walking forward, the cat is not hit with a waterballoon, the game is ended. The cat has the ability to 
 * spawn on either side of the screen, walking in the correct direction accordingly
 * @author (Simmone Stearn) 
 * @version (a version number or a date)
 */
public class Cat extends Actor
{
    /**
     * Act - do whatever the cat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int counter = 0; //variable used later for setting speed of image changes
    int currentImage = 7; //variable used later for setting image of object
    int position = 0; //vriable used later to dictate the timr at which the object changes direction
    int x = 0;  
    int y = 0;
    boolean walk = true;
    boolean stare = false;
    boolean right;
    boolean comeBack = false;
    long timeJumpCalled = 0;
    
   public Cat(boolean right)
    {
     this.right = right; //boolean given to Cat class to let the object know whether or not it is spawning on the L or R
    }
    
   public void size() //method increased size of the images, called throughout the code
    {
      GreenfootImage image = getImage();
      image.scale(100, 100);
      setImage(image);
    }
    
    public void act() 
   { if(walk){ //if boolean walk is true, the walk class is continously called
         walk();   
        }
        
     if(stare){ //if boolean stare is true, the startStaring class is called
            startStaring(false);
        }
    }
    
    public void walk() { //this method is called continuosly while the walk boolean is true
      if (!right) { //if the cat spawns from the left side of the screen, this if statement is executed
      int x = getX(); //gets the current horizontal orientation of the object
      int y = getY(); //gets the current verticle orientation of the object
      int starePosition = 640; //the cat will stare when x is 640 pixels
      position++; //position, which starts at zero, is continously increasing
       
      if (position < 190) //cat walks forward until position reaches 190 (a certain amount of time)
       { x += 5;
        }
      if (position >= 190) //when postion is greater than 190, cat walks in the opposite direction
       { x -= 5;
        }
        
      setLocation(x, y); 
      counter++; 
       if (counter == 10) //this slows the speed at which the images of the cat walking change
      {  
          setImage(); //calls the setImage method which dictates the images that will depict the cat walking
          counter = 0;    //on the left side of the screen
      }
      
      if (x >= 800 && x <= 850) //this boolean and if statement make it so the cat walks across the screen and back before
      { comeBack = true;        //it stops and faces forward at x = 640
        }
        
      if ((comeBack == true) && (x >= starePosition - 30 && x <= starePosition + 30))
      { walk = false; //if the cat has walked accross the acreen and back to the middle, the walk method ceases to be called
        stare = true; //and the stare boolean becomes true, allowing method startStaring to be executed
        timeJumpCalled = System.currentTimeMillis(); //amount of time since startStaring is called
        startStaring(true); //calls method startStaring
        }
      
     }
     else { //if the cat spawns from the right side of the screen, this else statement is executed
      int starePosition = 640; //the cat will stare when x is 640 pixels
      int x = getX(); //gets the current horizontal orientation of the object
      int y = getY(); //gets the current verticle orientation of the object
      position++; //position, which starts at zero, is continously increasing
       
      if (position < 190) 
       { 
         x -= 5; //the signs are switched here since the cat will be going the opposite direction when it spawns on the right
        }
      if (position >= 190) 
       {
         x += 5; //walks to the right when position is greater than or equal to 190
        }
        
      setLocation(x, y); 
      counter++;
       if (counter == 10) //slows the speed at which the images of the cat walking change
       {
           setImage(); //calls the setImage method which dictates the images that will depict the cat walking
           getImage().mirrorHorizontally(); //flips the images so that they face in the opposite direction
           counter = 0;
      }
      
      if (x >= 0 && x <= 500) //this boolean and if statement make it so that the cat walks accross the screen and back before 
      { comeBack = true;      //beginning to stare when x is 640 pixles
        }
      
      if ((comeBack == true) && (x >= starePosition - 30 && x <= starePosition + 30))
      { walk = false; //if the cat has walked across the screen and back to the middle, the walk method ceases to be called
        stare = true; //and the stare boolean becomes true, allowing method startStaring to be executed
        timeJumpCalled = System.currentTimeMillis(); //amount of time since startStaring is called
        startStaring(true); //calls startStaring
        }
        
       if (x <= 1200 && x >= 1250) 
      {
        makeDissapear();
      }
     }
   }
   
   public void setImage() 
    { 
      if (position < 190) //when the variable position is less than 190 (walking to the right if spawned on the left or to the left
       {                  //if spawned on the right) the object switches between the images cat8.fw.png and cat9.fw.png
        currentImage++;
        if (currentImage >= 10) 
       {
          currentImage = 8; //begins at cat8.fw.png
        }       
       setImage("cat" + currentImage + ".fw.png"); //file name
       size(); //calls method size to resize each image
      }
    
        if (position >= 190) //when the variable position is geater than or equals to 190 (walking to the left if spawned on the left
      {                      //or to the right when spawned on the right) the object switches between the images cat(10,11,12).fw.png
        currentImage++;
       if (currentImage == 13) 
        {
          currentImage = 10; //begins at cat10.fw.png
        }   
        setImage("cat" + currentImage + ".fw.png"); 
        size(); //calls method size to resize each image
      }
    }
   
   public void startStaring(boolean first) //when first is true (in walk mehtod) the cat stops walking and this method is executed
   {
      int x = getX(); //gets current horizontal orientation of the object
      int y = getY(); //gets current verticle orientation of the object
      counter++;
      
      if (counter == 10) //slows the speed at which the images of the cat change
      { 
        setStareImage(); //calls method setStareImage below which changes the images of the cat
        counter = 0;
          }
      if (first) 
      { 
        setLocation(x, y + 10); //moves the cat down 10 pixels when it begins to stare
          }   
          
      if(timeJumpCalled + 1000 <= System.currentTimeMillis()){ //after one second (1000 milliseconds), stare boolean becomes false and startStaring 
          //stare = false;                                     //ceases to be called and the attcked method from PlayScreen is called indicating that the
          //((PlayScreen)getWorld()).attacked("Cat");          //animal has attacked after the one second of "staring"
      }
    }
   
   public void setStareImage() //sets the images for the cat when it is staring and no longer walking
   {                           //switches between the images cat(13,14,15).fw.png
     currentImage++;
     if(currentImage >= 16) 
     {
       currentImage = 13; //begins at cat13.fw.png
        }
     setImage("cat" + currentImage + ".fw.png");
     size(); //calls method size to resize image
    }
    
   public void makeDissapear() //this method would potentially make the cat dissapear, but is included in the called attacked mthod
    {
      int x = getX();
      int y = getY();  
      ((PlayScreen)getWorld()).removeObject(this);
    }
  
   public int getScore(int score) //changes score
    { score += 100;
      return score;
    }
}
