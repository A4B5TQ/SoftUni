using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW02.BonusScore
{
    class BonusScore
    {
        static void Main()
        {
            double score = double.Parse( Console.ReadLine() );
            if(score > 0 && score <= 3)
            {
                Console.WriteLine(score * 10);
            }
            else if(score >= 4 && score <= 6)
            {
                Console.WriteLine(score * 100);
            }
            else if(score >= 7 && score <= 9)
            {
                Console.WriteLine( score * 1000 );
            }
            else
            {
                Console.WriteLine("invalid score");
            }
        }
    }
}
