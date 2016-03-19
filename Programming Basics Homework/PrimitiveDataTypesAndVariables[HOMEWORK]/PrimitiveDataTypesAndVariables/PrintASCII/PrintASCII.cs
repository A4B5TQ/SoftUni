using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PrintASCII
    {
    class PrintASCII
        {
        static void Main()
            {
            Console.OutputEncoding = Encoding.Unicode;
            for (int i = 0; i <= 255; i++)
                {
               char symbol = (char)i;
                Console.WriteLine(symbol);
                }

            }
        }
    }
