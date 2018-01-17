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
    int counter = 0;
    int currentImage = 7;
    int position = 0;
    int x = 0;
    int y = 0;
    boolean walk = true;
    boolean stare = false;
    boolean change;
    boolean right = true;
    boolean comeBack = false;
    long timeJumpCalled = 0;
    
   public Cat()
    {
     setImage();
     right = this.right;
    }
    
   public void size()
    {
      GreenfootImage image = getImage();
      image.scale(100, 100);
      setImage(image);
    }
    
    public void act() 
   { if(walk){
         walk();   
        }
        
     if(stare){
            startStaring(false);
        }
    }
    
    public void walk() {
      if (right) {
      int x = getX(); 
      int y = getY(); 
      int starePosition = 640;
      position++;
       
      if (position < 190) 
       { x += 5;
         change = false;
        }
      if (position >= 190) 
       { x -= 5;
         change = true;
        }
        
       setLocation(x, y); 
       counter++;
       
       if (counter == 10) 
      {  setImage();
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
       int starePosition = 650;
       int x = getX(); 
       int y = getY(); 
       position++;
       
      if (position < 190) 
       { x -= 5;
         change = false;
        }
      if (position >= 190) 
       { x += 5;
         change = true;
        }
        
       setLocation(x, y); 
       counter++;
       
       if (counter == 10) 
      {  setImage();
         getImage().mirrorHorizontally();
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
   }
   
   
    public void setImage() 
    { if (right) {
      if (position < 190) 
       {
        currentImage++;
        if (currentImage == 10) 
       {
          currentImage = 7;
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
     else {
      if (position < 190) 
       {
        currentImage++;
        if (currentImage == 10) 
       {
          currentImage = 7;
        }       
       setImage("cat" + currentImage + ".fw.png");
       getImage().mirrorHorizontally();
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
        getImage().mirrorHorizontally();
        size();
      }
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
          //makeDissapear();
      }
    }
   
   public void setStareImage()
   {
     currentImage++;
     if(currentImage == 16) 
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
    { score -= 100;
      return score;
    }
}
