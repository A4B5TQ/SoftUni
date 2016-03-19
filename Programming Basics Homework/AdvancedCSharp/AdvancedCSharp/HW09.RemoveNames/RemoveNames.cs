using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW09.RemoveNames
{
    class RemoveNames
    {
        static void Main()
        {
            List<string> names = new List<string>(Console.ReadLine().Split(' '));
            List<string> namesToRemove = new List<string>(Console.ReadLine().Split(' '));

            for(int i = 0; i < namesToRemove.Count; i++)
            {
                for(int a = 0; a < names.Count; a++)
                {
                    if(namesToRemove[i] == names[a])
                    {
                        names[a] = " ";
                    }
                }
            }

            foreach(var item in names)
            {
                if(item != " ")
                {
                     Console.Write(item + " ");
                }
            }

            Console.WriteLine();
        }
    }
}
