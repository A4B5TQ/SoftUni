using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW12.ExtractBitFromInteger
    {
    class ExtractBitFromInteger
        {
        static void Main()
            {
            int number = int.Parse(Console.ReadLine());
            int desirePositionBit = int.Parse(Console.ReadLine());
            int bitOnPPosition = (number >> desirePositionBit) & 1;
            Console.WriteLine(bitOnPPosition);
            }
        }
    }
