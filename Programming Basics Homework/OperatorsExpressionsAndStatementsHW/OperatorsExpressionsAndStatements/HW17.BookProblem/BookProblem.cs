using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW17.BookProblem
    {
    class BookProblem
        {
        static void Main()
            {
            double bookPages = double.Parse(Console.ReadLine());
            double campingDays = double.Parse(Console.ReadLine());
            double pagesPerDay = double.Parse(Console.ReadLine());

            double readDays = 30 - campingDays;
            double pagesPerMonth = pagesPerDay * readDays;

            int necessaryYears = (int)(bookPages / pagesPerMonth) / 12;
            double necessaryMonth = Math.Ceiling((bookPages / pagesPerMonth) - (necessaryYears * 12));

            if (campingDays >= 30)
                {
                Console.WriteLine("never");
                }
            else
                {
                Console.WriteLine("{0} years {1} months", necessaryYears, necessaryMonth);
                }
            }
        }
    }
