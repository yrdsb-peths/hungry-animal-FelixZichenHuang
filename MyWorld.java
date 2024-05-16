import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    int score = 0;
    Label scoreLabel;
    Label levelLabel;
    int level = 1;
    GreenfootSound bgm = new GreenfootSound("bgm.mp3");
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        
        // Create the elephant object.super(600, 400, 1);
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 300);
        
        // Create a label.
        scoreLabel = new Label("Score: " + 0, 50);
        addObject(scoreLabel, 150, 50);
        
        levelLabel = new Label("Level: " + 1, 50);
        addObject(levelLabel, 450, 50);
        
        int r = Greenfoot.getRandomNumber(2);
        if (r == 0)
        {
            createApple();
        }
        else if (r == 1)
        {
            createBanana();
        }
        
        playBGM();
    }
    
    /**
     * Create a new apple at random location at top of the screen.
     * 
     */
    public void createApple()
    {
        Apple apple = new Apple();
        int x = Greenfoot.getRandomNumber(600);
        addObject(apple, x, 0);
    }
    
    public void createBanana()
    {
        Banana banana = new Banana();
        int x = Greenfoot.getRandomNumber(600);
        addObject(banana, x, 0);
    }
    
    /**
     * End the game and draw "GameOver".
     * 
     */
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
    }
    
    /**
     * Increase score.
     * 
     */
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue("Score: " + score);
        
        if (score % 5 == 0)
        {
            level += 1;
            levelLabel.setValue("Level: " + level);
        }
    }
    
    /**
     * 
     * Create a new apple at random location at top of screen.
     */
    public void spawnApple()
    {
        Apple apple = new Apple();
        apple.setSpeed(level);
        int x = Greenfoot.getRandomNumber(getWidth());
        int y = 0;
        addObject(apple, x, y);
    }
    
    public void playBGM()
    {
        bgm.playLoop();
    }
}
