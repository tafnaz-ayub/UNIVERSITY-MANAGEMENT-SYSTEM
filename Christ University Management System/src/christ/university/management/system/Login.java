package christ.university.management.system;
import static java.awt.Color.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton login,cancel;
    JTextField ui;
    JPasswordField pw;
    Login(){
        getContentPane().setBackground(WHITE);
        setLayout(null); 
        
        JLabel un = new JLabel("USERNAME");
        un.setBounds(40,20,100,20);
        add(un);
        ui=new JTextField();
        ui.setBounds(150,20,150,20);
        add(ui);
        
        JLabel upw = new JLabel("PASSWORD");
        upw.setBounds(40,70,100,20);
        add(upw);
        pw=new JPasswordField();
        pw.setBounds(150,70,150,20);
        add(pw);
        
        login=new JButton("LOGIN");
        login.setBounds(40,140,120,30);
        login.setBackground(BLACK);
        login.setForeground(WHITE);
        login.addActionListener(this);
        login.setFont(new Font("Tahoma",Font.BOLD,15));
        add(login);
        
        cancel=new JButton("CANCEL");
        cancel.setBounds(180,140,120,30);
       cancel.setBackground(BLACK);
        cancel.setForeground(WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
        add(cancel); 
        
         ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("icon/cu2.jpg"));
        Image i1= i.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i2= new ImageIcon(i1);
        JLabel image = new JLabel(i2);
        image.setBounds(350,0,200,200);
        add(image);
        
        setSize(600,300);
        setLocation(500,250);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==login){
        String username = ui.getText();
        String password = pw.getText();
        String query= "select * from login where username='"+username+"'and password='"+password+"';";
        try{
            Conn conn =new Conn();
            ResultSet rs=conn.s.executeQuery(query);
             if(rs.next()){
               setVisible(false); 
               Project p= new Project();
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                setVisible(false);
            }
             //c.s.close();
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
        Login l= new Login();
    }
}
