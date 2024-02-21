import java.time.*;
import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
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
    String date;
    ZoneId pst; 
    Instant curTime;
    ZonedDateTime time;
    LocalDate today;

    public TestScanner()
    {
        input = new Scanner(System.in);
        d = new DataBase("names.txt", "ids.txt");
        use = false;
        idUse = -1;
        checkIn = LocalTime.now();
        checkOut = LocalTime.now();
        msg = "";
        date = "";
        pst = ZoneId.of( "America/Los_Angeles" );
        today = LocalDate.now( pst );
        curTime = Instant.now();
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
                date = today.toString();
                curTime = Instant.now();
                time = curTime.atZone(pst);

                if(dur.indexOf("H") != -1)
                {
                    ret += "Longer Than An Hour";
                }
                else if(dur.indexOf("M") != -1)
                {
                    ret += dur.substring(0, dur.indexOf("M")) + ":";
                    if(dur.substring(dur.indexOf("M") + 1, dur.indexOf(".")).length() < 2)
                    {
                        ret += "0";
                    }
                    ret += dur.substring(dur.indexOf("M") + 1, dur.indexOf("."));
                }
                else
                {
                    ret += "0:";
                    if(dur.substring(0, dur.indexOf(".")).length() < 2)
                    {
                        ret += "0";
                    }
                    ret += dur.substring(0, dur.indexOf("."));
                }
                
                System.out.println(test + " " + dur + " " + ret);
                String timeT = "" + time;
                timeT = timeT.substring(timeT.indexOf("T") + 1, timeT.indexOf("."));
                msg = d.getName(id) + " checked in the hallpass at " + date + " " + timeT + " (" + ret + ")\n";
                
                try {
                    Files.write(Paths.get("log.txt"), msg.getBytes(), StandardOpenOption.APPEND);
                }catch (IOException e) {
                    System.out.println("ERROR");
                }
                return d.getName(id) + " checked in the hallpass.";
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
                String test = "" + (checkOut);
                test = test.substring(0, test.indexOf("."));
                date = today.toString();
                curTime = Instant.now();
                time = curTime.atZone(pst);
                String timeT = "" + time;
                timeT = timeT.substring(timeT.indexOf("T") + 1, timeT.indexOf("."));
                msg = d.getName(id) + " checked out the hallpass at " + date + " " + timeT + "\n";

                try {
                    Files.write(Paths.get("log.txt"), msg.getBytes(), StandardOpenOption.APPEND);
                }catch (IOException e) {
                    System.out.println("ERROR");
                }
                return d.getName(id) + " checked in the hallpass.";
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