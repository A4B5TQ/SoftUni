using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW08.LongestNonDecreasingSubsequence
{
    class LongestNonDecreasingSubsequence
    {
        static void Main()
        {
            
            int[] arr = Console.ReadLine().Split().Select(int.Parse).ToArray();
            PrintLNS(arr);
            
        }
        static void PrintLNS(int[] s)
        {
            const int MAX = 100;
            int longestSeqLength = 0;
            int seqLength = s.Length - 1;
            int[,] LNS = new int[MAX, MAX];
            List<string> outputseq = new List<string>();

            /* Начално инициализиране */

            for(int i = 0; i <= seqLength; i++)
            {
                for(int j = 1; j <= seqLength; j++)
                {

                    LNS[i , j] = MAX + 1;
                    LNS[i , 0] = -1;
                }
            }
            /* Основен цикъл */

            longestSeqLength = 1;

            for(int i = 1; i <= seqLength; i++)
            {
                for(int j = 1; j <= seqLength; j++)
                {
                    if(LNS[i - 1 , j - 1] <= s[i] && s[i] <= LNS[i - 1 , j]
                    && LNS[i - 1 , j - 1] <= LNS[i - 1 , j])
                    {
                        LNS[i , j] = s[i];

                        if(longestSeqLength < j)
                        {
                            longestSeqLength = j;
                        }
                    }
                    else
                    {
                        LNS[i , j] = LNS[i - 1 , j];
                    }
                }
            }
            do
            {
            if(LNS[seqLength , longestSeqLength] == LNS[seqLength - 1 , longestSeqLength])
            {
                    seqLength--;
            }
            else
            {
               outputseq.Add(Convert.ToString(s[seqLength]));
                longestSeqLength--;
            }

            } while(seqLength > 0);

            for(int i = outputseq.Count - 1; i >= 0 ; i--)
            {
                Console.Write(outputseq[i] + " ");
            }

            Console.WriteLine();
        }
    }
}
