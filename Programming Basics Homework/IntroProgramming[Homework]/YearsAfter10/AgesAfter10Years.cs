using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace YearsAfter10
    {
    /*Write a program to read your birthday from the console and print how old you are now and how old you will be after 10 years.
Input	Output
12.04.1991	Now: 24
After 10 years: 34*/
    class AgesAfter10Years
        {
        static void Main()
            {
            int[] birthDate = Console.ReadLine().Split('.').Select(int.Parse).ToArray();
            int[] currDate = new int[] { DateTime.Now.Day, DateTime.Now.Month, DateTime.Now.Year };
            int result;
            if (birthDate[1] > currDate[1] || birthDate[1] == currDate[1] && birthDate[0] > currDate[0])
                {
                result = (currDate[2] - birthDate[2]) - 1;
                }
            else
                {
                result = currDate[2] - birthDate[2];
                }
            Console.WriteLine("Now: {0}", result);
            Console.WriteLine("After 10 years: {0}", result + 10);
            }
        }
    }
