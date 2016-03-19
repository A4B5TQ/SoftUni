using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW11.NumberAsWords
{
    class NumberAsWords
    {
        static void Main()
        {
            string[] units = new string[] { "Zero" , "One" , "Two" , "Three" , "Four" , "Five" , "Six" , "Seven" , "Eight" , "Nine" , "Ten" , "eleven" , "twelve" , "thirteen" , "fourteen" , "fifteen" , "sixteen" , "seventeen" , "eighteen" , "nineteen" };
            string[] tens = new string[] { "zero" , "ten" , "twenty" , "thirty" , "forty" , "fifty" , "sixty" , "seventy" , "eighty" , "ninety" };

            int number = int.Parse(Console.ReadLine());
            string words = string.Empty;

            if(number == 0)
            {
                Console.WriteLine(units[number]);
            }

            if((number / 100) != 0)
            {
                words += units[number / 100] + " " + "hundred";
                if(( number % 100 ) != 0)
                {
                    words += " " + "and" + " ";
                    number %= 100;
                }
            }

            if( number > 0 && number < 20)
            {
                words +=  units[number];
            }

            if(number >= 20 && number < 100)
            {
                words += tens[number / 10];
                if(number % 10 != 0)
                {
                    words += " " + units[number % 10];
                }
                
            }

            Console.WriteLine(words.ToUpper());
        }
    }
}
