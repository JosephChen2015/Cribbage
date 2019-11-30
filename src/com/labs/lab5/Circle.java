package com.labs.lab5;

public class Circle extends Shape
{
    private final double radius;

    public Circle(double r)
    {
        super();
        this.radius = r;
    }

    @Override
    public double perimeter()
    {
        return 2 * Math.PI * radius;
    }

    @Override
    public double area()
    {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String toString()
    {
        return this.getClass().getName() + "(" + radius + ")";
    }
}
