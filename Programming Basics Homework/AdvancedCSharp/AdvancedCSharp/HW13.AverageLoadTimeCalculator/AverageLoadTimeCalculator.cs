using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW13.AverageLoadTimeCalculator
{
    class AverageLoadTimeCalculator
    {
        static void Main()
        {
            string input = Console.ReadLine();
            Dictionary<string , double> sites = new Dictionary<string , double>();
            Dictionary<string , int> sitesCounter = new Dictionary<string , int>();
            while(input != string.Empty)
            {
                string[] site = input.Split(' ');
                string link = site[2];
                double loadTime = Convert.ToDouble(site[3]);

                if(!sites.ContainsKey(link))
                {
                    sites.Add(link , loadTime);
                    sitesCounter.Add(link , 1);
                }
                else
                {
                    sites[link] += loadTime;
                    sitesCounter[link]++;
                }

                input = Console.ReadLine();
            }

            foreach(var item in sites.Keys)
            {
                double avarage = sites[item] / sitesCounter[item];
                Console.WriteLine("{0} -> {1}", item, avarage);
            }
        }
    }
}
