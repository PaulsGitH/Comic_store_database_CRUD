import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
/**
 * This is the ComicStoreUI System class, containing the main() method and will be the front end user interface,
 * Includes everything that is required to input information regarding any product or customer, to represent said attributes of both.
 * 
 * Has an easy to understand interface, with various validators to ensure both information is entered correctly, and does not crash upon entering an invalid option.
 * 
 * Has sub classes of the customer class, to allow for two types of Customers, Regular and Premium
 * 
 * Has Five sub classes of the product class, to allow for the different types of products that are generally sold within a comic store.
 * 
 *
 *
 * @author Paul Dolan 20096590
 * @version 2.0
 */
public class ComicStoreUI
{
    //Create an object ComicShop from the ComicStore Class
    private ComicStore comicWD = new ComicStore(); 

    public ComicStoreUI()
    {
    }

    public static void main(String[] args)
    {
        ComicStoreUI cs1 = new ComicStoreUI();
        cs1.run();

    }

    /**
     * mainMenu() - This method displays the menu for the application,
     * reads the menu option that the user entered and returns it.
     *
     * @return     the users menu choice
     */
    public int mainMenu()
    {

        System.out.println("\n Comic Store Menu");
        System.out.println("\n ______________________");
        System.out.println("   1. Load all stored Product and Customer information");
        System.out.println("\n  ______________________");
        System.out.println("\n Customer menu");
        System.out.println("\n \t______________________");
        System.out.println("\t   2. Add a Customer ");
        System.out.println("\t   3. List all Customers ");
        System.out.println("\t   4. Number of Customers ");
        System.out.println("\t   5. Search for a Customer ");
        System.out.println("\t   6. Remove a Customer ");
        System.out.println("\t   7. Update Customer information ");
        System.out.println("\t   8. Create membership card ");
        System.out.println();
        System.out.println("\n Product menu");
        System.out.println("\n \t______________________");
        System.out.println("\t   9. Add a Product ");
        System.out.println("\t   10. List all Products ");
        System.out.println("\t   11. Number of Products ");
        System.out.println("\t   12. Search for a Product ");
        System.out.println("\t   13. Remove a Product ");
        System.out.println("\t   14. Update product information ");
        System.out.println("\n ______________________");
        System.out.println("\n 3 extra menu options not related to anything thought in class");
        System.out.println("\t 15. Display Time and Date");
        System.out.println("\t 16. Calculator");
        System.out.println("\t 17. Ring collect SF");
        System.out.println("\t Please save before exiting");
        System.out.println("\n ______________________");
        System.out.println("   18. Save all product and customer information");
        System.out.println("   0. Quit");
        System.out.println();
        System.out.print("Enter choice [0-18]: ");

        // get choice
        int choice = EasyScanner.nextInt();
        System.out.println("\n ______________________");
        return choice;

    }

    /**
     * run() - This method displays the menu and processes the user's menu
     * choice.  Option ‘0’ exits the program.
     */

    public void run()
    {

        int option = mainMenu();
        while(option !=0)
        {
            switch (option)
            {
                case 1:
                    try{

                        comicWD.load();
                    }
                    catch (Exception e)
                    { 
                        System.out.println("Error reading from file: " + e);
                    }
                    break;
                case 2: 
                    createCustomer();
                    break;
                case 3:
                    System.out.println(comicWD.listOfCustomers());
                    break;
                case 4:
                    System.out.println(comicWD.numberOfCustomers()); 
                    break;
                case 5:
                    listOfCustomersByName();
                    break;
                case 6:
                    deleteCustomer(); 
                    break;
                case 7:
                    updateCustomer();
                    break;
                case 8:
                    printmembershipCard();
                    break;    
                case 9: 
                    createProduct();
                    break;
                case 10:
                    System.out.println(comicWD.listOfProducts());
                    break;
                case 11:
                    System.out.println(comicWD.numberOfProducts()); 
                    break;
                case 12:
                    listOfProductsByProductNumber();
                    break;
                case 13:
                    deleteProduct(); 
                    break;
                case 14:
                    updateProduct();
                    break;
                case 15:
                    displayTime();
                    break;
                case 16:
                    calculator();
                    break;
                case 17:
                    playMp3();
                    break;
                case 18:
                    try{

                        comicWD.save();

                    }
                    catch (Exception e){
                        System.out.println("Error writing to file: " + e);
                    }
                default : 
                    System.out.println("Invalid option selected");
            }
            System.out.println();
            option = mainMenu();
        }
    } 

    /**
     * Create customer method, asks for account type to be allocated to an individual customer account
     * using one of the two options given for regular or premium. 
     */
    private void createCustomer()
    {
        int choice;
        System.out.println("\n ______________________");
        System.out.println("What kind of Customer do you want to add?.");
        System.out.println("\t 1. Regular Customer Account");
        System.out.println("\t 2. Premium Customer Account");
        System.out.println();
        System.out.println("Enter choice [1- 2]: ");
        choice = EasyScanner.nextInt();

        // get details from user
        System.out.println("Enter the new Customer details.");
        System.out.println("Enter Customer name: ");
        String name = EasyScanner.nextString();
        System.out.println("Enter Customer Account No: ");
        String customerId = EasyScanner.nextString();
        System.out.println("Enter Customer Address: ");
        String Address = EasyScanner.nextString();

        if(choice == 1)
        {

            String AccountStatus;
            String RegularShipping;
            System.out.println("Enter Account Status: Free Tier ");
            AccountStatus = EasyScanner.nextString();
            System.out.println("Enter Regular Shipping: ");
            RegularShipping = EasyScanner.nextString();
            System.out.println("\n ______________________");
            RegularCustomer c1 = new RegularCustomer(name, customerId, Address, AccountStatus, RegularShipping);

            comicWD.addCustomer(c1);

        }

        else if (choice == 2)
        {

            String PremiumAccountStatus;
            String AccessPreOrder;
            String PriorityShipping;
            System.out.println("Enter Account status Premium Tier: ");
            PremiumAccountStatus = EasyScanner.nextString();
            System.out.println("Enter pre-order Access: ");
            AccessPreOrder = EasyScanner.nextString();
            System.out.println("Enter Priority Shipping: ");
            PriorityShipping = EasyScanner.nextString();
            System.out.println("\n ______________________");
            PremiumCustomer p1 = new PremiumCustomer(name, customerId, Address, PremiumAccountStatus, AccessPreOrder, PriorityShipping);

            comicWD.addCustomer(p1);

        }

    }
    
    /**
     * Updates customer depending on index chosen, if index chosen is a regular customer,
     * asks for both customer class attributes and the attributes exclusive to regular customer
     */
    private void updateCustomer() {
        System.out.println("Waterford Comic Store list of Customers:  " + "\n" + comicWD.listOfCustomers());
        System.out.print("Enter the index of the customer to update: ");
        int index = EasyScanner.nextInt();
        ArrayList<Customer> customerList = comicWD.getCustomerList();

        if (index < 0 || index >= customerList.size()) {
            System.out.println("Invalid index.");
            return;
        }

        Customer selectedCustomer = customerList.get(index);

        System.out.println("Enter the new Customer details.");

        if (selectedCustomer instanceof RegularCustomer) {
            RegularCustomer selectedRegularCustomer = (RegularCustomer) selectedCustomer;

            System.out.print("Enter Customer name: ");
            String customerName = EasyScanner.nextString();
            selectedRegularCustomer.setName(customerName);

            System.out.print("Enter Customer Account No: ");
            String customerId = EasyScanner.nextString();
            selectedRegularCustomer.setcustomerId(customerId);

            System.out.print("Enter Customer Address: ");
            String customerAddress = EasyScanner.nextString();
            selectedRegularCustomer.setAddress(customerAddress);

            System.out.print("Enter Account Status: Free Tier ");
            String accountStatus = EasyScanner.nextString();
            selectedRegularCustomer.setAccountStatus(accountStatus);

            System.out.print("Enter Regular Shipping: ");
            String regularShipping = EasyScanner.nextString();
            selectedRegularCustomer.setRegularShipping(regularShipping);
        }
        else if (selectedCustomer instanceof PremiumCustomer) {
            PremiumCustomer selectedPremiumCustomer = (PremiumCustomer) selectedCustomer;

            System.out.print("Enter Customer name: ");
            String customerName = EasyScanner.nextString();
            selectedPremiumCustomer.setName(customerName);

            System.out.print("Enter Customer Account No: ");
            String customerId = EasyScanner.nextString();
            selectedPremiumCustomer.setcustomerId(customerId);

            System.out.print("Enter Customer Address: ");
            String customerAddress = EasyScanner.nextString();
            selectedPremiumCustomer.setAddress(customerAddress);

            System.out.print("Enter Account status Premium Tier: ");
            String premiumAccountStatus = EasyScanner.nextString();
            selectedPremiumCustomer.setPremiumAccountStatus(premiumAccountStatus);

            System.out.print("Enter pre-order Access: ");
            String accessPreOrder = EasyScanner.nextString();
            selectedPremiumCustomer.setAccessPreOrder(accessPreOrder);

            System.out.print("Enter Priority Shipping: ");
            String priorityShipping = EasyScanner.nextString();
            selectedPremiumCustomer.setPriorityShipping(priorityShipping);
        }
    }

    /**
     * Delete a customer, assuming one exists, according to the order in which a customer was enetered into the system
     */
    private void deleteCustomer()
    {
        // list of Customers
        System.out.println("Waterford Comic Store list of Customers:  " + "\n" +  
            comicWD.listOfCustomers());
        if(comicWD.numberOfCustomers() !=0)
        {
            //only process the delete if the medical professionals exist in the ArrayList

            System.out.print("Enter the Index of the Customer you wish to delete: ");
            int index = EasyScanner.nextInt();
            // delete item if it exists

            if(index < comicWD.numberOfCustomers())
            {
                comicWD.removeCustomer(index);
                System.out.println("Customer Removed");
            }
            else
            {
                System.out.println("There is no Customer for this index number");
            }
        }
        else
        {
            System.out.println("There are no Customers in the System");
        }

    }

    /**
     * Lists customers in the system by entering the name of the customer
     */
    public void listOfCustomersByName()
    {

        System.out.println("Enter Customers Name: ");
        String name = EasyScanner.nextString();
        System.out.println(comicWD.searchCustomerbyname(name));

    }

    /**
     * A method to play a sound file, originally meant to play a music track in the background, menu is unusable for the duration of the track
     * Scaled it back to a soundeffect
     */
    public static void playMp3() {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File("C:\\Users\\Paul WIT account\\OneDrive - Waterford Institute of Technology\\Desktop\\assignment 2 programming\\Comic Book store version 2\\mp3\\collect-ring-15982.wav")));
            clip.start();
            Thread.sleep(clip.getMicrosecondLength() / 1000);
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Create a product for the database by asking for details of each attribute of the product
     * Allows for the differences in terminology used in Book vs comic books and graphic novels
     * also includes attributes that are completely different as represented by the figuring class, would include anthing from plushes to large statues
     */
    private void createProduct()
    {
        int choice;
        System.out.println("\n ______________________");
        System.out.println("What kind of Product do you want to add?.");
        System.out.println("\t 1. Comic");
        System.out.println("\t 2. Book");
        System.out.println("\t 3. Figurine");
        System.out.println("\t 4. Graphic Novel");
        System.out.println();
        System.out.print("Enter choice [1- 4]: ");
        choice = EasyScanner.nextInt();

        // get details from user
        System.out.println("Enter the new Product details.");
        System.out.println("Enter Product Number: ");
        String productNo = EasyScanner.nextString();

        if(choice == 1)
        {

            String comicName;
            String comicArtist;
            String comicWriter;
            String comicPublisher;
            String comicISBN;
            System.out.println("Enter Comic name ");
            comicName = EasyScanner.nextString();
            System.out.println("Enter Artist: ");
            comicArtist = EasyScanner.nextString();
            System.out.println("Enter Writer ");
            comicWriter = EasyScanner.nextString();
            System.out.println("Enter Publisher ");
            comicPublisher = EasyScanner.nextString();
            System.out.println("Enter ISBN ");
            comicISBN = EasyScanner.nextString();
            System.out.println("\n ______________________");
            Comic prod1 = new Comic(productNo ,comicName, comicArtist, comicWriter, comicPublisher, comicISBN);

            comicWD.addProduct(prod1);

        }

        else if (choice == 2)
        {

            String bookName;
            String coverArtist;
            String bookAuthor;
            String bookPublisher;
            String bookISBN;
            System.out.print("Enter Book name ");
            bookName = EasyScanner.nextString();
            System.out.println("Enter Cover Artist: ");
            coverArtist = EasyScanner.nextString();
            System.out.println("Enter Author ");
            bookAuthor = EasyScanner.nextString();
            System.out.println("Enter Publisher ");
            bookPublisher = EasyScanner.nextString();
            System.out.println("Enter ISBN ");
            bookISBN = EasyScanner.nextString();
            System.out.println("\n ______________________");
            Book prod2 = new Book(productNo ,bookName, coverArtist, bookAuthor, bookPublisher, bookISBN);

            comicWD.addProduct(prod2);
        }

        else if (choice == 3)
        {

            String figurineName;
            String figurineSculptor;
            String figurineManufacturer;
            String figurineDistributor;
            String figurineDimensions;
            System.out.println("Enter Figurine name ");
            figurineName = EasyScanner.nextString();
            System.out.println("Enter Sculptor: ");
            figurineSculptor = EasyScanner.nextString();
            System.out.println("Enter Manufacturer ");
            figurineManufacturer = EasyScanner.nextString();
            System.out.println("Enter Distributor ");
            figurineDistributor = EasyScanner.nextString();
            System.out.println("Enter Dimensions: Small, Medium or Large");
            figurineDimensions = EasyScanner.nextString();
            System.out.println("\n ______________________");
            Figurine prod3 = new Figurine(productNo ,figurineName, figurineSculptor, figurineManufacturer, figurineDistributor, figurineDimensions);

            comicWD.addProduct(prod3);
        }

        else if (choice == 4)
        {

            String graphicnovelName;
            String graphicnovelArtist;
            String graphicnovelWriter;
            String graphicnovelPublisher;
            String graphicnovelISBN;
            System.out.println("Enter Graphic Novel name ");
            graphicnovelName = EasyScanner.nextString();
            System.out.println("Enter Artist: ");
            graphicnovelArtist = EasyScanner.nextString();
            System.out.println("Enter Writer ");
            graphicnovelWriter = EasyScanner.nextString();
            System.out.println("Enter Publisher ");
            graphicnovelPublisher = EasyScanner.nextString();
            System.out.println("Enter ISBN ");
            graphicnovelISBN = EasyScanner.nextString();
            System.out.println("\n ______________________");
            GraphicNovel prod4 = new GraphicNovel(productNo ,graphicnovelName, graphicnovelArtist, graphicnovelWriter, graphicnovelPublisher, graphicnovelISBN);

            comicWD.addProduct(prod4);

        }

    }

    /**
     * Deletes a product stored in the database, according to the order in which the products were detailed
     */
    private void deleteProduct()
    {
        // list of Customers
        System.out.println("Waterford Comic Store list of Products:  " + "\n" +  
            comicWD.listOfProducts());
        if(comicWD.numberOfProducts() !=0)
        {
            //only process the delete if the prodcuts exist in the ArrayList

            System.out.print("Enter the Index of the Product you wish to delete: ");
            int index = EasyScanner.nextInt();
            // delete item if it exists

            if(index < comicWD.numberOfProducts())
            {
                comicWD.removeProduct(index);
                System.out.println("Product Removed");
            }
            else
            {
                System.out.println("There is no Product for this index number");
            }
        }
        else
        {
            System.out.println("There are no Products in the System");
        }

    }
    
    /**
     * Updates any product type according to the product type of the index selected, example:If figurine is chosen from index,
     * figurine attributes will be asked for, alongside product number
     */
    private void updateProduct(int index) {
        if (index < 0 || index >= comicWD.getProductList().size()) {
            System.out.println("Invalid index, please try again.");
            return;
        }
        // get product details
        Product product = comicWD.getProductList().get(index);
        //System.out.println("Enter the new product details.");
        System.out.println("Enter product number: ");
        String productNo = EasyScanner.nextString();

        if (product instanceof Comic) {
            Comic comic = (Comic) product;
            System.out.println("Enter comic name: ");
            String name = EasyScanner.nextString();
            System.out.println("Enter artist: ");
            String artist = EasyScanner.nextString();
            System.out.println("Enter writer: ");
            String writer = EasyScanner.nextString();
            System.out.println("Enter publisher: ");
            String publisher = EasyScanner.nextString();
            System.out.println("Enter ISBN: ");
            String isbn = EasyScanner.nextString();

            comic.setproductNo(productNo);
            comic.setcomicName(name);
            comic.setcomicArtist(artist);
            comic.setcomicWriter(writer);
            comic.setcomicPublisher(publisher);
            comic.setcomicISBN(isbn);
        } 

        else if (product instanceof Book) {
            Book book = (Book) product;
            System.out.println("Enter book name: ");
            String name = EasyScanner.nextString();
            System.out.println("Enter cover artist: ");
            String artist = EasyScanner.nextString();
            System.out.println("Enter author: ");
            String author = EasyScanner.nextString();
            System.out.println("Enter publisher: ");
            String publisher = EasyScanner.nextString();
            System.out.println("Enter ISBN: ");
            String isbn = EasyScanner.nextString();

            book.setproductNo(productNo);
            book.setbookName(name);
            book.setcoverArtist(artist);
            book.setbookAuthor(author);
            book.setbookPublisher(publisher);
            book.setbookISBN(isbn);
        } 

        else if (product instanceof Figurine) {
            Figurine figurine = (Figurine) product;
            System.out.println("Enter figurine name: ");
            String name = EasyScanner.nextString();
            System.out.println("Enter sculptor: ");
            String sculptor = EasyScanner.nextString();
            System.out.println("Enter manufacturer: ");
            String manufacturer = EasyScanner.nextString();
            System.out.println("Enter distributor: ");
            String distributor = EasyScanner.nextString();
            System.out.println("Enter dimensions: ");
            String dimensions = EasyScanner.nextString();

            figurine.setproductNo(productNo);
            figurine.setfigurineName(name);
            figurine.setfigurineSculptor(sculptor);
            figurine.setfigurineManufacturer(manufacturer);
            figurine.setfigurineDistributor(distributor);
            figurine.setfigurineDimensions(dimensions);
        } 

        else if (product instanceof GraphicNovel) {
            GraphicNovel graphicNovel = (GraphicNovel) product;
            System.out.println("Enter graphic novel name: ");
            String name = EasyScanner.nextString();
            System.out.println("Enter artist: ");
            String artist = EasyScanner.nextString();
            System.out.println("Enter writer: ");
            String writer = EasyScanner.nextString();
            System.out.println("Enter publisher: ");
            String publisher = EasyScanner.nextString();
            System.out.println("Enter ISBN: ");
            String isbn = EasyScanner.nextString();

            graphicNovel.setproductNo(productNo);
            graphicNovel.setgraphicnovelName(name);
            graphicNovel.setgraphicnovelArtist(artist);
            graphicNovel.setgraphicnovelWriter(writer);
            graphicNovel.setgraphicnovelPublisher(publisher);
            graphicNovel.setgraphicnovelISBN(isbn);
        } 

        else {
            System.out.println("Invalid product type.");
            return;
        }

        System.out.println("Product updated successfully.");
    }
    /**
     * Allows update product(int index) to work,by declaring an updateProduct method
     */
    public void updateProduct() {
        System.out.println(comicWD.listOfProducts());
        System.out.println("Enter the index of the product to update: ");
        int index = EasyScanner.nextInt();

        updateProduct(index);
    }

    /**
     * Is part of the interface class, allows the shared attributes of both customer classes to be displayed as a "Membership" card
     */
    public void printmembershipCard()
    {
        System.out.println(comicWD.listOfCustomers());
        System.out.println("Enter Customers's Index ===> ");
        int index = EasyScanner.nextInt();
        String id = comicWD.getCustomer(index).printmembershipCard();
        System.out.println(id);
    }

    /**
     * Displays time and date, as indicated on the operating system.
     */
    public void displayTime() {
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("Current time: " + currentTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    /**
     * Basic calculator, adds, subtracts, divides and multiplies 2 seperate numerical inputs
     */
    public void calculator() {
        double num1, num2, result;
        char operator;

        System.out.print("Enter first number: ");
        num1 = EasyScanner.nextDouble();

        System.out.print("Enter operator (+, -, *, /): ");
        operator = EasyScanner.nextChar();

        System.out.print("Enter second number: ");
        num2 = EasyScanner.nextDouble();

        switch(operator) {
            case '+':
                result = num1 + num2;
                System.out.println(num1 + " + " + num2 + " = " + result);
                break;
            case '-':
                result = num1 - num2;
                System.out.println(num1 + " - " + num2 + " = " + result);
                break;
            case '*':
                result = num1 * num2;
                System.out.println(num1 + " * " + num2 + " = " + result);
                break;
            case '/':
                if(num2 == 0) {
                    System.out.println("Error: Division by zero");
                } else {
                    result = num1 / num2;
                    System.out.println(num1 + " / " + num2 + " = " + result);
                }
                break;
            default:
                System.out.println("Error: Invalid operator");
        }
    }

    /**
     * allows searching of products that are stored, searched by their only shared attribute, in this case being a product number
     * as different terminology is used for each type of product
     * Comics always lists the writer, whereas Books utilise author. Different terminology required different attributes for the same thing
     */
    public void listOfProductsByProductNumber()
    {

        System.out.println("Enter Product Number: ");
        String productNo = EasyScanner.nextString();
        System.out.println(comicWD.searchProductbyproductNo(productNo));

    }
}