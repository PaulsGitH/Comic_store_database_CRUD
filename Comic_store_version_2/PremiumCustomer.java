
/**
 * Premium Customer class
 * Is representative of a premium upgrade to an account.
 * Iv'e allocated Account status, access to pre-ordered items and priority shipping to be
 * included as what signifies the customer account as Premium, these are features typically found in "Premium" memberships on online stores
 * if such an option is provided.
 *
 * @author Paul Dolan
 * @version 2.0
 */
public class PremiumCustomer extends Customer
{
    // variables
    
    private String PremiumAccountStatus;
    private String AccessPreOrder;
    private String PriorityShipping;
    

    /**
     * Constructor for objects of class PostGraduate
     */

    public PremiumCustomer(String name, String customerId, String Address, String PremiumAccountStatus, String AccessPreOrder, String PriorityShipping)
    {
        super(name, customerId, Address);
        
        this.PremiumAccountStatus = PremiumAccountStatus;
        this.AccessPreOrder = AccessPreOrder;
        this.PriorityShipping = PriorityShipping;
    }

    /**
     * Getters for each Variable
     *
     * @param      No parameters
     * @return    the contents of the variable
     */
    

    public String getPremiumAccountStatus()
    {
        return PremiumAccountStatus;
    }
    
    public String getAccessPreOrder()
    {
        return AccessPreOrder;
    }
     
    public String getPriorityShipping()
    {
        return PriorityShipping;
    }
    
    /**
     * Setters for each Variable
     *
     * @param     String parameter
     * @return    Nothing
     */
    

    public void setPremiumAccountStatus(String PremiumAccountStatus)
    { 
        this.PremiumAccountStatus = PremiumAccountStatus;
    }
    
    public void setAccessPreOrder(String AccessPreOrder)
    { 
        this.AccessPreOrder = AccessPreOrder;
    }
    
    public void setPriorityShipping(String PriorityShipping)
    {
        this.PriorityShipping = PriorityShipping;
    }
    
       public double registrationFee()
    {
        return 10.00;
    }
    
    public String printmembershipCard()
    {
            return "------------------------------\n" + 
                   "|Premium Customer ID:   " + getcustomerId() + "           |\n" +
                   "|Premium Customer Name: " + getName() + "         |\n"+
                   "------------------------------\n";
    }
    
    public String toString()
    {
        return "Premium Customer Details: " + " Name: " + getName()
        + " Customer ID: " + getcustomerId()
        + " Customer Address: " + getAddress()
        + " PremiumAccountStatus: " + PremiumAccountStatus
        + " Access to Pre-orders: " + AccessPreOrder
        + " Priority Shipping: " + PriorityShipping
        +" Premium Account Fee Paid: " + registrationFee()
        + "\n";
    }
}


