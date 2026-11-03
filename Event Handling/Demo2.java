import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class MyFrame extends JFrame{
	JTextField txtTitle;
	JButton btnSetTitle;
	
	MyFrame(){
		setSize(300,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		
		txtTitle=new JTextField(10);
		txtTitle.setFont(new Font("",1,20));
		add(txtTitle);
			
		btnSetTitle=new JButton("Set Title");
		btnSetTitle.setFont(new Font("",1,20));
		btnSetTitle.addActionListener(new ButtonAction());
		add(btnSetTitle);
	}
}
class ButtonAction implements ActionListener{
	MyFrame myFrame;
	public void actionPerformed(ActionEvent evt){
		String title=myFrame.txtTitle.getText();
		myFrame.setTitle(title);
	}
}
class Demo2{
	public static void main(String args[]){
		new MyFrame().setVisible(true);
	}
}

