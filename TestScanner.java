import java.util.Scanner;
import java.time.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
public class TestScanner
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        DataBase d = new DataBase("names.txt", "ids.txt");
        boolean use = false;
        int idUse = -1;
        int inp;
        LocalTime checkIn = LocalTime.now();
        LocalTime checkOut = LocalTime.now();
        String msg = "";
        boolean contin = true;
        try
        {
            while(contin)
            {
                inp = input.nextInt();
                if(inp == -1)
                {
                    contin = false;
                }
                else if(use)
                {
                    if(inp == idUse)
                    {
                        use = false;
                        checkIn = LocalTime.now();
                        msg = d.getName(inp) + " checked in the hallpass at " + checkIn + ". (" + Duration.between(checkOut, checkIn) + ")\n";
                        Files.write(Paths.get("log.txt"), msg.getBytes(), StandardOpenOption.APPEND);
                    }
                    else
                    {
                        System.out.println("Someone else is using the hallpass.");
                    }
                }
                else
                {
                    if(d.validId(inp))
                    {   
                        use = true;
                        idUse = inp;
                        checkOut = LocalTime.now();
                        msg = d.getName(inp) + " checked out the hallpass at " + checkOut + ".\n";
                        Files.write(Paths.get("log.txt"), msg.getBytes(), StandardOpenOption.APPEND);
                    }
                    else
                    {
                        System.out.println("Invalid Id");
                    }
                }
            }
        }
        catch(IOException e)
        {
            System.out.println("ERROR");
        }
        System.out.println("END");
        input.close();
    }
}