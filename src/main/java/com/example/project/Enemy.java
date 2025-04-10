package com.example.project;

//Enemy only need constructor and getCoords() getRowCol()
public class Enemy extends Sprite { //child  of Sprite
    
    public Enemy(int x, int y) 
    { 
        super(x, y); 
    }
    public String getCoords() 
    { 
        return "Enemy:" + super.getCoords(); 
    }
    public String getRowCol(int size) 
    { 
        return "Enemy:" + super.getRowCol(size); 
    }
}