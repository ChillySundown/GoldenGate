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
            log = (String[][])ois.readObject();
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

                for(int i = 1; i < log.length; i++)
                {
                    if(Integer.valueOf(log[i][1]) == id)
                    {
                        if(!(log[i][3].equals("")))
                        {
                            log[i][3] += "\n";
                        }
                        log[i][3] += (d.getName(id) + " checked in the hallpass.");
                        log[i][6] = "" + (Integer.valueOf(log[i][6]) - 1);
                        if((dur.indexOf("M") != -1 && Integer.valueOf(dur.substring(0, dur.indexOf("M"))) > 9) || dur.indexOf("H") != -1)
                        {
                            log[i][5] = "" + (Integer.valueOf(log[i][5]) + 1);
                        }
                    }
                    writeData();
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

                for(int i = 1; i < log.length; i++)
                {
                    if(Integer.valueOf(log[i][1]) == id)
                    {
                        if(!(log[i][3].equals("")))
                        {
                            log[i][3] += "\n";
                        }
                        log[i][3] += (d.getName(id) + " checked out the hallpass.");
                        log[i][4] = "" + (Integer.valueOf(log[i][4]) + 1);
                        log[i][6] = "" + (Integer.valueOf(log[i][6]) + 1);
                    }
                }
                writeData();
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

    public void addStudent(int id, String fullName, int period)
    {
        if(!(d.validId(id)))
        {
            String[][] temp = new String[log.length + 1][7];
            boolean added = false;
            temp[0][0] = log[0][0];
            temp[0][1] = log[0][1];
            temp[0][2] = log[0][2];
            temp[0][3] = log[0][3];
            temp[0][4] = log[0][4];
            temp[0][5] = log[0][5];
            temp[0][6] = log[0][6];
            
            if(log.length == 1)
            {
                temp[1][0] = "" + period;
                temp[1][1] = "" + id;
                temp[1][2] = fullName;
                temp[1][3] = "";
                temp[1][4] = "0";
                temp[1][5] = "0";
                temp[1][6] = "0";
            }
            else
            {
                int j = 1;
                for(int i = 1; i < temp.length; i++)
                {
                    if(!added && (j == log.length || (log[j][2].compareTo(fullName) > 0 || Integer.valueOf(log[j][0]) > period)))
                    {
                        added = true;
                        temp[i][0] = "" + period;
                        temp[i][1] = "" + id;
                        temp[i][2] = fullName;
                        temp[i][3] = "";
                        temp[i][4] = "0";
                        temp[i][5] = "0";
                        temp[i][6] = "0";
                    }
                    else
                    {
                        temp[i][0] = log[j][0];
                        temp[i][1] = log[j][1];
                        temp[i][2] = log[j][2];
                        temp[i][3] = log[j][3];
                        temp[i][4] = log[j][4];
                        temp[i][5] = log[j][5];
                        temp[i][6] = log[j][6];
                        j++;
                    }
                }
            }
            d.newStudent(id, fullName);
            log = temp;
            writeData();
        }
    }

    public void delStudent(int id)
    {
        if(d.validId(id))
        {
            String[][] temp = new String[log.length - 1][7];
            temp[0][0] = log[0][0];
            temp[0][1] = log[0][1];
            temp[0][2] = log[0][2];
            temp[0][3] = log[0][3];
            temp[0][4] = log[0][4];
            temp[0][5] = log[0][5];
            temp[0][6] = log[0][6];
            int j = 1;
            for(int i = 1; i < temp.length; i++)
            {
                if(Integer.valueOf(log[j][1]) == id)
                {
                    j++;
                }
                temp[i][0] = log[j][0];
                temp[i][1] = log[j][1];
                temp[i][2] = log[j][2];
                temp[i][3] = log[j][3];
                temp[i][4] = log[j][4];
                temp[i][5] = log[j][5];
                temp[i][6] = log[j][6];
                j++;
            }
            d.remStudent(id);
            log = temp;
            writeData();
        }
    }

    public void clearEvents()
    {
        for(int i = 1; i < log.length; i++)
        {
            log[i][3] = "";
            log[i][4] = "0";
            log[i][5] = "0";
            log[i][6] = "0";
        }
        writeData();
    }

    public void resetLog()
    {
        String[][] temp = new String[1][7];
        temp[0][0] = log[0][0];
        temp[0][1] = log[0][1];
        temp[0][2] = log[0][2];
        temp[0][3] = log[0][3];
        temp[0][4] = log[0][4];
        temp[0][5] = log[0][5];
        temp[0][6] = log[0][6];
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

    public String[][] getLog()
    {
        return log;
    }
}