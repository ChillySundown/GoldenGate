import java.util.Scanner;
import java.time.*;
import java.io.*;
public class TestScanner
{
    Scanner input;
    DataBase d;
    boolean use;
    int idUse;
    LocalTime checkIn;
    LocalTime checkOut;
    String msg;
    boolean contin;

    public TestScanner()
    {
        input = new Scanner(System.in);
        d = new DataBase("names.txt", "ids.txt");
        use = false;
        idUse = -1;
        checkIn = LocalTime.now();
        checkOut = LocalTime.now();
        msg = "";
        contin = true;
    }

    public String scan(int id)
    {
        if(use)
        {
            if(id == idUse)
            {
                use = false;
                checkIn = LocalTime.now();
                String test = "" + (checkIn);
                test = test.substring(0, test.indexOf("."));
                String dur = "" + Duration.between(checkOut, checkIn);
                dur = dur.substring(2);
                String ret = "";
                if(dur.substring(dur.length() - 1).equalsIgnoreCase("m"))
                {
                    
                }
                else
                {
                    ret += "0:";
                }
                System.out.println(test + " " + dur);
                msg = d.getName(id) + " checked in the hallpass at " + checkIn + ". (";
                return msg;
            }
            else
            {
                return "Someone else is using the hallpass.";
            }
        }
        else
        {
            if(d.validId(id))
            {   
                use = true;
                idUse = id;
                checkOut = LocalTime.now();
                msg = d.getName(id) + " checked out the hallpass at " + checkOut;
                return msg;
            }
            else
            {
                return "Invalid Id";
            }
        }
    }
    public String curOut()
    {
        if(use)
        {
            return d.getName(idUse);
        }
        else
        {
            return "";
        }
    }

    public boolean validId(int id)
    {
        return d.validId(id);
    }
}