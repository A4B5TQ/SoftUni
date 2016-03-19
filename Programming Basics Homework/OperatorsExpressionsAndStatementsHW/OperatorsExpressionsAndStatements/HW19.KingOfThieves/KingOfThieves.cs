using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW19.KingOfThieves
    {
    class KingOfThieves
        {
        static void Main()
            {
            int gemSize = int.Parse(Console.ReadLine());
            char gemChar = Convert.ToChar(Console.ReadLine());
            for (int i = 1; i <= gemSize; i+=2)
                {
                string charLine = new string(gemChar, i);
                string dashLine = new string('-', (gemSize - i) / 2);
                Console.WriteLine("{1}{0}{1}", charLine,dashLine);
                }
            for (int i = gemSize - 2;  i >= 1;  i -= 2)
                {
                string charLine = new string(gemChar, i);
                string dashLine = new string('-', (gemSize - i) / 2);
                Console.WriteLine("{1}{0}{1}", charLine, dashLine);
                }
            
            }
        }
    }
