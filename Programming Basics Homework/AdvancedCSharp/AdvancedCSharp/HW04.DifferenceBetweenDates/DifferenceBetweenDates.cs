using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW04.DifferenceBetweenDates
{
    class DifferenceBetweenDates
    {
        static void Main()
        {
            DateTime firstDate = DateTime.Parse(Console.ReadLine());
            DateTime seccondDate = DateTime.Parse(Console.ReadLine());

            Console.WriteLine(seccondDate.Subtract(firstDate).TotalDays);
        }
    }
}
