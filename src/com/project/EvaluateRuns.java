/** This class is a derived class from 'EvaluateBase', providing an overriding method 'getScores'
 * to calculate final scores, two private methods which one is to get the combinations of runs
 * and another is to judge the prerequisite of generating runs. In this class, I use an array
 * 'diff' to store the difference between two adjacent cards. Given the prerequisites that at least
 * two consecutive '1' exist in the 'diff' or several '0' exist between two '1' in the 'diff',
 * only meet either can generate the combinations of runs.
 *
 * Name: Jingyin Chen
 * ID:   971159
 */
package com.project;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EvaluateRuns extends EvaluateBase
{
    /** This method overrides the abstract method in the base class,
     * calls the inherited method 'getCardValues' and 'replaceCardValues'
     * to get the values of a hand, then sorts it; gets the array 'diff',
     * if there are two differences equal to 1, calls 'getPrerequisites'
     * to judge if 'diff' meet the condition; passes 'diff' to 'getRuns',
     * then calculate the final scores using the output combinations
     * obtained in 'getRuns'.
     *
     * @param args
     * @return
     */
    @Override
    public int getScores(String[] args)
    {
        if(args != null)
        {
            int[] handValues = new int[args.length];
            Map<Character, Integer> cardValues = new HashMap<>();
            super.getCardValues(cardValues, handValues, args);
            super.replaceCardValues(handValues, args);
            Arrays.sort(handValues);

            int[] diff = new int[args.length-1];
            int count = 0;
            for(int i = 0; i < diff.length; i++)
            {
                diff[i] = handValues[i+1] - handValues[i];
                if(diff[i] == 1)
                {
                    count++;
                }
            }

            if(count >= 2)
            {
                if(getPrerequisites(diff))
                {
                    return (count + 1) * getRuns(diff, 0);
                }
                else
                {
                    return 0;
                }
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

    /** This method divides the combinations of different runs into four types,
     * the first one is to check the number of '0' between two '1', the second
     * one is to check the number of '0' before the first '1', the third one
     * is to check the number of '0' after the last '1' and the fourth one is
     * to check if the 'diff' is '0101' or '0110' or '1010', counts the total
     * number of '0' in 'diff' as the number of different runs; at last,
     * increases 'total' by 1 to include the original run.
     *
     * @param diff
     * @param total
     * @return
     */
    private int getRuns(int[] diff, int total)
    {
        /* If there is a '1' in 'diff', from the next difference calculate the number
           of '0' until the next '1', then break to try to start from another '1';
           if there is a difference not equal to 0 or 1 before finding the next '1',
           also break to try to start form another '1'; if until the last difference,
           still no next '1' was found, then break to try to start form another '1'.
         */
        int count = 0;
        for(int i = 0; i < diff.length; i++)
        {
            if(diff[i] == 1)
            {
                for(int j = i + 1; j < diff.length; j++)
                {
                    if(j != diff.length - 1)
                    {
                        if(diff[j] == 0)
                        {
                            count++;
                        }
                        else if(diff[j] == 1)
                        {
                            break;
                        }
                        else
                        {
                            count = 0;
                            break;
                        }
                    }
                    else if(j == diff.length - 1 && diff[j] != 1)
                    {
                        count = 0;
                        break;
                    }
                }
                total += count;
                count = 0;
            }
        }

        /* If the first difference is not equal to 1, find the first '1' and calculate
           the number of '0' before it.
         */
        count = 0;
        if(diff[0] != 1)
        {
            for(int i = 1; i < diff.length; i++)
            {
                if(diff[i] == 1)
                {
                    for(int j = i - 1; j >= 0; j--)
                    {
                        if(diff[j] == 0)
                        {
                            count++;
                        }
                        else
                        {
                            break;
                        }
                    }
                    break;
                }
            }
            total += count;
        }

        /* If the last difference is not equal to 1, find the last '1' and calculate
           the number of '0' after it.
         */
        count = 0;
        if(diff[diff.length-1] != 1)
        {
            for(int i = diff.length - 2; i >= 0; i--)
            {
                if(diff[i] == 1)
                {
                    for(int j = i + 1; j < diff.length; j++)
                    {
                        if(diff[j] == 0)
                        {
                            count++;
                        }
                        else
                        {
                            break;
                        }
                    }
                    break;
                }
            }
            total += count;
        }

        /* If the 'diff' is '0101' or '0110' or '1010', the number of different runs
           is twice as the number of '0'.
         */
        if((diff[0] == 0 && diff[2] == 0) || (diff[0] == 0 && diff[3] == 0) || (diff[1] == 0 && diff[3] == 0))
        {
            total *= 2;
        }
        else
        {
            total++;
        }

        return total;
    }

    // Check if 'diff' with two more '1' meets the prerequisites.
    private boolean getPrerequisites(int[] diff)
    {
        int count = 0;
        for(int i = 0; i < diff.length; i++)
        {
            if(diff[i] == 1)
            {
                for(int j = i + 1; j < diff.length; j++)
                {
                    if(diff[j] == 0)
                    {
                        continue;
                    }
                    else if(diff[j] == 1)
                    {
                        count++;
                        break;
                    }
                    else
                    {
                        break;
                    }
                }
            }
        }

        if(count != 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
