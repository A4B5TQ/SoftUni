using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MinMaxSumAndAverageOfNNumbers
{
    class MinMaxSumAndAverageOfNNumbers
    {
        static void Main()
        {
            double n = double.Parse(Console.ReadLine());
            double min = 0;
            double max = 0;
            double sum = 0;

            for(double i = 0; i < n; i++)
            {
                double numbers = double.Parse(Console.ReadLine());
                if(i == 0)
                {
                    min = numbers;
                    max = numbers;
                }
                if(numbers < min)
                {
                    min = numbers;
                }
                else if(numbers > max)
                {
                    max = numbers;
                }

                sum += numbers;
            }

            double avg = (sum / n);
            Console.WriteLine("min = {0}",min);
            Console.WriteLine("max = {0}",max);
            Console.WriteLine("sum = {0}",sum);
            Console.WriteLine("avg = {0:F2}",avg);
        }
    }
}
