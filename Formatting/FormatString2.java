import java.util.*;

class FormatString2{

public static void main(String args[]){
		int x=100;
		double d=12.12;
		char ch='A';
		boolean b=true;
		String s1="Niroth";
		String fs=String.format("",x,d,ch,b,s1);//output->100,12.12,A,true,Niroth
		System.out.println(fs);
    }
}


//Conversion char
//%d ->decimal
//%f ->floating point 
//%c ->characters
//%b ->boolean
//%s ->String

