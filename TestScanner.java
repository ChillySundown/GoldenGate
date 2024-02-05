import java.util.Scanner;
public class TestScanner
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        DataBase d = new DataBase("names.txt", "ids.txt");
        int a = input.nextInt();
        System.out.println(d.getName(a));
        System.out.println(d.getName(0));
    }
}