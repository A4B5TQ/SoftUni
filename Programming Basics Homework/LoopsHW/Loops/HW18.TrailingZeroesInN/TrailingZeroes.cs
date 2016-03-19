using System;
using System.Collections.Generic;
using System.Linq;
using System.Numerics;
using System.Text;
using System.Threading.Tasks;

namespace HW18.TrailingZeroesInN
{
    class TrailingZeroes
    {
        static void Main()
        {
            BigInteger n = BigInteger.Parse(Console.ReadLine());
            BigInteger zeroCount = 0;
            BigInteger goldFive = 5;

            while(goldFive <= n)
            {
                zeroCount += n / goldFive;
                goldFive *= 5;
            }

            Console.WriteLine(zeroCount);
        }
    }
}
