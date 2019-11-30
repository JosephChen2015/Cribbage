package com.tutorials.tut8;

import java.util.Objects;

public class Shoe
{
    protected String color;
    protected String designer;
    protected float size;

    public Shoe(String color, String designer, float size) {
        this.color = color;
        this.designer = designer;
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shoe)) return false;
        Shoe shoe = (Shoe) o;
        return Float.compare(getSize(), shoe.getSize()) == 0 &&
                Objects.equals(getColor(), shoe.getColor()) &&
                Objects.equals(getDesigner(), shoe.getDesigner());
    }

    @Override
    public String toString() {
        return "Shoe{" +
                "color='" + color + '\'' +
                ", designer='" + designer + '\'' +
                ", size=" + size +
                '}';
    }
}
