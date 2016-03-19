using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Numerics;

namespace HW06.CalculateN_K_
{
    class Program
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            int k = int.Parse(Console.ReadLine());
            BigInteger nFac = 1;
            BigInteger kFac = 1;

            for(int i = 1; i <= n; i++)
            {
                if(i <= k)
                {
                    kFac *= i;
                }

                nFac *= i;
            }
            BigInteger factorielDevide = nFac / kFac;
            Console.WriteLine(factorielDevide);
        }
    }
}
