using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PrintADeckOf52Cards
{
    class PrintADeckOf52Cards
    {
        static void Main(string[] args)
        {
            Console.OutputEncoding = Encoding.UTF8;
            char clubs = '\u2660';
            char hearts = '\u2665';
            char diamonds = '\u2666';
            char spades = '\u2663';

            for(int i = 2; i <= 14; i++)
            {
                if(i < 11)
                {
                    string cards = Convert.ToString(i) + spades + " " + Convert.ToString(i) + diamonds + " " + Convert.ToString(i) + hearts + " " + Convert.ToString(i) + clubs;
                    Console.WriteLine(cards);
                }
                else if(i >= 11)
                {
                    switch(i)
                    {
                        case 11:
                            string cards = "J" + spades + " " + "J" + diamonds + " " + "J" + hearts + " " + "J" + clubs;
                            Console.WriteLine(cards);
                            break;
                        case 12:
                            cards = "Q" + spades + " " + "Q" + diamonds + " " + "Q" + hearts + " " + "Q" + clubs;
                            Console.WriteLine(cards);
                            break;
                        case 13:
                            cards = "K" + spades + " " + "K" + diamonds + " " + "K" + hearts + " " + "K" + clubs;
                            Console.WriteLine(cards);
                            break;
                        case 14:
                            cards = "A" + spades + " " + "A" + diamonds + " " + "A" + hearts + " " + "A" + clubs;
                            Console.WriteLine(cards);
                            break;
                        default:
                            break;
                    }
                }
                
            }
        }
    }
}
