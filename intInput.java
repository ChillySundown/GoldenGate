import java.util.*;
import java.io.*;
public class intInput
{
    public static void main(String[] args)
    {
        int a = getUserInt();
        System.out.println(a);
    }

    public static int getUserInt()
    {
        boolean contin = true;
        int ret = -1;
        String inp;
        Scanner input = new Scanner(System.in);

        while(contin)
        {
            try
            {
                System.out.println("Enter an id");
                inp = input.nextLine();
                ret = Integer.parseInt(inp);
                contin = false;
            }
            catch(Exception e)
            {
                System.out.println("Enter a number");
            }
        }
        input.close();
        return ret;
    }
}

