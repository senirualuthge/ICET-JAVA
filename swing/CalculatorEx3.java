import javax.swing.*;
import java.awt.*;
class CalculatorEx3 {
	public static void main(String[] args) {
		JFrame f1=new JFrame();
		f1.setSize(300,300);
		f1.setTitle("Calculator");
		f1.setLocationRelativeTo(null);
		f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JTextField txtDisplay=new JTextField();
		txtDisplay.setFont(new Font("",Font.BOLD,25));
		txtDisplay.setHorizontalAlignment(JTextField.RIGHT);
		//txtDisplay.setEditable(false);
		f1.add("North",txtDisplay);
		
		
		JButton[] buttonArray=new JButton[16];
		String[] buttonName={"7","8","9","*","4","5","6","/","1","2","3","+","0",".","=","-"};
		JPanel buttonPanel=new JPanel(new GridLayout(4,4,4,4));
		for (int i = 0; i < 16; i++){
			buttonArray[i]=new JButton(buttonName[i]);
			buttonArray[i].setFont(new Font("",Font.BOLD,25));
			buttonPanel.add(buttonArray[i]);
		}
		f1.add("Center",buttonPanel);
		f1.setVisible(true);
	}
}
