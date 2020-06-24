package atm;

import static atm.ReUsable_Codes.Account_Number;
import static atm.ReUsable_Codes.Salutation;
import static atm.ReUsable_Codes.jf;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import vm_custom_gui.VM_ImagePanel;

public class MainMenu extends ReUsable_Codes
{
    
    
    protected void MainMenuP() 
    {
        jf.setVisible(true);
        jf.setLayout(null);
        jf.setSize(1152,668);
        jf.setTitle("STATE BANK -MAIN MENU");
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
        JButton b=new JButton("Deposit Money");
        b.setBounds(130,64,350,60);
        button_hover(b);
        b.setToolTipText("Deposits Money To Your Account");
        b.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {   
                click_sound();
                jf.getContentPane().removeAll();
                jf.repaint();
                new DepositPanel().DepositP();
            }
        });
        jp.add(b);
        
        jp.repaint();
        
        jp.repaint();
        JButton b2=new JButton("Withdraw Money");
        b2.setBounds(580,64,350,60);
        button_hover(b2);
        b2.setToolTipText("Withdraws Money From Your Account");
        b2.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                click_sound();
                jf.getContentPane().removeAll();
                jf.repaint();
                new WithdrawPanel().WithdrawP();
            }
        });
        jp.add(b2);
        jp.repaint();
        
        jp.repaint();
        JButton b3=new JButton("Balance Transfer");
        b3.setBounds(130,170,350,60);
        button_hover(b3);
        b3.setToolTipText("Transfer Money To Another Account");
        b3.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                click_sound();
                jf.getContentPane().removeAll();
                jf.repaint();
                new BalanceTransferPanel().BalanceTransferP();
            }
        });
        jp.add(b3);
        jp.repaint();
        
        JButton b4=new JButton("Check Balance");
        b4.setBounds(580,170,350,60);
        button_hover(b4);
        b4.setToolTipText("");
        jp.add(b4);
        b4.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                click_sound();
                jf.getContentPane().removeAll();
                jf.repaint();
                new CheckBalancePanel().CheckBalanceP();
            }
        });
        jp.repaint();
        
        jp.repaint();
        JButton b5=new JButton("Information");
        b5.setBounds(130,276,350,60);
        button_hover(b5);
        b5.setToolTipText("Information About User");
        jp.add(b5);
        b5.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                click_sound();
                jf.getContentPane().removeAll();
                jf.repaint();
                new InformationPanel().InformationP();
            }
        });
        jp.repaint();
        
        jp.repaint();
        JButton b6=new JButton("Change Pin");
        b6.setBounds(580,276,350,60);
        button_hover(b6);
        b6.setToolTipText("Changes You Account Pin");
        b6.addActionListener(new ActionListener() 
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
        jp.add(b6);
        
        ImageIcon Lo_icon = new ImageIcon(MyPath+"ATM\\src\\ISVAO\\LogOut_ic.png");
        
        jp.repaint();
        JButton logout=new JButton("  Logout",Lo_icon);
        logout.setBounds(355,382,350,60);
        logout.setFont(new Font("Arial",Font.BOLD,30));
        logout.setBorder(BorderFactory.createBevelBorder(0));
        logout.setForeground(Color.WHITE);
        logout.setBackground(Color.decode("#4F81BD"));
        logout.setToolTipText("");
        jp.add(logout);
        logout.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me)
            {
                logout.setBackground(Color.decode("#E15858"));
                logout.repaint();
            }

            @Override
            public void mousePressed(MouseEvent me){}

            @Override
            public void mouseReleased(MouseEvent me) {}

            @Override
            public void mouseEntered(MouseEvent me) 
            {
                logout.setBackground(Color.decode("#E60A0A"));
                logout.repaint();
            }

            @Override
            public void mouseExited(MouseEvent me) 
            {
                logout.setBackground(Color.decode("#4F81BD"));
                logout.repaint();
            }
        });
        logout.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                click_sound();
                
                JButton yl = new JButton("<html><h2>&nbsp&nbsp&nbsp&nbsp YES &nbsp&nbsp&nbsp&nbsp</h2></html>");
                button_hover(yl);
                yl.addActionListener(new ActionListener() 
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
                      jf.repaint();
                    }
                });
                JButton nl = new JButton("<html><h2>&nbsp&nbsp&nbsp&nbsp NO &nbsp&nbsp&nbsp&nbsp</h2></html>");
                button_hover(nl);
                nl.addActionListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) 
                    {
                      click_sound();
                      JOptionPane.getRootFrame().dispose();
                    }
                });
                JButton bs[]={yl,nl};
                ImageIcon icon = new ImageIcon(MyPath+"ATM\\src\\ISVAO\\LogOut.png");
                JOptionPane.showOptionDialog(null,("<html><h1>"+Salutation+"."+FN+" "+LN+"<br>Are you sure? <br>You want to Logout?</h1></html>").toUpperCase(),("logout confirmation").toUpperCase(),JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE, icon,bs,null);
                
            }
        });
        jp.repaint();
        
    }  
    
}
