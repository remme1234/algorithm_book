package Chap_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1253 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int numCount = Integer.parseInt(bf.readLine());
		int result = 0;
		long numArr[] = new long[numCount];
		StringTokenizer st = new StringTokenizer(bf.readLine());
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
					if( startIdx != endIdx) {
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
		bf.close();
	}
}