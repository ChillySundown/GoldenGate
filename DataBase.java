import java.util.*;
import java.io.*;
public class DataBase {
    private Map<Integer, String> database;

    public DataBase(String names, String ids)
    {
        database = new HashMap<Integer, String>();
        setDataBase(names, ids);
    }

    public DataBase(String[][] l)
    {
        database = new HashMap<Integer, String>();
        setDataBase(l);
    }

    private void setDataBase(String names, String ids)
    {
        try
        {
            Scanner in1 = new Scanner(new File(names));
            Scanner in2 = new Scanner(new File(ids));

            while(in1.hasNext() && in2.hasNext())
            {
                int id = in2.nextInt();
                String name = in1.nextLine();

                database.put(id, name);
            }
            in1.close();
            in2.close();
        }
        catch(IOException i)
        {
            System.out.println("ERROR: " + i.getMessage());
        }
    }

    private void setDataBase(String[][] list)
    {
        for(int i = 1; i < list.length; i++)
        {
            database.put(Integer.valueOf(Integer.valueOf(list[i][0])), list[i][1]);
        }
    }

    public boolean validId(int id)
    {
        return database.containsKey(id);
    }

    public String getName(int id)
    {
        if(validId(id))
            return database.get(id);
        else
            return "Invalid";
    }

    public void newStudent(int id, String name)
    {
        database.put(id, name);
    }

    public void remStudent(int id)
    {
        database.remove(id);
    }
}
