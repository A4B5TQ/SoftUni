using System;
using System.Collections.Generic;
using System.Threading;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW12.FallingRocks
    {
    class FallingRocks
        {
        
        static void Main()
            {
            //style
            Console.Title = "FollingRocks";
            Random rnd = new Random();
            Console.BackgroundColor = ConsoleColor.Black;
            Console.Clear();
            Console.ForegroundColor = ConsoleColor.Red;
            Console.WindowWidth = 70;
            Console.BufferWidth = Console.WindowWidth;
            Console.WindowHeight = 30;
            Console.BufferHeight = Console.WindowHeight;
            int playfield = Console.WindowWidth - 26;
            int rockXposs = 0;
            int rockYposs = 0;
            int xPoss = 35;
            int yPoss = 29;
            string cursorImage = " (o) ";
            string rocks = "^@*&+%$#!.;";
            while (true)
                {
                int i = rnd.Next(0, rocks.Length);
                int assist = rnd.Next(0, 100);
                int rockLength;
                if (assist < 70)
                    {
                    rockLength = 1;
                    }
                else if (assist < 95)
                    {
                    rockLength = 2;
                    }
                else
                    {
                    rockLength = 3;
                    }
                    rockXposs = rnd.Next(0, playfield);
                    rockYposs = 0;
                    for (int j = 0; j < rockLength; j++)
                        {
                        rockXposs += 1;
                        if (rockXposs < playfield)
                            {
                            Console.SetCursorPosition(rockXposs, rockYposs);
                              Console.Write(rocks[i]);
                            }
                        }
                Console.SetCursorPosition(xPoss, yPoss);
                Console.Write(cursorImage);
                ConsoleKeyInfo pressedKey = Console.ReadKey();
                if (pressedKey.Key == ConsoleKey.LeftArrow)
                    {
                    if (xPoss - 1 >= 1)
                        {
                        xPoss--;
                        }
                    }
                else if (pressedKey.Key == ConsoleKey.RightArrow)
                    {
                    if (xPoss < Console.WindowWidth - 26)
                        {
                        xPoss++;
                        }
                    }
                for (int k = 0; k < 29; k++)
                    {
                    rockYposs += 1;
                    Console.SetCursorPosition(rockXposs, rockYposs);
                    Console.Write(rocks[i]);
                    Thread.Sleep(20);
                    }

                Console.Clear();
                for (int p = 0; p <= yPoss; p++)
                    {
                    Console.SetCursorPosition(Console.WindowWidth - 20, p);
                    Console.WriteLine("|");
                    }
                Console.SetCursorPosition(52, 12);
                Console.WriteLine("Lives: ");
                Console.SetCursorPosition(52, 16);
                Console.WriteLine("Scores: ");
                }
            }
        }
    }
