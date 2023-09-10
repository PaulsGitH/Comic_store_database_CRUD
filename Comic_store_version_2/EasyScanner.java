import java.util.*;
/**
 * This is the Scanner class, incudes validation for Integers.
 *
 * @author Paul Dolan 20096590
 * @version 2.0
 */
public class EasyScanner
{
    /**
     * Scans for the input of an integer value, will crash upon input of anything other than an integer.
     * I included a validation, this stops the system from crashing upon input of a
     * character at any point in the options of any methods requiring input of an integer.
     */
    public static int nextInt()
    {
        Scanner sc = new Scanner(System.in);
        int i;
        do {
            System.out.println("Please enter number!");
            while (!sc.hasNextInt()) {
                System.out.println("That's not a number!");
                sc.next();
            }
            i = sc.nextInt();
        } while (i <= -1);
        System.out.println("You entered " + i);
        return i;
    }

    public static double nextDouble()
    {
        Scanner sc = new Scanner(System.in);
        double d = sc.nextDouble();
        return d;
    }

    public static String nextString()
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        return s;
    }

    public static char nextChar()
    {
        Scanner sc = new Scanner(System.in);
        char c = sc.next().charAt(0);
        return c;
    }
}
