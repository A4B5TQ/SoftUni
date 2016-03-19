using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW06.LongestAreaInArray
{
    class LongestAreaInArray
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            string[] stringArray = new string[n];
            string match = string.Empty;
            int length = 0;

            for(int i = 0; i < n; i++)
            {
                stringArray[i] = Console.ReadLine();
            }

            for(int i = 0; i < stringArray.Length; i++)
            {
                int count = 0;

                for(int a = i; a < stringArray.Length; a++)
                {
                    if(stringArray[i] == stringArray[a])
                    {
                        count++;
                    }
                    else
                    {
                        break;
                    }

                    if(length < count)
                    {
                        length = count;
                        match = stringArray[i];
                    }
                }
            }

            Console.WriteLine(length);

            foreach(var item in stringArray)
            {
                if(item == match)
                {
                    Console.WriteLine(item);
                }
            }
        }
    }
}
