using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW21.DetectiveBoev
{
    class DetectiveBoev
    {
        static void Main()
        {
            string secretWord = Console.ReadLine();
            string encrypMess = Console.ReadLine();
            int count = 0;
            foreach(char item in secretWord)
            {
                count += (int)item;
            }
            string countString = count.ToString();
            count = 0;
            while(countString.Length > 1)
            {
                foreach(var item in countString)
                {
                    count += (int)char.GetNumericValue(item);
                }
                countString = count.ToString();
                count = 0;
            }
            count = int.Parse(countString);
            string decrMess = null;
            foreach(var item in encrypMess)
            {
                if(item % count == 0)
                {
                    decrMess += (char)( item + count );
                }
                else
                {
                    decrMess += (char)( item - count );
                }
            }
            string decrMessRev = new string(decrMess.ToCharArray().Reverse().ToArray());
            Console.WriteLine(decrMessRev);
        }
    }
}
