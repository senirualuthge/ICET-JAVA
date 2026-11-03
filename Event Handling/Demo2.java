import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Demo2Frame extends JFrame{
	JTextField txtTitle;
	JButton btnSetTitle;
	
	Demo2Frame(){
		setSize(300,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		
		txtTitle=new JTextField(10);
		txtTitle.setFont(new Font("",1,20));
		add(txtTitle);
			
		btnSetTitle=new JButton("Set Title");
		btnSetTitle.setFont(new Font("",1,20));
		btnSetTitle.addActionListener(new Demo2ButtonAction(this));
		add(btnSetTitle);
	}
}
class Demo2ButtonAction implements ActionListener{
	Demo2Frame demo2Frame;
	Demo2ButtonAction(Demo2Frame demo2Frame){
		this.demo2Frame=demo2Frame;
	}
	public void actionPerformed(ActionEvent evt){
		String title=demo2Frame.txtTitle.getText();
		demo2Frame.setTitle(title);
	}
}
// Named EventDemo2 because OOP/Demo2.java already declares Demo2 in this
// default package and both compile into the same .vscode/out folder.
class EventDemo2{
	public static void main(String args[]){
		new Demo2Frame().setVisible(true);
	}
}
