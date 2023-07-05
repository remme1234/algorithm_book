package Chap_1;

import java.util.Scanner;

public class Q2_11720 {

	public static void main(String[] args) {
		
		Scanner in = null;
		try {
			in = new Scanner(System.in);
		
			
			long n = in.nextLong();
			String valueStr = in.next();
		
			
			
			long sumValue = 0;
			for (int i = 0; i < n; i++) {
				long tempVal = Integer.parseInt(valueStr.substring(i, i+1));
				
				sumValue += tempVal;
			}
			System.out.println(sumValue);
			
			
			
			
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			in.close();
		}
		
	}
}
