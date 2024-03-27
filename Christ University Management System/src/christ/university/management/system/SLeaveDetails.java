package christ.university.management.system;

import java.sql.*;
import java.awt.*;
import static java.awt.Color.*;
import java.awt.event.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class SLeaveDetails extends JFrame implements ActionListener{
    JLabel heading;
    Choice crollno;
    JTable table; 
    JButton search,print,cancel;
    SLeaveDetails(){
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
            ResultSet rs = con.s.executeQuery("Select * from studentleave");
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
            ResultSet rs = con.s.executeQuery("Select * from studentleave");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);
        
        search = new JButton("SEARCH");
        search.setBounds(20,70,100,20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("PRINT");
        print.setBounds(120,70,100,20);
        print.addActionListener(this);
        add(print);
        
        cancel = new JButton("CANCEL");
        cancel.setBounds(220,70,100,20);
        cancel.addActionListener(this);
        add(cancel);
        
        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== search){
           String query="select * from studentleave where roll_number='"+crollno.getSelectedItem()+"';";
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
        else if(ae.getSource()==cancel){
            setVisible(false);
        }
}
    public static void main(String[] args){
        new SLeaveDetails();
    }
}
