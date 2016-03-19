using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW03.CheckForThePlayCard
{
    class CheckForThePLayCard
    {
        static void Main()
        {
            string character = Console.ReadLine();
            int number;
            bool isNumber = int.TryParse( character , out number );
            if(number >= 2 && number <= 10)
            {
                Console.WriteLine("yes");
            }
            else
            {
                switch(character)
                {
                    case "J":
                    case "Q":
                    case "K":
                    case "A":
                        Console.WriteLine("yes"); break;
                    default:
                        Console.WriteLine("no");
                        break;
                }
            }
        }
    }
}
