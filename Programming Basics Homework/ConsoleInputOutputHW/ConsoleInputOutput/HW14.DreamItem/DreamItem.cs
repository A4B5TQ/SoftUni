using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW14.DreamItem
    {
    class DreamItem
        {
        static void Main()
            {
            //input
            string[] input = Console.ReadLine().Split('\\');
            string mounth = input[0];
            decimal count = 0;
            int hoursPerDay = int.Parse(input[2]);
            decimal priceOfTheItem = decimal.Parse(input[3]);
            decimal moneyPerHour = decimal.Parse(input[1]);
            //calculation
            if (hoursPerDay <= 24)
                {
                switch (mounth)
                    {
                    case "Jan":
                    case "May":
                    case "March":
                    case "Aug":
                    case "July":
                    case "Oct":
                    case "Dec": count = 21 * hoursPerDay * moneyPerHour; break;
                    default:
                        break;
                    }
                switch (mounth)
                    {
                    case "Apr":
                    case "June":
                    case "Sept":
                    case "Nov": count = 20 * hoursPerDay * moneyPerHour; break;
                    default:
                        break;
                    }
                switch (mounth)
                    {
                    case "Feb": count = 18 * hoursPerDay * moneyPerHour; break;
                    default:
                        break;
                    }
                }
            if (count > 700)
                {
                count += (count * 10) / 100;

                if (count < priceOfTheItem)
                    {
                    Console.WriteLine("Not enough money. {0:F2} leva needed.", priceOfTheItem -= count);

                    }
                else
                    {
                    Console.WriteLine("Money left = {0:F2} leva.", count -= priceOfTheItem);
                    }
                }
            else
                {
                if (count < priceOfTheItem)
                    {
                    Console.WriteLine("Not enough money. {0:F2} leva needed.", priceOfTheItem -= count);

                    }
                else
                    {
                    Console.WriteLine("Money left = {0:F2} leva.", count -= priceOfTheItem);
                    }
                }
            }
        }
    }
