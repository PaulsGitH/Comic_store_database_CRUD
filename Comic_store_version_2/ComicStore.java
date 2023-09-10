import java.util.ArrayList;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import com.thoughtworks.xstream.security.AnyTypePermission;
/**
 * Comic Store Class is resposible for storing all information related to both Customers and all product types
 *
 * @author Paul Dolan 20096590
 * @version 2.0
 */
public class ComicStore
{
    //Declares and build an ArrayList of type customerList and one for productList
    private ArrayList<Customer> customerList= new ArrayList<Customer>();
    private ArrayList<Product> productList= new ArrayList<Product>();
    /**
     * Constructor - no parameters
     */
    public ComicStore()
    {

    }

    //3. Methods
    /**
     * All Methods listed here are for storing,deleting and or listing the customers stored in the database
     */
    public void addCustomer(Customer c)
    {
        customerList.add(c);
    }

    public void removeCustomer(int index)
    {
        customerList.remove(index);
    }

    public int numberOfCustomers()
    {
        return customerList.size();
    }

    public Customer getCustomer(int index)
    {
        return customerList.get(index);
    }

    public String listOfCustomers() 
    {
        String list = "";
        int i = 0;
        for(Customer c : customerList) 
        {
            list += i + ":" + c + "\n";
            i++;
        }
        return list;
    }
    
    public ArrayList<Customer> getCustomerList(){
        return customerList;
    }    
    
    public String searchCustomerbyname(String nameIn)
    {
        String searchResults="";
        for(Customer c: customerList)
        {
            if(c.getName().equals(nameIn))
            {
                searchResults = searchResults + c.toString() + "\n";
            }        }
        return searchResults;
    }

    /**
     * All Methods listed here are for storing,deleting and or listing the products stored in the database
     */
    public void addProduct(Product p)
    {
        productList.add(p);
    }

    public void removeProduct(int index)
    {
        productList.remove(index);
    }

    public int numberOfProducts()
    {
        return productList.size();
    }

    public Product getProduct(int index)
    {
        return productList.get(index);
    }

    public String listOfProducts() 
    {
        String list = "";
        int i = 0;
        for(Product p : productList) 
        {
            list += i + ":" + p + "\n";
            i++;
        }
        return list;
    }

    public String searchProductbyproductNo(String productNo)
    {
        String searchResults="";
        for(Product p: productList)
        {
            if(p.getproductNo().equals(productNo))
            {
                searchResults = searchResults + p.toString() + "\n";
            }        }
        return searchResults;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    /**
     * Saves all entered information detailing customers and products on an xml file, so they can later be reloaded
     */
    public void save() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("Comicstore.xml"));
        out.writeObject(customerList);
        out.writeObject(productList);
        out.close();    
    }

    /**
    * Loads all entered information detailing customers and products on an xml file that was previously saved
    */
    @SuppressWarnings("unchecked")
    public void load() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        xstream.addPermission(AnyTypePermission.ANY);
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("Comicstore.xml"));
        customerList = (ArrayList<Customer>) is.readObject();
        productList = (ArrayList<Product>) is.readObject();
        is.close();
    }

}