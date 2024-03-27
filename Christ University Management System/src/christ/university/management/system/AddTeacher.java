
package christ.university.management.system;

import java.awt.Font;
import java.util.Random;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import static java.awt.Color.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddTeacher extends JFrame implements ActionListener{
    JLabel heading,name,f,roll,rn,dob,add,Mn,em,x,xii,adh,co,g;
    JTextField n,fn,addn,mn,emn,tfx,xiin,adhn;
    JDateChooser dcob;
    JComboBox c,gc;
    JButton submit,cancel;
    Random ram=new Random();
    long first4 = Math.abs((ram.nextLong() % 9000) + 1000L);
    AddTeacher(){
        setSize(900,700);
        setLocation(350,50);
        setLayout(null);
        heading=new JLabel("Faculty Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif", Font.BOLD,30));
        add(heading);
        
        name=new JLabel("Name");
        name.setBounds(50,150,100,30);
        name.setFont(new Font("serif", Font.BOLD,20));
        add(name);
        
        n=new JTextField();
        n.setBounds(200,150,100,30);
        add(n);
        
        f=new JLabel("Father's Name");
        f.setBounds(400,150,200,30);
        f.setFont(new Font("serif", Font.BOLD,20));
        add(f);
        
        fn=new JTextField();
        fn.setBounds(600,150,100,30);
        add(fn);
        
        roll=new JLabel("Faculty ID");
        roll.setBounds(50,200,200,30);
        roll.setFont(new Font("serif", Font.BOLD,20));
        add(roll);
        
        rn=new JLabel("101"+first4);
        rn.setBounds(200,200,200,30);
        rn.setFont(new Font("serif", Font.BOLD,20));
        add(rn);
        
        dob=new JLabel("Date Of Birth");
        dob.setBounds(400,200,200,30);
        dob.setFont(new Font("serif", Font.BOLD,20));
        add(dob);
        
        dcob = new JDateChooser();
        dcob.setBounds(600,200,150,30);
        add(dcob);
        
        add=new JLabel("Address");
        add.setBounds(50,250,200,30);
        add.setFont(new Font("serif", Font.BOLD,20));
        add(add);
        
        addn=new JTextField();
        addn.setBounds(200,250,100,30);
        add(addn);
        
        Mn=new JLabel("Mobile Number");
        Mn.setBounds(400,250,200,30);
        Mn.setFont(new Font("serif", Font.BOLD,20));
        add(Mn);
        
        mn=new JTextField();
        mn.setBounds(600,250,100,30);
        add(mn);
        
        em=new JLabel("Email");
        em.setBounds(50,300,200,30);
        em.setFont(new Font("serif", Font.BOLD,20));
        add(em);
        
        emn=new JTextField();
        emn.setBounds(200,300,100,30);
        add(emn);
        
        x=new JLabel("Qualification");
        x.setBounds(400,300,200,30);
        x.setFont(new Font("serif", Font.BOLD,20));
        add(x);
        
        tfx=new JTextField();
        tfx.setBounds(600,300,100,30);
        add(tfx);
        
        xii=new JLabel("Salary");
        xii.setBounds(50,350,200,30);
        xii.setFont(new Font("serif", Font.BOLD,20));
        add(xii);
        
        xiin=new JTextField();
        xiin.setBounds(200,350,100,30);
        add(xiin);
        
        adh=new JLabel("Aadhar Number");
        adh.setBounds(400,350,200,30);
        adh.setFont(new Font("serif", Font.BOLD,20));
        add(adh);
        
        adhn=new JTextField();
        adhn.setBounds(600,350,100,30);
        add(adhn);

        co=new JLabel("Department");
        co.setBounds(50,400,200,30);
        co.setFont(new Font("serif", Font.BOLD,20));
        add(co);
        
        String course[]={"select new","Computer Science","Management","Psychology","Electrical","Electronics and communication","Mechanical","Civil"};
        c = new JComboBox(course);
        c.setBounds(200,400,150,30);
        c.setBackground(WHITE);
        add(c);
        setVisible(true);
        
        g=new JLabel("Gender");
        g.setBounds(400,400,200,30);
        g.setFont(new Font("serif", Font.BOLD,20));
        add(g);
        
        String gender[]={"select new","Male","Female","transgender"};
        gc = new JComboBox(gender);
        gc.setBounds(600,400,150,30);
        gc.setBackground(WHITE);
        add(gc);
        setVisible(true);
        
        submit = new JButton("Submit");
        submit.setBounds(250,550,120,30);
        submit.setBackground(BLACK);
        submit.setForeground(WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("serif", Font.BOLD,20));
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(450,550,120,30);
        cancel.setBackground(BLACK);
        cancel.setForeground(WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("serif", Font.BOLD,20));
        add(cancel);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== submit){
           String name = n.getText();
           String fname = fn.getText();
           String rollnumber=rn.getText();
           String dcob1 = ((JTextField) dcob.getDateEditor().getUiComponent()).getText();
           String addname = addn.getText();
           String mobilenum=mn.getText();
           String emailid=emn.getText();
           String xmarks=tfx.getText();
           String xiimarks=xiin.getText();
           String aadhar=adhn.getText();
           String courses=(String) c.getSelectedItem();
           String genders=(String) gc.getSelectedItem();
           try{
               String query = "Insert into teacher values('"+name+"','"+fname+"','"+rollnumber+"','"+dcob1+"','"+addname+"','"+mobilenum+"','"+emailid+"','"+xmarks+"','"+xiimarks+"','"+aadhar+"','"+courses+"','"+genders+"');";
               Conn con =new Conn();
               con.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "Inserted succesfully");
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
        AddTeacher ad=new AddTeacher();
    }
}
