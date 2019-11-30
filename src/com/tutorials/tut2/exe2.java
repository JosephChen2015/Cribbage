package com.tutorials.tut2;

public class exe2
{
    public static void main(String[] args)
    {
        String arg = "";
        for(int i = 0; i <= args.length - 1; i++)
        {
            if(args[i].startsWith("\"") && args[i].endsWith("\""))
            {
                arg = args[i];
                break;
            }
        }
        System.out.println("First quoted word = " + arg);
    }
}
