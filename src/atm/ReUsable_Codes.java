package atm;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public abstract class ReUsable_Codes 
{
    static final String MyPath="D:\\Applications\\Projects&Practices\\Projects\\JavaProjects\\";
    static JFrame jf=new JFrame();
    static String Account_Number="1548451103";
    static String Salutation="Miss";
    static String FN="Upasana";
    static String LN="Valendra";
    
    protected void nullify()
    {
        Account_Number=null;
        FN=null;
        LN=null;
        Salutation=null;
    }
    protected String acc_No_hider(String Account_no)
    {   
           String temp=Account_no;
        char tarr[]=temp.toCharArray();
        for (int i = 0; i <7; i++) 
        {
            tarr[i]='X';
        }
        
        String temp2= new String(tarr);
        return temp2;
    }

    
    protected int[] VM_Date_Time()
    {
        Calendar cal=new GregorianCalendar();
        int Date_Time[]= new int[6];
        Date_Time[0]=cal.get(Calendar.DAY_OF_MONTH);
        Date_Time[1]=(cal.get(Calendar.MONTH))+1;
        Date_Time[2]=cal.get(Calendar.YEAR);
        Date_Time[3]=cal.get(Calendar.HOUR);
        Date_Time[4]=cal.get(Calendar.MINUTE);
        Date_Time[5]=cal.get(Calendar.SECOND);
        return Date_Time;
    }
    
    protected boolean Acc_if_Exists(String ACCNUM)
    {
        boolean res=true;
        String Host="jdbc:sqlserver://localhost\\VAIBHAV:1433;databaseName=StateBank";
                String UserN="xxxx";
                String UserP="xxxxx";
                try {
                    
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    Connection conn= DriverManager.getConnection(Host,UserN,UserP);
                    Statement smt=conn.createStatement();
                    ResultSet rs= smt.executeQuery("select * from Customers_account_details where account_no="+ACCNUM);
                    if (rs.next()) 
                    {
                       res=true;
                    }
                    else
                    {
                       res=false;
                    }
                    
                }catch(Exception e){ 
                    e.printStackTrace();
                }
        
        
        return res;
    }
    
    
    protected String get_custumer_details(int colum_no,String ACC_NUM)
    {
        String Custdetails[]=new String[21];
        String Host="jdbc:sqlserver://localhost\\VAIBHAV:1433;databaseName=StateBank";
                String UserN="xxx";
                String UserP="xxxxx";
                String temp=null;
                try {
                    
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    Connection conn= DriverManager.getConnection(Host,UserN,UserP);
                    PreparedStatement p=conn.prepareStatement("Select * from Customers_account_details where account_no=?");
                    p.setString(1,ACC_NUM);
                    
                    ResultSet rs= p.executeQuery();
                    if(rs.next())
                    { 
                    Custdetails[0]=String.valueOf(rs.getInt("account_no"));
                    Custdetails[1]=rs.getString("acc_pin");
                    Custdetails[2]=rs.getString("salutation");
                    Custdetails[3]=rs.getString("firstname");
                    Custdetails[4]=rs.getString("lastname");
                    Custdetails[5]=Integer.toString(rs.getInt("amount"));
                    Custdetails[6]=rs.getString("acc_type");
                    Custdetails[7]=rs.getString("gender");
                    Custdetails[8]=String.valueOf((rs.getInt("mobile_number1")));
                    Custdetails[9]=String.valueOf((rs.getInt("mobile_number2")));;
                    Custdetails[10]=rs.getString("dob");
                    Custdetails[11]=rs.getString("ac_opened_date");
                    Custdetails[12]=rs.getString("cust_address_room_app");
                    Custdetails[13]=rs.getString("cust_address_rd");
                    Custdetails[14]=rs.getString("cust_address_sub");
                    Custdetails[15]=rs.getString("cust_address_city");
                    Custdetails[16]=rs.getString("emailId");
                    Custdetails[17]=rs.getString("fav_fruit");
                    Custdetails[18]=rs.getString("trust_p");
                    Custdetails[19]=rs.getString("nickname");
                    Custdetails[20]=Integer.toString(rs.getInt("age"));
                    }
                }catch(Exception e){ 
                    e.printStackTrace();
                }   
        
        
        return Custdetails[colum_no-1].trim();
    }
    
    protected void Insert_In_LogStatus_Table(String Account_no,String FirstName,String LastName,String Log_Status,int Day,int Month,int Year,int Hour,int Minutes,int Seconds)
    {
        try 
        {
            String Ht="jdbc:sqlserver://localhost\\VAIBHAV:1433;databaseName=StateBank";
            String UN="xxxxx";
            String UP="xxxxx";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con= DriverManager.getConnection(Ht,UN,UP);
            PreparedStatement c=con.prepareStatement("INSERT INTO Customers_login_details values(?,?,?,?,?,?,?,?)");
            int an=Integer.parseInt(Account_no);
            c.setInt(1,an);
            c.setString(2,FirstName);
            c.setString(3,LastName);
            c.setString(4,Log_Status);
            c.setString(5,Year+"-"+Month+"-"+Day);
            c.setString(6,Hour+":"+Minutes+":"+Seconds);
            c.setString(7,"Vile Parle(East)");
            c.setInt(8,57);
            c.execute();
            
        } catch (Exception e) {}
            
    }
    
    protected void Insert_In_Transaction_Table(String Account_no,int Day,int Month,int Year,int Hour,int Minutes,int Seconds,String Location,int LocationID,String Tran_type,String To_acc,int ab,int at,int aa)
    {
        try 
        {
            String Ht="jdbc:sqlserver://localhost\\VAIBHAV:1433;databaseName=StateBank";
            String UN="xxx";
            String UP="xxxxx";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con= DriverManager.getConnection(Ht,UN,UP);
            PreparedStatement c=con.prepareStatement("INSERT INTO Customers_transactions_details values(?,?,?,?,?,?,?,?,?,?)");
            int an=Integer.parseInt(Account_no);
            c.setInt(1,an);
            c.setString(2,Year+"-"+Month+"-"+Day);
            c.setString(3,Hour+":"+Minutes+":"+Seconds);
            c.setString(4,Location);
            c.setInt(5,LocationID);
            c.setString(6,Tran_type);
            c.setString(7,To_acc);
            c.setInt(8,ab);
            c.setInt(9,at);
            c.setInt(10,aa);
            c.execute();
            
        } catch (Exception e) {}
    }
    
    protected void update_amt(String Acc_no,int amt)
    {
        try 
        {
            String Ht="jdbc:sqlserver://localhost\\VAIBHAV:1433;databaseName=StateBank";
            String UN="xxxx";
            String UP="xxxxx";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con= DriverManager.getConnection(Ht,UN,UP);
            PreparedStatement c=con.prepareStatement("update Customers_account_details set amount=? where account_no=?");
            c.setInt(1,amt);
            int an=Integer.parseInt(Acc_no);
            c.setInt(2,an);
            c.executeUpdate();
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
  
    }
    
    protected void clock(JLabel time)
    {
        Thread clock=new Thread()
        {
            public void run()
            {
                while (true) 
                {   
                    int DT[]=new int[6];
                    DT=VM_Date_Time();
                    
                    if(DT[4]==1||DT[4]==2||DT[4]==3||DT[4]==4||DT[4]==5||DT[4]==6||DT[4]==7||DT[4]==8||DT[4]==9||DT[4]==0)
                    {
                        time.setText("Date: "+DT[0]+"/"+DT[1]+"/"+DT[2]+"    "+"Time: "+DT[3]+":0"+DT[4]+":"+DT[5]);
                        if(DT[5]==1||DT[5]==2||DT[5]==3||DT[5]==4||DT[5]==5||DT[5]==6||DT[5]==7||DT[5]==8||DT[5]==9||DT[5]==0)
                        {
                            time.setText("Date: "+DT[0]+"/"+DT[1]+"/"+DT[2]+"    "+"Time: "+DT[3]+":0"+DT[4]+":0"+DT[5]);
                        }
                    }
                    else
                    {
                        time.setText("Date: "+DT[0]+"/"+DT[1]+"/"+DT[2]+"    "+"Time: "+DT[3]+":"+DT[4]+":"+DT[5]);
                        if(DT[5]==1||DT[5]==2||DT[5]==3||DT[5]==4||DT[5]==5||DT[5]==6||DT[5]==7||DT[5]==8||DT[5]==9||DT[5]==0)
                        {
                            time.setText("Date: "+DT[0]+"/"+DT[1]+"/"+DT[2]+"    "+"Time: "+DT[3]+":"+DT[4]+":0"+DT[5]);
                        }
                    }
                    try 
                    {
                      sleep(1000);  
                    } 
                    catch (Exception e)
                    {}
                }
            }
        };
        clock.start();
    }
         
   
    protected void click_sound()
    {
        try {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(MyPath+"ATM\\src\\ISVAO\\Click.wav").getAbsoluteFile());
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                    } catch (Exception e) {}
    }
    
    protected void  button_hover(JButton name)
    {
        name.setFont(new Font("Arial",Font.BOLD,30));
        name.setBorder(BorderFactory.createBevelBorder(0));
        name.setForeground(Color.WHITE);
        name.setBackground(Color.decode("#4F81BD"));
        name.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me)
            {
                name.setBackground(Color.decode("#197BF1"));
                name.repaint();
            }

            @Override
            public void mousePressed(MouseEvent me){}

            @Override
            public void mouseReleased(MouseEvent me) {}

            @Override
            public void mouseEntered(MouseEvent me) 
            {
                name.setBackground(Color.decode("#3883DE"));
                name.repaint();
            }

            @Override
            public void mouseExited(MouseEvent me) 
            {
                name.setBackground(Color.decode("#4F81BD"));
                name.repaint();
            }
        });
    }
    
    protected void only_numbers(JTextField obj)
    {
        obj.addKeyListener(new KeyListener() 
        {    
            @Override
            public void keyTyped(KeyEvent ke)
            {
                char c=ke.getKeyChar();
               if (!(Character.isDigit(c)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))) 
               {
                   ke.consume();
               }
            }

            @Override
            public void keyPressed(KeyEvent ke) 
            {}

            @Override
            public void keyReleased(KeyEvent ke)
            {}
        });
    
    }
    
    protected void only_chars(JTextField obj)
    {
        obj.addKeyListener(new KeyListener() 
        {    
            @Override
            public void keyTyped(KeyEvent ke)
            {
                char c=ke.getKeyChar();
               if (!(Character.isAlphabetic(c)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))) 
               {
                   ke.consume();
               }
            }

            @Override
            public void keyPressed(KeyEvent ke) 
            {}

            @Override
            public void keyReleased(KeyEvent ke)
            {}
        });
    
    }
    
    protected int check_withdraw_amt_on_date(String accn,int day,int month,int year)
    {
        int sum=0;
                String Host="jdbc:sqlserver://localhost\\VAIBHAV:1433;databaseName=StateBank";
                String UserN="xxxx";
                String UserP="xxxxx";
        try 
        {

                     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    Connection conn= DriverManager.getConnection(Host,UserN,UserP);
                    PreparedStatement c=conn.prepareStatement("select sum(Amt_T) from Customers_transactions_details where account_no=? and OnDate=? and Transaction_type=? ");
                    int an=Integer.parseInt(accn);
                    c.setInt(1,an);
                    c.setString(2,year+"-"+month+"-"+day);
                    c.setString(3,"Withdrawal");
                    ResultSet rs=c.executeQuery();
                    
                    while (rs.next()) 
                    {                
                        int t=rs.getInt(1);
                        sum=sum+t;
                    }
        }
        catch (Exception e) {}
        return sum;
    }
}

