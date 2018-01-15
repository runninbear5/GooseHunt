import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class cat here.
 * 
 * @author (Simmone Stearn) 
 * @version (a version number or a date)
 */
public class lion extends Actor
{
    /**
     * Act - do whatever the cat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int counter = 0;
    int currentImage = 0;
    int position = 0;
    int x = 0;
    int y = 0;
    boolean walk = true;
    boolean hunt = false;
    boolean image1 = true;
    boolean image2 = false;
    boolean image3 = false;
    
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
       int x = getX(); 
       int y = getY(); 
       int width2 = 210;
       int height2 = 180;
       size(width2++, height2++);
       int starePosition = 640;
       position++;
      if (x < 681) 
       { x += 5;
        }
      
       setLocation(x, y); 
       counter++;
       if (counter == 10) 
      {  setImage();
         counter = 0;
      }
      
      if (x >= starePosition - 30 && x <= starePosition + 30) 
      { walk = false;
        hunt = true;
        startStaring(true);
        }
   }
   
   public void setImage() 
    {
       if ( position < 190) {
        currentImage++;
        if (currentImage == 4) 
       {currentImage = 1;
        }       
       setImage("LionRight" + currentImage + ".fw.png");
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
    }
   
   public void setStareImage()
     {
      int width1 = 150;
      int height1 = 210;
      currentImage++;
      if (currentImage == 4) 
      { currentImage = 1;
          }
      setImage("LionFront" + currentImage + ".fw.png"); 
      size(width1 ++, height1 ++);
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
