import java.util.Scanner;
public class TestScanner
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        DataBase d = new DataBase("names.txt", "ids.txt");
        boolean use = false;
        int idUse = -1;
        int inp;

        while(true)
        {
            inp = input.nextInt();
            if(use)
            {
                if(inp == idUse)
                {
                    use = false;
                    System.out.println(d.getName(inp) + " checked in the hallpass.");
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
                    System.out.println(d.getName(inp) + " checked out the hallpass.");
                }
                else
                {
                    System.out.println("Invalid Id");
                }
            }
        }
    }
}