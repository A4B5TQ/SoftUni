using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QuotesStrings
    {
    class QuotesInStrings
        {
        static void Main()
            {
            string firstOut = "The \"use\" of quotations causes difficulties.";
            string secondOut = @"The ""use"" of quotations causes difficulties.";
            Console.WriteLine(firstOut);
            Console.WriteLine(secondOut);
            }
        }
    }
