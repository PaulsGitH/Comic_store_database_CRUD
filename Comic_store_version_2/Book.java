
/**
 * Collects all the attributes of a Book to include in database.
 * Includes cover artist, and author. To represent the extra categories that would allow a book to differe in a database from
 * comics and graphic novels
 *
 * @author (Paul Dolan 20096590)
 * @version (2.0)
 */
public class Book extends Product
{
    // variables
    
    private String bookName;
    private String coverArtist;
    private String bookAuthor;
    private String bookPublisher;
    private String bookISBN;
        
    /**
     * Constructor for objects of class Book
     */

    public Book(String productNo, String bookName, String coverArtist, String bookAuthor, String bookPublisher, String bookISBN)
    {
        super(productNo);
        
        this.bookName = bookName;
        this.coverArtist = coverArtist;
        this.bookAuthor = bookAuthor;
        this.bookPublisher = bookPublisher;
        this.bookISBN = bookISBN;
       
    }

    public String getbookName()
    {
        return bookName;
    }
    
    public String getcoverArtist()
    {
        return coverArtist;
    }
    
    public String getbookAuthor()
    {
        return bookAuthor;
    }
    
    public String getbookPublisher()
    {
        return bookPublisher;
    }
    
    public String getbookISBN()
    {
        return bookISBN;
    }
   
    public void setbookName(String bookName)
    { 
        this.bookName = bookName;
    }

    public void setcoverArtist(String coverArtist)
    { 
        this.coverArtist = coverArtist;
    }
    
    public void setbookAuthor(String bookAuthor)
    { 
        this.bookAuthor = bookAuthor;
    }
    
    public void setbookPublisher(String bookPublisher)
    { 
        this.bookPublisher = bookPublisher;
    }
    
    public void setbookISBN(String bookISBN)
    { 
        this.bookISBN = bookISBN;
    }
    
    public double productPrice()
    {
        return 12.98;
    }
    
    public String toString()
    {
        return "Order Details: " + " Product Number: " + getproductNo() 
        + " Book name: " + bookName
        + " Cover Artist: " + coverArtist
        + " Book Author: " + bookAuthor
        + " Book Publisher: " + bookPublisher
        + " Book ISBN: " + bookISBN
        +" Book Price: " + productPrice()
        + "\n";
    }
}

