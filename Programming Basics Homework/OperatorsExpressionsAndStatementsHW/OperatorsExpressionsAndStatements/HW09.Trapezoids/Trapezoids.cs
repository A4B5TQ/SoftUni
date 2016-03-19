using System;
using System.Threading;
using System.Globalization;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW09.Trapezoids
    {
    class Trapezoids
        {
        static void Main()
            {
            Thread.CurrentThread.CurrentCulture = CultureInfo.InvariantCulture;
            double a = double.Parse(Console.ReadLine());
            double b = double.Parse(Console.ReadLine());
            double h = double.Parse(Console.ReadLine());
            double area = ((a + b) / 2.0D) * h;
            Console.WriteLine(area);
            }
        }
    }
