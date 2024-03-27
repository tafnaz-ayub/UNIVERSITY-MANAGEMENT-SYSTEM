/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package christ.university.management.system;

import static java.awt.Color.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class ExamDetails extends JFrame implements ActionListener{
    JLabel heading;
    JTextField search;
    JButton submit,cancel;
    JTable table;
ExamDetails(){
    setSize(900,475);
    setLocation(300,100);
    setLayout(null);
      getContentPane().setBackground(WHITE);
      heading = new JLabel("Check Reuslts");
        heading.setBounds(80, 15, 400, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        add(heading);
        
        search=new JTextField();
        search.setBounds(80,90,200,30);
        search.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(search);
        
        submit = new JButton("Result");
        submit.setBounds(300, 90, 120, 35);
        submit.setBackground(BLACK);
        submit.setForeground(WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("serif", Font.BOLD, 20));
        add(submit);

        cancel = new JButton("Back");
        cancel.setBounds(440, 90, 120, 35);
        cancel.setBackground(BLACK);
        cancel.setForeground(WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("serif", Font.BOLD, 20));
        add(cancel);
        
        table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 16));
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 130, 900, 310);
        add(jsp);
        
        try{
            Conn con = new Conn();
            ResultSet rs = con.s.executeQuery("Select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        table.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                int row = table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row, 2).toString());
            }
        });
        
    setVisible(true);
}  
@Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            setVisible(false);
           new Marks(search.getText());
        }
        else{
            setVisible(true);
        }
    }
public static void main(String[] args){
       new ExamDetails();
    }
}
