using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW01.NumbersFromOneToN
{
    class NumbersFromOneToN
    {
        static void Main()
        {
            int number = int.Parse(Console.ReadLine());

            for(int i = 1; i <= number; i++)
            {
                Console.Write(i + " ");
            }
        }
    }
}
