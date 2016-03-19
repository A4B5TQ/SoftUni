using System;
using System.Collections.Generic;
using System.Linq;
using System.Numerics;
using System.Text;
using System.Threading.Tasks;

namespace HW08.CatalanNumbers
{
    class CatalanNumbers
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            BigInteger doubleN = 1;
            BigInteger nPlusOne = 1;
            BigInteger nFac = 1;


            for(int i = 1; i <= 2 * n; i++)
            {

                if(i <= n + 1)
                {
                    nPlusOne *= i;
                }

                if(i <= n)
                {
                    nFac *= i;
                }

                doubleN *= i;
            }

            BigInteger catalanNumbers = doubleN / ( nPlusOne * nFac );
            Console.WriteLine(catalanNumbers);
        }
    }
}
