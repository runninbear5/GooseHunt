import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class cat here.
 * 
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
    
    public void walk() {
      if (!right) {
      int x = getX(); 
      int y = getY(); 
      int starePosition = 640;
      position++;
       
      if (position < 190) 
       { x += 5;
        }
      if (position >= 190) 
       { x -= 5;
        }
        
      setLocation(x, y); 
      counter++;
       if (counter == 10) 
      {  
          setImageLeft();
          counter = 0;
      }
      
      if (x >= 800 && x <= 850) 
      { comeBack = true;
        }
        
      if ((comeBack == true) && (x >= starePosition - 30 && x <= starePosition + 30))
      { walk = false;
        stare = true;
        timeJumpCalled = System.currentTimeMillis();
        startStaring(true);
        }
      
       if (x <= 50 && x >= 0) {
       makeDissapear();
      }
     }
     else {
      int starePosition = 640;
      int x = getX(); 
      int y = getY(); 
      position++;
       
      if (position < 190) 
       { x -= 5;
        }
      if (position >= 190) 
       { x += 5;
        }
        
      setLocation(x, y); 
      counter++;
       if (counter == 10) 
          {setImageLeft();
           getImage().mirrorHorizontally();
           counter = 0;
      }
      
      if (x >= 0 && x <= 500) 
      { comeBack = true;
        }
      
      if ((comeBack == true) && (x >= starePosition - 30 && x <= starePosition + 30))
      { walk = false;
        stare = true;
        timeJumpCalled = System.currentTimeMillis();
        startStaring(true);
        }
        
       if (x <= 1200 && x >= 1250) {
       makeDissapear();
      }
     }
   }
   
   public void setImageLeft() 
    { 
      if (position < 190) 
       {
        currentImage++;
        if (currentImage >= 10) 
       {
          currentImage = 8;
        }       
       setImage("cat" + currentImage + ".fw.png");
       size();
      }
    
        if (position >= 190) 
      {
        currentImage++;
       if (currentImage == 13) 
        {
          currentImage = 10;
        }   
        setImage("cat" + currentImage + ".fw.png"); 
        size();
      }
     }
   
   public void setImageRight() {
      if (position < 190) 
       {
        currentImage++;
        if (currentImage >= 13) 
       {
          currentImage = 10;
        }       
       setImage("cat" + currentImage + ".fw.png");
       getImage().mirrorHorizontally();
       size();
      }
    
        if (position >= 190) 
      {
        currentImage++;
       if (currentImage == 10) 
        {
          currentImage = 8;
        }   
       setImage("cat" + currentImage + ".fw.png"); 
       getImage().mirrorHorizontally();
       size();
      }
     }
   
   public void startStaring(boolean first)
   {
      int x = getX();
      int y = getY();
      counter++;
      
      if (counter == 10) 
      { setStareImage();
        counter = 0;
          }
      if (first) 
      { setLocation(x, y);
          }   
          
      if(timeJumpCalled + 1000 <= System.currentTimeMillis()){
          //stare = false;
          //((PlayScreen)getWorld()).attacked("Cat");
      }
    }
   
   public void setStareImage()
   {
     currentImage++;
     if(currentImage >= 16) 
     {
       currentImage = 13;
        }
     setImage("cat" + currentImage + ".fw.png");
     size();
    }
    
   public void makeDissapear() 
    {
      int x = getX();
      int y = getY();  
      ((PlayScreen)getWorld()).removeObject(this);
    }
  
   public int getScore(int score) 
    { score += 100;
      return score;
    }
}
