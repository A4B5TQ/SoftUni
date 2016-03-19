using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW20.DecryptTheMessages
    {
    class DecryptTheMessages
        {
        static void Main()
            {
            string inputMessages = Console.ReadLine();
            int counterOfMessages = 0;
            List<string> messages = new List<string>();
            while (inputMessages.ToUpper() != "START")
                {
                inputMessages = Console.ReadLine();
                }
            inputMessages = Console.ReadLine();
            while (inputMessages != "END" && inputMessages != "end")
                {
                if (inputMessages != "" && inputMessages != "END" && inputMessages != "end")
                    {
                    counterOfMessages++;
                    messages.Add(inputMessages);
                    }
                inputMessages = Console.ReadLine();
                }
            if (counterOfMessages > 0)
                {
                Console.WriteLine("Total number of messages: {0}", counterOfMessages);
                for (int i = 0; i < messages.Count; i++)
                    {
                    DecryptMessages(messages[i]);
                    }
                }
            else
                {
                Console.WriteLine("No message received.");
                }
            }

        private static void DecryptMessages(string inputMessages)
            {
            string outputMessages = string.Empty;
            foreach (char item in inputMessages)
                {
                if (char.IsLetter(item))
                    {
                    if (item >= 65 && item <= 77 || item >= 97 && item <= 109)
                        {
                        outputMessages += (char)(item + 13);
                        }
                    else
                        {
                        if (item <= 90 && item > 77 || item > 109 && item <= 122)
                            {
                            outputMessages += (char)(item - 13);
                            }
                        }
                    }
                else
                    {
                    switch (item)
                        {
                        case '+': outputMessages += (char)(item - 11); break;
                        case '%': outputMessages += (char)(item + 7); break;
                        case '&': outputMessages += (char)(item + 8); break;
                        case '#': outputMessages += (char)(item + 28); break;
                        case '$': outputMessages += (char)(item - 3); break;
                        default: outputMessages += (char)item; break;
                        }
                    }
                }
            outputMessages = new string(outputMessages.ToCharArray().Reverse().ToArray());
            Console.WriteLine(outputMessages);
            }
        }
    }
