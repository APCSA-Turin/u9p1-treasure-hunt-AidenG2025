package com.example.project;
import java.util.Scanner;

public class Game{
    private Grid grid;
    private Player player;
    private Enemy[] enemies;
    private Treasure[] treasures;
    private Trophy trophy;
    private int size;
    public Game(int size) 
    {
        this.size = size;
        initialize();
        play();
    }
    public void initialize() 
    {
        
        grid = new Grid(size);
        player = new Player(0, 0);
        trophy = new Trophy(9, 9);
        treasures = new Treasure[]{new Treasure(2, 2), new Treasure(7, 7)};
        enemies = new Enemy[]{new Enemy(5, 5), new Enemy(5, 7)};
        
        
        grid.placeSprite(player);
        grid.placeSprite(trophy);
        for (Treasure t : treasures) 
        {
            grid.placeSprite(t);
        }
        for (Enemy e : enemies)
        {
            grid.placeSprite(e);
        } 
    }
    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (player.getLives() > 0) 
        {
            grid.display();
            System.out.println("Player: " + player.getCoords());
            System.out.println("Treasure Collected: " + player.getTreasureCount());
            System.out.println("Lives Remaining: " + player.getLives());
            System.out.print("Move (w/a/s/d): ");
            String move = scanner.next();
    
            if (player.isValid(size, move)) 
            {
             
                int newX = player.getX();
                int newY = player.getY();
                if (move.equals("w")) newY++;
                if (move.equals("s")) newY--;
                if (move.equals("a")) newX--;
                if (move.equals("d")) newX++;
    
               
                Sprite obj = grid.getGrid()[size - 1 - newY][newX];
    
               
                player.interact(size, move, treasures.length, obj);
    
                if (player.getLives() == 0) 
                {
                    grid.display();
                    grid.gameover();
                    return;
                }
    
                
                if (player.getWin()) 
                {
                    player.move(move);
                    grid.placeSprite(player, move);
                    grid.display();
                    grid.win();
                    return;
                }
    
               
                player.move(move);
                grid.placeSprite(player, move);
            }
        }
    
        grid.display();
        grid.gameover();
    }
    public static void main(String[] args) 
    { 
        new Game(10); 
    }
}