package christ.university.management.system;

import com.toedter.calendar.JDateChooser;
import static java.awt.Color.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class StudentLeave extends JFrame implements ActionListener{
    JLabel heading1,heading,datef,datet,duration;
    JTextField durationw;
    Choice crollno;
    JDateChooser from,to;
    JButton submit,cancel;
    StudentLeave(){
        setSize(600,600);
        setLocation(550,100);
        setLayout(null);
        getContentPane().setBackground(LIGHT_GRAY);
        
        heading1 = new JLabel("APPLY LEAVE: STUDENT");
        heading1.setBounds(140,50,500,40);
        heading1.setFont(new Font("Tahoma", Font.BOLD,20 ));
        add(heading1);
        
        heading= new JLabel("Search By Roll Number");
        heading.setBounds(60,130,200,20);
        heading.setFont(new Font("Tahoma", Font.BOLD,10 ));
        add(heading);
        
        crollno = new Choice();
        crollno.setBounds(60,150,150,20);
        add(crollno);
        try{
            Conn con = new Conn();
            ResultSet rs = con.s.executeQuery("Select * from student");
            while(rs.next()){
                crollno.add(rs.getString("roll_number"));
            }
           
        }
        catch(Exception e){
            e.printStackTrace();
        }
        datef= new JLabel("From: ");
        datef.setBounds(40,180,150,20);
        datef.setFont(new Font("Tahoma", Font.BOLD,10 ));
        add(datef);
        
        from = new JDateChooser();
        from.setBounds(100,180,150,20);
        add(from);
        
        datet= new JLabel("To: ");
        datet.setBounds(300,180,150,20);
        datet.setFont(new Font("Tahoma", Font.BOLD,10 ));
        add(datet);
        
        to = new JDateChooser();
        to.setBounds(360,180,150,20);
        add(to);
        
        duration= new JLabel("Duration (no of days)");
        duration.setBounds(170,300,150,20);
        duration.setFont(new Font("Tahoma", Font.BOLD,10 ));
        add(duration);
        
        durationw= new JTextField();
        durationw.setBounds(300,300,150,20);
        add(durationw);
        
        submit = new JButton("Submit");
        submit.setBounds(150,400,120,30);
        submit.setBackground(BLACK);
        submit.setForeground(WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("serif", Font.BOLD,20));
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(300,400,120,30);
        cancel.setBackground(BLACK);
        cancel.setForeground(WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("serif", Font.BOLD,20));
        add(cancel);
        
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== submit){
           String crollno1= crollno.getSelectedItem();
           String dcob1 = ((JTextField) from.getDateEditor().getUiComponent()).getText();
           String dcob2 = ((JTextField) to.getDateEditor().getUiComponent()).getText();
           String nod = durationw.getText();
           String query = "Insert into studentleave values('"+crollno1+"','"+dcob1+"','"+dcob2+"','"+nod+"');";
           try{
               Conn con =new Conn();
               con.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "Leave initiated!!");
               setVisible(false);
           }
           catch(Exception e){
              e.printStackTrace();
           }
        }
        else if(ae.getSource()==cancel);
        {
            setVisible(false);
        }
}
public static void main(String[] args){
        new StudentLeave();
    }    
}
