package christ.university.management.system;

import static java.awt.Color.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class EnterMarks extends JFrame implements ActionListener {
    JLabel heading,heading1,se,su,em;
    JTextField s1,s2,s3,s4,s5,m1,m2,m3,m4,m5;
    Choice crollno;
    JComboBox smc;
    JButton submit,cancel;
    EnterMarks(){
      setSize(900,500);
      setLocation(300,150);
      setLayout(null);
      getContentPane().setBackground(WHITE);
      ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("icon/cu4.jpg"));
        Image i1= i.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i2= new ImageIcon(i1);
        JLabel image = new JLabel(i2);
        image.setBounds(500,40,400,300);
        add(image);
      
        heading = new JLabel("Enter Marks of Student");
        heading.setBounds(50, 0, 500, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        heading1 = new JLabel("Select Roll Number");
        heading1.setBounds(50, 70, 150, 20);
        add(heading1);

        crollno = new Choice();
        crollno.setBounds(200, 70, 150, 20);
        add(crollno);
        try {
            Conn con = new Conn();
            ResultSet rs = con.s.executeQuery("Select * from student");
            while (rs.next()) {
                crollno.add(rs.getString("roll_number"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        se = new JLabel("Select Semester");
        se.setBounds(50, 110, 150, 20);
        add(se);
        
        String smcs[]={"select new","1st","2nd","3rd","4th","5th","6th","7th","8th"};
        smc = new JComboBox(smcs);
        smc.setBounds(200,110,150,20);
        smc.setBackground(WHITE);
        add(smc);
        
        su = new JLabel("Subject");
        su.setBounds(100, 150, 200, 40);
        add(su);

        em = new JLabel("Enter Marks");
        em.setBounds(320, 150, 200, 40);
        add(em);
        
        s1=new JTextField();
        s1.setBounds(50,200,200,20);
        add(s1);
        
        s2=new JTextField();
        s2.setBounds(50,230,200,20);
        add(s2);
        
        s3=new JTextField();
        s3.setBounds(50,260,200,20);
        add(s3);
        
        s4=new JTextField();
        s4.setBounds(50,290,200,20);
        add(s4);
        
        s5=new JTextField();
        s5.setBounds(50,320,200,20);
        add(s5);
        
        m1=new JTextField();
        m1.setBounds(250,200,200,20);
        add(m1);
        
        m2=new JTextField();
        m2.setBounds(250,230,200,20);
        add(m2);
        
        m3=new JTextField();
        m3.setBounds(250,260,200,20);
        add(m3);
        
        m4=new JTextField();
        m4.setBounds(250,290,200,20);
        add(m4);
        
        m5=new JTextField();
        m5.setBounds(250,320,200,20);
        add(m5);
        
        submit = new JButton("Submit");
        submit.setBounds(70, 360, 150, 25);
        submit.setBackground(BLACK);
        submit.setForeground(WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("serif", Font.BOLD, 20));
        add(submit);

        cancel = new JButton("Back");
        cancel.setBounds(280, 360, 150, 25);
        cancel.setBackground(BLACK);
        cancel.setForeground(WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("serif", Font.BOLD, 20));
        add(cancel);
        
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==submit){
           String rn=(String) crollno.getSelectedItem();
           String smc1=(String) smc.getSelectedItem();
           String ss1 = s1.getText();
           String ss2 = s2.getText();
           String ss3=s3.getText();
           String ss4 = s4.getText();
           String ss5=s5.getText();
           String mm1=m1.getText();
           String mm2=m2.getText();
           String mm3=m3.getText();
           String mm4=m4.getText();
           String mm5=m5.getText();
           
           try{
               String query = "Insert into entermarks values('"+rn+"','"+smc1+"','"+ss1+"','"+ss2+"','"+ss3+"','"+ss4+"','"+ss5+"','"+mm1+"','"+mm2+"','"+mm3+"','"+mm4+"','"+mm5+"');";
               Conn con=new Conn();
               con.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "Inserted succesfully");
               setVisible(false);
           }
           catch(Exception e){
               e.printStackTrace();
           }
       } 
       else{
           setVisible(false);
       }
    }
    public static void main(String[] args){
       new EnterMarks();
    }
}
