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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import vm_custom_gui.VM_ImagePanel;

public class InformationPanel extends ReUsable_Codes
{
    protected void InformationP()
    {
        jf.setVisible(true);
        jf.setLayout(null);
        jf.setSize(1152,668);
        jf.setTitle("STATE BANK -DEPOSIT MONEY");
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
        
        
        JTextArea ta=new JTextArea(100,5);
        ta.setFont(new Font("Arial",Font.PLAIN,40));
        JScrollPane spp = new JScrollPane(ta);
        spp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        spp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        spp.setBounds(20, 20, 1020,360);
        ta.setEnabled(false);
        ta.append("Account Number : "+Account_Number+"\n\n");
        ta.append("Gender : "+get_custumer_details(8,Account_Number)+"\n\n");
        ta.append("First Name : "+FN+"\n\n");
        ta.append("Last Name : "+LN+"\n\n");
        ta.append("Age : "+get_custumer_details(21,Account_Number)+"\n\n");
        ta.append("Address : "+get_custumer_details(13,Account_Number)+",\n");
        ta.append("                 "+get_custumer_details(14,Account_Number)+",\n");
        ta.append("                 "+get_custumer_details(15,Account_Number)+",\n");
        ta.append("                 "+get_custumer_details(16,Account_Number)+".\n\n");
        ta.append("Email ID : "+get_custumer_details(17,Account_Number)+"\n\n");
        ta.append("Current Balance : "+get_custumer_details(6,Account_Number)+"\n\n");
        jp.add(spp);
        
        jp.repaint();
        JButton logout=new JButton("OK");
        logout.setBounds(355,395,350,60);
        logout.setFont(new Font("Arial",Font.BOLD,30));
        logout.setBorder(BorderFactory.createBevelBorder(0));
        logout.setForeground(Color.WHITE);
        logout.setBackground(Color.decode("#4F81BD"));
        logout.setToolTipText("");
        jp.add(logout);
        button_hover(logout);
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
    }
    
}
