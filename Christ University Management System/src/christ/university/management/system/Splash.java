package christ.university.management.system;
import java.awt.Image;
import javax.swing.*;

public class Splash extends JFrame implements Runnable{
    Thread t;
    int j,x;
    Splash(){
        ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("icon/cu1.jpg"));
        Image i1= i.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        ImageIcon i2= new ImageIcon(i1);
        JLabel image = new JLabel(i2);
        add(image);
        t=new Thread(this);
        t.start();
        setVisible(true); 
        for(j=2;j<=600;j+=4,x+=1){
        setLocation(600 -((j+x)/2),350-(j/2));
        setSize(j + 2*x,j+x/2);
        try{
            Thread.sleep(10);
        }
        catch(Exception e){ 
        }
        }
    }
    @Override
    public void run(){
       try{
           Thread.sleep(7000);
           setVisible(false);
           new Login();
       } 
       catch(Exception e){
           
       }
    }
  
    public static void main(String[] args){
        Splash s = new Splash();
        
    }
}