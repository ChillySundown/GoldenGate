import java.util.Scanner;
import java.time.*;
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

        while(true)
        {
            inp = input.nextInt();
            if(use)
            {
                if(inp == idUse)
                {
                    use = false;
                    checkIn = LocalTime.now();
                    System.out.println(d.getName(inp) + " checked in the hallpass at " + checkIn + ". (" + Duration.between(checkOut, checkIn) + ")");
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
                    System.out.println(d.getName(inp) + " checked out the hallpass at " + checkOut + ".");
                }
                else
                {
                    System.out.println("Invalid Id");
                }
            }
        }
    }
}