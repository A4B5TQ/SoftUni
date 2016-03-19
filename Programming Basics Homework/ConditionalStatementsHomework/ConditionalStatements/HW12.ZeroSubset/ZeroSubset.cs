using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW12.ZeroSubset
{
    class ZeroSubset
    {
        static void Main()
        {
            int[] numbers = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
            bool zeroSubsets = false;
            int length = (int)Math.Pow(2 , numbers.Length) - 1;

            for(int i = length; i > 0; i--)
            {
                int sum = 0;

                StringBuilder sb = new StringBuilder();

                for(int j = 0; j < numbers.Length; j++)
                {
                    int mask = i >> j;

                    if(mask % 2 != 0)
                    {
                        sum += numbers[j];
                        sb.Append(string.Format("{0} + " , numbers[j]));
                    }
                }

                if(sum == 0 && sb.Length != 0)
                {
                    zeroSubsets = true;
                    Console.WriteLine("{0} = 0" , sb.Remove(sb.Length - 2 , 2));
                }
            }

            if(!zeroSubsets)
            {
                Console.WriteLine("no zero subset");
            }
        }
    }
}
