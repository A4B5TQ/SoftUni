using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW01.OddOrEvenIntegers
    {
    class OddOrEvenIntegers
        {
        static void Main()
            {
            int input = int.Parse(Console.ReadLine());
            bool odd = input % 2 != 0;
            Console.WriteLine(odd);
            }
        }
    }
