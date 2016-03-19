using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TorrentPirate
    {
    class TorrentPirate
        {
        static void Main()
            {
            //input
            int downMB = int.Parse(Console.ReadLine());
            int moviePrice = int.Parse(Console.ReadLine());
            int moneyPerHour = int.Parse(Console.ReadLine());
            const int movieSize = 1500;
            //Calculation
            double downTime = ((double)downMB / 2) / 3600;
            decimal downPrice = (decimal)downTime * moneyPerHour;
            double moviesNumber = (double)downMB / movieSize;
            decimal cinemaPrice = (decimal)moviesNumber * moviePrice;
            downPrice = Math.Round(downPrice, 2);
            cinemaPrice = Math.Round(cinemaPrice, 2);
            //Result
            if (downPrice > cinemaPrice)
                {
                Console.WriteLine($"cinema -> {cinemaPrice}lv");
                }
            else
                {
                Console.WriteLine($"mall -> {downPrice}lv");
                }

            }
        }
    }
