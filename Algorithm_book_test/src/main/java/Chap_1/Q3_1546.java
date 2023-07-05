package Chap_1;

import java.util.Scanner;

public class Q3_1546 {

	
	public static void main(String[] args) {
		
		Scanner in = null;
		try {
			in = new Scanner(System.in);
	
			int n = in.nextInt();
			int valueArr[] = new int[n];
			
			for (int i = 0; i < valueArr.length; i++) {
				valueArr[i] = in.nextInt();
			}
			
			
			int maxValue = 0;
			double sumValue = 0.0;
			
			
			for (int i = 0; i < valueArr.length; i++) {

				int tempValue = valueArr[i];
				
				if(maxValue < tempValue) {
					maxValue = tempValue;
				}
				
				sumValue += tempValue;
			}
			
			double avgVal = (sumValue/maxValue)*100/n;
			
			System.out.println(avgVal);
			
			
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			in.close();
		}
	}
	
}