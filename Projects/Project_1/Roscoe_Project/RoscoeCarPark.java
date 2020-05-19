import java.util.Scanner;
import java.io.*;

/**
 * Simulates a day at Roscoe's Car Park (using StackADTs), where cars are either parked or picked-up
 * 
 * @author Matthew Pigliavento 
 * @version 10/14/2016
 */
public class RoscoeCarPark
{
    public static void main(String[] args)
    {
        // creates a StackADT for the lot and for the alley
        StackADT<Car> lot = new StackADT<Car>();
        StackADT<Car> alley = new StackADT<Car>();

        // creates a String array to store licenses
        String[] licenseRegistry = new String[50];

        // keeps track of which posistion in licenseRegistry to place the license
        int registryPosition = 0;
        
        // assigns the name of the file to open
        String fileName = "carin.txt";

        // creates a String variable to to hold the data from the input file
        String line;
        
        // open the input file
        Scanner inFile = null;
        System.out.println("Roscoe's Car Park is now open for business!");
        System.out.println();
        
        // checks for an error with opening the file; if so, print error message to the terminal and return
        try
        { 
            inFile = new Scanner(new File(fileName)); 
        }
        catch (FileNotFoundException e) 
        {
            System.out.println("Cannot open "+fileName+" check if it exist in this project directory");
            return;
        }

        // loop runs while the file has more data
        while (inFile.hasNextLine())
        {
            line = inFile.nextLine();
            
            // separates line into five pieces, stored in String array data
            String[] data = line.split("\\s");

            // converts the hour and minute from line into ints and stores them in variables hour and minute
            int hour = Integer.parseInt(data[3]);
            int minute = Integer.parseInt(data[4]);

            // stores the license and brand in variables license and brand
            String license = data[1];
            String brand = data[2];

            // checks whether a park or pick-up is requested
            // park
            if (data[0].equals("P"))
            {
                // checks if the lot is full; if so, outputs message to terminal
                if (lot.isFull(8))
                {
                    System.out.println("Apologies, Roscoe's lot is full.");
                }
                // parks car in lot, stores license in array licenseRegistry, outputs car's information to terminal
                else
                {
                    Car car = new Car(license, brand, hour, minute, 0, 0);
                    
                    // stores car's license in array licenseRegistry
                    licenseRegistry[registryPosition] = license;
                    
                    // increments registryPosition
                    registryPosition++;
                    
                    lot.push(car);
                    if (minute < 10)
                    {
                        System.out.println("Park " + license + " " + brand + " " + hour + " 0" + minute);
                    }
                    else
                    {
                        System.out.println("Park " + license + " " + brand + " " + hour + " " + minute);
                    }
                }
            }
            // pick-up
            else
            {
                if (minute < 10)
                {
                    System.out.println("Get " + license + " " + brand + " " + hour + " 0" + minute);
                }
                else
                {
                    System.out.println("Get " + license + " " + brand + " " + hour + " " + minute);
                }
                // checks for requested car's license in array licenseRegistry 
                boolean found = false;
                for (int i = 0; i < registryPosition; i++)
                {
                    if (licenseRegistry[i].equals(license))
                    {
                        found = true;
                    }
                }
                // car's license wasn't found, print error message to terminal
                if (!found)
                {
                    System.out.println("Apologies, " + license + " " + brand + " was not found in Roscoe's lot.");
                }
                // car's license was found
                else
                {
                    // pops through StackADT lot until the car is found
                    boolean carFound = false;
                    while (!carFound)
                    {
                        Car temp = lot.pop();
                        // if car at lot top is the requested car, assign it its pick-up hour/minute, calculate bill, exit loop
                        if (license.equals(temp.getLicense()))
                        {
                            temp.setPickUpHour(hour);
                            temp.setPickUpMinute(minute);
                            temp.calculateBill();
                            carFound = true;
                        }
                        // if car at lot top is not the requested car, pop lot and push temp onto Stack ADT alley; output information to terminal 
                        else
                        {
                            System.out.println("            Backup " + temp.getLicense() + " " + temp.getBrand());
                            alley.push(temp);
                        }
                    }
                    // while there are still cars in alley, pop and push onto lot; output car's information to terminal
                    while(!alley.isEmpty())
                    {
                        Car temp = alley.pop();
                        System.out.println("            Move " + temp.getLicense() + " " + temp.getBrand());
                        lot.push(temp);
                    }
                }
            }
        } 
        System.out.println();
        System.out.println("Roscoe's is now closed!");
    }
} 