using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW13.CompoundInterest
{
    class CompoundInterest
    {
        static void Main()
        {
            decimal priceTV = decimal.Parse(Console.ReadLine());
            decimal yearsPay = decimal.Parse(Console.ReadLine());
            decimal interestBank = decimal.Parse(Console.ReadLine());
            decimal interestFriend = decimal.Parse(Console.ReadLine());

            decimal bankOffer = priceTV * (DecimalPower((1M + interestBank), yearsPay));
            decimal friendOffer = priceTV * (1M + interestFriend);
            if (friendOffer <= bankOffer)
            {
                Console.WriteLine("{0:F2} Friend", friendOffer);
            }
            else
            {
                Console.WriteLine("{0:F2} Bank", bankOffer);
            }

        }
        public static decimal DecimalPower(decimal x, decimal y)
        {
            double X = (double)x;
            double Y = (double)y;
            return (decimal)System.Math.Pow(X, Y);
        }
    }
}
