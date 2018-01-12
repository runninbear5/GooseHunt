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
    int currentImage = 1;
    int x =0;
    int y = 100;
    public void act() 
    {
       walk();
    }
    public void walk() {
       int x = getX(); 
       int y = getY(); 
       x+=5; 
       setLocation(x, y);
       counter++;
       if (counter == 10) 
      {  setImage();
         counter = 0;
      }
    }
    public void setImage() 
    {
       currentImage++;
        if (currentImage == 13) 
       {currentImage = 1;
        }       
       setImage("Lion" + currentImage + ".fw.png");  
    }
    public int getScore(int score) 
    {
       return score;
    }
    public boolean gameOver() 
    {
      return true;  
    }
}
