using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW06.Four_DigitNumber
    {
    class FourDigitNumber
        {
        static void Main()
            {
            string input = Console.ReadLine();
            int sum = 0;
            string lastDigitOnFirstPosition = "";
            string reversedInput = "";
            string exchangeValues = "";
            foreach (char item in input) //Or We can use char.GetNumericValue(item); sum += item;
                {
                string charValue = Convert.ToString(item);
                int count = int.Parse(charValue);
                sum += count;
                }
            Console.WriteLine(sum); // Or We Can Use: reversedInput = new string(input.ToCharArray().Reverse().ToArray());
            for (int i = input.Length - 1; i >= 0; i--)
                {
                reversedInput += input[i];
                }
            Console.WriteLine(reversedInput);

            lastDigitOnFirstPosition = Convert.ToString(input[input.Length - 1]);
            for (int i = 0; i < input.Length - 1; i++)
                {
                lastDigitOnFirstPosition += input[i];
                }
            Console.WriteLine(lastDigitOnFirstPosition);

            exchangeValues += input[0];
            for (int i = input.Length / 2; i >= 1; i--)
                {
                exchangeValues += input[i];
                }
            exchangeValues += input[input.Length - 1];
            Console.WriteLine(exchangeValues);
            }
        }
    }
