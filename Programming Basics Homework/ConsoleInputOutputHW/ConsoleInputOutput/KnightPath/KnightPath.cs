using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace KnightPath
    {
    class KnightPath
        {
        static void Main()
            {
            string command = Console.ReadLine();
            int[] lines = new int[8] { 1, 0, 0, 0, 0, 0, 0, 0 };
            int xPos = 0;
            int yPos = 0;
            int secXpos = 0;
            int secYpos = 0;
            while (command != "stop")
                {
                xPos = secXpos;
                yPos = secYpos;
                switch (command)
                    {
                    case "left up": xPos += 2; yPos--; break;
                    case "left down": xPos += 2; yPos++; break;
                    case "right up": xPos -= 2; yPos--; break;
                    case "right down": xPos -= 2; yPos++; break;
                    case "up right": yPos -= 2; xPos--; break;
                    case "up left": yPos -= 2; xPos++; break;
                    case "down left": yPos += 2; xPos++; break;
                    case "down right": yPos += 2; xPos--; break;
                    default:
                        break;
                    }
                if (xPos >= 0 && xPos <= 7 && yPos >= 0 && yPos <= 7)
                    {
                    secXpos = xPos;
                    secYpos = yPos;

                    switch (yPos)
                        {
                        case 0: lines[yPos] ^= 1 << xPos; break;
                        case 1: lines[yPos] ^= 1 << xPos; break;
                        case 2: lines[yPos] ^= 1 << xPos; break;
                        case 3: lines[yPos] ^= 1 << xPos; break;
                        case 4: lines[yPos] ^= 1 << xPos; break;
                        case 5: lines[yPos] ^= 1 << xPos; break;
                        case 6: lines[yPos] ^= 1 << xPos; break;
                        case 7: lines[yPos] ^= 1 << xPos; break;
                        default:
                            break;
                        }
                    }
                command = Console.ReadLine();
                }
            foreach (var line in lines)
                {
                if (line > 0)
                    {
                    Console.WriteLine(line);
                    }
                }
            if (lines.Sum() == 0)
                {
                Console.WriteLine("[Board is empty]");
                }
            }
        }
    }
