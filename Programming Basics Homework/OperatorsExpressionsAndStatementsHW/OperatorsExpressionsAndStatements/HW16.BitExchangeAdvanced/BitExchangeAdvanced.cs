using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW16.BitExchangeAdvanced
    {
    class BitExchangeAdvanced
        {
        static void Main()
            {
            long number = long.Parse(Console.ReadLine());
            int startPoss = int.Parse(Console.ReadLine());
            int startSecondPoss = int.Parse(Console.ReadLine());
            int numberOfBitsToExchange = int.Parse(Console.ReadLine());
            long bitToExchangeFirst = 0;
            long bitToExchangeSecond = 0;
            string maskFromOnes = new string('1', numberOfBitsToExchange);
            int mask = Convert.ToInt32(maskFromOnes,2);
            bitToExchangeFirst = (number >> startPoss) & mask;
            bitToExchangeSecond = (number >> startSecondPoss) & mask;
            number = number & ~(mask << startPoss);
            number = number & ~(mask << startSecondPoss);
            number |= (bitToExchangeFirst << startSecondPoss);
            number |= (bitToExchangeSecond << startPoss);
            if (startPoss + startSecondPoss < numberOfBitsToExchange)
                {
                Console.WriteLine("overlapping");
                }
            else
                {
                if (startPoss + numberOfBitsToExchange > 31 || startSecondPoss + numberOfBitsToExchange > 31)
                    {
                    Console.WriteLine("out of range");
                    }
                else
                    {
                    Console.WriteLine(number);
                    }
                }
            }
        }
    }
