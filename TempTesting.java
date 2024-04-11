import java.util.*;
import java.io.*;
import java.util.concurrent.*;
public class TempTesting
{
    public static void main(String[] args)
    {
        //try
        //{
            TestScanner t = new TestScanner();
            String[][] t2 = t.getDb(); //t.getLog();
            String[][] t3 = t.getDbAlt();
            for(int r = 0; r < t2.length; r++)
            {
                for(int c = 0; c < t2[r].length; c++)
                {
                    System.out.print(t2[r][c] + " ");
                }
                System.out.println();
            }
            for(int r = 0; r < t3.length; r++)
            {
                for(int c = 0; c < t3[r].length; c++)
                {
                    System.out.print(t3[r][c] + " ");
                }
                System.out.println();
            }
        //}catch(Exception e)
        //{
        //    System.out.println("Other N");
        //}
        
        /*String[][] n = new String[1][7];
        n[0][0] = "Period";
        n[0][1] = "Id";
        n[0][2] = "Name";
        n[0][3] = "Log";
        n[0][4] = "# Usages";
        n[0][5] = "# Exceeds 10 Mins";
        n[0][6] = "# Fail Check In";

        try
        {
            FileOutputStream fos1 = new FileOutputStream("logdata.txt");
            ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
            oos1.writeObject(n);
            oos1.close();
        }catch(Exception e)
        {
            System.out.println("NOPE");
        }*/
        
        /*
        try
        {
            TestScanner t = new TestScanner();
            ArrayList<String[]> temp = t.getLog();
            for(int i = 0; i < temp.size(); i++)
            {
                for(int j = 0; j < 6; j++)
                {
                    System.out.print(temp.get(i)[j] + " ");
                }
                System.out.println();
            }
            //t.resetLog();
            //t.delStudent(123);
            //t.scan(960031902);
            //TimeUnit.SECONDS.sleep(10);
            //t.scan(960031902);
            //t.scan(960031902);
            //t = new TestScanner();
            /*t.addStudent(960031902, "Tadeh Mouradian", 3);
            t.addStudent(960011859, "Abbas Darwich", 3);
            t.addStudent(960011454, "Daniel Papazian", 3);
            t.addStudent(960011328, "Holden Wise", 3);
            t.addStudent(960028964, "Kai Cruz", 3);
            t.addStudent(960036172, "Alexander Mashhour", 3);
            t.addStudent(960011411, "Tobias Jacobsen", 3);
            t.addStudent(960011946, "Adam Timani", 3);
            t.addStudent(960029099, "Jeremiah Tinoco", 3);
            t.addStudent(960014776, "Raffi Petrosyan", 3);
            t.addStudent(123, "TEST", 3);
            t.addStudent(960012846, "Maxwell LeSane", 3);
            t.addStudent(960036277, "Aram Tsarukyan", 3);
            t.addStudent(960025157, "Ashot Hayrapetyan", 3);
            t.addStudent(960010958, "Sarah Dias", 3);
            t.addStudent(960024830, "Laressa Ottosson", 3);
            t.addStudent(960005921, "Anthony Olshansky", 3);
            t.addStudent(960031899, "Alexander Quintanilla", 3);
            t.addStudent(960040891, "Narek Nikoghosyan", 3);
            t.addStudent(960035920, "Dylan Muriano", 3);
            t.addStudent(960005592, "Bryant Johnson", 3);*/
            /*
            ArrayList<String[]> l = t.getLog();
            for(int i = 0; i < l.size(); i++)
            {
                for(int j = 0; j < l.get(i).length; j++)
                {
                    System.out.print(l.get(i)[j] + " ");
                }
                System.out.println();
            }
            /*String[] t1 = new String[6];
            t1[0] = "Id";
            t1[1] = "Names";
            t1[2] = "Log";
            t1[3] = "Number of usages";
            t1[4] = "Number of times usage exceeded 10 minutes";
            t1[5] = "Number of times check in failed";
            ArrayList<String[]> t2 = new ArrayList<String[]>();
            t2.add(t1);
            FileOutputStream fos1 = new FileOutputStream("logdata.txt");
            ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
            oos1.writeObject(t2);
            oos1.close(); */
            /*
            FileInputStream fis = new FileInputStream("logdata.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<String[]> t3 = (ArrayList<String[]>)ois.readObject();
            ois.close();
            for(int i = 0; i < t3.size(); i++)
            {
                for(int j = 0; j < t3.get(i).length; j++)
                {
                    System.out.println(t3.get(i)[j]);
                }    
            }
            String[] t4 = new String[6];
            t4[0] = "960031902";
            t4[1] = "Tadeh Mouradian";
            t4[2] = "";
            t4[3] = "0";
            t4[4] = "0";
            t4[5] = "0";
            t2.add(t4);
            fos = new FileOutputStream("logdata.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(t2);
            oos.close();
            fis = new FileInputStream("logdata.txt");
            ois = new ObjectInputStream(fis);
            t3 = (ArrayList<String[]>)ois.readObject();
            ois.close();
            for(int i = 0; i < t3.size(); i++)
            {
                for(int j = 0; j < t3.get(i).length; j++)
                {
                    System.out.println(t3.get(i)[j]);
                }
            }*/
            /*TestScanner t = new TestScanner();
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
            System.out.println(t.curOut());*//* 
        }
        catch(Exception e)
        {
            System.out.println("ERROR");
        }*/
    }
}