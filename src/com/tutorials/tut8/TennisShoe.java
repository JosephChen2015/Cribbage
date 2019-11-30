package com.tutorials.tut8;

public class TennisShoe extends Shoe
{
    private SoleType soleType;
    private CanvasType canvasType;

    public TennisShoe(String color, String designer, float size, SoleType soleType, CanvasType canvasType) {
        super(color, designer, size);
        this.soleType = soleType;
        this.canvasType = canvasType;
    }

    public SoleType getSoleType() {
        return soleType;
    }

    public void setSoleType(SoleType soleType) {
        this.soleType = soleType;
    }

    public CanvasType getCanvasType() {
        return canvasType;
    }

    public void setCanvasType(CanvasType canvasType) {
        this.canvasType = canvasType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TennisShoe)) return false;
        if (!super.equals(o)) return false;
        TennisShoe tennisShoe = (TennisShoe) o;
        return getSoleType() == tennisShoe.getSoleType() &&
                getCanvasType() == tennisShoe.getCanvasType();
    }

    @Override
    public String toString() {
        return "TennisShoe{" +
                "soleType='" + soleType + '\'' +
                ", canvasType='" + canvasType + '\'' +
                ", color='" + color + '\'' +
                ", designer='" + designer + '\'' +
                ", size=" + size +
                '}';
    }
}
