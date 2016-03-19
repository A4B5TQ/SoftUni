using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW17.CalculateGCD
{
    class CalculateGCD
    {
        static void Main()
        {
            int a = int.Parse(Console.ReadLine());
            int b = int.Parse(Console.ReadLine());

            while(a != 0 && b != 0)
            {
                if(a < 0)
                {
                    a *= -1;

                }
                if(b < 0)
                {
                    b *= -1;
                }
                if(a > b)
                {
                    a %= b;

                }
                else
                {
                    b %= a;
                }
            }

            if(a == 0)
            {
                Console.WriteLine(b);
            }
            else
            {
                Console.WriteLine(a);
            }
            
        }
    }
}
