using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW15.BitsExchange
    {
    class BitsExchange
        {
        static void Main()
            {
            long number = long.Parse(Console.ReadLine());
            long bitToExchangeFirst, bitToExchangeSecond;
            long mask = 7;
            bitToExchangeFirst = (number >> 3) & mask;
            bitToExchangeSecond = (number >> 24) & mask;
            number = number & ~(mask << 3);
            number = number & ~(mask << 24);
            number |= (bitToExchangeFirst << 24);
            number |= (bitToExchangeSecond << 3);
            Console.WriteLine(number);
            }
        }
    }
