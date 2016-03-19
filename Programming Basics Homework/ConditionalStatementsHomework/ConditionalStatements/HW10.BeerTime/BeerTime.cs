using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW10.BeerTime
{
    class BeerTime
    {
        static void Main()
        {
            char[] spliter = new char[] { ':',' '};
            string[] time = Console.ReadLine().Split(spliter);
            switch(time[2])
            {
                case "AM":
                    if(Convert.ToInt32(time[0]) == 12 || Convert.ToInt32(time[0]) < 3 && Convert.ToInt32(time[1]) <= 59)
                    {
                        Console.WriteLine("beer time");
                    }
                    else
                    {
                        Console.WriteLine("non - beer time");
                    }
                    break;
                case "PM":
                    if(Convert.ToInt32(time[0]) >= 1 && Convert.ToInt32(time[0]) < 12)
                    {
                        Console.WriteLine("beer time");
                    }
                    else
                    {
                        Console.WriteLine("non - beer time");
                    }
                    break;
                default:
                    Console.WriteLine("invalid time");
                    break;
            }
        }
    }
}
