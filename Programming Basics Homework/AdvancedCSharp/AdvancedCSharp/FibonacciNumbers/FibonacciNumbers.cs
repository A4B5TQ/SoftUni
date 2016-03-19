using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Numerics;

namespace FibonacciNumbers
{
    class FibonacciNumbers
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            
            Console.WriteLine(Fib(n));
        }
        public static BigInteger Fib(int n)
        {
            BigInteger Fibonacci = 0;
            BigInteger num1 = 0;
            BigInteger num2 = 1;
            for(int i = 0; i <= n; i++)
            {
                num1 = num2;
                num2 = Fibonacci + num2;
                Fibonacci = num1;
            }

            return Fibonacci;
        }
    }
}
