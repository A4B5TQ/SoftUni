using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW05.QuadraticEquation
    {
    class QuadraticEquation
        {
        static void Main()
            {
            double a = double.Parse(Console.ReadLine());
            double b = double.Parse(Console.ReadLine());
            double c = double.Parse(Console.ReadLine());
            double discr = Math.Pow(b, 2) - (4 * a * c);
            double x2 = ((-b) + Math.Sqrt(discr)) / (2 * a);
            double x1 = ((-b) - Math.Sqrt(discr)) / (2 * a);
            if (discr <= 0)
                {
                 Console.WriteLine("no real roots");
                }
            else
                {
                if (x1 == x2)
                    {
                    Console.WriteLine("X1=X2={0}",x1);
                    }
                else
                    {
                    Console.WriteLine("X1 = {0}; X2 = {1}", x1, x2);
                    }
                }
            }
        }
    }
