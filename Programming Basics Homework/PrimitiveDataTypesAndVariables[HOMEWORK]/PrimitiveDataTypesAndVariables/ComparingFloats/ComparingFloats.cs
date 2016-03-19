using System;
using System.Threading;
using System.Globalization;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ComparingFloats
    {
    class ComparingFloats
        {
        static void Main()
            {
            Thread.CurrentThread.CurrentCulture = CultureInfo.InvariantCulture;
            const double eps = 0.000001;
            double numberA = double.Parse(Console.ReadLine());
            double numberB = double.Parse(Console.ReadLine());
            double difference = Math.Max(numberA, numberB) - Math.Min(numberA, numberB);
            bool areEqual = difference < eps;
            Console.WriteLine(areEqual);
            }
        }
    }
