
package christ.university.management.system;

import java.awt.Font;
import javax.swing.*;
import java.awt.Choice;
import static java.awt.Color.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateTeacher extends JFrame implements ActionListener{
    JLabel heading,heading1,name,f,n,fn,roll,rn,dob,dcob,add,Mn,em,x,xii,adh,adhn,co,g,gc,c;
    JTextField addn,mn,emn,xiin,tfx;
    Choice crollno;
    JButton submit,cancel;
    UpdateTeacher(){
        setSize(900,650);
        setLocation(350,50);
        setLayout(null);
        
        heading=new JLabel("Update Faculty Details");
        heading.setBounds(50,10,500,50);
        heading.setFont(new Font("Tahoma", Font.ITALIC,35));
        add(heading);
        
        heading1= new JLabel("Select Faculty ID");
        heading1.setBounds(50,100,200,20);
        heading1.setFont(new Font("serif", Font.PLAIN,20));
        add(heading1);
        
        crollno = new Choice();
        crollno.setBounds(250,100,200,20);
        add(crollno);
        try{
            Conn con = new Conn();
            ResultSet rs = con.s.executeQuery("Select * from teacher");
            while(rs.next()){
                crollno.add(rs.getString("faculty_id"));
            }
           
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        name=new JLabel("Name");
        name.setBounds(50,150,100,30);
        name.setFont(new Font("serif", Font.BOLD,20));
        add(name);
        
        n=new JLabel();
        n.setBounds(200,150,100,30);
        n.setFont(new Font("serif", Font.PLAIN,20));
        add(n);
        
        f=new JLabel("Father's Name");
        f.setBounds(400,150,200,30);
        f.setFont(new Font("serif", Font.BOLD,20));
        add(f);
        
        fn=new JLabel();
        fn.setBounds(600,150,100,30);
        fn.setFont(new Font("serif", Font.PLAIN,20));
        add(fn);
        
        roll=new JLabel("Faculty ID");
        roll.setBounds(50,200,200,30);
        roll.setFont(new Font("serif", Font.BOLD,20));
        add(roll);
        
        rn=new JLabel();
        rn.setBounds(200,200,200,30);
        rn.setFont(new Font("serif", Font.PLAIN,20));
        add(rn);
        
        dob=new JLabel("Date Of Birth");
        dob.setBounds(400,200,200,30);
        dob.setFont(new Font("serif", Font.BOLD,20));
        add(dob);
        
        dcob = new JLabel();
        dcob.setBounds(600,200,150,30);
        dcob.setFont(new Font("serif", Font.PLAIN,20));
        add(dcob);
        
        add=new JLabel("Address");
        add.setBounds(50,250,200,30);
        add.setFont(new Font("serif", Font.BOLD,20));
        add(add);
        
        addn=new JTextField();
        addn.setBounds(200,250,100,30);
        addn.setFont(new Font("serif", Font.PLAIN,20));
        add(addn);
        
        Mn=new JLabel("Mobile Number");
        Mn.setBounds(400,250,200,30);
        Mn.setFont(new Font("serif", Font.BOLD,20));
        add(Mn);
        
        mn=new JTextField();
        mn.setBounds(600,250,100,30);
        mn.setFont(new Font("serif", Font.PLAIN,20));
        add(mn);
        
        em=new JLabel("Email");
        em.setBounds(50,300,200,30);
        em.setFont(new Font("serif", Font.BOLD,20));
        add(em);
        
        emn=new JTextField();
        emn.setBounds(200,300,100,30);
        emn.setFont(new Font("serif", Font.PLAIN,20));
        add(emn);
        
        x=new JLabel("Qualification");
        x.setBounds(400,300,200,30);
        x.setFont(new Font("serif", Font.BOLD,20));
        add(x);
        
        tfx=new JTextField();
        tfx.setBounds(600,300,100,30);
        tfx.setFont(new Font("serif", Font.PLAIN,20));
        add(tfx);
        
        xii=new JLabel("Salary");
        xii.setBounds(50,350,200,30);
        xii.setFont(new Font("serif", Font.BOLD,20));
        add(xii);
        
        xiin=new JTextField();
        xiin.setBounds(200,350,100,30);
        xiin.setFont(new Font("serif", Font.PLAIN,20));
        add(xiin);
        
        adh=new JLabel("Aadhar Number");
        adh.setBounds(400,350,200,30);
        adh.setFont(new Font("serif", Font.BOLD,20));
        add(adh);
        
        adhn=new JLabel();
        adhn.setBounds(600,350,100,30);
        adhn.setFont(new Font("serif", Font.PLAIN,20));
        add(adhn);

        co=new JLabel("Department");
        co.setBounds(50,400,200,30);
        co.setFont(new Font("serif", Font.BOLD,20));
        add(co);
        
        c = new JLabel();
        c.setBounds(200,400,150,30);
        c.setFont(new Font("serif", Font.PLAIN,20));
        add(c);
        setVisible(true);
        
        g=new JLabel("Gender");
        g.setBounds(400,400,200,30);
        g.setFont(new Font("serif", Font.BOLD,20));
        add(g);
        
        gc = new JLabel();
        gc.setBounds(600,400,150,30);
        gc.setFont(new Font("serif", Font.PLAIN,20));
        add(gc);
        setVisible(true);
        
       
        crollno.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
             try{
            Conn con = new Conn();
            String query= "Select * from teacher where faculty_id = '"+crollno.getSelectedItem()+"';";
            ResultSet rs = con.s.executeQuery(query);
            while(rs.next()){
                n.setText(rs.getString("name"));
                fn.setText(rs.getString("father_name"));
                rn.setText(rs.getString("faculty_id"));
                dcob.setText(rs.getString("dob"));
                addn.setText(rs.getString("address"));
                mn.setText(rs.getString("phone"));
                emn.setText(rs.getString("email"));
                tfx.setText(rs.getString("Qualification"));
                xiin.setText(rs.getString("salary"));
                adhn.setText(rs.getString("aadhar"));
                c.setText(rs.getString("deaprtment"));                
                gc.setText(rs.getString("gender"));
            }
           
        }
        catch(Exception e){
            e.printStackTrace();
        }   
            }
    });
        submit = new JButton("Update");
        submit.setBounds(250,500,120,30);
        submit.setBackground(BLACK);
        submit.setForeground(WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("serif", Font.BOLD,20));
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(450,500,120,30);
        cancel.setBackground(BLACK);
        cancel.setForeground(WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("serif", Font.BOLD,20));
        add(cancel);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== submit){
           String roll=rn.getText();
           String addname = addn.getText();
           String mobilenum=mn.getText();
           String emailid=emn.getText();
           String tfx1= tfx.getText();
           String xiin1= xiin.getText();
           try{
               String query = "update teacher set address='"+addname+"',phone='"+mobilenum+"',email='"+emailid+"',Qualification='"+tfx1+"',salary ='"+xiin1+"' where faculty_id = '"+roll+"';";
               Conn con =new Conn();
               con.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "Updated succesfully");
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
       new UpdateTeacher();
    }
}
