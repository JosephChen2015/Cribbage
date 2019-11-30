package com.labs.lab1;

public class Numbers
{
    public static void main(String[] args)
    {
        System.out.println(Integer.parseInt(args[0]) + Integer.parseInt(args[1]));
        System.out.println(Integer.parseInt(args[0]) - Integer.parseInt(args[1]));
        System.out.println(Integer.parseInt(args[0]) * Integer.parseInt(args[1]));
        if(Integer.parseInt(args[1]) == 0)
        {
            System.out.println("The divisor is invalid!");
        }
        else
        {
            System.out.println((int)(Integer.parseInt(args[0]) / Integer.parseInt(args[1])));
            System.out.println(Integer.parseInt(args[0]) % Integer.parseInt(args[1]));
        }
    }
}
