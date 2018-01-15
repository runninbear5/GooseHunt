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
     */;
    int currentImage = 7;
    int position = 0;
    int counter = 0;
    int x =0;
    int y = 100;
    
    public Cat(){
        setImage();
    }
    
    public void act() 
    {
       walk();
       if(Greenfoot.mouseClicked(this)){
            ((PlayScreen)getWorld()).animalHit("cat");
            makeDissapear();
        }
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
       {setImage();
        counter = 0;
        }
       if ( x >= 0 && x <= 0+30) 
        { makeDissapear();
        }
    }
    
    public void setImage() 
    {  if (position < 200) {
        currentImage++;
        if (currentImage >= 10) 
       {currentImage = 7;
        }   
       GreenfootImage catPic = new GreenfootImage("cat" + currentImage + ".fw.png");
       catPic.scale(100,100);
       setImage(catPic);
      }
      if (position > 200)
      {
       currentImage++;
       if (currentImage >= 8) 
        {
          currentImage = 4;
        }   
       GreenfootImage catPic = new GreenfootImage("cat" + currentImage + ".fw.png");
       catPic.scale(100,100);
       setImage(catPic);
      }
    }
    
    public void makeDissapear() 
    {
      int x = getX();
      int y = getY();  
      ((PlayScreen)getWorld()).removeObject(this);
    }
    public int getScore(int score) 
    {
       return score - 100;
    }
    
}
