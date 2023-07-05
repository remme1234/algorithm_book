package Chap_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1_11659 {

	public static void main(String[] args) {
		
	
		BufferedReader br = null;
		StringTokenizer st = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer(br.readLine());
			
			int dataCnt = Integer.parseInt(st.nextToken());
			int questionCnt = Integer.parseInt(st.nextToken());

			
			int[] sumDataArr = new int[dataCnt+1];
			sumDataArr[0] = 0; // 초기 값 세팅 
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= dataCnt; i++) {
				int tempVal = Integer.parseInt(st.nextToken());
				sumDataArr[i] = sumDataArr[i-1] + tempVal;
			}
			
			
			for (int i = 0; i < questionCnt; i++) {
				st = new StringTokenizer(br.readLine());
				
				int startIdx = Integer.parseInt(st.nextToken());
				int endIdx = Integer.parseInt(st.nextToken());
				
				System.out.println("$$ sumDataArr[endIdx] : " + sumDataArr[endIdx] + ", sumDataArr[startIdx-1] : " + sumDataArr[startIdx-1]);

				int calValue = sumDataArr[endIdx] - sumDataArr[startIdx-1];
				System.out.println(calValue);
			}
			
			
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			try { br.close(); } catch (Exception e) { }
		}
	}
	
}
