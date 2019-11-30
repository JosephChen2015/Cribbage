/** This class is a derived class from 'EvaluateBase', providing an overriding method 'getScores'
 * to calculate final scores, a private method to get the number of flushes.
 *
 * Name: Jingyin Chen
 * ID:   971159
 */
package com.project;

public class EvaluateFlushes extends EvaluateBase
{
    /** This method overrides the abstract method in the base class,
     * calls the inherited method 'getCardSuits' to get the suits
     * of a hand, passes it to 'getFlushes'; only when the output
     * number obtained in 'getFlushes' is no less than 3 can return
     * the final scores.
     *
     * @param args
     * @return
     */
    @Override
    public int getScores(String[] args)
    {
        if(args != null)
        {
            char[] handSuits = new char[args.length];
            super.getCardSuits(handSuits, args);

            int count = getFlushes(handSuits, 0);
            if(count == 3)
            {
                return 4;
            }
            else if(count == 4)
            {
                return 5;
            }
            else
            {
                return 0;
            }
        }
        else
        {
            return -1;
        }
    }

    /** If the suit of current card is same to next card,
     * increase the counter by 1.
     *
     * @param handSuits
     * @param count
     * @return
     */
    private int getFlushes(char[] handSuits, int count)
    {
        for(int i = 0; i < handSuits.length - 1; i++)
        {
            if(handSuits[i] == handSuits[i+1])
            {
                count++;
            }
            else
            {
                break;
            }
        }
        return count;
    }
}
