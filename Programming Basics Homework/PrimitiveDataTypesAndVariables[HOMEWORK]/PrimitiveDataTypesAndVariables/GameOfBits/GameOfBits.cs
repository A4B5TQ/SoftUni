using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PrimitiveDataTypesAndVariables
    {
    class GameOfBits
        {
        static void Main()
            {
            uint input = uint.Parse(Console.ReadLine());
            string command = Console.ReadLine();
            while (command != "Game Over!")
                {
                if (command == "Odd")
                    {
                    uint oddBitsValues = 0;
                    uint oddBits = 0;
                    for (int i = 31; i >= 0; i -= 2)
                        {
                        oddBitsValues = 1 & (input >> (i - 1));
                        oddBits |= oddBitsValues << (i / 2);
                        }
                    input = oddBits;
                    command = Console.ReadLine();
                    }
                if (command == "Even")
                    {
                    uint evenBitsValues = 0;
                    uint evenBits = 0;
                    for (int i = 31; i >= 0; i -= 2)
                        {
                        evenBitsValues = 1 & (input >> (i));
                        evenBits |= evenBitsValues << (i / 2);
                        }
                    input = evenBits;
                    command = Console.ReadLine();
                    }
                }
            int count = 0;
            char[] bitValues = Convert.ToString(input, 2).ToCharArray();
            for (int i = 0; i < bitValues.Length; i++)
                {
                int bit = (int)char.GetNumericValue(bitValues[i]);
                count += bit;
                }
            Console.WriteLine("{0} -> {1}", input, count);
            }
        }
    }
