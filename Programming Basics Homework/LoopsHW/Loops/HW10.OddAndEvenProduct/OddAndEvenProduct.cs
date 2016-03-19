using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW10.OddAndEvenProduct
{
    class OddAndEvenProduct
    {
        static void Main()
        {
            int[] n = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
            int oddProduct = 1;
            int evenProduct = 1;

            for(int i = 0; i < n.Length; i+=2)
            {

                oddProduct *= n[i];

                if(i + 1 < n.Length)
                {
                  evenProduct *= n[i + 1];
                }

            }

            if(oddProduct == evenProduct)
            {
                Console.WriteLine("yes");
                Console.WriteLine("product = {0}", oddProduct);
            }
            else
            {
                Console.WriteLine("no");
                Console.WriteLine("Odd Product = {0} \nEven Product = {1} \n", oddProduct, evenProduct);
            }
        }
    }
}
