/**
 * Attributes typically associated with Graphic novels are detailed in this class.
 * Tends to be from 180-1200 pages long depending on the type, making it differ from comic books
 * Is always listed as a seperate category on websites that offers comics, graphic novels and books
 *
 * @author (Paul Dolan 20096590)
 * @version (2.0)
 */
public class GraphicNovel extends Product
{
    // variables
    
    private String graphicnovelName;
    private String graphicnovelArtist;
    private String graphicnovelWriter;
    private String graphicnovelPublisher;
    private String graphicnovelISBN;
        
    /**
     * Constructor for objects of class Graphic Novels
     */

    public GraphicNovel(String productNo, String graphicnovelName, String graphicnovelArtist, String graphicnovelWriter, String graphicnovelPublisher, String ISBN)
    {
        super(productNo);
        
        this.graphicnovelName = graphicnovelName;
        this.graphicnovelArtist = graphicnovelArtist;
        this.graphicnovelWriter = graphicnovelWriter;
        this.graphicnovelPublisher = graphicnovelPublisher;
        this.graphicnovelISBN = graphicnovelISBN;
        
       
    }

    public String getgraphicnovelName()
    {
        return graphicnovelName;
    }
    
    public String getgraphicnovelArtist()
    {
        return graphicnovelArtist;
    }
    
    public String getgrahicnovelWriter()
    {
        return graphicnovelWriter;
    }
    
    public String getgraphicnovelPublisher()
    {
        return graphicnovelPublisher;
    }
    
    public String getgraphicISBN()
    {
        return graphicnovelISBN;
    }
    
    public void setgraphicnovelName(String graphicnovelName)
    { 
        this.graphicnovelName = graphicnovelName;
    }

    public void setgraphicnovelArtist(String graphicnovelArtist)
    { 
        this.graphicnovelArtist = graphicnovelArtist;
    }
    
    public void setgraphicnovelWriter(String graphicnovelWriter)
    { 
        this.graphicnovelWriter = graphicnovelWriter;
    }
    
    public void setgraphicnovelPublisher(String graphicnovelPublisher)
    { 
        this.graphicnovelPublisher = graphicnovelPublisher;
    }
    
    public void setgraphicnovelISBN(String graphicnovelISBN)
    { 
        this.graphicnovelISBN = graphicnovelISBN;
    }
    
    
    public double productPrice()
    {
        return 25.99;
    }

    
    public String toString()
    {
        return "Order Details: " + " Product Number: " + getproductNo() 
        + " Graphic Novel name: " + graphicnovelName
        + " Graphic Novel Artist: " + graphicnovelArtist
        + " Graphic Novel Writer: " + graphicnovelWriter
        + " Graphic Novel Publisher: " + graphicnovelPublisher
        + " graphic Novel ISBN: " + graphicnovelISBN
        +" Graphic Novel Price: " + productPrice()
        + "\n";
    }
}
