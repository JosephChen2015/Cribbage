package com.tutorials.tut3;

public class exe1
{
    public static void main(String[] args)
    {
        if(args.length > 0)
        {
            switch(args[0].charAt(0))
            {
                case 'N' :
                    System.out.println("0");
                    break;
                case 'S' :
                    System.out.println("180");
                    break;
                case 'E' :
                    System.out.println("90");
                    break;
                case 'W' :
                    System.out.println("270");
                    break;
                default :
                    System.out.println("Invalid input!");
                    System.exit(1);
            }
        }
    }
}
