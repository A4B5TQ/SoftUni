using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW15.HexadecimalToDecimalNumber
{
    class HexadecimalToDecimalNumber
    {
        static void Main()
        {
            string hex = Console.ReadLine();
            long num = 0; ;
            int index = hex.Length - 1;
            for(int i = 0; i < hex.Length; i++)
            {
                if(char.IsDigit(hex[i]))
                {
                    num += (long)char.GetNumericValue(hex[i]) * (long)Math.Pow(16 , index);
                }
                else
                {
                    switch(hex[i])
                    {
                        case 'A':  num += 10L * (long)Math.Pow(16 , index);
                            break;
                        case 'B': num += 11L * (long)Math.Pow(16 , index);
                            break;
                        case 'C': num += 12L * (long)Math.Pow(16 , index);
                            break;
                        case 'D': num += 13L * (long)Math.Pow(16 , index);
                            break;
                        case 'E': num += 14L * (long)Math.Pow(16 , index);
                            break;
                        case 'F': num += 15L * (long)Math.Pow(16 , index);
                            break;
                        default:
                            Console.WriteLine("Invalid Number");
                            break;
                    }
                }

                index--;
            }
            Console.WriteLine(num);
        }
    }
}
