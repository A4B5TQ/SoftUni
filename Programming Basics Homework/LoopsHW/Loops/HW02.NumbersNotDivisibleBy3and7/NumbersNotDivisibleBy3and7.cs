using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW02.NumbersNotDivisibleBy3and7
{
    class NumbersNotDivisibleBy3and7
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());

            for(int i  = 1; i  <= n ; i ++)
            {
                if(i % 3 != 0 && i % 7 != 0)
                {
                    Console.Write(i + " ");
                }
                else
                {
                    continue;
                }
            }
        }
    }
}
