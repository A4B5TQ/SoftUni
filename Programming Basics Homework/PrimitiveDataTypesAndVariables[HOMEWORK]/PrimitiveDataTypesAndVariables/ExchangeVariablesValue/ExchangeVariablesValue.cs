using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExchangeVariablesValue
    {
    class ExchangeVariablesValue
        {
        static void Main()
            {
            int a = 5;
            int b = 10;
            Console.WriteLine($"Before \na = {a}\nb = {b}");
            a = a + b;
            b = a - b;
            a = a - b;
            Console.WriteLine($"After \na = {a}\nb = {b}");
            }
        }
    }
