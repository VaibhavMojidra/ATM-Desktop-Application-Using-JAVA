package atm;

import static atm.ReUsable_Codes.Account_Number;
import static atm.ReUsable_Codes.jf;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import vm_custom_gui.VM_ImagePanel;

public class WithdrawPanel extends ReUsable_Codes
{
    protected void WithdrawP()
{
        jf.setVisible(true);
        jf.setLayout(null);
        jf.setSize(1152,668);
        jf.setTitle("STATE BANK -WITHDRAW MONEY");
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
        JLabel user=new JLabel("Enter An Amount:");
        user.setBounds(100, 130, 400, 30);
        user.setFont(new Font("Rockwell",Font.BOLD,45));
        jp.add(user);
        jp.repaint();
        jf.repaint();
        
        try{
        JLabel am_icon =new JLabel();
        am_icon.setIcon(new ImageIcon(ImageIO.read(new File(MyPath+"ATM\\src\\ISVAO\\Am.png"))));
        am_icon.setBounds(500, 129,42,38);
        am_icon.setBackground(Color.WHITE);
        am_icon.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, Color.BLACK));
        am_icon.setOpaque(true);
        jp.add(am_icon,SwingConstants.CENTER);
        jf.repaint();
        }catch(Exception e){}
        
        JTextField amtb=new JTextField();
        amtb.setBounds(542, 129, 200,38);
        amtb.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.BLACK));
        amtb.setFont(new Font("Arial",Font.BOLD,25));
        only_numbers(amtb);
        jp.add(amtb);
        jp.repaint();
        jf.repaint();
        
    jp.repaint();
    ImageIcon wd_icon = new ImageIcon(MyPath+"ATM\\src\\ISVAO\\Wd.png");
    JButton withdb=new JButton(" Withdraw",wd_icon);
    withdb.setBounds(580, 370,350,60);
    withdb.setFont(new Font("Arial",Font.BOLD,30));
    withdb.setBorder(BorderFactory.createBevelBorder(0));
    withdb.setForeground(Color.WHITE);
    withdb.setBackground(Color.decode("#4F81BD"));
    withdb.setToolTipText("Deposits Amount In Account");
    withdb.repaint();
    jp.add(withdb);
    button_hover(withdb);
    withdb.addActionListener(new ActionListener()
    {
                @Override
                public void actionPerformed(ActionEvent ae) 
                {
                    click_sound();
                    if(!(amtb.getText().equals("")||Integer.parseInt(amtb.getText())==0))
                    {
                        int dt[]=VM_Date_Time();
                        int on_date_w=check_withdraw_amt_on_date(Account_Number,dt[0], dt[1],dt[2]);
                        int Amt_T=Integer.parseInt(amtb.getText());
                        
                        int RW=40000-on_date_w;
                        if (Amt_T<=RW) 
                        {
                            int Amt_B_T=Integer.parseInt(get_custumer_details(6,Account_Number));
                            if(((Amt_B_T-1000)-Amt_T)>=0)
                           {
                                    JButton confirm = new JButton("<html><h2>&nbsp&nbsp&nbsp&nbsp Confirm &nbsp&nbsp&nbsp&nbsp</h2></html>");
                                button_hover(confirm);
                                confirm.addActionListener(new ActionListener() 
                                {
                                    @Override
                                    public void actionPerformed(ActionEvent actionEvent) 
                                    {  
                                        click_sound();
                                        int Amt_A_T=Amt_B_T-Amt_T;
                                        int datTi[]=new int[6];
                                        datTi=VM_Date_Time();
                                        Insert_In_Transaction_Table(Account_Number,datTi[0],datTi[1],datTi[2], datTi[3], datTi[4], datTi[5], "Vile Parle(East)",57, "Withdrawal",null, Amt_B_T,Amt_T, Amt_A_T);
                                        update_amt(Account_Number,Amt_A_T);
                                        jp.removeAll();
                                        jp.repaint();
                                        JOptionPane.getRootFrame().dispose();
                                        jp.repaint();
                                        
                                        JPanel r_jp=new JPanel();
                                        r_jp.setVisible(true);
                                        r_jp.setLayout(null);
                                        r_jp.setBounds(20,20,400,435);
                                        r_jp.setBackground(Color.WHITE);
                                        r_jp.setBorder(BorderFactory.createEtchedBorder(0));
                                        jp.add(r_jp);
                                        jp.repaint();
                                        
                                        JLabel sb=new JLabel("STATE BANK");
                                        sb.setFont(new Font("Rockwell",Font.BOLD,37));
                                        sb.setForeground(Color.BLACK);
                                        sb.setBackground(Color.decode("#E60A0A"));
                                        sb.setOpaque(false);
                                        sb.setBounds(20,10,250,100);
                                        r_jp.add(sb);
                                        r_jp.repaint();
                                        
                                        try {
                                        JLabel log=new JLabel(new ImageIcon(ImageIO.read(new File(MyPath+"ATM\\src\\ISVAO\\Receipt.png"))));   
                                        log.setBounds(250,10,150,100);
                                        r_jp.add(log);
                                        r_jp.repaint();
                                            }
                                        catch (Exception e) {}
                                        
                                        JLabel line=new JLabel("_____________________");
                                        line.setFont(new Font("Rockwell",Font.BOLD,37));
                                        line.setBounds(2,75,400,40);
                                        r_jp.add(line);
                                        r_jp.repaint();                                        
                                        
                                        JLabel dt=new JLabel(datTi[0]+"/"+datTi[1]+"/"+datTi[2]+"  "+datTi[3]+":"+datTi[4],SwingConstants.LEFT);
                                        dt.setFont(new Font("Arial Unicode MS",Font.BOLD,15));
                                        dt.setForeground(Color.decode("#363636"));
                                        dt.setBackground(Color.WHITE);
                                        dt.setOpaque(true);
                                        dt.setBounds(20,125,370,30);
                                        r_jp.add(dt);
                                        r_jp.repaint();
                                        
                                        JLabel ACC=new JLabel(acc_No_hider(Account_Number),SwingConstants.LEFT);
                                        ACC.setFont(new Font("Arial Unicode MS",Font.BOLD,15));
                                        ACC.setForeground(Color.decode("#363636"));
                                        ACC.setBackground(Color.WHITE);
                                        ACC.setOpaque(true);
                                        ACC.setBounds(20,175,370,30);
                                        r_jp.add(ACC);
                                        
                                        JLabel Trans_t=new JLabel("WITHDRAWAL",SwingConstants.LEFT);
                                        Trans_t.setFont(new Font("Arial Unicode MS",Font.BOLD,15));
                                        Trans_t.setForeground(Color.decode("#363636"));
                                        Trans_t.setBackground(Color.WHITE);
                                        Trans_t.setOpaque(true);
                                        Trans_t.setBounds(30,205,360,30);
                                        r_jp.add(Trans_t);
                                        r_jp.repaint();
                                        
                                        JLabel rev=new JLabel("",SwingConstants.LEFT);
                                        rev.setFont(new Font("Arial Unicode MS",Font.BOLD,15));
                                        rev.setForeground(Color.decode("#363636"));
                                        rev.setBackground(Color.WHITE);
                                        rev.setOpaque(true);
                                        rev.setBounds(20,235,370,30);
                                        r_jp.add(rev);
                                        r_jp.repaint();
                                        
                                        JLabel amtL=new JLabel("AMT. RS."+Amt_T,SwingConstants.RIGHT);
                                        amtL.setFont(new Font("Arial Unicode MS",Font.BOLD,15));
                                        amtL.setForeground(Color.decode("#363636"));
                                        amtL.setBackground(Color.WHITE);
                                        amtL.setOpaque(true);
                                        amtL.setBounds(10,265,380,30);
                                        r_jp.add(amtL);
                                        r_jp.repaint();
                                        
                                        JLabel avb=new JLabel("AVAILABLE BALANCE:",SwingConstants.LEFT);
                                        avb.setFont(new Font("Arial Unicode MS",Font.BOLD,15));
                                        avb.setForeground(Color.decode("#363636"));
                                        avb.setBackground(Color.WHITE);
                                        avb.setOpaque(true);
                                        avb.setBounds(20,295,360,30);
                                        r_jp.add(avb);
                                        r_jp.repaint();
                                        
                                        JLabel ab=new JLabel("AMT. RS."+Amt_A_T,SwingConstants.RIGHT);
                                        ab.setFont(new Font("Arial Unicode MS",Font.BOLD,15));
                                        ab.setForeground(Color.decode("#363636"));
                                        ab.setBackground(Color.WHITE);
                                        ab.setOpaque(true);
                                        ab.setBounds(10,325,380,30);
                                        r_jp.add(ab);
                                        r_jp.repaint();
                                        
                                        JLabel star=new JLabel("*******************************",SwingConstants.CENTER);
                                        star.setFont(new Font("Arial Unicode MS",Font.BOLD,25));
                                        star.setForeground(Color.decode("#363636"));
                                        star.setBackground(Color.WHITE);
                                        star.setOpaque(true);
                                        star.setBounds(20,380,360,30);
                                        r_jp.add(star);
                                        r_jp.repaint();
                                        
                                        JLabel sss=new JLabel("WITHDRAWAL SUCCESSFUL",SwingConstants.CENTER);
                                        sss.setFont(new Font("Arial Unicode MS",Font.BOLD,40));
                                        sss.setForeground(Color.BLACK);
                                        sss.setOpaque(true);
                                        sss.setBounds(450,100,600,50);
                                        jp.add(sss);
                                        jp.repaint();
                                        
                                        jp.repaint();   
                                        ImageIcon b_icon = new ImageIcon(MyPath+"ATM\\src\\ISVAO\\print.png");
                                        JButton printb=new JButton(" Print",b_icon);
                                        printb.setBounds(565, 200,350,60);
                                        printb.setFont(new Font("Arial",Font.BOLD,30));
                                        printb.setBorder(BorderFactory.createBevelBorder(0));
                                        printb.repaint();
                                        jp.add(printb);
                                        button_hover(printb);
                                        printb.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent vvv) 
                                            {
                                                click_sound();
                                                int dt[]=new int[6];
                                                dt=VM_Date_Time();
                                                Insert_In_LogStatus_Table(Account_Number, FN, LN, "Logged Out",dt[0] ,dt[1], dt[2],dt[3],dt[4], dt[5]);
                                                jf.getContentPane().removeAll();
                                                jf.repaint();
                                                new LogInPanel().LogInP();
                                            }
                                        });
    
                                        jp.repaint();
                                        jf.repaint();
    
                                        jp.repaint();   
                                        JButton cancel=new JButton("Don't Print");
                                        cancel.setBounds(565, 300,350,60);
                                        cancel.setFont(new Font("Arial",Font.BOLD,30));
                                        cancel.setBorder(BorderFactory.createBevelBorder(0));
                                        cancel.repaint();
                                        jp.add(cancel);
                                        button_hover(cancel);
                                        cancel.addActionListener(new ActionListener() 
                                        {
                                            @Override
                                            public void actionPerformed(ActionEvent aavavva) 
                                            {
                                                JButton yes = new JButton("<html><h2>&nbsp&nbsp&nbsp&nbsp YES &nbsp&nbsp&nbsp&nbsp</h2></html>");
                                                button_hover(yes);
                                                yes.addActionListener(new ActionListener() 
                                                {
                                                    @Override
                                                    public void actionPerformed(ActionEvent actionEvent) 
                                                    {
                                                        click_sound();
                                                        int dt[]=new int[6];
                                                        dt=VM_Date_Time();
                                                        Insert_In_LogStatus_Table(Account_Number, FN, LN, "Logged Out",dt[0] ,dt[1], dt[2],dt[3],dt[4], dt[5]);
                                                        JOptionPane.getRootFrame().dispose();
                                                        jf.getContentPane().removeAll();
                                                        jf.repaint();
                                                        new LogInPanel().LogInP();
                                                    }
                                                });
                                                JButton no = new JButton("<html><h2>&nbsp&nbsp&nbsp&nbsp NO &nbsp&nbsp&nbsp&nbsp</h2></html>");
                                                button_hover(no);
                                                no.addActionListener(new ActionListener() 
                                                {
                                                    @Override
                                                    public void actionPerformed(ActionEvent actionEvent) 
                                                    {
                                                        click_sound();
                                                        JOptionPane.getRootFrame().dispose();
                                                    }
                                                });
                                                JButton bs[]={yes,no};
                                                JOptionPane.showOptionDialog(null,("<html><h1>ARE YOU SURE YOU DON'T WANT TO PRINT THE RECEIPT ?</h1></html>").toUpperCase(),("PRint confirmation").toUpperCase(),JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE, null,bs,null);
                                            }
                                        });
                                        jp.repaint();
                                        
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
                                ImageIcon dpc_icon = new ImageIcon(MyPath+"ATM\\src\\ISVAO\\Wd.png");
                                JOptionPane.showOptionDialog(null,("<html><h1>You Want to Withdraw rs."+amtb.getText()+"<br>into your account: "+acc_No_hider(Account_Number)+"</h1></html>").toUpperCase(),("Withdrawal confirmation").toUpperCase(),JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE, dpc_icon,bs,null);
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
                                ImageIcon dpc_icon = new ImageIcon(MyPath+"ATM\\src\\ISVAO\\Wd.png");
                                JOptionPane.showOptionDialog(null,("<html><h1>Insufficient Amount in Your account: "+acc_No_hider(Account_Number)+"</h1></html>").toUpperCase(),("Withdrawal amount exceeded").toUpperCase(),JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE, dpc_icon,bs,null);    
                           }
                            
                        }
                        else
                        {
                            if(RW<=0)
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
                                ImageIcon dpc_icon = new ImageIcon(MyPath+"ATM\\src\\ISVAO\\Wd.png");
                                JOptionPane.showOptionDialog(null,("<html><h1>You cannot withdraw any amount as you<br>have exceed the withdrawal limit of current date</h1></html>").toUpperCase(),("Withdrawal amount exceeded").toUpperCase(),JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE, dpc_icon,bs,null);
                            }
                            if(RW>0)
                            {
                                if (RW==40000) 
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
                                   ImageIcon dpc_icon = new ImageIcon(MyPath+"ATM\\src\\ISVAO\\Wd.png");
                                   JOptionPane.showOptionDialog(null,("<html><h1>You cannot withdraw amount more than Rs."+RW+" per day.</h1></html>").toUpperCase(),("Withdrawal amount exceeded").toUpperCase(),JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE, dpc_icon,bs,null);
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
                                   ImageIcon dpc_icon = new ImageIcon(MyPath+"ATM\\src\\ISVAO\\Wd.png");
                                   JOptionPane.showOptionDialog(null,("<html><h1>You cannot withdraw amount rs."+Amt_T+" as you<br>have previous withdrawals for the current date<br>Your remaining withdrawal amount<br> for the current date: Rs."+RW+" </h1></html>").toUpperCase(),("Withdrawal amount exceeded").toUpperCase(),JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE, dpc_icon,bs,null);  
                                }
                            }
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
                            ImageIcon dpc_icon = new ImageIcon(MyPath+"ATM\\src\\ISVAO\\Wd.png");
                            JOptionPane.showOptionDialog(null,("<html><h1>please enter an amount </h1></html>").toUpperCase(),("Amount Validation").toUpperCase(),JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE, dpc_icon,bs,null);
                    
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
                new MainMenu().MainMenuP();
            }
    });
    jp.repaint();
    jf.repaint();
    
    
    }
    
    
//    public static void main(String[] args)
//    {
//        new WithdrawPanel().WithdrawP();
//    }
}
