using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW12.RandomizeTheNumbers
{
    class RandomizeTheNumbers
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            bool[] isPrinted = new bool[n + 1];
            Random rnd = new Random();
            int numberToPrint;

            for(int i = 0; i < n; i++)
            {
                numberToPrint = rnd.Next(1 , n + 1);

                if(!isPrinted[numberToPrint])
                {
                    Console.Write(numberToPrint + " ");
                    isPrinted[numberToPrint] = true;
                }
                else
                {
                    i--;
                }
            }
        }
    }
}
