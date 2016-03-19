using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW04.Rectangles
    {
    class Rectangles
        {
        static void Main()
            {
            double width = double.Parse(Console.ReadLine());
            double height = double.Parse(Console.ReadLine());
            Console.WriteLine("Perimeter: {0}", (width + height) * 2);
            Console.WriteLine("Area: {0}", width * height);
            }
        }
    }
