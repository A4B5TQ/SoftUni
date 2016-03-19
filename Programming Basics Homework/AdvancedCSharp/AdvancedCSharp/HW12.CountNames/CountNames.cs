using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW12.CountNames
{
    class CountNames
    {
        static void Main()
        {
            List<string> names = new List<string>(Console.ReadLine().Split(' ').ToList());

            names.Sort();

            NamesCounter(names);
        }

        private static void NamesCounter(List<string> names)
        {
            int counter = 1;
            for(int i = 1; i < names.Count; i++)
            {
                if(names[i] == names[i - 1])
                {
                    counter++;
                }
                else
                {
                    Console.Write("{0} -> {1} times" , names[i - 1] , counter);
                    counter = 1;
                    Console.WriteLine();
                }
                if(i == names.Count - 1)
                {
                    Console.Write("{0} -> {1} times" , names[i] , counter);
                }
            }
            Console.WriteLine();
        }
    }
}
