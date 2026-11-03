import javax.swing.*;
import java.awt.*;
class MyFrame extends JFrame{
	JButton btnExit;
	
	MyFrame(){
		setSize(300,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		
		btnExit=new JButton("Exit");
		btnExit.setFont(new Font("",1,20));
		btnExit.addActionListener(e -> new ButtonAction().action());
		add(btnExit);
	}
}
class ButtonAction{
	public void action(){
		System.out.println("Exited....");
		System.exit(0);
	}
}

class Demo1{
	public static void main(String args[]){
		new MyFrame().setVisible(true);
	}
}
