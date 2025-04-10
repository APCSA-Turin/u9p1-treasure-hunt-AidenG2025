package com.example.project;


//Dot only needs a constructor
public class Dot extends Sprite{
    public Dot(int x, int y) 
    {
        super(x, y);

    }
    public String getRowcol (int size)
    {
        return "Dot: " + super.getRowCol(size);
    }
    public String getCoords()
    {
        return "Dot: " + super.getCoords();
    }

}
