
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import vm_custom_gui.VM_ImagePanel;

public class BalanceTransferPanel extends ReUsable_Codes
{
    protected void BalanceTransferP()
    {
        jf.setVisible(true);
        jf.setLayout(null);
        jf.setSize(1152,668);
        jf.setTitle("STATE BANK -TRANSFER MONEY");
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
        JLabel user=new JLabel("<html>Enter Receiver's<br>Account Number: <html>");
        user.setBounds(75, 40, 400, 100);
        user.setFont(new Font("Rockwell",Font.BOLD,35));
        jp.add(user);
        jp.repaint();
        jf.repaint();
        
        try{
        JLabel acc_icon =new JLabel();
        acc_icon.setIcon(new ImageIcon(ImageIO.read(new File(MyPath+"ATM\\src\\ISVAO\\Acc.png"))));
        acc_icon.setBounds(390, 97,38,34);
        acc_icon.setBackground(Color.WHITE);
        acc_icon.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, Color.BLACK));
        acc_icon.setOpaque(true);
        jp.add(acc_icon,SwingConstants.CENTER);
        jf.repaint();
        }catch(Exception e){}
        
        JTextField acctb=new JTextField();
        acctb.setBounds(428, 97, 200,34);
        acctb.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.BLACK));
        acctb.setFont(new Font("Arial",Font.BOLD,22));
        only_numbers(acctb);
        jp.add(acctb);
        jp.repaint();
        jf.repaint();
        
        jp.repaint();
        JLabel amtl=new JLabel("<html>Enter An Amount: <html>");
        amtl.setBounds(76, 170, 400, 30);
        amtl.setFont(new Font("Rockwell",Font.BOLD,35));
        jp.add(amtl);
        jp.repaint();
        jf.repaint();
        
        try{
        JLabel am_icon =new JLabel();
        am_icon.setIcon(new ImageIcon(ImageIO.read(new File(MyPath+"ATM\\src\\ISVAO\\Am.png"))));
        am_icon.setBounds(390, 172,38,34);
        am_icon.setBackground(Color.WHITE);
        am_icon.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, Color.BLACK));
        am_icon.setOpaque(true);
        jp.add(am_icon,SwingConstants.CENTER);
        jf.repaint();
        }catch(Exception e){}
        
        JTextField amtb=new JTextField();
        amtb.setBounds(428, 172, 200,34);
        amtb.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.BLACK));
        amtb.setFont(new Font("Arial",Font.BOLD,25));
        only_numbers(amtb);
        jp.add(amtb);
        jp.repaint();
        jf.repaint();
        
        jp.repaint();
        JLabel rp=new JLabel("<html>Re-type Pin: <html>");
        rp.setBounds(169, 240, 400, 40);
        rp.setFont(new Font("Rockwell",Font.BOLD,35));
        jp.add(rp);
        jp.repaint();
        jf.repaint();
        
        try{
        JLabel pass_icon =new JLabel();
        pass_icon.setIcon(new ImageIcon(ImageIO.read(new File(MyPath+"ATM\\src\\ISVAO\\Pass.png"))));
        pass_icon.setBounds(390, 247,38,34);
        pass_icon.setBackground(Color.WHITE);
        pass_icon.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, Color.BLACK));
        pass_icon.setOpaque(true);
        jp.add(pass_icon,SwingConstants.CENTER);
        jf.repaint();
        }catch(Exception e){}
        
        
        JPasswordField pintb=new JPasswordField();
        pintb.setBounds(428,247, 200,34);
        pintb.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.BLACK));
        pintb.setFont(new Font("Arial",Font.BOLD,30));
        only_numbers(pintb);
        jp.add(pintb);
        jp.repaint();
        jf.repaint();
        
        jp.repaint();
        ImageIcon tf_icon = new ImageIcon(MyPath+"ATM\\src\\ISVAO\\Tf.png");
        JButton tfb=new JButton(" Transfer",tf_icon);
        tfb.setBounds(580, 370,350,60);
        tfb.setFont(new Font("Arial",Font.BOLD,30));
        tfb.setBorder(BorderFactory.createBevelBorder(0));
        tfb.setForeground(Color.WHITE);
        tfb.setBackground(Color.decode("#4F81BD"));
        tfb.setToolTipText("Transfer Money to Another Account");
        tfb.repaint();
        tfb.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                click_sound();
                if(!((acctb.getText().equals(""))||(amtb.getText().equals(""))||(pintb.getText().equals(""))))
                {
                    if(Acc_if_Exists(acctb.getText()))
                    {
                        if(!(Account_Number.equals(acctb.getText())))
                        {
                            int Amt_B_T=Integer.parseInt(get_custumer_details(6,Account_Number));
                            int Amt_T=Integer.parseInt(amtb.getText());
                        
                            if(Amt_T<=(Amt_B_T-1000))
                            {
                                if((pintb.getText()).equals(new vm_encryption.VM_Pin_Encryption().char_num(get_custumer_details(2,Account_Number))))
                                {
                                    JButton confirm = new JButton("<html><h2>&nbsp&nbsp&nbsp&nbsp Confirm &nbsp&nbsp&nbsp&nbsp</h2></html>");
                                    button_hover(confirm);
                                    confirm.addActionListener(new ActionListener() 
                                    {
                                        @Override
                                        public void actionPerformed(ActionEvent ae) 
                                        {
                                            click_sound();
                                            int Amt_A_T=Amt_B_T-Amt_T;
                                            int datTi[]=new int[6];
                                            String accrev=acctb.getText();
                                            int Amt_B_T_rev=Integer.parseInt(get_custumer_details(6,accrev));
                                            int Amt_A_T_rev=Amt_B_T_rev+Amt_T;
                                            datTi=VM_Date_Time();
                                            Insert_In_Transaction_Table(Account_Number,datTi[0],datTi[1],datTi[2], datTi[3], datTi[4], datTi[5], "Vile Parle(East)",57, "Transfered To",acctb.getText(), Amt_B_T,Amt_T, Amt_A_T);
                                            Insert_In_Transaction_Table(accrev,datTi[0],datTi[1],datTi[2], datTi[3], datTi[4], datTi[5], "Vile Parle(East)",57, "Received From",Account_Number, Amt_B_T_rev,Amt_T, Amt_A_T_rev);
                                            update_amt(Account_Number,Amt_A_T);
                                            update_amt(accrev, Amt_A_T_rev);
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
                                            
                                            JLabel Trans_t=new JLabel("TRANSFER TO",SwingConstants.LEFT);
                                            Trans_t.setFont(new Font("Arial Unicode MS",Font.BOLD,15));
                                            Trans_t.setForeground(Color.decode("#363636"));
                                            Trans_t.setBackground(Color.WHITE);
                                            Trans_t.setOpaque(true);
                                            Trans_t.setBounds(30,205,360,30);
                                            r_jp.add(Trans_t);
                                            r_jp.repaint();

                                            JLabel rev=new JLabel(acc_No_hider(accrev),SwingConstants.LEFT);
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
                                            
                                            JLabel sss=new JLabel("TRANSFER SUCCESSFUL",SwingConstants.CENTER);
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
                                    ImageIcon dpc_icon = new ImageIcon(MyPath+"ATM\\src\\ISVAO\\Tf.png");
                                    JOptionPane.showOptionDialog(null,("<html><h1>You Want to tranfer rs."+amtb.getText()+"<br>to account : "+acc_No_hider(acctb.getText())+"</h1></html>").toUpperCase(),("Transfer confirmation").toUpperCase(),JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE, dpc_icon,bs,null);
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
                                ImageIcon dpc_icon = new ImageIcon(MyPath+"ATM\\src\\ISVAO\\Tf.png");
                                JOptionPane.showOptionDialog(null,("<html><h1>Insufficient Amount in Your account: "+acc_No_hider(Account_Number)+"</h1></html>").toUpperCase(),("Withdrawal amount exceeded").toUpperCase(),JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE, dpc_icon,bs,null);
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
                            ImageIcon dpc_icon = new ImageIcon(MyPath+"ATM\\src\\ISVAO\\Tf.png");
                            JOptionPane.showOptionDialog(null,("<html><h1>SENDER'S account number and<br>receiver's account number cannot be same</h1></html>").toUpperCase(),("Withdrawal amount exceeded").toUpperCase(),JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE, dpc_icon,bs,null);
                        
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
                            ImageIcon dpc_icon = new ImageIcon(MyPath+"ATM\\src\\ISVAO\\Tf.png");
                            JOptionPane.showOptionDialog(null,("<html><h1>please Complete all the fields </h1></html>").toUpperCase(),("Empty Text").toUpperCase(),JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE, dpc_icon,bs,null);
                }
            }
        });
        jp.add(tfb);
        button_hover(tfb);
        
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
//
//    public static void main(String[] args) 
//    {
//        new BalanceTransferPanel().BalanceTransferP();
//    }

}