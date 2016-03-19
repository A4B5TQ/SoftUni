using System;
using System.Collections.Generic;
using System.Collections;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW16.ArrayMatcher
    {
    class ArrayMatcher
        {
        static void Main()
            {
            string[] input = Console.ReadLine().Split('\\');
            string charValues = null;
            char[] output = null;
            if (input[2] == "join")
                {
                foreach (char item in input[0])
                    {
                    foreach (var item1 in input[1])
                        {
                        if (item == item1)
                            {
                            charValues = charValues + (char)item;
                            }
                        }
                    }
                output = charValues.ToCharArray();
                Array.Sort(output);
                Console.WriteLine(output);
                }
            if (input[2] == "right exclude")
                {
                foreach (var item in input[0])
                    {
                    if (input[1].Contains(item) == false)
                        {
                        charValues = charValues + item;
                        }
                    }
                output = charValues.ToCharArray();
                Array.Sort(output);
                Console.WriteLine(output);
                }
            if (input[2] == "left exclude")
                {
                foreach (var item in input[1])
                    {
                    if (input[0].Contains(item) == false)
                        {
                        charValues = charValues + item;
                        }
                    }
                output = charValues.ToCharArray();
                Array.Sort(output);
                Console.WriteLine(output);
                }
            }
        }
    }
