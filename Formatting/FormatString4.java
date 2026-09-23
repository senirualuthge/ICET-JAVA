import java.util.*;

 public class FormatString4 {

	public static void main(String args[]){
		int idNum=1;
		String name="Niroth Samarawickrama";
		int age=12;
		double salary=1234567.2324;
		String fs=String.format("S%05d   %-30s   %-5d%20f",idNum,name,age,salary);
		System.out.println(fs);
		fs=String.format("S%05d   %-30s   %-5d%20f",idNum,name,age,salary);
		System.out.println(fs);
	}
}

//%[argument_index$][flags][width][.precision]conversion char
/* 
Flag	Description
===================
'-'		The result will be left-justified.
'#'		The result should use a conversion-dependent alternate form
'+'		The result will always include a sign
' '		The result will include a leading space for positive values
'0'		The result will be zero-padded
','		The result will include locale-specific grouping separators
'('		The result will enclose negative numbers in parentheses

*/
