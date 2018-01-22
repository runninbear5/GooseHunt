import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class PlayerTotal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    /**
     * Act - do whatever the PlayerTotal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int score;
    public Score(int score){//used to intially set the score
        setImage(new GreenfootImage(""+score, 50, greenfoot.Color.WHITE, greenfoot.Color.BLACK));
        this.score = score;
    }
    public void addTotal(int addedScore) //adds the new score
    {
        score += addedScore;
        setImage(new GreenfootImage(""+score, 50, greenfoot.Color.WHITE, greenfoot.Color.BLACK));
    }    
}