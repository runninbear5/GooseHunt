import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class cat here.
 * 
 * @author (Simmone Stearn) 
 * @version (a version number or a date)
 */
public class Dog extends Actor
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
   boolean walk = true; 
   boolean jump = false;
   boolean laugh = false;
   long timeJumpedCalled = 0;
   
    public void act() 
   {
      if(walk){
         walk();   
        }
      if(jump){
            jumpOver(false);
        }
    }
    
    public void walk() {
      int x = getX(); 
      int y = getY(); 
      int jumpPosition = 640;
      position++;
      
      if (x < 800) 
       { x += 5;
        }
      if (x >= 800) 
       { x -= 5;
        }
        
      setLocation(x, y); 
      counter++;
      
       if (counter == 10) 
      {  setImage();
         counter = 0;
      }
       if (x <= jumpPosition+30 && x>= jumpPosition-30) {
       walk = false;
       jump = true;
       timeJumpedCalled = System.currentTimeMillis();
       jumpOver(true);
      }
      if(timeJumpedCalled == 10000) 
      { 
          getWorld().addObject(this, x, y);
          startLaugh(true);
        }
   }
   
    public void setImage() 
    {
       if ( position < 800) {
        currentImage++;
        if (currentImage == 5) 
       {currentImage = 1;
        }       
       setImage("dog" + currentImage + ".fw.png");
      }
      
        if (position > 800) {
       currentImage++;
       if (currentImage == 12) 
        {
          currentImage = 8;
        }   
        setImage("dog" + currentImage + ".fw.png");
      }
   }
    
    public void jumpOver(boolean first)
    {
      int x = getX();
      int y = getY();
      setJumpImage();
      if(first){
          setLocation(x, y - 50);
        }
      
      if(timeJumpedCalled + 300 <= System.currentTimeMillis()){
          ((PlayScreen)getWorld()).removeObject(this);
          jump = false;
      }
   }
   
    public void startLaugh(boolean second)
    { 
      int x = getX();
      int y = getY();
      setLaughImage();
      if(second){
          setLocation(x, y - 50);
        }
      
      if(timeJumpedCalled + 300 <= System.currentTimeMillis()){
          ((PlayScreen)getWorld()).removeObject(this);
          laugh = false;
      }
   }
   
   public void setJumpImage() {
      currentImage = 6;
      setImage("dog" + currentImage + ".fw.png");
    }
    
   public void setLaughImage() {
      currentImage = 7;
      setImage("dog" + currentImage + ".fw.png");
    }
    
   public int getScore(int score) 
    {
       return score;
    }
}
