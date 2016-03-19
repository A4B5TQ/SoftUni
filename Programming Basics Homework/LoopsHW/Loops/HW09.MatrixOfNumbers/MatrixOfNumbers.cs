using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW09.MatrixOfNumbers
{
    class MatrixOfNumbers
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());

            for(int i = 1; i <= n; i++)
            {

                for(int a = i; a < i + n; a++)
                {
                    Console.Write(a + " ");
                }

                Console.WriteLine();
            }
        }
    }
}
