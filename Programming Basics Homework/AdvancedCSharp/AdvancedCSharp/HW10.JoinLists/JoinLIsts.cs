using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW10.JoinLists
{
    class JoinLists
    {
        static void Main()
        {
            List<int> firstList = new List<int>(Console.ReadLine().Split(' ').Select(int.Parse).ToList());
            List<int> secondList = new List<int>(Console.ReadLine().Split(' ').Select(int.Parse).ToList());

            for(int i = 0; i < secondList.Count; i++)
            {
                if(!firstList.Contains(secondList[i]))
                {
                    firstList.Add(secondList[i]);
                }
            }

            RemoveDuplicates(firstList);
            firstList.Sort();

            foreach(var item in firstList)
            {
                Console.Write(item + " ");
            }
            Console.WriteLine();
        }

        public static void RemoveDuplicates(List<int> List)
        {
            if(List == null)
            {
                return;
            }

            int i = 1;

            while(i < List.Count)
            {
                int j = 0;
                bool remove = false;

                while(j < i && !remove)
                {
                    if(List[i].Equals(List[j]))
                    {
                        remove = true;
                    }

                    j++;
                }

                if(remove)
                {
                    List.RemoveAt(i);
                }
                else
                {
                    i++;
                }
            }
        }
    }
}
