package test1;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;


public class IfTest {
	
	public static void main(String[] args) {

		//check if string/digit is a palydrome
		int a = 955559;
		String s = String.valueOf(a);
		boolean isPal = false;
		
		char[] arr = s.toCharArray();
		
		for(int i = 0; i < arr.length / 2; i++){
			if(arr[i] == arr[arr.length - 1 - i]){
				isPal = true;
			}
			else{
				System.out.println("not pal");
				isPal = false;
			}
		}
		
		System.out.println(s + " is a " + isPal + " pal");
		
		
	}
}

//  0110 - 6
//	&
//  0011 - 3
//  =
//	0010 - 2 
//
//	0101 - 5
//	^
//	0010 - 2
//	=
//	0111 - 7
//
// 0 - 0000        // 5 - 0101 
// 1 - 0001        // 6 - 0110 
// 2 - 0010        // 7 - 0111 
// 3 - 0011        // 8 - 1000 
// 4 - 0100        // 9 - 1001   
