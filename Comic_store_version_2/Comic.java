
/**
 * Code for comic class detailed here. Collects the information needed to store a comic book into a database
 *
 * @author (Paul Dolan 20096590)
 * @version (2.0)
 */
public class Comic extends Product
{
    // variables
    
    private String comicName;
    private String comicArtist;
    private String comicWriter;
    private String comicPublisher;
    private String comicISBN;
        
    /**
     * Constructor for objects of class Comic
     */

    public Comic(String productNo, String comicName, String comicArtist, String comicWriter, String comicPublisher, String comicISBN)
    {
        super(productNo);
        
        this.comicName = comicName;
        this.comicArtist = comicArtist;
        this.comicWriter = comicWriter;
        this.comicPublisher = comicPublisher;
        this.comicISBN = comicISBN;
       
    }

    public String getcomicName()
    {
        return comicName;
    }
    
    public String getcomicArtist()
    {
        return comicArtist;
    }
    
    public String getcomicWriter()
    {
        return comicWriter;
    }
    
    public String getcomicPublisher()
    {
        return comicPublisher;
    }
    
    public String getcomicISBN()
    {
        return comicISBN;
    }
    
    public void setcomicName(String comicName)
    { 
        this.comicName = comicName;
    }

    public void setcomicArtist(String comicArtist)
    { 
        this.comicArtist = comicArtist;
    }
    
    public void setcomicWriter(String comicWriter)
    { 
        this.comicWriter = comicWriter;
    }
    
    public void setcomicPublisher(String comicPublisher)
    { 
        this.comicPublisher = comicPublisher;
    }
    
    public void setcomicISBN(String comicISBN)
    { 
        this.comicISBN = comicISBN;
    }
    
    
    public double productPrice()
    {
        return 5.00;
    }

    
    public String toString()
    {
        return "Order Details: " + " Product Number: " + getproductNo() 
        + " Comic name: " + comicName
        + " Comic Artist: " + comicArtist
        + " Comic Writer: " + comicWriter
        + " Comic Publisher: " + comicPublisher
        + " Comic ISBN: " + comicISBN
        +" Comic Price: " + productPrice()
        + "\n";
    }
}

