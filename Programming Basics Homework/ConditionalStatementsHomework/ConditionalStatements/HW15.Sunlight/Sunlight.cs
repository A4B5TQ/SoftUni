using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW15.Sunlight
{
    class Sunlight
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            int counter = 0;

            string firstLine = new string('.', n + (n / 2)) + (new string('*', 1)) + new string('.', (n + (n / 2)));
            Console.WriteLine(firstLine);

            //Diagonals
            for (int i = 0; i < n - 1; i++)
            {
                string leftdots = new string('.', i);
                string middledots = new string('.', (((3 * n) - 5) / 2) - i);
                Console.WriteLine(".{0}*{1}*{1}*{0}.",leftdots, middledots);
                counter++;
            }
            for (int i = 1; i <= counter / 2; i++)
            {
                string middleLine = new string('.', n) + new string('*', n) + new string('.', n);
                Console.WriteLine(middleLine);
            }

            //Center
            string centerLine = new string('*', n * 3);
            Console.WriteLine(centerLine);

            for (int i = 1; i <= counter / 2; i++)
            {
                string middleLine = new string('.', n) + new string('*', n) + new string('.', n);
                Console.WriteLine(middleLine);
            }

            for (int i = n - 2; i >= 0; i--)
            {
                string leftdots = new string('.', i);
                string middledots = new string('.', (((3 * n) - 5) / 2) - i);
                Console.WriteLine(".{0}*{1}*{1}*{0}.", leftdots, middledots);
            }
                Console.WriteLine(firstLine);
        }
    }
}
