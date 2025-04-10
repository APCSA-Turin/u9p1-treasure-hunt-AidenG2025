package com.example.project;

//DO NOT DELETE ANY METHODS BELOW
public class Player extends Sprite
{
    private int treasureCount = 0;
    private int numLives = 2;
    private boolean win;
    

    public Player(int x, int y) 
    { 
        super(x, y); 
    }

    public int getTreasureCount() 
    { 
        return treasureCount; 
    }
    public int getLives() 
    { 
        return numLives; 
    }
    public boolean getWin() 
    { 
        return win; 
    }


    public void move(String direction) 
    {
        int newX = getX(); 
        int newY = getY(); 

        if (direction.equals("w")) newY++;   
        if (direction.equals("s")) newY--;   
        if (direction.equals("a")) newX--;   
        if (direction.equals("d")) newX++;   

        setX(newX); 
        setY(newY); 
    }
    public void interact (int size, String direction, int numTreasures, Object obj)
    {
        if (obj instanceof Treasure && !(obj instanceof Trophy))
        {
            treasureCount++;
        }
        if (obj instanceof Enemy)
        {
            numLives--;
        }
        if (obj instanceof Trophy && treasureCount == numTreasures)
        {
            win = true;
            
        }
    }

    public boolean isValid(int size, String direction)
    {
        int newX = getX();
        int newY = getY();

        if (direction.equals("w") && newY < size - 1) return true;
        if (direction.equals("s") && newY > 0) return true;
        if (direction.equals("a") && newX > 0) return true;
        if (direction.equals("d") && newX < size - 1) return true;
        return false;
    }
    public String getRowCol (int size)
    {
        return "Player:" + super.getRowCol(size);
    }
    public String getCoords()
    {
        return "Player:" + super.getCoords();
    }

   
}



