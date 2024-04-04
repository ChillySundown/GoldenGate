import java.time.*;
import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
public class TestScanner
{
    private DataBase d;
    private boolean use;
    private int idUse;
    private LocalTime checkIn;
    private LocalTime checkOut;
    private String msg;
    private String date;
    private ZoneId pst; 
    private Instant curTime;
    private ZonedDateTime time;
    private LocalDate today;
    private String timeT;
    private String[][] log;

    public TestScanner()
    {
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
        timeT = "";
        ObjectInputStream ois = new ObjectInputStream(new FileReader("logdata.txt"));
        Object o = ois.read();
        log = (String[][])o;
    }

    public String scan(int id)
    {
        if(use)
        {
            if(id == idUse)
            {
                use = false;
                checkIn = LocalTime.now();
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
                
                timeT += "" + time;
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
                date = today.toString();
                curTime = Instant.now();
                time = curTime.atZone(pst);
                timeT += "" + time;
                timeT = timeT.substring(timeT.indexOf("T") + 1, timeT.indexOf("."));
                msg = d.getName(id) + " checked out the hallpass at " + date + " " + timeT + "\n";

                try {
                    Files.write(Paths.get("log.txt"), msg.getBytes(), StandardOpenOption.APPEND);
                }catch (IOException e) {
                    System.out.println("ERROR");
                }
                return d.getName(id) + " checked out the hallpass.";
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

    public void addStudent(int id, String fullName)
    {
        if(names.length() == 0)
        {

        }
        else
        {

        }
    }

    public void delStudent(int id)
    {

    }

    public void clearEvents()
    {

    }

    public void resetLog()
    {
         
    }
}