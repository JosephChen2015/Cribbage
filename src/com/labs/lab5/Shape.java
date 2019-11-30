package com.labs.lab5;

public abstract class Shape
{
    protected Shape()
    {
        super();
    }

    protected abstract double perimeter();

    protected abstract double area();

    @Override
    public abstract String toString();
}
