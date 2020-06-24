package atm;

import static atm.ReUsable_Codes.Account_Number;
import static atm.ReUsable_Codes.jf;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import vm_custom_gui.VM_ImagePanel;

public class ChangePinPanel extends ReUsable_Codes
{
    protected void ChangePinP()
    {
        jf.setVisible(true);
        jf.setLayout(null);
        jf.setSize(1152,668);
        jf.setTitle("STATE BANK -CHANGE PIN");
        ImageIcon img = new ImageIcon(MyPath+"ATM\\src\\ISVAO\\Logo.png");
        jf.setIconImage(img.getImage());
        jf.setResizable(false);
        jf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        jf.repaint();
        
        JPanel jp1=new JPanel();
        jp1.setVisible(true);
        jp1.setLayout(null);
        jp1.setSize(1152,618);
        jp1.setBackground(Color.decode("#4286D7"));
        jf.add(jp1);
        jp1.repaint();
        jf.repaint();
        
        String fn1=FN.trim();
        String ln1=LN.trim();
        JLabel UserName=new JLabel(fn1.toUpperCase()+"  "+ln1.toUpperCase(),SwingConstants.CENTER);
        UserName.setFont(new Font("Rockwell",Font.BOLD,45));
        UserName.setBounds(0,0,1152, 100);
        UserName.setForeground(Color.WHITE);
        jp1.add(UserName);
        jp1.repaint();
        jf.repaint();
        
        
        JLabel task=new JLabel("Account number: "+acc_No_hider(Account_Number));
        task.setBounds(30, 618, 842,22);
        task.setFont(new Font("Rockwell",Font.BOLD,17));
        task.setForeground(Color.WHITE);
        task.setBackground(Color.decode("#E60A0A"));
        task.setOpaque(true);
        jf.add(task,new Integer(-6));
        jf.repaint();
        
        try{
        JLabel User_icon =new JLabel();
        if(Salutation.equals("Mr"))
        {
            User_icon.setIcon(new ImageIcon(ImageIO.read(new File(MyPath+"ATM\\src\\ISVAO\\User_M.png"))));
        }
        else
        {
            User_icon.setIcon(new ImageIcon(ImageIO.read(new File(MyPath+"ATM\\src\\ISVAO\\User_F.png"))));
        }
        User_icon.setBounds(0, 618, 30,22);
        User_icon.setBackground(Color.decode("#E60A0A"));
        User_icon.setOpaque(true);
        jf.add(User_icon,new Integer(1000));
        jf.repaint();
        }catch(Exception e){}
        
        JLabel time=new JLabel();
        time.setBounds(872, 618, 300,22);
        time.setFont(new Font("Rockwell",Font.BOLD,17));
        time.setForeground(Color.WHITE);
        time.setBackground(Color.decode("#E60A0A"));
        time.setOpaque(true);
        clock(time);
        jf.add(time);
        jf.repaint();
        jp1.repaint();                
        
        vm_custom_gui.VM_ImagePanel jp=new VM_ImagePanel(MyPath+"ATM\\src\\ISVAO\\InnerP.jpg");
        jp.setVisible(true);
        jp.setLayout(null);
        jp.setSize(1060,475);
        jp.setBackground(Color.decode("#FFE135"));
        jp.setBounds(46, 100,1060,475);
        jp.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        jp1.add(jp);
        jp1.repaint();
        jf.repaint();
        
        jp.repaint();
        JLabel user=new JLabel("<html>In Order to change the Pin you need <br>to answer certain questions: </html>");
        user.setBounds(50, 0, 1000, 150);
        user.setFont(new Font("Rockwell",Font.BOLD,40));
        jp.add(user);
        jp.repaint();
        jf.repaint();
        
        JLabel que1L=new JLabel("Which is your favorite fruit ? :");
        que1L.setBounds(75, 150, 600, 40);
        que1L.setFont(new Font("Times New Roman",Font.BOLD,35));
        jp.add(que1L);
        jp.repaint();
        jf.repaint();
        
        
        JTextField q1tb=new JTextField();
        q1tb.setBounds(770, 159, 200,30);
        q1tb.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        q1tb.setFont(new Font("Arial",Font.BOLD,22));
        only_chars(q1tb);
        jp.add(q1tb);
        jp.repaint();
        jf.repaint();
        
        JLabel que2L=new JLabel("Who is the most trusted person in your life ? :");
        que2L.setBounds(75, 210, 700, 40);
        que2L.setFont(new Font("Times New Roman",Font.BOLD,35));
        jp.add(que2L);
        jp.repaint();
        jf.repaint();
        
        JTextField q2tb=new JTextField();
        q2tb.setBounds(770, 219, 200,30);
        q2tb.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        q2tb.setFont(new Font("Arial",Font.BOLD,22));
        only_chars(q2tb);
        jp.add(q2tb);
        jp.repaint();
        jf.repaint();
        
        JLabel que3L=new JLabel("What is your nickname ? :");
        que3L.setBounds(75, 270, 600, 40);
        que3L.setFont(new Font("Times New Roman",Font.BOLD,35));
        jp.add(que3L);
        jp.repaint();
        jf.repaint();
        
        JTextField q3tb=new JTextField();
        q3tb.setBounds(770, 279, 200,30);
        q3tb.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        q3tb.setFont(new Font("Arial",Font.BOLD,22));
        only_chars(q3tb);
        jp.add(q3tb);
        jp.repaint();
        jf.repaint();
        
        jp.repaint();
        JButton proceedb=new JButton("Proceed>>>");
        proceedb.setBounds(580, 370,350,60);
        proceedb.setFont(new Font("Arial",Font.BOLD,30));
        proceedb.setBorder(BorderFactory.createBevelBorder(0));
        proceedb.setForeground(Color.WHITE);
        proceedb.setBackground(Color.decode("#4F81BD"));
        proceedb.setToolTipText("Deposits Amount In Account");
        proceedb.repaint();
        jp.add(proceedb);
        proceedb.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                click_sound();
                if(!((q1tb.getText().equals(""))||(q2tb.getText().equals(""))||(q3tb.getText().equals(""))))
                {
                    String fruit=new vm_encryption.VM_Alphabet_Encryption().char_Alphabet(get_custumer_details(18,Account_Number)),trustedP=new vm_encryption.VM_Alphabet_Encryption().char_Alphabet(get_custumer_details(19,Account_Number)),nickn=new vm_encryption.VM_Alphabet_Encryption().char_Alphabet(get_custumer_details(20,Account_Number));
                    if((fruit.equalsIgnoreCase(q1tb.getText()))&&(trustedP.equalsIgnoreCase(q2tb.getText()))&&(nickn.equalsIgnoreCase(q3tb.getText())))
                    {
                        jp.removeAll();
                        jp.repaint();
                        jp.repaint();

                        JLabel oldp=new JLabel("Enter Current Pin :");
                        oldp.setBounds(75, 40, 400, 100);
                        oldp.setFont(new Font("Rockwell",Font.BOLD,35));
                        jp.add(oldp);
                        jp.repaint();
                        jf.repaint();

                        try{
                        JLabel pass_icon =new JLabel();
                        pass_icon.setIcon(new ImageIcon(ImageIO.read(new File(MyPath+"ATM\\src\\ISVAO\\Pass.png"))));
                        pass_icon.setBounds(430,77,38,34);
                        pass_icon.setBackground(Color.WHITE);
                        pass_icon.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, Color.BLACK));
                        pass_icon.setOpaque(true);
                        jp.add(pass_icon,SwingConstants.CENTER);
                        jf.repaint();
                        }catch(Exception e){}


                        JPasswordField pintb=new JPasswordField();
                        pintb.setBounds(468,77, 200,34);
                        pintb.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.BLACK));
                        pintb.setFont(new Font("Arial",Font.BOLD,30));
                        only_numbers(pintb);
                        jp.add(pintb);
                        jp.repaint();
                        jf.repaint();
                        
                        JLabel np=new JLabel("Enter New  Pin :");
                        np.setBounds(75, 110, 400, 100);
                        np.setFont(new Font("Rockwell",Font.BOLD,35));
                        jp.add(np);
                        jp.repaint();
                        jf.repaint();
                        
                        try{
                        JLabel pass2_icon =new JLabel();
                        pass2_icon.setIcon(new ImageIcon(ImageIO.read(new File(MyPath+"ATM\\src\\ISVAO\\Pass.png"))));
                        pass2_icon.setBounds(430,147,38,34);
                        pass2_icon.setBackground(Color.WHITE);
                        pass2_icon.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, Color.BLACK));
                        pass2_icon.setOpaque(true);
                        jp.add(pass2_icon,SwingConstants.CENTER);
                        jf.repaint();
                        }catch(Exception e){}


                        JPasswordField npintb=new JPasswordField();
                        npintb.setBounds(468,147, 200,34);
                        npintb.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.BLACK));
                        npintb.setFont(new Font("Arial",Font.BOLD,30));
                        only_numbers(npintb);
                        jp.add(npintb);
                        jp.repaint();
                        jf.repaint();
                       
                        JLabel rnp=new JLabel("Re-Type New Pin :");
                        rnp.setBounds(75, 180, 400, 100);
                        rnp.setFont(new Font("Rockwell",Font.BOLD,35));
                        jp.add(rnp);
                        jp.repaint();
                        jf.repaint();
                        
                        try{
                        JLabel pass3_icon =new JLabel();
                        pass3_icon.setIcon(new ImageIcon(ImageIO.read(new File(MyPath+"ATM\\src\\ISVAO\\Pass.png"))));
                        pass3_icon.setBounds(430,217,38,34);
                        pass3_icon.setBackground(Color.WHITE);
                        pass3_icon.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, Color.BLACK));
                        pass3_icon.setOpaque(true);
                        jp.add(pass3_icon,SwingConstants.CENTER);
                        jf.repaint();
                        }catch(Exception e){}


                        JPasswordField rpintb=new JPasswordField();
                        rpintb.setBounds(468,217, 200,34);
                        rpintb.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.BLACK));
                        rpintb.setFont(new Font("Arial",Font.BOLD,30));
                        only_numbers(rpintb);
                        jp.add(rpintb);
                        jp.repaint();
                        jf.repaint();
                        
                        
                        
                        
                        jp.repaint();
                        ImageIcon dp_icon = new ImageIcon(MyPath+"ATM\\src\\ISVAO\\Pc.png");
                        JButton changep=new JButton(" Change Pin",dp_icon);
                        changep.setBounds(580, 370,350,60);
                        changep.setFont(new Font("Arial",Font.BOLD,30));
                        changep.setBorder(BorderFactory.createBevelBorder(0));
                        changep.setForeground(Color.WHITE);
                        changep.setBackground(Color.decode("#4F81BD"));
                        changep.setToolTipText("Deposits Amount In Account");
                        changep.repaint();
                        jp.add(changep);
                        button_hover(changep);
                        changep.addActionListener(new ActionListener() 
                        {
                            @Override
                            public void actionPerformed(ActionEvent ae) 
                            {
                                click_sound();
                                if(!((pintb.getText().equals(""))||(npintb.getText().equals(""))||(rpintb.getText().equals(""))))
                        {
                            String pass=new vm_encryption.VM_Pin_Encryption().char_num(get_custumer_details(2, Account_Number));
                            if(pass.equals(pintb.getText()))
                            {
                                if(rpintb.getText().equals(npintb.getText()))
                                {
                                    int count=rpintb.getText().length();
                                    if(count==6)
                                    {
                                        JButton confirm = new JButton("<html><h2>&nbsp&nbsp&nbsp&nbsp Confirm &nbsp&nbsp&nbsp&nbsp</h2></html>");
                                        button_hover(confirm);
                                        confirm.addActionListener(new ActionListener() 
                                        {
                                            @Override
                                            public void actionPerformed(ActionEvent ae) 
                                            {
                                                String nep=new vm_encryption.VM_Pin_Encryption().num_char(npintb.getText());
                                                        try 
                                                    {
                                                        String Ht="jdbc:sqlserver://localhost\\VAIBHAV:1433;databaseName=xxxxx";
                                                        String UN="xxxxx";
                                                        String UP="xxxxx";
                                                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                                                        Connection con= DriverManager.getConnection(Ht,UN,UP);
                                                        PreparedStatement c=con.prepareStatement("update Customers_account_details set acc_pin=? where account_no=?");
                                                        c.setString(1,nep);
                                                        int an=Integer.parseInt(Account_Number);
                                                        c.setInt(2,an);
                                                        c.executeUpdate();
                                                    }
                                                    catch (Exception e) 
                                                    {
                                                        e.printStackTrace();
                                                    }
                                                        
                                                        jp.removeAll();
                                                        jp.repaint();
                                                    
                                                            JLabel sss=new JLabel("PIN CHANGED SUCESSFULLY",SwingConstants.CENTER);
                                                        sss.setFont(new Font("Arial Unicode MS",Font.BOLD,50));
                                                        sss.setForeground(Color.BLACK);
                                                        sss.setOpaque(true);
                                                        sss.setBounds(5,100,1050,70);
                                                        jp.add(sss);
                                                        jp.repaint();
                                                        jp.repaint();
                                                        JButton logout=new JButton("Ok");
                                                        logout.setBounds(355,300,350,60);
                                                        logout.setFont(new Font("Arial",Font.BOLD,30));
                                                        logout.setBorder(BorderFactory.createBevelBorder(0));
                                                        logout.setForeground(Color.WHITE);
                                                        logout.setBackground(Color.decode("#4F81BD"));
                                                        logout.setToolTipText("");
                                                        button_hover(logout);
                                                        jp.add(logout);
                                                        logout.addActionListener(new ActionListener() 
                                                        {
                                                            @Override
                                                            public void actionPerformed(ActionEvent ae) 
                                                            {
                                                                click_sound();
                                                                      int dt[]=new int[6];
                                                                      dt=VM_Date_Time();
                                                                      Insert_In_LogStatus_Table(Account_Number, FN, LN, "Logged Out",dt[0] ,dt[1], dt[2],dt[3],dt[4], dt[5]);
                                                                      jf.getContentPane().removeAll();
                                                                      jf.repaint();
                                                                      new LogInPanel().LogInP();
                                                                      jf.repaint();
                                                            }
                                                        });
                                                        jp.repaint();
                                                JOptionPane.getRootFrame().dispose();
                                            }
                                        });
                                        JButton back = new JButton("<html><h2>&nbsp&nbsp&nbsp&nbsp Cancel &nbsp&nbsp&nbsp&nbsp</h2></html>");
                                        button_hover(back);
                                        back.addActionListener(new ActionListener() 
                                        {
                                            @Override
                                            public void actionPerformed(ActionEvent actionEvent) 
                                            {
                                                click_sound();
                                                JOptionPane.getRootFrame().dispose();
                                            }
                                        });
                                        JButton bs[]={confirm,back};
                                        ImageIcon dpc_icon = new ImageIcon(MyPath+"ATM\\src\\ISVAO\\Pc.png");
                                        JOptionPane.showOptionDialog(null,("<html><h1>You Want change pin for : "+acc_No_hider(Account_Number)+"</h1></html>").toUpperCase(),("deposit confirmation").toUpperCase(),JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE, dpc_icon,bs,null);
                                    }
                                    else
                                    {
                                        JButton kkk = new JButton("<html><h2>&nbsp&nbsp&nbsp&nbsp OK &nbsp&nbsp&nbsp&nbsp</h2></html>");
                                        button_hover(kkk);
                                        kkk.addActionListener(new ActionListener() 
                                        {
                                            @Override
                                            public void actionPerformed(ActionEvent actionEvent) 
                                            {
                                                click_sound();
                                                JOptionPane.getRootFrame().dispose();
                                            }
                                        });
                                        JButton bs[]={kkk};
                                        ImageIcon dpc_icon = new ImageIcon(MyPath+"ATM\\src\\ISVAO\\Pc.png");
                                        JOptionPane.showOptionDialog(null,("<html><h1>New pin should be of 6 numbers only </h1></html>").toUpperCase(),("Invalid").toUpperCase(),JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE, dpc_icon,bs,null);
                                    }
                                }
                                else
                                {
                                    JButton kkk = new JButton("<html><h2>&nbsp&nbsp&nbsp&nbsp OK &nbsp&nbsp&nbsp&nbsp</h2></html>");
                                    button_hover(kkk);
                                    kkk.addActionListener(new ActionListener() 
                                    {
                                        @Override
                                        public void actionPerformed(ActionEvent actionEvent) 
                                        {
                                            click_sound();
                                            JOptionPane.getRootFrame().dispose();
                                        }
                                    });
                                    JButton bs[]={kkk};
                                    ImageIcon dpc_icon = new ImageIcon(MyPath+"ATM\\src\\ISVAO\\Pc.png");
                                    JOptionPane.showOptionDialog(null,("<html><h1>New Pin Doesn't Match With ReType NEw PIN </h1></html>").toUpperCase(),("Invalid").toUpperCase(),JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE, dpc_icon,bs,null);
                                }
                            }
                            else
                            {
                                JButton kkk = new JButton("<html><h2>&nbsp&nbsp&nbsp&nbsp OK &nbsp&nbsp&nbsp&nbsp</h2></html>");
                                button_hover(kkk);
                                kkk.addActionListener(new ActionListener() 
                                {
                                    @Override
                                    public void actionPerformed(ActionEvent actionEvent) 
                                    {
                                        click_sound();
                                        JOptionPane.getRootFrame().dispose();
                                    }
                                });
                                JButton bs[]={kkk};
                                ImageIcon dpc_icon = new ImageIcon(MyPath+"ATM\\src\\ISVAO\\Pc.png");
                                JOptionPane.showOptionDialog(null,("<html><h1>Invalid current pin</h1></html>").toUpperCase(),("Invalid").toUpperCase(),JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE, dpc_icon,bs,null);
                            }

                        }
                        else
                        {
                            JButton kkk = new JButton("<html><h2>&nbsp&nbsp&nbsp&nbsp OK &nbsp&nbsp&nbsp&nbsp</h2></html>");
                            button_hover(kkk);
                            kkk.addActionListener(new ActionListener() 
                            {
                                @Override
                                public void actionPerformed(ActionEvent actionEvent) 
                                {
                                    click_sound();
                                    JOptionPane.getRootFrame().dispose();
                                }
                            });
                            JButton bs[]={kkk};
                            ImageIcon dpc_icon = new ImageIcon(MyPath+"ATM\\src\\ISVAO\\Pc.png");
                            JOptionPane.showOptionDialog(null,("<html><h1>please Complete all the fields </h1></html>").toUpperCase(),("Empty Text").toUpperCase(),JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE, dpc_icon,bs,null);
                            
                        }
                            }
                        });
    
                        jp.repaint();   
                        ImageIcon b_icon = new ImageIcon(MyPath+"ATM\\src\\ISVAO\\back_ic.png");
                        JButton backb=new JButton(" Back",b_icon);
                        backb.setBounds(130, 370,350,60);
                        backb.setBackground(Color.decode("#4F81BD"));
                        backb.setToolTipText("Back To Main Menu");
                        backb.repaint();
                        jp.add(backb);
                        button_hover(backb);
                        backb.addActionListener(new ActionListener() 
                        {
                                @Override
                                public void actionPerformed(ActionEvent ae) 
                                {
                                    click_sound();
                                    jf.getContentPane().removeAll();
                                    jf.repaint();
                                    new ChangePinPanel().ChangePinP();
                                }
                        });
                        jp.repaint();
                        jf.repaint();
                        
                        
                    }
                    else
                    {
                        JButton kkk = new JButton("<html><h2>&nbsp&nbsp&nbsp&nbsp OK &nbsp&nbsp&nbsp&nbsp</h2></html>");
                        button_hover(kkk);
                        kkk.addActionListener(new ActionListener() 
                        {
                            @Override
                            public void actionPerformed(ActionEvent actionEvent) 
                            {
                                click_sound();
                                JOptionPane.getRootFrame().dispose();
                            }
                        });
                        JButton bs[]={kkk};
                        ImageIcon dpc_icon = new ImageIcon(MyPath+"ATM\\src\\ISVAO\\Pc.png");
                        JOptionPane.showOptionDialog(null,("<html><h1>Invalid answers </h1></html>").toUpperCase(),("Invalid").toUpperCase(),JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE, dpc_icon,bs,null);
                    }
                }
                else
                {
                    JButton kkk = new JButton("<html><h2>&nbsp&nbsp&nbsp&nbsp OK &nbsp&nbsp&nbsp&nbsp</h2></html>");
                    button_hover(kkk);
                    kkk.addActionListener(new ActionListener() 
                    {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) 
                        {
                            click_sound();
                            JOptionPane.getRootFrame().dispose();
                        }
                    });
                    JButton bs[]={kkk};
                    ImageIcon dpc_icon = new ImageIcon(MyPath+"ATM\\src\\ISVAO\\Pc.png");
                    JOptionPane.showOptionDialog(null,("<html><h1>please Complete all the fields </h1></html>").toUpperCase(),("Empty Text").toUpperCase(),JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE, dpc_icon,bs,null);
                }
            
            }
        });
        button_hover(proceedb);
        
        jp.repaint();   
        ImageIcon b_icon = new ImageIcon(MyPath+"ATM\\src\\ISVAO\\back_ic.png");
        JButton backb=new JButton(" Back",b_icon);
        backb.setBounds(130, 370,350,60);
        backb.setBackground(Color.decode("#4F81BD"));
        backb.setToolTipText("Back To Main Menu");
        backb.repaint();
        jp.add(backb);
        button_hover(backb);
        backb.addActionListener(new ActionListener() 
        {
                @Override
                public void actionPerformed(ActionEvent ae) 
                {
                    click_sound();
                    jf.getContentPane().removeAll();
                    jf.repaint();
                    new MainMenu().MainMenuP();
                }
        });
    }
    
}
