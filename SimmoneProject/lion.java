import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class cat here.
 * 
 * @author (Simmone Stearn) 
 * @version (a version number or a date)
 */
public class Lion extends Actor
{
    /**
     * Act - do whatever the cat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   int counter = 0;
   int currentImage = 1;
   int position = 0;
   int x = 0;
   int y = 0;
   boolean walk = true;
   boolean hunt = false;
   boolean comeBack = false;
   boolean right;
   long timeJumpCalled = 0;
    
   public Lion()
    {
      setImage();
      right = this.right;
    }
    
   public void size(int width, int height)
    {
      GreenfootImage image = getImage();
      image.scale(width, height);
      setImage(image);
    }
    
    public void act() 
   { 
      if(walk){
         walk();   
        }
        
      if(hunt){
            startStaring(false);
        }
    }
    
    public void walk() {
      if (right) {
      int x = getX(); 
      int y = getY(); 
      int width2 = 210;
      int height2 = 180;
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
      {  setImage();
         counter = 0;
      }
       
      if (x >= 800 && x <= 850) 
      { comeBack = true;
        }
      
      if ((comeBack == true) && (x >= starePosition - 30 && x <= starePosition + 30))
      { walk = false;
        hunt = true;
        timeJumpCalled = System.currentTimeMillis();
        startStaring(true);
        }
     }
     else{
      int x = getX(); 
      int y = getY(); 
      int width2 = 210;
      int height2 = 180;
      int starePosition = 640;
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
      {  setImage();
         getImage().mirrorHorizontally();
         counter = 0;
      }
       
      if (x >= 800 && x <= 850) 
      { comeBack = true;
        }
      
      if ((comeBack == true) && (x >= starePosition - 30 && x <= starePosition + 30))
      { walk = false;
        hunt = true;
        timeJumpCalled = System.currentTimeMillis();
        startStaring(true);
        
      }
     }
   }
   
   public void setImage() 
    { if (right) {
       if ( position < 190) {
        currentImage++;
        if (currentImage == 4) 
       {currentImage = 1;
        }       
       setImage("LionRight" + currentImage + ".fw.png");
       size(210, 180);
      }
      
      if ( position >= 190) {
        currentImage++;
        if (currentImage == 4) 
       {currentImage = 1;
        }       
       setImage("LionLeft" + currentImage + ".fw.png");
       getImage().mirrorHorizontally();
       size(210, 180);
      }
     }
     else{
         if ( position < 190) {
        currentImage++;
        if (currentImage == 4) 
       {currentImage = 1;
        }       
       setImage("LionRight" + currentImage + ".fw.png");
       getImage().mirrorHorizontally();
       size(210, 180);
      }
      
      if ( position >= 190) {
        currentImage++;
        if (currentImage == 4) 
       {currentImage = 1;
        }       
       setImage("LionLeft" + currentImage + ".fw.png");
       getImage().mirrorHorizontally();
       size(210, 180);
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
      { setLocation(x, y + 30);
          }
          
      if(timeJumpCalled + 1000 <= System.currentTimeMillis()){
          hunt = false;
          setGameOverImage();
      }
    }
   
   public void setStareImage()
     {
      int width1 = 180;
      int height1 = 250;
      currentImage++;
      if (currentImage == 4) 
      { currentImage = 1;
          }
      setImage("LionFront" + currentImage + ".fw.png"); 
      size(width1 ++, height1 ++);
    }
    
   public void setGameOverImage()
   {
      setImage("lionmouthcorrect");
      size(1280, 769);
      setLocation (640, 385);
      if(timeJumpCalled + 300 <= System.currentTimeMillis()){
          ((PlayScreen)getWorld()).animalHit("Lion");
      }
   }
    
   public int getScore(int score) 
    {
      return score;
    }
    
   public boolean gameOver(boolean gaming)
    {
      return gaming;
    }
}
