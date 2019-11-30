package com.tutorials.tut8;

public class Boot extends Shoe
{
    private HeelType heelType;

    public Boot(String color, String designer, float size, HeelType heelType) {
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
        if (!(o instanceof Boot)) return false;
        if (!super.equals(o)) return false;
        Boot boot = (Boot) o;
        return getHeelType() == boot.getHeelType();
    }

    @Override
    public String toString() {
        return "Boot{" +
                "heelType=" + heelType +
                ", color='" + color + '\'' +
                ", designer='" + designer + '\'' +
                ", size=" + size +
                '}';
    }
}
