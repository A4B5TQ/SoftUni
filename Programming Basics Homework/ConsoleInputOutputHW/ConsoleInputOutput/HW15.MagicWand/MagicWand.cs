using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW15.MagicWand
    {
    class MagicWand
        {
        static void Main()
            {
            int n = int.Parse(Console.ReadLine());
            string firstLine = new string('.', n + n / 2);
            Console.WriteLine("{0}.*.{0}",firstLine);
            //top
            for (int i = n - n/2; i > 0; i--)
                {
                string nextLinesPoints = new string('.', n + i - 1);
                string nextLinesAsteriks = new string('.', 3*n - (n + i - 1 )* 2);
                Console.WriteLine("{0}*{1}*{0}",nextLinesPoints,nextLinesAsteriks);
                }
            string devideLineAster = new string('*', n);
            string devideLinePoints = new string('.', n + 2);
            Console.WriteLine("{0}{1}{0}",devideLineAster,devideLinePoints);
            // middle
            for (int i = 1; i <= n/2; i++)
                {
                string nextLinesPoints = new string('.', i);
                string nextLinesInnerPoints = new string('.', 3 * n - 2 * i);
                Console.WriteLine("{0}*{1}*{0}",nextLinesPoints,nextLinesInnerPoints);
                }
            for (int i = n/2; i > 0; i--)
                {
                string middlePairBegin = new string('.', i - 1);
                string middlePairAfter = new string('.', n / 2);
                string middlePairMiddle = new string('.', n);
                string middlePairEnd = new string('.', (n / 2) - i);
                Console.WriteLine("{0}*{1}*{3}*{2}*{3}*{1}*{0}",middlePairBegin,middlePairAfter, middlePairMiddle,middlePairEnd);
                }
            string afterMiddleLineAsteriks = new string('*', n - n / 2);
            string afterMiddleLinePoints = new string('.', n/2);
            string afterMiddleCenterLinePoints = new string('.', n);
            Console.WriteLine("{0}{1}*{2}*{1}{0}",afterMiddleLineAsteriks,afterMiddleLinePoints,afterMiddleCenterLinePoints);
            //bottom
            for (int i = 0; i < n; i++)
                {
                string bottomPoints = new string('.', n);
                Console.WriteLine("{0}*{0}*{0}",bottomPoints);
                }
            //end
            string endPoints = new string('.', n);
            string endAsteriks = new string('*', n);
            Console.WriteLine("{0}*{1}*{0}",endPoints,endAsteriks);
            }
        }
    }
