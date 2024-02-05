import java.util.*;
import java.io.*;
public class DataBase {
    private Map<Integer, String> database;

    public DataBase(String names, String ids)
    {
        database = new HashMap<Integer, String>();
        setDataBase(names, ids);
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
        }
        catch(IOException i)
        {
            System.out.println("ERROR: " + i.getMessage());
        }
    }

    private boolean validId(int id)
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
}
