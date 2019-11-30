package com.tutorials.tut10;

import java.util.Scanner;

public class InputException
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        while(true)
        {
            try
            {
                int num1 = scan.nextInt();
                if(num1 < 0)
                {
                    throw new NegativeNumberException();
                }
                int num2 = scan.nextInt();
                if(num2 < 0)
                {
                    throw new NegativeNumberException("num2 is less than 0");
                }
                System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
            }
//            catch(InputMismatchException e)
//            {
//                System.out.println("Input mismatched: " + e.getMessage());
//                System.exit(1);
//            }
            catch(NegativeNumberException e)
            {
                System.out.println("Negative number matched: " + e.getMessage());
            }
            finally {
                System.out.println("aaa");
            }
        }
    }
}
