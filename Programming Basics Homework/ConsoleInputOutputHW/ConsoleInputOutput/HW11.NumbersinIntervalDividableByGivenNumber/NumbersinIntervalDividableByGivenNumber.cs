using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW11.NumbersinIntervalDividableByGivenNumber
    {
    class NumbersinIntervalDividableByGivenNumber
        {
        static void Main()
            {
            int start = int.Parse(Console.ReadLine());
            int end = int.Parse(Console.ReadLine());
            int count = 0;
            for (int i = start; i <= end; i++)
                {
                if (i % 5 == 0)
                    {
                    count++;
                    }
                }
            Console.WriteLine(count);
            }
        }
    }
