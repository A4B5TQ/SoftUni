using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW09.PlayWithIntDoubleAndString
{
    class PlayWithIntDoubleAndString
    {
        static void Main()
        {
            Console.WriteLine("Please choose a type:");
            Console.WriteLine("1 --> int");
            Console.WriteLine("2 --> double");
            Console.WriteLine("3 --> string");
            int choice = int.Parse(Console.ReadLine());
            switch(choice)
            {
                case 1:
                    Console.WriteLine("Please enter a int:");
                    int intNum = int.Parse(Console.ReadLine());
                    intNum += 1;
                    Console.WriteLine(intNum);
                    break;
                case 2:
                    Console.WriteLine("Please enter a double:");
                    double doubleNum = double.Parse(Console.ReadLine());
                    doubleNum += 1;
                    Console.WriteLine(doubleNum);
                    break;
                case 3:
                    Console.WriteLine("Please enter a string:");
                    string str = Console.ReadLine();
                    str += "*";
                    Console.WriteLine(str);
                    break;
                default:
                    Console.WriteLine("Invalid Input!");
                    break;
            }
        }
    }
}
