package hw4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame {
	JFrame f;
    JTextField result;
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bdiv,bmult,bsub,badd,bdec,beq,bdel,bclr;
    Controller c;
	View(Controller control) {
	        f=new JFrame("Calculator");
	        result=new JTextField();
	        c = control;
	        b1=new JButton("1");
	        
	        b2=new JButton("2");
	        
	        b3=new JButton("3");
	        
	        b4=new JButton("4");
	        
	        b5=new JButton("5");
	        
	        b6=new JButton("6");
	        
	        b7=new JButton("7");
	        
	        b8=new JButton("8");
	        
	        b9=new JButton("9");
	        
	        b0=new JButton("0");
	        
	        bdiv=new JButton("/");
	        
	        bmult =new JButton("*");
	        
	        bsub=new JButton("-");
	        
	        badd=new JButton("+");
	        
	        beq=new JButton("=");
	        
	        bclr=new JButton("C");
	        
	        b1.addActionListener(c.actionListener());
	        b2.addActionListener(c.actionListener());
	        b3.addActionListener(c.actionListener());
	        b4.addActionListener(c.actionListener());
	        b5.addActionListener(c.actionListener());
	        b6.addActionListener(c.actionListener());
	        b7.addActionListener(c.actionListener());
	        b8.addActionListener(c.actionListener());
	        b9.addActionListener(c.actionListener());
	        b0.addActionListener(c.actionListener());
	        bdiv.addActionListener(c.actionListener());
	        bmult.addActionListener(c.actionListener());
	        bsub.addActionListener(c.actionListener());
	        badd.addActionListener(c.actionListener());
	        beq.addActionListener(c.actionListener());
	        bclr.addActionListener(c.actionListener());
	        
	        result.setBounds(30,40,280,30);
	        b1.setBounds(40,100,50,40);
	        b2.setBounds(110,100,50,40);
	        b3.setBounds(180,100,50,40);
	        badd.setBounds(250,100,50,40);
	        
	        b4.setBounds(40,170,50,40);
	        b5.setBounds(110,170,50,40);
	        b6.setBounds(180,170,50,40);
	        bsub.setBounds(250,170,50,40);
	        
	        b7.setBounds(40,240,50,40);
	        b8.setBounds(110,240,50,40);
	        b9.setBounds(180,240,50,40);
	        bmult.setBounds(250,240,50,40);
	        
	        b0.setBounds(40,310,50,40);
	        beq.setBounds(110,310,50,40);
	        bdiv.setBounds(250,310,50,40);
	     
	        bclr.setBounds(180,310,50,40);
	        
	        f.add(result);
	        f.add(b7);
	        f.add(b8);
	        f.add(b9);
	        f.add(bdiv);
	        f.add(b4);
	        f.add(b5);
	        f.add(b6);
	        f.add(bmult);
	        f.add(b1);
	        f.add(b2);
	        f.add(b3);
	        f.add(bsub);
	        f.add(b0);
	        f.add(beq);
	        f.add(badd);
	        f.add(bclr);
	        
	        f.setLayout(null);
	        f.setVisible(true);
	        f.setSize(350,400);
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        f.setResizable(false);
	}
	
	public void setValue(String v) {
		result.setText(v);
	}
}
