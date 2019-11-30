package com.tutorials.tut10;

public class NegativeNumberException extends Exception
{
    public NegativeNumberException()
    {
        super("Negative Number Not Allowed!");
    }

    public NegativeNumberException(String msg)
    {
        super(msg);
    }
}
