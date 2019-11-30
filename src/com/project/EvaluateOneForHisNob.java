/** This class is a derived class from 'EvaluateBase', providing an overriding method 'getScores'
 * to calculate final scores, a private method to get if there is 'one for his nob'.
 *
 * Name: Jingyin Chen
 * ID:   971159
 */
package com.project;

public class EvaluateOneForHisNob extends EvaluateBase
{
    /** This method overrides the abstract method in the base class,
     * calls the inherited method 'getCardSuits' to get the suits
     * of a hand, passes it to 'getOneForHisNob', then check if there
     * is a 'one for his nob' and returns the final scores.
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

            int count = getOneForHisNob(args, handSuits, 0);
            if(count == 1)
            {
                return 1;
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

    /** Traverse the cards, if there is a card whose face value is 'J' and
     * suit is same to the last card, increase the counter by 1 and break
     * the for-loop.
     *
     * @param args
     * @param handSuits
     * @param count
     * @return
     */
    private int getOneForHisNob(String[] args, char[] handSuits, int count)
    {
        for(int i = 0; i < args.length - 1; i++)
        {
            if(args[i].charAt(0) == 'J')
            {
                if(handSuits[i] == handSuits[args.length-1])
                {
                    count++;
                    break;
                }
                else
                {
                    continue;
                }
            }
        }
        return count;
    }
}
