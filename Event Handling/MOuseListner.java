import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyFrame extends JFrame{
	JButton btnExit;
	
	MyFrame(){
		setSize(300,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		
		btnExit=new JButton("Exit");
		btnExit.setFont(new Font("",1,20));
		btnExit.addActionListener(new ButtonmouseListner());
		add(btnExit);
	}
}
class ButtonmouseListner implements ActionListener{
	public void actionPerformed(ActionEvent evt){
		System.out.println("Exited....");
		System.exit(0);
	}
}

class MOuseListner {
	public static void main(String args[]){
		new MyFrame().setVisible(true);
	}
}
