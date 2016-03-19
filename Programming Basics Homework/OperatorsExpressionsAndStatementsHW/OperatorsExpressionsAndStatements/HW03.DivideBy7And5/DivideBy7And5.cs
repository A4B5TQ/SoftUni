using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW03.DivideBy7And5
    {
    class DivideBy7And5
        {
        static void Main()
            {
            int input = int.Parse(Console.ReadLine());
            bool divide = input % 7 == 0 && input % 5 == 0;
            Console.WriteLine(divide); 
            }
        }
    }
