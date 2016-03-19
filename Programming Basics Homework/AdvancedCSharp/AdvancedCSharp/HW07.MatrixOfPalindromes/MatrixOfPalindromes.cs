using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW07.MatrixOfPalindromes
{
    class MatrixOfPalindromes
    {
        static void Main()
        {
            // FIRST Solution

            //string[] input = Console.ReadLine().Split(' ');
            //int row = int.Parse(input[0]);
            //int column = int.Parse(input[1]);
            //char alph = 'a';

            //for(int i = 0; i < row; i++)
            //{
            //    for(int b = 0; b < column; b++)
            //    {
            //        string chars = Convert.ToString((char)( alph + i )) + Convert.ToString((char)( alph + b + i )) + Convert.ToString((char)( alph + i ));

            //        Console.Write(chars + " ");
            //    }

            //    Console.WriteLine();
            //}

            // SECOND Solution

            int[] indexs = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
            string[,] matrix = new string[indexs[0], indexs[1]];
            char alph = 'a';

            for(int i = 0; i < indexs[0]; i++)
            {
                for(int a = 0; a < indexs[1]; a++)
                {
                    matrix[i , a] = Convert.ToString((char)( alph + i )) + Convert.ToString((char)( alph + a + i )) + Convert.ToString((char)( alph + i ));
                }
            }

            for(int i = 0; i < indexs[0]; i++)
            {
                for(int a = 0; a < indexs[1]; a++)
                {
                    Console.Write(matrix[i , a] + " ");
                }

                Console.WriteLine();
            }
        }
    }
}
