using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW13.CurrencyCheck
    {
    class CurrencyCheck
        {
        static void Main()
            {
            decimal r = decimal.Parse(Console.ReadLine());
            decimal d = decimal.Parse(Console.ReadLine());
            decimal e = decimal.Parse(Console.ReadLine());
            decimal b = decimal.Parse(Console.ReadLine());
            decimal m = decimal.Parse(Console.ReadLine());
            //Calculation
            r = r / 100 * 3.5M;
            d *=1.5M;
            e *=1.95M;
            b /=2;
            Console.WriteLine("{0:F2}", Math.Min(Math.Min(r, Math.Min(d, m)), Math.Min(e, b)));
            }
        }
    }
