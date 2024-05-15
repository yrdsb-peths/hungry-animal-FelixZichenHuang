import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author Felix Huang 
 * @version May 2024
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("The Elephant", 60);
    
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        addObject(titleLabel, getWidth() / 2, 200);
        prepare();
    }

    /**
     * 
     * The main world act loop.
     */
    public void act()
    {
        // Start the game if user presses the space bar.
        if(Greenfoot.isKeyDown("enter"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

        Elephant elephant = new Elephant();
        addObject(elephant,390,110);
        elephant.setLocation(310,110);
        Label label = new Label("Use \u2190 and \u2192 to move", 40);
        addObject(label,220,257);
        label.setLocation(300,260);
        Label label2 = new Label("Press <enter> to start", 40);
        addObject(label2,311,267);
        label2.setLocation(300,310);
    }
}
