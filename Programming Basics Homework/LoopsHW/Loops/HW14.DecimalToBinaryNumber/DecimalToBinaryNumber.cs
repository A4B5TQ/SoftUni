using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW14.DecimalToBinaryNumber
{
    class DecimalToBinaryNumber
    {
        static void Main()
        {
            // THIS IS ONE SOLUTION OF THE PROBLEM

            //long n = long.Parse(Console.ReadLine());

            //string binary = "";

            //for(int i = 0; i < 64; i++)
            //{
            //    binary = ( ( n >> i ) & 1 ).ToString() + binary;
            //}

            //Console.WriteLine(binary);

            //ANOTHER SOLUTION

            long n = long.Parse(Console.ReadLine());
            string binary = string.Empty;
            int divideRemainder;

            while(n > 0)
            {
                divideRemainder = (int)( n % 2 );
                n /= 2;
                binary = divideRemainder + binary;
            }

            Console.WriteLine(binary);
        }
    }
}
