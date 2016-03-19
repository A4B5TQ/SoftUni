using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW24.WiggleWiggle
{
    class WiggleWiggle
    {
        static void Main()
        {

            //SOLUTION WITH BITS 100/100
            //input
            string[] inputNumbers = Console.ReadLine().Split(' ');
            long[] numbers = new long[inputNumbers.Length];
            for(int i = 0; i < inputNumbers.Length; i++)
            {
                numbers[i] = long.Parse(inputNumbers[i]);
            }
            //Calculation
            for(int i = 0; i < inputNumbers.Length; i += 2)
            {
                long bitOnEvenPositionFirstN = 0;
                long bitOnEvenPositionSecondN = 0;
                //long evenBitsFirstNumber = 0;
                //long evenBitsSecondNumber = 0;
                for(int j = 0; j < 64; j += 2)
                {
                    bitOnEvenPositionFirstN = 1L & ( numbers[i] >> ( j ) );
                    bitOnEvenPositionSecondN = 1L & ( numbers[i + 1] >> ( j ) );
                    if(bitOnEvenPositionFirstN == bitOnEvenPositionSecondN)
                    {
                        continue;
                    }
                    else
                    {
                        if(bitOnEvenPositionFirstN > 0)
                        {
                            numbers[i] &= ~( bitOnEvenPositionFirstN << j );
                            numbers[i + 1] |= bitOnEvenPositionFirstN << j;
                        }
                        else
                        {

                            numbers[i + 1] &= ~( bitOnEvenPositionSecondN << j );
                            numbers[i] |= bitOnEvenPositionSecondN << j;
                        }
                    }
                }
                numbers[i] = ~numbers[i];
                numbers[i + 1] = ~numbers[i + 1];
                numbers[i] ^= 1L << 63;
                numbers[i + 1] ^= 1L << 63;
                //Output
                Console.WriteLine($"{numbers[i]} {Convert.ToString(numbers[i] , 2).PadLeft(63 , '0')}");
                Console.WriteLine($"{numbers[i + 1]} {Convert.ToString(numbers[i + 1] , 2).PadLeft(63 , '0')}");
            }

            //SOLUTION WITH STRINGBUILDER 100/100

            //string[] input = Console.ReadLine().Split();
            //for(int i = 0; i < input.Length; i += 2)
            //{
            //    long num1 = long.Parse(input[i]);
            //    long num2 = long.Parse(input[i + 1]);
            //    StringBuilder num1Bin = new StringBuilder(Convert.ToString(num1 , 2).PadLeft(63 , '0'));
            //    StringBuilder num2Bin = new StringBuilder(Convert.ToString(num2 , 2).PadLeft(63 , '0'));
            //    for(int a = 0; a < 63; a += 2)
            //    {
            //        if(num1Bin[a] != num2Bin[a])
            //        {
            //            char binaryDigit = num1Bin[a];
            //            num1Bin[a] = num2Bin[a];
            //            num2Bin[a] = binaryDigit;
            //        }
            //    }
            //    num1Bin.Replace('1' , '2');
            //    num1Bin.Replace('0' , '1');
            //    num1Bin.Replace('2' , '0');
            //    num2Bin.Replace('1' , '2');
            //    num2Bin.Replace('0' , '1');
            //    num2Bin.Replace('2' , '0');
            //    string output = num1Bin.ToString();
            //    long firstOutput = Convert.ToInt64(output , 2);
            //    output = num2Bin.ToString();
            //    long secondOutput = Convert.ToInt64(output , 2);
            //    Console.WriteLine("{0} {1}" , firstOutput , num1Bin);
            //    Console.WriteLine("{0} {1}" , secondOutput , num2Bin);
            //}

        }
    }
}
