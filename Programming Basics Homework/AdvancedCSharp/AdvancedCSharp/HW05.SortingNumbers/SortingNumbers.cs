using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW05.SortingNumbers
{
    class SortingNumbers
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            int[] numbersArray = new int[n];

            for(int i = 0; i < n; i++)
            {
                numbersArray[i] = int.Parse(Console.ReadLine());
            }

            Array.Sort(numbersArray);

            for(int i = 0; i < numbersArray.Length; i++)
            {
                Console.WriteLine(numbersArray[i]);
            }
        }
    }
}
