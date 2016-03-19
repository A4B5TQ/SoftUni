using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW02.PrimeChecker
{
    class PrimeChecker
    {
        static void Main()
        {
            long n = long.Parse(Console.ReadLine());
            Console.WriteLine(IsPrime(n));
        }

        public static bool IsPrime(long n)
        {
            bool IsPrime = true;
            
            if(n == 1 || n == 2 || n == 3)
            {
                IsPrime = true;
            }
            else
            {
                for(int i = 2; i <= Math.Sqrt(n); i++)
                {
                    if(n % i == 0)
                    {

                        IsPrime = false;
                        break;
                    }
                    else
                    {
                        IsPrime = true;
                    }
                }
            }

            return IsPrime;
        }
    }
}
