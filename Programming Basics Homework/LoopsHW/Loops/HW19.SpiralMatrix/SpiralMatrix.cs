using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW19.SpiralMatrix
{
    class SpiralMatrix
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            int indexR = 0;
            int indexC = 0;
            int[,] matrix = new int[n, n];
            int counter = 1;
            int rowlength = n;

            while(counter <= n*n)
            {
                for(int i = 0; i < rowlength; i++)
                {
                    matrix[indexR , indexC] = counter;
                    counter++;
                    indexC++;
                }

                indexR++;
                indexC--;
                rowlength--;

                for(int i = 0; i < rowlength; i++)
                {
                    matrix[indexR , indexC] = counter;
                    counter++;
                    indexR++;
                }

                indexC--;
                indexR--;

                for(int i = 0; i < rowlength; i++)
                {
                    matrix[indexR , indexC] = counter;
                    counter++;
                    indexC--;
                }

                indexR--;
                indexC++;
                rowlength--;

                for(int i = 0; i < rowlength; i++)
                {
                    matrix[indexR , indexC] = counter;
                    counter++;
                    indexR--;
                }

                indexC++;
                indexR++;
            }

            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                {
                    Console.Write(matrix[i,j] + " ");
                }

                Console.WriteLine();
            }
        }
    }
}
