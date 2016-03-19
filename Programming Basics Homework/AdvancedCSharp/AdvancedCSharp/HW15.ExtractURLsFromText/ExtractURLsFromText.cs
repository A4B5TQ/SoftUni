using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW15.ExtractURLsFromText
{
    class ExtractURLsFromText
    {
        static void Main()
        {
            Console.SetIn(new System.IO.StreamReader(Console.OpenStandardInput(512)));

            string[] input = Console.ReadLine().Split(' '/*new char[] { ' ' , '.' , ',' , '!' , '?' , ':' , ';' , '"', '@','\\','/' }*/);
            List<string> extractedUrls = new List<string>();
            string http = "http://";
            string www = "www";

            for(int i = 0; i < input.Length; i++)
            {
                if(input[i].Contains(http) || input[i].Contains(www))
                {
                    extractedUrls.Add(input[i]);
                }
            }

            foreach(var item in extractedUrls)
            {
                if(item.EndsWith("."))
                {
                    Console.WriteLine(item.Remove(item.Length - 1 , 1));
                }
                else
                {
                    Console.WriteLine(item);
                }
            }
        }
    }
}
