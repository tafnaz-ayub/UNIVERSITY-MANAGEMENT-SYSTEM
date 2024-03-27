package christ.university.management.system;

import java.sql.*;
import java.awt.*;
import static java.awt.Color.*;
import java.awt.event.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class StudentDetails extends JFrame implements ActionListener{
    JLabel heading;
    Choice crollno;
    JTable table; 
    JButton search,print,update,add,cancel;
    StudentDetails(){
        getContentPane().setBackground(PINK);
        setLayout(null);
        
        heading= new JLabel("Search By Roll Number");
        heading.setBounds(20,20,150,20);
        add(heading);
        
        crollno = new Choice();
        crollno.setBounds(180,20,150,20);
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
        table= new JTable();
        try{
            Conn con = new Conn();
            ResultSet rs = con.s.executeQuery("Select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);
        
        search = new JButton("SEARCH");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("PRINT");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);
        
        add = new JButton("ADD");
        add.setBounds(220,70,80,20);
        add.addActionListener(this);
        add(add);
        
        update = new JButton("UPDATE");
        update.setBounds(320,70,80,20);
        update.addActionListener(this);
        add(update);
        
        cancel = new JButton("CANCEL");
        cancel.setBounds(420,70,80,20);
        cancel.addActionListener(this);
        add(cancel);
        
        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== search){
           String query="select * from student where roll_number='"+crollno.getSelectedItem()+"';";
           try{
               Conn con=new Conn();
              ResultSet rs= con.s.executeQuery(query);
               table.setModel(DbUtils.resultSetToTableModel(rs));
           }
           catch(Exception e){
              e.printStackTrace();
           }
        }
        else if(ae.getSource()== print){
            try{
               table.print();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==add){
            setVisible(false);
            new AddStudent();
        }
        else if(ae.getSource()== update){
            setVisible(false);
            new UpdateStudent();
        }
        else if(ae.getSource()==cancel){
            setVisible(false);
        }
}
    public static void main(String[] args){
        new StudentDetails();
    }
}
