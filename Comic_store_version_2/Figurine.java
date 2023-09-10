/**
 * Attributes typically associated with Figurines are detailed here.
 * Not all attributes would apply to all non print merchandise sold by a online comic store,
 * In most cases sculptor is not listed unless it's a premium handmade or limited edition collectible.
 *
 * @author (Paul Dolan 20096590)
 * @version (2.0)
 */
public class Figurine extends Product
{
    // variables
    
    private String figurineName;
    private String figurineSculptor;
    private String figurineManufacturer;
    private String figurineDistributor;
    private String figurineDimensions;    
    /**
     * Constructor for objects of class Figurine
     */

    public Figurine(String productNo, String figurineName, String figurineSculptor, String figurineManufacturer, String figurineDistributor, String figurineDimensions)
    {
        super(productNo);
        
        this.figurineName = figurineName;
        this.figurineSculptor = figurineSculptor;
        this.figurineManufacturer = figurineManufacturer;
        this.figurineDistributor = figurineDistributor;
        this.figurineDimensions = figurineDimensions;
    }

    public String getfigurineName()
    {
        return figurineName;
    }
    
    public String getfigurineSculptor()
    {
        return figurineSculptor;
    }
    
    public String getfigurineManufacturer()
    {
        return figurineManufacturer;
    }
    
    public String getfigurineDistributor()
    {
        return figurineDistributor;
    }
    
    public String getfigurineDimensions()
    {
        return figurineDimensions;
    }
    
    public void setfigurineName(String figurineName)
    { 
        this.figurineName = figurineName;
    }

    public void setfigurineSculptor(String figurineSculptor)
    { 
        this.figurineSculptor = figurineSculptor;
    }
    
    public void setfigurineManufacturer(String figurineManufacturer)
    { 
        this.figurineManufacturer = figurineManufacturer;
    }
    
    public void setfigurineDistributor(String figurineDistributor)
    { 
        this.figurineDistributor = figurineDistributor;
    }
    
    public void setfigurineDimensions(String figurineDimensions)
    { 
        this.figurineDimensions = figurineDimensions;
    }
    
    public double productPrice()
    {
        return 10.00-500.00;
    }

    
    public String toString()
    {
        return "Order Details: " + " Product Number: " + getproductNo() 
        + " Figurine name: " + figurineName
        + " Sculptors name: " + figurineSculptor
        + " Figurine Manufacturer: " + figurineManufacturer
        + " Figurine Distributor: " + figurineDistributor
        +" Figurine Price: " + productPrice()
        +" Figurine Dimensions: Small, Medium or Large" + figurineDimensions
        + "\n";
    }
}

