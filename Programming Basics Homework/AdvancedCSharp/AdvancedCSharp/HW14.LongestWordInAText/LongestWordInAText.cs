using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW14.LongestWordInAText
{
    class LongestWordInAText
    {
        static void Main()
        {
            string[] input = Console.ReadLine().Split(new char[] { ' ' , '.' });
            string longestWord = string.Empty;
            int length = 0;

            for(int i = 0; i < input.Length; i++)
            {
                if(input[i].Length > length)
                {
                    length = input[i].Length;
                    longestWord = input[i];
                }
            }

            Console.WriteLine(longestWord);
        }
    }
}
