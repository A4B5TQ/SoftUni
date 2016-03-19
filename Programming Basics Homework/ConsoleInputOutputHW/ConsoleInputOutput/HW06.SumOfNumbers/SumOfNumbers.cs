using System;
using System.Threading;
using System.Globalization;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW06.SumOfNumbers
    {
    class SumOfNumbers
        {
        static void Main()
            {
            Thread.CurrentThread.CurrentCulture = CultureInfo.InvariantCulture;
            string[] numbers = Console.ReadLine().Split(' ');
            double sum = 0;
            for (int i = 0; i < numbers.Length; i++)
                {
                double n = double.Parse(numbers[i]);
                sum += n;
                }
            Console.WriteLine(sum);
            }
        }
    }
