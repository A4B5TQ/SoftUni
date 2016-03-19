using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW_03.CirclePerimeterAndArea
    {
    class CirclePerimeterAndArea
        {
        static void Main()
            {
            double rad = double.Parse(Console.ReadLine());
            double per, area;
            per = 2 * (Math.PI * rad);
            area = Math.PI * Math.Pow(rad, 2);
            Console.WriteLine("Perimeter: {0:F2}", per);
            Console.WriteLine("Area: {0:F2}", area);
            }
        }
    }
