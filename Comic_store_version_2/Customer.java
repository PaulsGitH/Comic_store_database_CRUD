
/**
 * Customer Class. Represents that attributes typically associated with documenting a customer to store in a database
 *
 * @author (Paul Dolan)
 * @version (2.0)
 */
public abstract class Customer implements iCustomer 
{
   // variables
    private String name;
    private String customerId;
    private String Address;

    /**
     * Constructor for objects of class Student
     */

    public Customer(String name, String customerId, String Address)
    {
        if(name.length() <=40)
        {
            this.name = name;
        }
        else
        {
            this.name.substring(0-40);
        }
        this.customerId = customerId;
        this.Address = Address;
    }
    
    public abstract double registrationFee();
    
    /**
     * Getters for each Variable
     *
     * @param      No parameters
     * @return    the contents of the variable
     */
    public String getName()
    { 
        return name;
    }

    public String getcustomerId()
    {
        return customerId;
    }
    
    public String getAddress()
    {
        return Address;
    }
    
    /**
     * Setters for each Variable
     *
     * @param     String parameter
     * @return    Nothing
     */
    public void setName(String name)
    { 
        if(name.length() <=40)
        {
            this.name = name;
        }
        else
        {
            this.name.substring(0-40);
        }
    }  

    public void setAddress(String Address)
    {
        this.Address = Address;
    }

    public void setcustomerId(String customerId)
    {
        this.customerId = customerId;
    }
    

    public String toString()
    {
        return "Customer Details: " + " Name: " + name
        + "Customer ID: " + customerId
        + "Customer Address: " + Address
        + "\n";
    }
}

