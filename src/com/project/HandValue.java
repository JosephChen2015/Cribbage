/** This class provides a main method to evaluate the value
 * of a hand.
 *
 * Name: Jingyin Chen
 * ID:   971159
 */
package com.project;

public class HandValue
{
    /** In this static method, I declare a variable of base class,
     * each time create an instance of a derived class through
     * dynamic binding.
     *
     * @param args
     */
    public static void main(String[] args)
    {
        if(args != null)
        {
            int scores = 0;
            EvaluateBase e = new Evaluate15s();
            scores += e.getScores(args);
            e = new EvaluatePairs();
            scores += e.getScores(args);
            e = new EvaluateRuns();
            scores += e.getScores(args);
            e = new EvaluateFlushes();
            scores += e.getScores(args);
            e = new EvaluateOneForHisNob();
            scores += e.getScores(args);
            System.out.println(scores);
        }
    }
}
