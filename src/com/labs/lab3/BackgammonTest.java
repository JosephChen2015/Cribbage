package com.labs.lab3;

public class BackgammonTest
{
    public static void main(String[] args)
    {
        int bugCount = 0;

        if(test1())
        {
            bugCount++;
        }
        if(test2())
        {
            bugCount++;
        }
        if(test3())
        {
            bugCount++;
        }
        if(test4())
        {
            bugCount++;
        }
        if(test5())
        {
            bugCount++;
        }
        if(test6())
        {
            bugCount++;
        }
        if(test7())
        {
            bugCount++;
        }
        if(test8())
        {
            bugCount++;
        }
        if(test9())
        {
            bugCount++;
        }
        if(test10())
        {
            bugCount++;
        }

        if(bugCount == 0)
        {
            System.out.println("CORRECT");
        }
        else
        {
            System.out.println("BUG");
        }
    }

    // Move more than 6 points
    private static boolean test1()
    {
        BackgammonBoard b = new BackgammonBoard();

        b.setPoint(4, 2, false);
        b.setPoint(13, 3, false);
        b.move(4, 13);
        int count13 = b.getPointCount(13);
        if(count13 == 4)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    // Move white men from higher to lower
    private static boolean test2()
    {
        BackgammonBoard b = new BackgammonBoard();

        b.setPoint(9, 1, false);
        b.setPoint(7, 3, false);
        b.move(9, 7);
        int count7 = b.getPointCount(7);
        if(count7 == 4)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    // Move black men from lower to higher
    private static boolean test3()
    {
        BackgammonBoard b = new BackgammonBoard();

        b.setPoint(7, 1, true);
        b.setPoint(9, 3, true);
        b.move(7, 9);
        int count9 = b.getPointCount(9);
        if(count9 == 4)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    // Move white men to toPoint occupied by more than one black men
    private static boolean test4()
    {
        BackgammonBoard b = new BackgammonBoard();

        b.setPoint(7, 1, false);
        b.setPoint(9, 3, true);
        b.move(7, 9);
        int count7 = b.getPointCount(7);
        if(count7 == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    // toPoint is not set to black
    private static boolean test5()
    {
        BackgammonBoard b = new BackgammonBoard();

        b.setPoint(7, 1, false);
        b.setPoint(9, 1, true);
        b.move(7, 9);
        boolean toBlack = b.getPointBlack(9);
        if(toBlack)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    // fromPoint does not minus 1
    private static boolean test6()
    {
        BackgammonBoard b = new BackgammonBoard();

        b.setPoint(9, 1, true);
        b.setPoint(7, 3, true);
        b.move(9, 7);
        int count9 = b.getPointCount(9);
        if(count9 == 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    // toPoint does not plus 1
    private static boolean test7()
    {
        BackgammonBoard b = new BackgammonBoard();

        b.setPoint(9, 1, true);
        b.setPoint(7, 1, true);
        b.move(9, 7);
        int count7 = b.getPointCount(7);
        if(count7 == 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    // fromPoint is out of range
    private static boolean test8()
    {
        BackgammonBoard b = new BackgammonBoard();

//        b.setPoint(-1, 1, false);
        b.setPoint(22, 1, false);
        b.move(22, 25);
        int count22 = b.getPointCount(22);
        if(count22 == 1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    // Black men is not moved from toPoint to the bar
    private static boolean test9()
    {
        BackgammonBoard b = new BackgammonBoard();

        b.setPoint(7, 1, false);
        b.setPoint(9, 1, true);
        b.move(7, 9);
        int countBar = b.getBarBlackCount();
        if(countBar == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    // White men is not moved from toPoint to the bar
    private static boolean test10()
    {
        BackgammonBoard b = new BackgammonBoard();

        b.setPoint(9, 1, true);
        b.setPoint(7, 1, false);
        b.move(9, 7);
        int countBar = b.getBarWhiteCount();
        if(countBar == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
