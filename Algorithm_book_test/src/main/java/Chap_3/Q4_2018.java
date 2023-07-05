package Chap_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 연속된 자연수 값 구하
public class Q4_2018 {

	public static void main(String[] args) {
		
		BufferedReader br = null;
		int resultCount = 1; // targetValue 만큼은 항상 있어서
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			
			int targetValue = Integer.parseInt(br.readLine());
			
			// 사용 할 index값 초기화 
			int startIndex = 1;
			int endIndex = 1;
			int sumVal = 1;
			
			while(endIndex != targetValue) {
				
				if(sumVal == targetValue) {
					resultCount++;
					endIndex++;
					sumVal =sumVal + endIndex;
					
				} else if (sumVal > targetValue) {
					sumVal = sumVal - startIndex;
					startIndex++;
					
				} else {
					endIndex++;
					sumVal = sumVal + endIndex;
					
				}
			}

			
			System.out.println(resultCount);
			
			
			
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			try { br.close(); } catch (Exception e) { }
		}
	}
	
}
