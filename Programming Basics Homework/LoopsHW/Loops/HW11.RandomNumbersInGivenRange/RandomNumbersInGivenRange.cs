using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW11.RandomNumbersInGivenRange
{
    class RandomNumbersInGivenRange
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            int min = int.Parse(Console.ReadLine());
            int max = int.Parse(Console.ReadLine());

            Random rnd = new Random();

            for(int i = 1; i <= n; i++)
            {
                Console.Write(rnd.Next(min,max + 1) + " ");
            }
        }
    }
}
