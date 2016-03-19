using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW05.TheBiggestOfThreeNumbers
{
    class TheBiggestOfThreeNumbers
    {
        static void Main()
        {
            double a = double.Parse( Console.ReadLine() );
            double b = double.Parse( Console.ReadLine() );
            double c = double.Parse( Console.ReadLine() );
            if(a > b && a > c)
            {
                Console.WriteLine(a);
            }
            else if (b > c)
            {
                Console.WriteLine(b);
            }
            else
            {
                Console.WriteLine(c);
            }
        }
    }
}
