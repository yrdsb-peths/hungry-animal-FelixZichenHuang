import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Banana here.
 * 
 * @author Felix Huang
 * @version May 2024;
 */
public class Banana extends Actor
{
    int speed = 4;
    
    public void act()
    {
        // Apple falls downwards.
        int x = getX();
        int y = getY() + speed;
        setLocation(x, y);
        
        // Remove apple and draw game over when apple gets to bottom.
        MyWorld world = (MyWorld) getWorld();
        if (getY() >= world.getHeight())
        {
            world.gameOver();
            world.removeObject(this);
        }
    }
    
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}
