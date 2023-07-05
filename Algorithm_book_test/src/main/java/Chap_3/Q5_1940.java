package Chap_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q5_1940 {

	public static void main(String[] args) {
		
		BufferedReader br = null;
		StringTokenizer st = null;
		
		int resultCount = 0;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			
			st = new StringTokenizer(br.readLine());
			int materialCount = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int makeCondCount = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int[] materialArr = new int[materialCount];
			for (int i = 0; i < materialCount; i++) {
				materialArr[i] = Integer.parseInt(st.nextToken());
			}

			/**
			 * 정렬, makeCondCount의 최대 범위가 15000 이므로 O(nlogn) 시간 복잡도 알고리즘 사용해도 됨
			 * 일반적으로 정렬 알고리즘의 시간 복잡도는 O(nlogn)
			 */
			Arrays.sort(materialArr);
			
			
			
			// 이번 투포인터에서는 맨 앞, 맨 뒤에서 시작해서 가운데에서 만나는
			int startIdx = 0;
			int endIdx = materialCount -1;
			
			
			while(startIdx < endIdx) {
				
				int sumValue = materialArr[startIdx] + materialArr[endIdx];
				
				
				if(sumValue == makeCondCount) {
					resultCount++;
					startIdx++;
					endIdx--;
				} else if (sumValue > makeCondCount) {
					endIdx--;
				} else {
					startIdx++;
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
