package com.labs.lab2;

public class Primes
{
    public static void main(String[] args)
    {
        if(args.length > 0)
        {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            if(a != 0 || b != 0)
            {
                int j;
                for(int i = a; i <= b; i++)
                {
                    for(j = 2; j <= i - 1; j++)
                    {
                        if(i % j != 0)
                        {
                            continue;
                        }
                        else
                        {
                            break;
                        }
                    }
                    if(j == i)
                    {
                        System.out.println(i);
                    }
                }
            }
        }
    }
}
