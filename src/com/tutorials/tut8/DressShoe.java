package com.tutorials.tut8;

public class DressShoe extends Shoe
{
    private HeelType heelType;

    public DressShoe(String color, String designer, float size, HeelType heelType) {
        super(color, designer, size);
        this.heelType = heelType;
    }

    public HeelType getHeelType() {
        return heelType;
    }

    public void setHeelType(HeelType heelType) {
        this.heelType = heelType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DressShoe)) return false;
        if (!super.equals(o)) return false;
        DressShoe dressShoe = (DressShoe) o;
        return getHeelType() == dressShoe.getHeelType();
    }

    @Override
    public String toString() {
        return "DressShoe{" +
                "heelType=" + heelType +
                ", color='" + color + '\'' +
                ", designer='" + designer + '\'' +
                ", size=" + size +
                '}';
    }
}

