using System;
using System.Numerics;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW10.FibonacciNumbers
    {
    class FibonacciNumbers
        {
        static void Main()
            {
            int n = int.Parse(Console.ReadLine());
            BigInteger Fibonacci = 0;
            BigInteger num1 = 0;
            BigInteger num2 = 1;
            for (int i = 0; i <= n; i++)
                {
                Fibonacci = num1;
                num1 = num2;
                num2 = Fibonacci + num2;
                Console.Write(" " + Fibonacci);
                }
            Console.WriteLine();
            }
        }
    }
