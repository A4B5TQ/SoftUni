using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW13.BinaryToDecimalNumber
{
    class BinaryToDecimalNumber
    {
        static void Main()
        {
            string binary = Console.ReadLine();

            long sum = 0;

            binary = new string(binary.ToCharArray().Reverse().ToArray());

            for(int i = 0; i < binary.Length; i++)
            {
                if(binary[i] == '1')
                {
                    sum += (long)Math.Pow(2 , i);
                }
            }

            Console.WriteLine(sum);
        }
    }
}
