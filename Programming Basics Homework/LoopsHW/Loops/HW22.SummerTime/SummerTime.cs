using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW22.SummerTime
{
    class SummerTime
    {
        static void Main()
        {
            int input = int.Parse(Console.ReadLine());
            string spaces = new string(' ' , input / 2);
            string top = new string('*' , input + 1);
            Console.WriteLine($"{spaces}{top}");
            int neckHeight = input - ( input / 2 );
            for(int i = 0; i < neckHeight; i++)
            {
                string neck = "*" + new string(' ' , input - 1) + "*";
                Console.WriteLine($"{spaces}{neck}");
            }
            for(int i = 1; i <= ( ( input / 2 ) - 1 ) * 2; i += 2)
            {
                spaces = new string(' ' , ( input / 2 ) - ( i / 2 ) - 1);
                string middle = new string(' ' , input + i);
                Console.WriteLine($"{spaces}*{middle}*{spaces}");
            }
            for(int i = 0; i < input; i++)
            {
                string middle = new string('.' , ( input * 2 ) - 2);
                Console.WriteLine($"*{middle}*");
            }
            for(int i = 0; i < input; i++)
            {
                string middle = new string('@' , ( input * 2 ) - 2);
                Console.WriteLine($"*{middle}*");
            }
            string bottom = new string('*' , input * 2);
            Console.WriteLine(bottom);
        }
    }
}
