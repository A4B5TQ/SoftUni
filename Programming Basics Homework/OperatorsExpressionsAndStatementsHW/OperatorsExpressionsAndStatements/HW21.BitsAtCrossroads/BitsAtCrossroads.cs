using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW21.BitsAtCrossroads
    {
    class BitsAtCrossroads
        {
        static void Main()
            {
            uint boardSize = uint.Parse(Console.ReadLine());
            string[] direction = Console.ReadLine().Split(' ');
            int crossroads = 0;
            uint bitcheck = 0;

            uint[] lineFills = new uint[boardSize];

            for (uint i = 0; i < boardSize; i++)
                {
                lineFills[i] = 0;
                }

            while (direction[0] != "end")
                {
                int lineNumber = int.Parse(direction[0]);
                uint mask = 1U;
                for (int i = lineNumber, bitPoss = int.Parse(direction[1]); i >= 0 && bitPoss < boardSize; i--, bitPoss++)
                    {
                    bitcheck = (lineFills[i] >> bitPoss) & 1U;
                    if (bitcheck == 1)
                        {
                        crossroads++;
                        }
                    lineFills[i] |= mask << bitPoss;
                    }
                for (int i = lineNumber, bitPoss = int.Parse(direction[1]); i >= 0 && bitPoss >= 0; i--, bitPoss--)
                    {
                    bitcheck = (lineFills[i] >> bitPoss) & 1U;
                    if (i != lineNumber && bitcheck == 1)
                        {
                        crossroads++;
                        }
                    lineFills[i] |= mask << bitPoss;
                    }

                for (int i = lineNumber, bitPoss = int.Parse(direction[1]); bitPoss >= 0 && i < boardSize; i++, bitPoss--)
                    {
                    bitcheck = (lineFills[i] >> bitPoss) & 1U;
                    if (i != lineNumber && bitcheck == 1)
                        {
                        crossroads++;
                        }
                    lineFills[i] |= mask << bitPoss;
                    }
                for (int i = lineNumber, bitPoss = int.Parse(direction[1]); bitPoss < boardSize && i < boardSize; i++, bitPoss++)
                    {
                    bitcheck = (lineFills[i] >> bitPoss) & 1U;
                    if (bitcheck == 1)
                        {
                        crossroads++;
                        }
                    lineFills[i] |= mask << bitPoss;
                    }
                direction = Console.ReadLine().Split(' ');
                }

            for (uint i = 0; i < boardSize; i++)
                {
                Console.WriteLine(lineFills[i]);
                }
            Console.WriteLine(crossroads);
            }
        }
    }
