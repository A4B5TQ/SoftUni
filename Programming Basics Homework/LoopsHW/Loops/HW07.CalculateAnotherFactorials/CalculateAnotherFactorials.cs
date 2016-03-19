using System;
using System.Collections.Generic;
using System.Linq;
using System.Numerics;
using System.Text;
using System.Threading.Tasks;

namespace HW07.CalculateAnotherFactorials
{
    class CalculateAnotherFactorials
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            int k = int.Parse(Console.ReadLine());
            int nk = n - k;
            BigInteger nFac = 1;
            BigInteger kFac = 1;
            BigInteger nkFac = 1;

            for(int i = 1; i <= n; i++)
            {
                if(i <= k)
                {
                    kFac *= i;
                }

                if(i <= nk)
                {
                    nkFac *= i; 
                }

                nFac *= i;
            }
            BigInteger factorielDevide = nFac / (kFac * nkFac);
            Console.WriteLine(factorielDevide);
        }
    }
}
