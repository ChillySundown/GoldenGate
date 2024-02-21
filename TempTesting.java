import java.util.concurrent.TimeUnit;
public class TempTesting
{
    public static void main(String[] args)
    {
        try
        {
            TestScanner t = new TestScanner();
            System.out.println(t.scan(960031902));
            TimeUnit.SECONDS.sleep(10);
            System.out.println(t.scan(960031902));
            System.out.println(t.scan(96003190));
            System.out.println(t.scan(960031902));
            System.out.println(t.scan(96003190));
            System.out.println(t.scan(960031902));
            System.out.println(t.validId(960031902));
            System.out.println(t.validId(96003190));
            System.out.println(t.scan(960031902));
            System.out.println(t.curOut());
            System.out.println(t.scan(960031902));
            System.out.println(t.curOut());
        }
        catch(Exception e)
        {
            System.out.println("ERROR");
        }
    }
}