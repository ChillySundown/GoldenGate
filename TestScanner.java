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
    private ArrayList<String[]> log;

    public TestScanner()
    {
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
        try{
            FileInputStream fis = new FileInputStream("logdata.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            log = (ArrayList<String[]>)ois.readObject();
            ois.close();
        }catch(Exception e)
        {
            System.out.println("INIT PROBLEM");
        }
        d = new DataBase(log);
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

                for(int i = 1; i < log.size(); i++)
                {
                    if(Integer.valueOf(log.get(i)[0]) == id)
                    {
                        String[] temp = log.get(i);
                        if(!(temp[2].equals("")))
                        {
                            temp[2] += "\n";
                        }
                        temp[2] += (d.getName(id) + " checked in the hallpass.");
                        temp[5] = "" + (Integer.valueOf(temp[5]) - 1);
                        if(Integer.valueOf(dur.substring(0, dur.indexOf("M"))) > 9 || dur.indexOf("H") != -1)
                        {
                            temp[4] = "" + (Integer.valueOf(temp[4]) + 1);
                        }
                        log.set(i, temp);
                    }
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

                for(int i = 1; i < log.size(); i++)
                {
                    if(Integer.valueOf(log.get(i)[0]) == id)
                    {
                        String[] temp = log.get(i);
                        if(!(temp[2].equals("")))
                        {
                            temp[2] += "\n";
                        }
                        temp[2] += (d.getName(id) + " checked out the hallpass.");
                        temp[3] = "" + (Integer.valueOf(temp[3]) + 1);
                        temp[5] = "" + (Integer.valueOf(temp[5]) + 1);
                        log.set(i, temp);
                    }
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
        String[] entry = new String[6];
        entry[0] = "" + id;
        entry[1] = fullName;
        entry[2] = "";
        entry[3] = "0";
        entry[4] = "0";
        entry[5] = "0";
        log.add(entry);
        writeData();
    }

    public void delStudent(int id)
    {
        int delIdx = -1;
        for(int i = 1; i < log.size(); i++)
        {
            if(Integer.valueOf(log.get(i)[0]) == id)
            {
                delIdx = i;
            }
        }
        if(delIdx != -1)
        {
            log.remove(delIdx);
            writeData();
        }
    }

    public void clearEvents()
    {
        for(int i = 0; i < log.size(); i++)
        {
            log.get(i)[2] = "";
        }
        writeData();
    }

    public void resetLog()
    {
        ArrayList<String[]> temp = new ArrayList<String[]>();
        temp.add(log.get(0));
        log = temp;
        writeData();
    }

    public void writeData()
    {
        try{
            FileOutputStream fos = new FileOutputStream("logdata.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(log);
            oos.close();
        }catch(Exception e)
        {
            System.out.println("PROBLEM");
        }
    }

    public ArrayList<String[]> getLog()
    {
        return log;
    }
}