import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Elephant, our hero.
 * 
 * @author Felix Huang
 * @version May 2024
 */
public class Elephant extends Actor
{
    GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];

    // Direction that the elephant is facing.
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    /**
     *
     * Constructor - The code that gets run one time when object is created.
     */ 
    public Elephant()
    {
        for (int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleRight[i].scale(100, 100);
        }

        for (int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(100, 100);
        }

        animationTimer.mark();
        
        // Initial elephant image.
        setImage(idleRight[0]);
    }

    /**
     *
     * Animate the elephant.
     */
    int imageIndex = 0;
    public void animateElephant()
    {
        if (animationTimer.millisElapsed() < 100)
        {
            return;
        }
        animationTimer.mark();
        
        if (facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
    }

    public void act()
    {
        if (Greenfoot.isKeyDown("left")) 
        {
            facing = "left";
            move(-6);
        }
        else if (Greenfoot.isKeyDown("right")) 
        {
            facing = "right";
            move(6);
        }
        
        // Remove apple if elephant eats it.
        eat();

        //Animate the elephant.
        animateElephant();
    }
    
    /**
     * 
     * Eat the apple and spawn new apple if an apple is eaten.
     */
    public void eat()
    {
        if (isTouching(Apple.class))
        {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            int r = Greenfoot.getRandomNumber(2);
            if (r == 0)
            {
                world.createApple();
            }
            else if (r == 1)
            {
                world.createBanana();
            }
            world.increaseScore();
            elephantSound.play();
        }
        else if (isTouching(Banana.class))
        {
            removeTouching(Banana.class);
            MyWorld world = (MyWorld) getWorld();
            int r = Greenfoot.getRandomNumber(2);
            if (r == 0)
            {
                world.createApple();
            }
            else if (r == 1)
            {
                world.createBanana();
            }
            world.increaseScore();
            elephantSound.play();
        }
    }
}
