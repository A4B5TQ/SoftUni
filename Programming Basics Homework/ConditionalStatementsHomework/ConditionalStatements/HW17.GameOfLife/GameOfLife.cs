using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW17.GameOfLife
{
    class GameOfLife
    {
        static void Main()
        {
            int[] inputMatrix = new int[10];
            int[] outputMatrix = new int[10];
            int n = int.Parse(Console.ReadLine());
            
            for ( int i = 0 ; i < n ; i++ )
            {
                int xPoss = int.Parse( Console.ReadLine() );
                int yPoss = int.Parse( Console.ReadLine() );
                int mask = 1 << yPoss;
                inputMatrix[xPoss] |= mask;
            }

            for(int xPoss = 0; xPoss < 10 ; xPoss++)
            {
                for(int yPoss = 0 ; yPoss < 10 ; yPoss++)
                {

                    int liveNeighbours = 0;

                    liveNeighbours += CheckForLives(inputMatrix , xPoss , yPoss , -1 , 0);
                    liveNeighbours += CheckForLives(inputMatrix , xPoss , yPoss , 1 , 0);
                    liveNeighbours += CheckForLives(inputMatrix , xPoss , yPoss , 0 , -1);
                    liveNeighbours += CheckForLives(inputMatrix , xPoss , yPoss , 0 , 1);
                    liveNeighbours += CheckForLives(inputMatrix , xPoss , yPoss , -1 , -1);
                    liveNeighbours += CheckForLives(inputMatrix , xPoss , yPoss , -1 , 1);
                    liveNeighbours += CheckForLives(inputMatrix , xPoss , yPoss , 1 , -1);
                    liveNeighbours += CheckForLives(inputMatrix , xPoss , yPoss , 1 , 1);

                    if(( liveNeighbours == 3 || liveNeighbours == 2 ) && ( (( inputMatrix[xPoss] >> yPoss) & 1 ) == 1 ))
                    {
                        int mask = 1 << yPoss;
                        outputMatrix[xPoss] |= mask;
                    }
                    else if(liveNeighbours == 3 && ( ( inputMatrix[xPoss] >> yPoss & 1 ) == 0 ))
                    {
                        int mask = 1 << yPoss;
                        outputMatrix[xPoss] |= mask;
                    }
                }
            }

            for(int i = 0; i < outputMatrix.Length; i++)
            {

                Console.WriteLine(Convert.ToString(outputMatrix[i] , 2).PadLeft(10 , '0'));

            }
        }

        private static int CheckForLives(int[] numbers , int Xposs , int Yposs , int Xchange , int Ychange)
        {
            int count = 0;
            Xposs += Xchange;
            Yposs += Ychange;
            if(Xposs >= 0 && Xposs < 10 && Yposs >= 0 && Yposs < 10 && ( ( numbers[Xposs] >> Yposs ) & 1 ) == 1)
            {
                count = 1;
            }

            return count;
        }
    }
}
