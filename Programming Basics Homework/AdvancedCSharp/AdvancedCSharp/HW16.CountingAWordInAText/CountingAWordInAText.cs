using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW16.CountingAWordInAText
{
    class CountingAWordInAText
    {
        static void Main()
        {
            Console.SetIn(new System.IO.StreamReader(Console.OpenStandardInput(512)));

            string searchKey = Console.ReadLine().ToLower(); 
            string[] input = Console.ReadLine().ToLower().Split(new char[] { ' ' , '.' , ',' , '!' , '?' , ':' , ';' , '"' , '@' , '\\' , '/' , '(', ')'});
            int counter = 0;

            foreach(var item in input)
            {
                if(item.Equals(searchKey/*,StringComparison.InvariantCultureIgnoreCase*/))
                {
                    counter++;
                }
            }
            Console.WriteLine(counter);
        }
    }
}
