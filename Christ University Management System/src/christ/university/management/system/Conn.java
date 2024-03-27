
package christ.university.management.system;
import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
Conn(){
    try{
       Class.forName("com.mysql.cj.jdbc.Driver");//REGISTER THE DRIVER CLASS 
       c = DriverManager.getConnection("jdbc:mysql:///christuniversitymanagementsystem","root","654321");
       s=c.createStatement();
    }
    
    catch(Exception e){
        e.printStackTrace();
    } 
}
}
