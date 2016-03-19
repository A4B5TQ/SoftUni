using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW18.ChessboardGame
    {
    class ChessboardGame
        {
        static void Main()
            {
            int boardSize = int.Parse(Console.ReadLine());
            string message = Console.ReadLine();
            int messageLength = (boardSize * boardSize) - message.Length;
            for (int i = 0; i < messageLength; i++)
                {
                message += " ";
                }

            char[] input = message.ToCharArray();

            int whiteScores = 0;
            int blackScores = 0;

            for (int i = 0; i < Math.Pow(boardSize,2); i += 2)
                {
                if (char.IsLetterOrDigit(input[i]))
                    {
                    if (char.IsUpper(input[i]))
                        {
                        whiteScores += input[i];
                        }
                    else
                        {
                        blackScores += input[i];
                        }
                    }
                }
            for (int i = 1; i < Math.Pow(boardSize, 2); i += 2)
                {
                if (char.IsLetterOrDigit(input[i]))
                    {
                    if (char.IsUpper(input[i]))
                        {
                        blackScores += input[i];
                        }
                    else
                        {
                        whiteScores += input[i];
                        }
                    }
                }
            if (whiteScores == blackScores)
                {
                Console.WriteLine("Equal result: {0}", blackScores);
                }
            else
                {
                if (blackScores > whiteScores)
                    {
                    Console.WriteLine("The winner is: black team");
                    Console.WriteLine(Math.Max(whiteScores,blackScores) - Math.Min(whiteScores,blackScores));
                    }
                else if(blackScores < whiteScores)
                    {
                    Console.WriteLine("The winner is: white team");
                    Console.WriteLine(Math.Max(whiteScores, blackScores) - Math.Min(whiteScores, blackScores));
                    }
                }
            }
        }
    }
