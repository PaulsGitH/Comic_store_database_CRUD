
/**
 * Product class.Includes the shared attribute of all products, a product number.
 * Due to the high variance of attributes to represent a product in a online comic store, I could only include a product number
 * as a shared attribute.
 * 
 *
 * @author (Paul Dolan 20096590)
 * @version (2.0)
 */
public abstract class Product
{
   // variables
    public String productNo;

    /**
     * Constructor for objects of class Product
     */

    public Product(String productNo)
    {
        this.productNo = productNo;
    }
    
    public abstract double productPrice();
    
    /**
     * Getters for each Variable
     *
     * @param      No parameters
     * @return    the contents of the variable
     */
    public String getproductNo()
    {
        return productNo;
    }

    /**
     * Setters for each Variable
     *
     * @param     String parameter
     * @return    Nothing
     */
    

    

    public void setproductNo(String productNo)
    {
        this.productNo = productNo;
    }
    

    public String toString()
    {
        return "Product Details: " + "Product Number: " + productNo
        + "\n";
    }
}


