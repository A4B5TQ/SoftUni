using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DetectiveBoev
{
    class DetectiveBoev
    {
        static void Main(string[] args)
        {
            string secretWord = Console.ReadLine();
            string encryptedMessage = Console.ReadLine();

            //First part ----> Calculate mask

            int mask = 0;

            foreach(char item in secretWord)
            {
                mask += item;
            }

            while(mask > 9)
            {
                string tempMask = mask.ToString();
                mask = 0;

                foreach(char value in tempMask)
                {
                    mask += (int)char.GetNumericValue(value);
                    //mask += value - '0'; ----> Different way to get numeric value of character symbol
                }

            }

            // Second part - Decrypt message

            string decrypt = string.Empty;

            for(int i = 0; i < encryptedMessage.Length; i++)
            {
                if(encryptedMessage[i] % mask == 0)
                {
                    //decrypt += Convert.ToChar(( encryptedMessage[i] + mask ));  ----> Different way covert integer number to ASCII symbol
                    decrypt += (char)( encryptedMessage[i] + mask );
                }
                else
                {
                    //decrypt += Convert.ToChar(( encryptedMessage[i] - mask ));
                    decrypt += (char) (encryptedMessage[i] - mask);
                }
            }

            //Reverse string
            string output = string.Empty;

            output = ReverseString(decrypt);

            //output = new string(decrypt.ToCharArray().Reverse().ToArray()); ---> Reverse string using internal reverse array method 
            Console.WriteLine(output);
        }
        // Implementation of reverse string method ---> for optimization use StringBuilder with size equal of the input string length
        private static string ReverseString(string decrypt)
        {
            string output = string.Empty;

            for(int i = decrypt.Length - 1; i >= 0; i--)
            {
                output += decrypt[i];
            }

            return output;
        }
    }
}
