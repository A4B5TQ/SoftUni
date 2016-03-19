using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW07.PointInACircle
    {
    class PointInACircle
        {
        static void Main()
            {
            double xPoint = double.Parse(Console.ReadLine());
            double yPoint = double.Parse(Console.ReadLine());
            double xCirclePoint = 0;
            double yCirclePoint = 0;
            double radius = 2;
            double areInside = Math.Pow((xPoint - xCirclePoint), 2) + Math.Pow((yPoint - yCirclePoint), 2);
            bool inside = areInside <= Math.Pow(radius, 2);
            Console.WriteLine(inside);
            }
        }
    }
