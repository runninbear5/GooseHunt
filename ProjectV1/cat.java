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
    boolean change;

    public Cat()
    {
        setImage();

    }

    public void size()
    {
        GreenfootImage image = getImage();
        image.scale(100, 100);
        setImage(image);
    }

    public void act() 
    { 
        walk();
        if(Greenfoot.mouseClicked(this)){
            ((PlayScreen)getWorld()).animalHit("Cat");//chnage to help screen when created
            ((PlayScreen)getWorld()).removeObject(this);
        }
    }

    public void walk() {
        int x = getX(); 
        int y = getY(); 
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

        if (x <= 50 && x >= 0) {
            makeDissapear();
        }
    }

    public void setImage() 
    {
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
