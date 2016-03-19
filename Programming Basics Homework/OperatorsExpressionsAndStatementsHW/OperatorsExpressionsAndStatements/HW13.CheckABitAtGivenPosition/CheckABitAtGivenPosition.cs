using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW13.CheckABitAtGivenPosition
    {
    class CheckABitAtGivenPosition
        {
        static void Main()
            {
            int number = int.Parse(Console.ReadLine());
            int desirePositionBit = int.Parse(Console.ReadLine());
            int bitOnPPosition = (number >> desirePositionBit) & 1;
            bool bitValueOne = bitOnPPosition == 1;
            Console.WriteLine(bitValueOne);
            }
        }
    }
