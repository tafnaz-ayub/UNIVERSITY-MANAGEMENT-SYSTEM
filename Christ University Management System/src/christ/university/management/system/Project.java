
package christ.university.management.system;

import java.awt.*;
import static java.awt.Color.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Project extends JFrame implements ActionListener{
    
        Project(){
          setSize(1540,850);
          
          ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("icon/cu3.png"));
        Image i1= i.getImage().getScaledInstance(1500, 750, Image.SCALE_DEFAULT);
        ImageIcon i2= new ImageIcon(i1);
        JLabel image = new JLabel(i2);
        add(image);
        
        JMenuBar mb= new JMenuBar();
        
        //new
        JMenu ni=new JMenu("NEW");
        ni.setForeground(BLUE);
        mb.add(ni);
        JMenuItem f = new JMenuItem("NEW FACULTY");
        f.setForeground(BLUE);
        f.addActionListener(this);
        ni.add(f);
        JMenuItem s = new JMenuItem("NEW STUDENT");
        s.setForeground(BLUE);
        s.addActionListener(this);
        ni.add(s);
        
        //deets
        JMenu d=new JMenu("DETAILS");
        d.setForeground(BLUE);
        mb.add(d);
        JMenuItem fd = new JMenuItem("FACULTY DETAILS");
        fd.setForeground(BLUE);
        fd.addActionListener(this);
        d.add(fd);
        JMenuItem sd = new JMenuItem("STUDENT DETAILS");
        sd.setForeground(BLUE);
        sd.addActionListener(this);
        d.add(sd);
        
        //Leave
        JMenu lv=new JMenu("APPLY LEAVE");
        lv.setForeground(BLUE);
        mb.add(lv);
        JMenuItem fl = new JMenuItem("FACULTY LEAVE");
        fl.setForeground(BLUE);
        fl.addActionListener(this);
        lv.add(fl);
        JMenuItem sl = new JMenuItem("STUDENT LEAVE");
        sl.setForeground(BLUE);
        sl.addActionListener(this);
        lv.add(sl);
        
        //Leave deets
        JMenu lvd=new JMenu("LEAVE DETAILS");
        lvd.setForeground(BLUE);
        mb.add(lvd);
        JMenuItem fld = new JMenuItem("FACULTY LEAVE DETAILS");
        fld.setForeground(BLUE);
        fld.addActionListener(this);
        lvd.add(fld);
        JMenuItem sld = new JMenuItem("STUDENT LEAVE DETAILS");
        sld.setForeground(BLUE);
        sld.addActionListener(this);
        lvd.add(sld);
        
        //EXAM
        JMenu ex=new JMenu("EXAMINATION");
        ex.setForeground(BLUE);
        mb.add(ex);
        JMenuItem exr = new JMenuItem("EXAMINATION RESULTS");
        exr.setForeground(BLUE);
        exr.addActionListener(this);
        ex.add(exr);
        JMenuItem em = new JMenuItem("ENTER MARKS");
        em.addActionListener(this);
        em.setForeground(BLUE);
        ex.add(em);
        
        //UPDATE
        JMenu up=new JMenu("UPDATE INFO");
        up.setForeground(BLUE);
        mb.add(up);
        JMenuItem upf = new JMenuItem("UPDATE FACULTY INFO");
        upf.setForeground(BLUE);
        upf.addActionListener(this);
        up.add(upf);
        JMenuItem ups = new JMenuItem("UPDATE STUDENT INFO");
        ups.setForeground(BLUE);
        ups.addActionListener(this);
        up.add(ups);
        
        //UTILITY
        JMenu u=new JMenu("UTILITY");
        u.setForeground(BLUE);
        mb.add(u);
        JMenuItem n = new JMenuItem("NOTEPAD");
        n.setForeground(BLUE);
        u.add(n);
        n.addActionListener(this);
        JMenuItem c = new JMenuItem("CALCULATOR");
        c.setForeground(BLUE);
        u.add(c);
        c.addActionListener(this);
        
        JMenu E=new JMenu("EXIT");
        E.setForeground(BLUE);
        mb.add(E);
        JMenuItem EX = new JMenuItem("EXIT");
        EX.setForeground(BLUE);
        E.add(EX);
        EX.addActionListener(this);
        
        setJMenuBar(mb);
        setVisible(true);
        }
        @Override
        public void actionPerformed(ActionEvent ae){
        String msg=ae.getActionCommand();
    if(msg.equals("EXIT"))
        setVisible(false);
    else if(msg.equals("CALCULATOR")){
        try{
            Runtime.getRuntime().exec("calc.exe");
        }
        catch(Exception e){ }
    }
    else if(msg.equals("NOTEPAD")){
        try{
            Runtime.getRuntime().exec("notepad.exe");
        }
        catch(Exception O){ }
    }
    else if(msg.equals("NEW FACULTY")){
        new AddTeacher();
    }
    else if(msg.equals("NEW STUDENT")){
        new AddStudent();
    }
    else if(msg.equals("FACULTY DETAILS")){
        new TeacherDetails();
    }
    else if(msg.equals("STUDENT DETAILS")){
        new StudentDetails();
    }
    else if(msg.equals("STUDENT LEAVE")){
        new StudentLeave();
    }
    else if(msg.equals("FACULTY LEAVE")){
        new TeacherLeave();
    }
    else if(msg.equals("STUDENT LEAVE DETAILS")){
        new SLeaveDetails();
    }
    else if(msg.equals("FACULTY LEAVE DETAILS")){
        new TLeaveDetails();
    }
    else if(msg.equals("UPDATE FACULTY INFO")){
        new UpdateTeacher();
    }
    else if(msg.equals("UPDATE STUDENT INFO")){
        new UpdateStudent();
    }
        else if(msg.equals("ENTER MARKS")){
        new EnterMarks();
    }
    else if(msg.equals("EXAMINATION RESULTS")){
        new ExamDetails();
    }
}
    public static void main(String[] args){
        Project p= new Project();
    }
}
