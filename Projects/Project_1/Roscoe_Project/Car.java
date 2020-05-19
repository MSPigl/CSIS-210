/**
 * Creates a Car object with a license plate, brand, arrival hour, arrival minute, pick-up hour, pick-up minute, and calculates the car's parking bill
 * 
 * @author Matthew Pigliavento 
 * @version October 14, 2016
 */
public class Car
{
    // instance variables
    // stores the car's license plate
    private String license;    
    // stores the car's brand
    private String brand;     
    // stores the hour of the car's arrival
    private int arrivalHour;   
    // stores the minute of the car's arrival
    private int arrivalMinute; 
    // stores the hour of the car's pick-up
    private int pickUpHour;   
    // stores the minute of the car's pick-up
    private int pickUpMinute; 

    /**
     * Constructor for objects of class Car
     */
    public Car(String licenseIn, String brandIn, int arrivalHrIn, int arrivalMinIn, int pickUpHrIn, int pickUpMinIn)
    {
        // initialise instance variables
        license = licenseIn;
        brand = brandIn;
        arrivalHour = arrivalHrIn;
        arrivalMinute = arrivalMinIn;
        pickUpHour = pickUpHrIn;
        pickUpMinute = pickUpMinIn;
    }

    /**
     * Sets the car's license plate
     * 
     * @param licenseIn the license to set
     */
    public void setLicense(String licenseIn)
    {
        license = licenseIn;
    }

    /**
     * Gets the car's license plate
     * 
     * @return license car's license plate 
     */
    public String getLicense()
    {
        return license;
    }

    /**
     * Sets the car's brand
     * 
     * @param brandIn the brand to set
     */
    public void setBrand(String brandIn)
    {
        brand = brandIn;
    }

    /**
     * Gets the car's brand
     * 
     * @return brand the car's brand
     */
    public String getBrand()
    {
        return brand;
    }

    /**
     * Sets the car's arrival hour
     * 
     * @param arrivalHrIn the arrival hour
     */
    public void setArrivalHour(int arrivalHrIn)
    {
        arrivalHour = arrivalHrIn;
    }

    /**
     * Gets the car's arrival hour
     * 
     * @return the arrival hour
     */
    public int getArrivalHour()
    {
        return arrivalHour;
    }

    /**
     * Sets the car's arrival minute
     * 
     * @param arrivalMinIn the arrival minute
     */
    public void setArrivalMinute(int arrivalMinIn)
    {
        arrivalMinute = arrivalMinIn;
    }

    /**
     * Gets the car's arrival minute 
     * 
     * @return the arrival minute
     */
    public int getArrivalMinute()
    {
        return arrivalMinute;
    }

    /**
     * Sets the car's pick-up hour
     * 
     * @param pickUpHourIn the car's pick-up hour
     */
    public void setPickUpHour(int pickUpHourIn)
    {
        pickUpHour = pickUpHourIn;
    }

    /**
     * Gets the car's pick-up hour
     * 
     * @return pickUpHour the car's pick-up hour
     */
    public int getPickUpHour()
    {
        return pickUpHour;
    }

    /**
     * Sets the car's pick-up minute
     * 
     * @param pickUpMinuteIn the car's pick-up minute
     */
    public void setPickUpMinute(int pickUpMinuteIn)
    {
        pickUpMinute = pickUpMinuteIn;
    }

    /**
     * Gets the car's pick-up minute
     * 
     * @return pickUpMinute the car's pick-up minute
     */
    public int getPickUpMinute()
    {
        return pickUpMinute;
    }

    /**
     * Calculates the parking bill for the car, and prints information to terminal
     */
    public void calculateBill()
    {
        // variables to hold the values for arrivalHour and arrivalMinute
        int arriveHr = arrivalHour;
        int arriveMn = arrivalMinute;
        
        // variable to hold total bill
        int bill = 10;
        
        // variable to keep track of how many hours parked
        int hours = 0;       
        
        // variable to keep cout of total minutes parked
        int minutes = 0;
        
        // totals how many minutes the car was parked
        if(arriveHr != pickUpHour)
        {
            while(arriveHr != pickUpHour && arriveMn != pickUpMinute)
            {
                arriveMn++;
                if (arriveMn == 60)
                {
                    arriveHr++;
                    arriveMn = 0;
                }
                minutes++;
            }
        }
        else
        {
            minutes = pickUpMinute - arrivalMinute;
        }
        
        // totals how many hours the car was parked
        if (arrivalHour == pickUpHour)
        {
            hours = 0;
        }
        else if (arrivalHour + 1 == pickUpHour)
        {
            hours = 1;
        }
        else
        {
            hours = (pickUpHour - arrivalHour) - 1;
        }
        
        // totals the bill ($10 for first whole/partial hour, $6 for all following whole/partial hour)
        bill = bill + (hours)*6;
        
        // ouputs the car's park time and bill to terminal
        System.out.println("Car was parked for " + hours + " hour(s) " + minutes + " minutes. Bill for " + (hours + 1) + " hour(s): $10 + $" + (hours*6) + " = $" + bill);
    }
}