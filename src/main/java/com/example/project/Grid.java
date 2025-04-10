package com.example.project;


//DO NOT DELETE ANY METHODS BELOW
public class Grid{
    private Sprite[][] grid;
    private int size;
    public Grid(int size) 
    { 
        this.size = size;
        grid = new Sprite[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) 
            {
                grid[i][j] = new Dot(j, size - 1 - i); 
            }
        }
    }
    public Sprite[][] getGrid() 
    { 
        return grid; 
    }
    public void placeSprite(Sprite s) 
    { 
        grid[size - 1 - s.getY()][s.getX()] = s; 
    }
    public void placeSprite(Sprite s, String direction)
    {
        if (direction.equals("w"))
        {
            placeSprite(new Dot(s.getX(), s.getY() - 1));
        }
        if (direction.equals("a"))
        {
            placeSprite(new Dot(s.getX() + 1, s.getY()));
        }
        if (direction.equals("s"))
        {
            placeSprite(new Dot(s.getX(), s.getY() + 1));
        }
        if (direction.equals("d"))
        {
            placeSprite(new Dot(s.getX() - 1, s.getY()));
        }
        placeSprite(s);
    }
    public void display() 
    {
        for (int i = size - 1; i >= 0; i--) {
            for (int j = 0; j < size; j++)
                if (grid[i][j] instanceof Player) System.out.print("🦄 ");
                else if (grid[i][j] instanceof Enemy) System.out.print("🦂 ");
                else if (grid[i][j] instanceof Trophy) System.out.print("🏆 ");
                else if (grid[i][j] instanceof Treasure) System.out.print("🌈 ");
                else System.out.print("⬜ ");
            System.out.println();
        }
    }
    public void gameover() 
    { 
        
        System.out.println("Game Over!"); 
    }
    public void win() 
    { 

        System.out.println("You win!"); 
    }


}