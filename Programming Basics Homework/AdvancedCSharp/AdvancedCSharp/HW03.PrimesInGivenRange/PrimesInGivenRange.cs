using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW03.PrimesInGivenRange
{
    class PrimesInGivenRange
    {
        static void Main()
        {
            int startNum = int.Parse(Console.ReadLine());
            int endNum = int.Parse(Console.ReadLine());
            List<int> primes = IsPrimeInRange(startNum , endNum);
            PrintPrimes(primes);
        }
        

        private static void PrintPrimes(List<int> list)
        {

            string output = string.Join("," , list.Select(x => x.ToString()).ToArray());
            Console.WriteLine(output);
        }

        public static List<int> IsPrimeInRange(int startNum , int endNum)
        {
            List<int> primes = new List<int>();

            for(int i = startNum; i <= endNum; i++)
            {
                if(IsPrime(i))
                {
                    primes.Add(i);
                }
            }

            return primes;
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
