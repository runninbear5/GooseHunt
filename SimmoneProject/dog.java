import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class cat here.
 * 
 * @author (Simmone Stearn) 
 * @version (a version number or a date)
 */
public class dog extends Actor
{
    /**
     * Act - do whatever the cat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int counter = 0;
    int currentImage = 1;
    int position = 0;
    int x =0;
    int y = 100;
    public void act() 
    {
       walk();
    }
    public void walk() {
       int x = getX(); 
       int y = getY(); 
       position++;
        if (position < 100) 
       { x += 5;
        }
       if (position > 100) 
       { x -= 5;
        }
       setLocation(x, y); 
       counter++;
       if (counter == 10) 
      {  setImage();
         counter = 0;
      }
     
    }
    public void setImage() 
    {
       if ( position < 100) {
        currentImage++;
        if (currentImage == 5) 
       {currentImage = 1;
        }       
       setImage("dog" + currentImage + ".fw.png");
    }
        if (position > 100) 
    {
       currentImage++;
       if (currentImage == 12) 
        {
          currentImage = 8;
        }   
        setImage("dog" + currentImage + ".fw.png");
      }
    }
  
    public int getScore(int score) 
    {
       return score;
    }
}
