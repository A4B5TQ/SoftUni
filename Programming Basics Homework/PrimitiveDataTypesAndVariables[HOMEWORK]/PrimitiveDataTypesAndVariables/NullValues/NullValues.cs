using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NullValues
    {
    class NullValues
        {
        static void Main()
            {
            int? firstValue = null;
            double? secondValue = null;
            Console.WriteLine(firstValue);
            Console.WriteLine(secondValue);
            firstValue = 12345;
            secondValue = 0.12345;
            Console.WriteLine(firstValue);
            Console.WriteLine(secondValue);
            firstValue = 0;
            secondValue = 0.0;
            Console.WriteLine(firstValue);
            Console.WriteLine(secondValue);
            }
        }
    }
