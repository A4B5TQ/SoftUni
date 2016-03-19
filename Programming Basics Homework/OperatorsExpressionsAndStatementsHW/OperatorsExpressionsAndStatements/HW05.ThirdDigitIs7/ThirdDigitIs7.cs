using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW05.ThirdDigitIs7
    {
    class ThirdDigitIs7
        {
        static void Main()
            {
            int input = int.Parse(Console.ReadLine());
            int isSeven = input / 100;
            Console.WriteLine(isSeven % 10 == 7);
            }
        }
    }
