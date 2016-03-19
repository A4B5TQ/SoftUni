using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW08.PrimeNumberCheck
    {
    class PrimeNumberCheck
        {
        static void Main()
            {
            int number = int.Parse(Console.ReadLine());
            if (number > 0 && number <= 100)
                {
                if (number == 1 || number == 2 || number == 3)
                    {
                    Console.WriteLine(true);
                    }
                else
                    {
                    for (int i = 2; i <= Math.Sqrt(number); i++)
                        {
                        if (number % i != 0 && number % 3 != 0)
                            {
                            Console.WriteLine(true);
                            break;      
                            }
                        else
                            {
                            Console.WriteLine(false);
                            break;
                            }
                        }
                    }
                }
            }
        }
    }
