/**
*Reprsents the attributes of a premium account, includes options that are unavailable to regular customers 
* @author Paul Dolan 20096590
* @version 2.0
*/
public class RegularCustomer extends Customer
{
    // variables
    
    private String AccountStatus;
    private String RegularShipping;
    

    /**
     * Constructor for objects of class PostGraduate
     */

    public RegularCustomer(String name, String customerId, String Address, String AccountStatus, String RegularShipping)
    {
        super(name, customerId, Address);
        
        this.AccountStatus = AccountStatus;
        this.RegularShipping = RegularShipping;
    }

    /**
     * Getters for each Variable
     *
     * @param      No parameters
     * @return    the contents of the variable
     */
    

    public String getAccountStatus()
    {
        return AccountStatus;
    }
     
    public String getRegularShipping()
    {
        return RegularShipping;
    }
    
    /**
     * Setters for each Variable
     *
     * @param     String parameter
     * @return    Nothing
     */
    

    public void setAccountStatus(String AccountStatus)
    { 
        this.AccountStatus = AccountStatus;
    }
    
    public void setRegularShipping(String RegularShipping)
    {
        this.RegularShipping = RegularShipping;
    }
    
       public double registrationFee()
    {
        return 0.00;
    }
    
    public String printmembershipCard()
    {
            return "------------------------------\n" + 
                   "|  Customer ID:   " + getcustomerId() + "           |\n" +
                   "|  Customer Name: " + getName() + "         |\n"+
                   "------------------------------\n";
    }
    
    public String toString()
    {
        return "Customer Details: " + " Name: " + getName()
        + " Customer ID: " + getcustomerId()
        + " Address :" +getAddress()
        + " AccountStatus: " + AccountStatus
        + " Reglar Shipping: " + RegularShipping
        +" No fee required: " + registrationFee()
        + "\n";
    }
}
