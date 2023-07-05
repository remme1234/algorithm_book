package Chap_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q6_1253 {
	
	
	public static void main(String[] args) {
		
		BufferedReader br = null;
		StringTokenizer st = null;
		
		int result = 0;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer(br.readLine());
			
			
			int numCount = Integer.parseInt(st.nextToken());
			long[] numArr = new long[numCount];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < numCount; i++) {
				numArr[i] = Long.parseLong(st.nextToken());
			}
			
			Arrays.sort(numArr);
			
			for (int k = 0; k < numCount; k++) {
				
				long numVal = numArr[k];
				int startIdx = 0;
				int endIdx = numCount-1;
				
				while(startIdx < endIdx) {
					
					long sumVal = numArr[startIdx] + numArr[endIdx];
					
					if(sumVal == numVal) {
						if( startIdx != k && endIdx != k) {
							result++;
							break;
						} else if (startIdx == k) {
							startIdx++;
						} else if (endIdx == k){
							endIdx--;
						}
					} else if (sumVal < numVal) {
						startIdx++;
					} else {
						endIdx--;
					}
				}
			}
			
			System.out.println(result);
			
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			try { br.close(); } catch (Exception e) { }
		}
	}
}
