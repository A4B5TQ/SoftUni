using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW05.CalculateFactAndPow
{
    class CalculateFactAndPow
    {
        static void Main()
        {
            double n = double.Parse(Console.ReadLine());
            double x = double.Parse(Console.ReadLine());
            double sumFac = 1;
            double sumPow = 0;
            double sum = 1;

            for(double i = 1; i <= n; i++)
            {
                sumFac *= i;
                sumPow = Math.Pow(x , i);
                sum += sumFac / sumPow;
            }

            Console.WriteLine($"{sum:F5}");
        }
    }
}
