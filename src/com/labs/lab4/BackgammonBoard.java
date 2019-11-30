package com.labs.lab4;

public class BackgammonBoard
{
    private int[] points = new int[24];
    private int blacksOnBar = 0;
    private int whitesOnBar = 0;

    public BackgammonBoard()
    {
        for(int i = 0; i < 24; i++)
        {
            points[i] = 0;
        }
    }

    public int getPointCount(int point)
    {
        if(point >= 0 && point <= 23)
        {
            return Math.abs(points[point]);
        }
        else
        {
            return 0;
        }
    }

    public boolean getPointBlack(int point)
    {
        if(point >= 0 && point <= 23)
        {
            if(points[point] <= 0)//If there are no men on that point, the result would be true
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    public void setPoint(int point, int count, boolean black)
    {
        if(count >= 0 && point >= 0 && point <= 23)
        {
            if(black)
            {
                points[point] = count * (-1);
            }
            else
            {
                points[point] = count * 1;
            }
        }
    }

    public int getBarBlackCount()
    {
        return blacksOnBar;
    }

    public int getBarWhiteCount()
    {
        return whitesOnBar;
    }

    public void move(int fromPoint, int toPoint)
    {
        if((fromPoint >= 0 && fromPoint <= 23) && (toPoint >= 0 && toPoint <= 23))
        {
            int distance = Math.abs(toPoint-fromPoint);
            if(distance >= 1 && distance <= 6)
            {
                int fromCount = getPointCount(fromPoint);
                boolean fromBlack = getPointBlack(fromPoint);
                int toCount = getPointCount(toPoint);
                boolean toBlack = getPointBlack(toPoint);

                if(fromCount > 0)
                {
                    if(fromBlack && (toPoint < fromPoint))
                    {
                        if(toBlack == true && toCount == 0)
                        {
                            toCount++;
                            toBlack = fromBlack;
                            setPoint(toPoint, toCount, toBlack);
                        }
                        else if(toBlack == fromBlack)
                        {
                            toCount++;
                            setPoint(toPoint, toCount, toBlack);
                        }
                        else if(toBlack == (!fromBlack) && toCount == 1)
                        {
                            toCount = 1;
                            toBlack = fromBlack;
                            setPoint(toPoint, toCount, toBlack);
                            whitesOnBar++;
                        }
                        else
                        {
                            return;
                        }

                        fromCount--;
                        if(fromCount == 0)
                        {
                            fromBlack = true;
                        }
                        setPoint(fromPoint, fromCount, fromBlack);
                    }
                    else if(!fromBlack && (toPoint > fromPoint))
                    {
                        if(toBlack == true && toCount == 0)
                        {
                            toCount++;
                            toBlack = fromBlack;
                            setPoint(toPoint, toCount, toBlack);
                        }
                        else if(toBlack == fromBlack)
                        {
                            toCount++;
                            setPoint(toPoint, toCount, toBlack);
                        }
                        else if(toBlack == (!fromBlack) && toCount == 1)
                        {
                            toCount = 1;
                            toBlack = fromBlack;
                            setPoint(toPoint, toCount, toBlack);
                            blacksOnBar++;
                        }
                        else
                        {
                            return;
                        }

                        fromCount--;
                        if(fromCount == 0)
                        {
                            fromBlack = true;
                        }
                        setPoint(fromPoint, fromCount, fromBlack);
                    }
                    else
                    {
                        return;
                    }
                }
                else
                {
                    return;
                }
            }
            else
            {
                return;
            }
        }
        else
        {
            return;
        }
    }
}
