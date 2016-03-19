using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW14.ModifyABitAtGivenPosition
    {
    class ModifyABitAtGivenPosition
        {
        static void Main()
            {
            int number = int.Parse(Console.ReadLine());
            int position = int.Parse(Console.ReadLine());
            int bitValue = int.Parse(Console.ReadLine());
            switch (bitValue)
                {
                case 0: number &= ~(1 << position); break;
                case 1: number |= 1 << position; break;
                default: break;
                }
            Console.WriteLine(number);
            }
        }
    }
