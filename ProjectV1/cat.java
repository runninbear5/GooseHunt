import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class cat here.
 * 
 * @author (Simmone Stearn) 
 * @version (a version number or a date)
 */
public class cat extends Actor
{
    /**
     * Act - do whatever the cat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int x =0;
    int y = 100;
    public void act() 
    {
       
    }
    public void setLocation(int x, int y)
    {
      x = 0;
      y = 100;
    }
  
    public void walk() 
    {
      for (int i =0; i < 1280; i++) 
      {
        x += i;
        }
    }
    public int getScore(int score) 
    {
       return score;
    }
}
