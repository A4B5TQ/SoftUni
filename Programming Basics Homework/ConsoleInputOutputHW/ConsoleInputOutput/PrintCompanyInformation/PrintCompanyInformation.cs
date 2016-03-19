using System;
using System.Threading;
using System.Globalization;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PrintCompanyInformation
    {
    class PrintCompanyInformation
        {
        static void Main()
            {
            string companyName = Console.ReadLine();
            string companyAddress = Console.ReadLine();
            string phoneNumber = Console.ReadLine();
            string faxNumber = Console.ReadLine();
            string webSite = Console.ReadLine();
            string managerFirstName = Console.ReadLine();
            string managerLastName = Console.ReadLine();
            int managerAge = int.Parse(Console.ReadLine());
            string managerPhone = Console.ReadLine();
            Console.WriteLine($"{companyName} \nAddress: {companyAddress} \nTel. {phoneNumber} \nFax: {faxNumber} \nWeb Site: {@webSite} \nManager: {managerFirstName} {managerLastName} (age:{managerAge}, tel. {managerPhone})");
            }
        }
    }
