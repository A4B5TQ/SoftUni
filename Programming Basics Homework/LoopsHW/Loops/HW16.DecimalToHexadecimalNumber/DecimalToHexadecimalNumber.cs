using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW16.DecimalToHexadecimalNumber
{
    class DecimalToHexadecimalNumber
    {
        static void Main()
        {
            long n = long.Parse(Console.ReadLine());
            string hex = string.Empty;
            int divideRemainder;

            while(n > 0)
            {
                divideRemainder = (int)( n % 16 );

                if(divideRemainder < 10)
                {
                    hex = divideRemainder + hex;
                }
                else
                {
                    switch(divideRemainder)
                    {
                        case 10:
                            hex = "A" + hex;
                            break;
                        case 11:
                            hex = "B" + hex;
                            break;
                        case 12:
                            hex = "C" + hex;
                            break;
                        case 13:
                            hex = "D" + hex;
                            break;
                        case 14:
                            hex = "E" + hex;
                            break;
                        case 15:
                            hex = "F" + hex;
                            break;
                        default:
                            Console.WriteLine("Invalid Number");
                            break;
                    }
                }

                n /= 16;
            }

            Console.WriteLine(hex);
        }
    }
}
