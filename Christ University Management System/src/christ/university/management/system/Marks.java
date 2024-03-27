/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package christ.university.management.system;

import java.awt.*;
import javax.swing.*;
//import java.awt.event.*;
import java.sql.*;

public class Marks extends JFrame{
    JLabel heading,Sheading,RN,S,S1,S2,S3,S4,S5,M1,M2,M3,M4,M5,S11;
    String rollno;
    Marks(String rollno){
      this.rollno=rollno;
      setSize(500,600);
      setLocation(500,100);
      setLayout(null);
      
      heading = new JLabel("CHRIST UNIVERSITY");
      heading.setBounds(100, 10, 500, 25);
      heading.setFont(new Font("Tahoma", Font.BOLD, 20));
      add(heading);
      
      Sheading = new JLabel("RESULT OF EXAMINATION 2024");
      Sheading.setBounds(100, 50, 500, 20);
      Sheading.setFont(new Font("Tahoma", Font.BOLD, 20));
      add(Sheading);
      
      RN = new JLabel("ROLL NUMBER: "+rollno);
      RN.setBounds(60, 100, 500, 20);
      RN.setFont(new Font("Tahoma", Font.PLAIN, 16));
      add(RN);
      
      S = new JLabel("SEMESTER: ");
      S.setBounds(60, 130, 500, 20);
      S.setFont(new Font("Tahoma", Font.PLAIN, 16));
      add(S);
      
      S11 = new JLabel();
      S11.setBounds(200, 130, 500, 20);
      S11.setFont(new Font("Tahoma", Font.PLAIN, 16));
      add(S11);
      
      S1 = new JLabel();
      S1.setBounds(100, 200, 500, 20);
      S1.setFont(new Font("Tahoma", Font.PLAIN, 16));
      add(S1);
      
      S2 = new JLabel();
      S2.setBounds(100, 230, 500, 20);
      S2.setFont(new Font("Tahoma", Font.PLAIN, 16));
      add(S2);
      
      S3 = new JLabel();
      S3.setBounds(100, 260, 500, 20);
      S3.setFont(new Font("Tahoma", Font.PLAIN, 16));
      add(S3);
      
      S4 = new JLabel();
      S4.setBounds(100, 290, 500, 20);
      S4.setFont(new Font("Tahoma", Font.PLAIN, 16));
      add(S4);
      
      S5 = new JLabel();
      S5.setBounds(100, 320, 500, 20);
      S5.setFont(new Font("Tahoma", Font.PLAIN, 16));
      add(S5);
      
      M1 = new JLabel();
      M1.setBounds(200, 200, 500, 20);
      M1.setFont(new Font("Tahoma", Font.PLAIN, 16));
      add(M1);
      
      M2 = new JLabel();
      M2.setBounds(200, 230, 500, 20);
      M2.setFont(new Font("Tahoma", Font.PLAIN, 16));
      add(M2);
      
      M3 = new JLabel();
      M3.setBounds(200, 260, 500, 20);
      M3.setFont(new Font("Tahoma", Font.PLAIN, 16));
      add(M3);
      
      M4 = new JLabel();
      M4.setBounds(200, 290, 500, 20);
      M4.setFont(new Font("Tahoma", Font.PLAIN, 16));
      add(M4);
      
      M5 = new JLabel();
      M5.setBounds(200, 320, 500, 20);
      M5.setFont(new Font("Tahoma", Font.PLAIN, 16));
      add(M5);
      
      try{
         Conn con = new Conn();
         ResultSet rs = con.s.executeQuery("Select * from entermarks where roll_no = '"+rollno+"';");
         while(rs.next()){
             S1.setText(rs.getString("s1"));
             S2.setText(rs.getString("s2"));
             S3.setText(rs.getString("s3"));
             S4.setText(rs.getString("s4"));
             S5.setText(rs.getString("s5"));
             M1.setText(rs.getString("m1"));
             M2.setText(rs.getString("m2"));
             M3.setText(rs.getString("m3"));
             M4.setText(rs.getString("m4"));
             M5.setText(rs.getString("m5"));
             S11.setText(rs.getString("sem"));
         }
      }
    catch(Exception e){
        e.printStackTrace();
    }
      setVisible(true);
    }
    public static void main(String[] args){
       new Marks("");
    }
}
