using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW10.PointInsideACircleOutsideOfARectangle
    {
    class PointInsideACircleAndOutsideOfARectangle
        {
        static void Main()
            {
            double xPoint = double.Parse(Console.ReadLine());
            double yPoint = double.Parse(Console.ReadLine());
            double xCirclePoint = 1;
            double yCirclePoint = 1;
            double radius = 1.5D;
            double areInside = Math.Pow((xPoint - xCirclePoint), 2) + Math.Pow((yPoint - yCirclePoint), 2);
            bool insideCircle = areInside <= Math.Pow(radius, 2);
            bool insideRectangle = (xPoint >= -1 && xPoint <= 5) && (yPoint >= -1 && yPoint <= 1);
            if (insideCircle && insideRectangle == false)
                {
                Console.WriteLine("yes");
                }
            else
                {
                Console.WriteLine("no");
                }
            }
        }
    }
