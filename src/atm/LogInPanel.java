package atm;


import static atm.ReUsable_Codes.Account_Number;
import static atm.ReUsable_Codes.FN;
import static atm.ReUsable_Codes.LN;
import static atm.ReUsable_Codes.Salutation;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import vm_custom_gui.VM_ImagePanel;



public class LogInPanel extends ReUsable_Codes
{
    
    protected void LogInP()
    {
        
        jf.repaint();
        nullify();
        jf.setVisible(true);
        jf.setLayout(null);
        jf.setSize(1152,668);
        jf.setTitle("STATE BANK -LOG IN");
        ImageIcon img = new ImageIcon(MyPath+"ATM\\src\\ISVAO\\Logo.png");
        jf.setIconImage(img.getImage());
        jf.setResizable(false);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.repaint();
        
        vm_custom_gui.VM_ImagePanel jp=new VM_ImagePanel(MyPath+"ATM\\src\\ISVAO\\LoginBg.png");
        jp.setVisible(true);
        jp.setLayout(null);
        jp.setSize(1152,618);
        jf.add(jp);
        jp.repaint();
        jf.repaint();
        
        JLabel task=new JLabel("Welcome To State Bank");
        task.setBounds(30, 618, 872,22);
        task.setFont(new Font("Rockwell",Font.BOLD,17));
        task.setForeground(Color.WHITE);
        task.setBackground(Color.decode("#E60A0A"));
        task.setOpaque(true);
        jf.add(task,new Integer(-6));
        jf.repaint();
        
        try{
        JLabel User_icon =new JLabel();
        User_icon.setIcon(new ImageIcon(ImageIO.read(new File(MyPath+"ATM\\src\\ISVAO\\Logo_T.png"))));
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
        
        jp.repaint();
        
        
        jp.repaint();
        JLabel user=new JLabel("Enter Your Account Number:");
        user.setBounds(80, 200, 500, 30);
        user.setFont(new Font("Rockwell",Font.BOLD,30));
        jp.add(user);
        jp.repaint();
        jf.repaint();
        
        try{
        JLabel acc_icon =new JLabel();
        acc_icon.setIcon(new ImageIcon(ImageIO.read(new File(MyPath+"ATM\\src\\ISVAO\\Acc.png"))));
        acc_icon.setBounds(515, 202,38,34);
        acc_icon.setBackground(Color.WHITE);
        acc_icon.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, Color.BLACK));
        acc_icon.setOpaque(true);
        jp.add(acc_icon,SwingConstants.CENTER);
        jf.repaint();
        }catch(Exception e){}
        
        JTextField acctb=new JTextField();
        acctb.setBounds(553, 202, 200,34);
        acctb.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.BLACK));
        acctb.setFont(new Font("Arial",Font.BOLD,22));
        only_numbers(acctb);
        jp.add(acctb);
        jp.repaint();
        jf.repaint();
        
       
        jp.repaint();
        JLabel pin=new JLabel("Enter Your Pin:");
        pin.setBounds(80, 285, 500, 30);
        pin.setFont(new Font("Rockwell",Font.BOLD,30));
        jp.add(pin);
        jp.repaint();jf.repaint();
    
        try{
        JLabel pass_icon =new JLabel();
        pass_icon.setIcon(new ImageIcon(ImageIO.read(new File(MyPath+"ATM\\src\\ISVAO\\Pass.png"))));
        pass_icon.setBounds(315, 287,38,34);
        pass_icon.setBackground(Color.WHITE);
        pass_icon.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, Color.BLACK));
        pass_icon.setOpaque(true);
        jp.add(pass_icon,SwingConstants.CENTER);
        jf.repaint();
        }catch(Exception e){}
        
        
        JPasswordField pintb=new JPasswordField();
        pintb.setBounds(353,287, 200,34);
        pintb.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.BLACK));
        pintb.setFont(new Font("Arial",Font.BOLD,30));
        only_numbers(pintb);
        jp.add(pintb);
        jp.repaint();
        jf.repaint();
        
        
    jp.repaint();
    ImageIcon Li_icon = new ImageIcon(MyPath+"ATM\\src\\ISVAO\\LogIn_ic.png");
    JButton logIn=new JButton(" Log In",Li_icon);
    logIn.setBounds(415, 387, 200,50);
    logIn.setFont(new Font("Arial",Font.BOLD,30));
    logIn.setBorder(BorderFactory.createBevelBorder(0));
    logIn.setForeground(Color.WHITE);
    logIn.setBackground(Color.decode("#4F81BD"));
    logIn.setToolTipText("Logs In");
    logIn.repaint();
    button_hover(logIn);
    jp.repaint();
        jf.repaint();
        logIn.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                
                logIn.repaint();
                jp.repaint();
                click_sound();
                logIn.repaint();
                 if(!(acctb.getText().equals("")))
                 {
                    if(Acc_if_Exists(acctb.getText())) 
                    {   
                        
                       String database_pass=new vm_encryption.VM_Pin_Encryption().char_num(get_custumer_details(2,acctb.getText()));
                       String user_entered_pass=pintb.getText();
                       
                       if(!(user_entered_pass.equals(""))) 
                       {
                           if(database_pass.equals(user_entered_pass))
                            {
                                FN=get_custumer_details(4,acctb.getText());
                                LN=get_custumer_details(5,acctb.getText());
                                Account_Number=get_custumer_details(1,acctb.getText());
                                Salutation=get_custumer_details(3, acctb.getText());
                                int datTi[]=new int[6];
                                datTi=VM_Date_Time();
                                Insert_In_LogStatus_Table(Account_Number,FN,LN,"Logged In",datTi[0],datTi[1],datTi[2], datTi[3], datTi[4], datTi[5]);
                                String AcNo=acctb.getText();
                                AcNo=acc_No_hider(AcNo);
                                ImageIcon icon = new ImageIcon(MyPath+"ATM\\src\\ISVAO\\LogIn.png");
                                JButton kk = new JButton("<html><h2>&nbsp&nbsp&nbsp&nbsp OK &nbsp&nbsp&nbsp&nbsp</h2></html>");
                                button_hover(kk);
                                kk.addActionListener(new ActionListener() 
                                 {
                                @Override
                                public void actionPerformed(ActionEvent actionEvent) 
                                    {
                                        click_sound();
                                        jf.getContentPane().removeAll();
                                        jf.repaint();
                                        new MainMenu().MainMenuP();
                                        JOptionPane.getRootFrame().dispose();
                                    }
                                });
                                JButton bs[]={kk};
                                int ch=JOptionPane.showOptionDialog(null,("<html><h1>Sucessfully Logged In as "+AcNo+"</h1></html>").toUpperCase() ,("LogIn Sucessfull").toUpperCase(),JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE, icon,bs,null); 
                                if(ch==JOptionPane.CLOSED_OPTION)
                                {
                                        jf.getContentPane().removeAll();
                                        jf.repaint();
                                        new MainMenu().MainMenuP();
                                        JOptionPane.getRootFrame().dispose();
                                }
                            }
                            else
                            {
                                JButton kk = new JButton("<html><h2>&nbsp&nbsp&nbsp&nbsp OK &nbsp&nbsp&nbsp&nbsp</h2></html>");
                                button_hover(kk);
                                kk.addActionListener(new ActionListener() 
                                 {
                                @Override
                                public void actionPerformed(ActionEvent actionEvent) 
                                    {
                                        click_sound();
                                        JOptionPane.getRootFrame().dispose();
                                    }
                                });
                                JButton bs[]={};
                                JOptionPane.showOptionDialog(null,("<html><h1>Invalid Pin</h1></html>").toUpperCase() ,("Pin validation").toUpperCase(),JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE, null,bs,null); 
                            }
                       }
                       else
                       {
                           JButton kk = new JButton("<html><h2>&nbsp&nbsp&nbsp&nbsp OK &nbsp&nbsp&nbsp&nbsp</h2></html>");
                                button_hover(kk);
                                kk.addActionListener(new ActionListener() 
                                 {
                                @Override
                                public void actionPerformed(ActionEvent actionEvent) 
                                    {
                                        click_sound();
                                        JOptionPane.getRootFrame().dispose();
                                    }
                                });
                                JButton bs[]={};
                                JOptionPane.showOptionDialog(null,("<html><h1>PLEASE ENTER A PIN</h1></html>").toUpperCase() ,("Pin validation").toUpperCase(),JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE, null,bs,null); 
                       }
                    }
                    else
                    {
                        JButton kk = new JButton("<html><h2>&nbsp&nbsp&nbsp&nbsp OK &nbsp&nbsp&nbsp&nbsp</h2></html>");
                                button_hover(kk);
                                kk.addActionListener(new ActionListener() 
                                 {
                                @Override
                                public void actionPerformed(ActionEvent actionEvent) 
                                    {
                                        click_sound();
                                        JOptionPane.getRootFrame().dispose();
                                    }
                                });
                                JButton bs[]={kk};
                                JOptionPane.showOptionDialog(null,("<html><h1>Invalid Account Number</h1></html>").toUpperCase(),("ACCOunt validation").toUpperCase(),JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE, null,bs,null);
                    }
                 }
                 else
                 {
                             JButton kk = new JButton("<html><h2>&nbsp&nbsp&nbsp&nbsp OK &nbsp&nbsp&nbsp&nbsp</h2></html>");
                                button_hover(kk);
                                kk.addActionListener(new ActionListener() 
                                 {
                                @Override
                                public void actionPerformed(ActionEvent actionEvent) 
                                    {
                                        click_sound();
                                        JOptionPane.getRootFrame().dispose();
                                    }
                                });
                                JButton bs[]={};
                                JOptionPane.showOptionDialog(null,("<html><h1>Please Enter The Account Number</h1></html>").toUpperCase(),("ACCOunt validation").toUpperCase(),JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE, null,bs,null);
                 }
                    
                logIn.repaint();
                jp.repaint();        
                    
                
            }
        });
    jp.add(logIn);
    jp.repaint();
    jf.repaint();
    
    }
    
}
