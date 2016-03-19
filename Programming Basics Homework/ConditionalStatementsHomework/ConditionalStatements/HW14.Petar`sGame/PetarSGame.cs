using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Numerics;

namespace HW14.Petar_sGame
{
    class PetarSGame
    {
        static void Main()
        {
            ulong firstNumber = ulong.Parse(Console.ReadLine());
            ulong secondNumber = ulong.Parse(Console.ReadLine());
            string replaceString = Console.ReadLine();
            BigInteger sumNumbers = 0;

            for (ulong i = firstNumber; i < secondNumber; i++)
            {
                if (i % 5 == 0)
                {
                    sumNumbers += i;
                }
                else
                {
                    sumNumbers += (i % 5);
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.Append(sumNumbers);
            if (sumNumbers % 2 == 0)
            {
                sb.Replace(sb[0].ToString(), replaceString);
            }
            else
            {
                sb.Replace(sb[sb.Length - 1].ToString(), replaceString);
            }

            Console.WriteLine(sb.ToString());
        }
    }
}
