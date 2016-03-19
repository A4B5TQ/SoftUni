using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW11.BitwiseExtractBit3
    {
    class BitwiseExtractBit3
        {
        static void Main()
            {
            int input = int.Parse(Console.ReadLine());
            int bitOnThirdPosition = (input >> 3) & 1;
            Console.WriteLine(bitOnThirdPosition);
            }
        }
    }
