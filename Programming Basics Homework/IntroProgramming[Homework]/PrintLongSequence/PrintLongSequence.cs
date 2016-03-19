using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PrintLongSequence
    {
    /*Write a program that prints the first 1000 members of the sequence: 2, -3, 4, -5, 6, -7, … You might need to learn how to use loops in C# (search in Internet).
    Expected Output
2,-3,4,-5,6,-7,8,-9,10,-11,12,-13,14,-15,16,-17…998,-999,1000,-1001*/

    class PrintLongSequence
        {
        static void Main()
            {
            for (int i = 2; i < 1002; i++)
                {
                if (i % 2 == 0)
                    {
                    Console.Write(i +",");
                    }
                else
                    {
                    if (i == 1001)
                        {
                        Console.WriteLine(-i);
                        }
                    else
                        {
                        Console.Write(-i + ",");
                        }
                    }
                }
            }
        }
    }
