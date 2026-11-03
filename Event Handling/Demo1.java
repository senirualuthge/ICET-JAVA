import javax.swing.*;
import java.awt.*;
class Demo1Frame extends JFrame{
	JButton btnExit;
	
	Demo1Frame(){
		setSize(300,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		
		btnExit=new JButton("Exit");
		btnExit.setFont(new Font("",1,20));
		btnExit.addActionListener(e -> new Demo1ButtonAction().action());
		add(btnExit);
	}
}
class Demo1ButtonAction{
	public void action(){
		System.out.println("Exited....");
		System.exit(0);
	}
}

// Named EventDemo1 because OOP/Demo1.java already declares Demo1 in this
// default package and both compile into the same .vscode/out folder.
class EventDemo1{
	public static void main(String args[]){
		new Demo1Frame().setVisible(true);
	}
}
