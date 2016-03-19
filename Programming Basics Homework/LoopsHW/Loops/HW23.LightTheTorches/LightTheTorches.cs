using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW23.LightTheTorches
{
    class LightTheTorches
    {
        static void Main()
        {
            int numberOfRooms = int.Parse(Console.ReadLine());
            char[] roomsCondition = new char[numberOfRooms];
            string inputCondition = Console.ReadLine();
            string[] command = Console.ReadLine().Split(' ');
            int counter = 0;
            while(inputCondition.Length < numberOfRooms)
            {
                inputCondition += inputCondition;
            }
            for(int i = 0; i < numberOfRooms; i++)
            {
                roomsCondition[i] = inputCondition[i];
            }
            int currRoom = numberOfRooms / 2;
            int lastPoss = 0;

            // Conditions

            while(command[0] != "END")
            {
                string direction = command[0];
                int nPassedRooms = int.Parse(command[1]);

                nPassedRooms += 1;

                if(direction == "RIGHT")
                {
                    if(currRoom + nPassedRooms < roomsCondition.Length - 1)
                    {
                        lastPoss = currRoom;
                        currRoom = currRoom + nPassedRooms;
                        if(currRoom != lastPoss)
                        {
                            if(roomsCondition[currRoom] == 'L')
                            {
                                roomsCondition[currRoom] = 'D';
                            }
                            else
                            {
                                roomsCondition[currRoom] = 'L';
                            }
                        }
                    }
                    else
                    {
                        lastPoss = currRoom;
                        currRoom = roomsCondition.Length - 1;
                        if(currRoom != lastPoss)
                        {
                            if(roomsCondition[currRoom] == 'L')
                            {
                                roomsCondition[currRoom] = 'D';
                            }
                            else
                            {
                                roomsCondition[currRoom] = 'L';
                            }
                        }
                    }
                }
                if(direction == "LEFT")
                {
                    if(currRoom - nPassedRooms > 0)
                    {
                        lastPoss = currRoom;
                        currRoom = currRoom - nPassedRooms;
                        if(currRoom != lastPoss)
                        {
                            if(roomsCondition[currRoom] == 'L')
                            {
                                roomsCondition[currRoom] = 'D';
                            }
                            else
                            {
                                roomsCondition[currRoom] = 'L';
                            }
                        }
                    }
                    else
                    {
                        lastPoss = currRoom;
                        currRoom = 0;
                        if(currRoom != lastPoss)
                        {
                            if(roomsCondition[currRoom] == 'L')
                            {
                                roomsCondition[currRoom] = 'D';
                            }
                            else
                            {
                                roomsCondition[currRoom] = 'L';
                            }
                        }
                    }
                }
                command = Console.ReadLine().Split(' ');
            }
            foreach(var item in roomsCondition)
            {
                if(item == 'D')
                {
                    counter++;
                }
            }
            Console.WriteLine(counter * 'D');
        }
    }
}
