using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW11.CountOfLetters
{
    class CountOfLetters
    {
        static void Main()
        {
            List<char> letters = new List<char>(Console.ReadLine().Split(' ').Select(char.Parse).ToList());

            letters.Sort();
            CountLetters(letters);
        }

        private static void CountLetters(List<char> letters)
        {
            int counter = 1;
            for(int i = 1; i < letters.Count; i++)
            {
                if(letters[i] == letters[i - 1])
                {
                    counter++;
                }
                else
                {
                    Console.Write("{0} -> {1} times" , letters[i - 1] , counter);
                    counter = 1;
                    Console.WriteLine();
                }
                if(i == letters.Count - 1)
                {
                    Console.Write("{0} -> {1} times" , letters[i] , counter);
                }
            }
            Console.WriteLine();
        }
    }
}
