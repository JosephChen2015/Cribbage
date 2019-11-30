package com.labs.lab5;

public class Rectangle extends Shape
{
    private final double width;
    private final double height;

    public Rectangle(double w, double h)
    {
        super();
        this.width = w;
        this.height = h;
    }

    @Override
    public double perimeter()
    {
        return 2 * (width + height);
    }

    @Override
    public double area()
    {
        return width * height;
    }

    @Override
    public String toString()
    {
        return this.getClass().getName() + "(" + width + "," + height + ")";
    }
}
