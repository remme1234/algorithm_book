
package Chap_1;

import java.util.Scanner;

public class Test {

	
	public static void main(String[] args) {
		
		Scanner in = null;
		try {
			in = new Scanner(System.in);
			
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			in.close();
		}
	}
}
