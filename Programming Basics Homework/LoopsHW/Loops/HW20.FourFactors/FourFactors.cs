using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW20.FourFactors
{
    class FourFactors
    {
        static void Main()
        {
            //input
            double FG = double.Parse(Console.ReadLine());
            double FGA = double.Parse(Console.ReadLine());
            double ThreeP = double.Parse(Console.ReadLine());
            double TOV = double.Parse(Console.ReadLine());
            double ORB = double.Parse(Console.ReadLine());
            double OppDRB = double.Parse(Console.ReadLine());
            double FT = double.Parse(Console.ReadLine());
            double FTA = double.Parse(Console.ReadLine());
            // Calculation
            double eFGPer = ( FG + ( 0.5 * ThreeP ) ) / FGA;
            double TOVPer = ( TOV / ( FGA + ( 0.44 * FTA ) + TOV ) );
            double ORBPer = ORB / ( ORB + OppDRB );
            double FTPer = FT / FGA;
            // output
            if(eFGPer >= 0 || TOVPer >= 0 || ORBPer >= 0 || FTPer >= 0)
            {
                Console.WriteLine("eFG% {0:F3}" , eFGPer);
                Console.WriteLine("TOV% {0:F3}" , TOVPer);
                Console.WriteLine("ORB% {0:F3}" , ORBPer);
                Console.WriteLine("FT% {0:F3}" , FTPer);
            }
            else
            {
                Console.WriteLine();
            }
        }
    }
}
