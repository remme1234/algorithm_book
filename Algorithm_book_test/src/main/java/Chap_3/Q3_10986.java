package Chap_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q3_10986 {

	public static void main(String[] args) {
		
		long result = 0;
		BufferedReader br = null;
		StringTokenizer st = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			
			st = new StringTokenizer(br.readLine());
			
			int dataCount = Integer.parseInt(st.nextToken());
			int divideValue = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			// 1. 합배열 생성
			long[] sumArr = new long[dataCount];
			sumArr[0] = Integer.parseInt(st.nextToken());
			
			for (int i = 1; i < dataCount; i++) {
				long tempVal = Integer.parseInt(st.nextToken());
				sumArr[i] = sumArr[i-1] + tempVal;
			}
			
			
			// 2. 합배열에서 M으로 나눈 값으로 된 합배열 업데이트 생성
			long[] updatedSumArr = new long[dataCount];
			updatedSumArr[0] = 0;
			
			for (int i = 0; i < sumArr.length; i++) {
				updatedSumArr[i] = sumArr[i] % divideValue;
			}
			
			
			
			// 3. 합 배열에서 원소 값이 0인 개수만 세어 정답에 더하기 
			for(long tempVal : updatedSumArr) {
				if(tempVal == 0) {
					result++;
				}
			}
			
			
			// 4. 원소 값이 같은 경우, 해당 배열 인덱스에 ++ 처
			long[] sameValCheck = new long[divideValue];
			for (int i = 0; i < updatedSumArr.length; i++) {
				long tempVal = updatedSumArr[i];
				sameValCheck[(int) tempVal]++;
			}
			
			// 5.같은 원소값이 있는지 확인 했으면 그에 대한 경우의 수 계산
			for (int i = 0; i < sameValCheck.length; i++) {	
				if( sameValCheck[i] <= 1) { // 2개를 뽑았을 때의 경우의 수를 확인할 것이라서 1이하  
					continue;
				}
				
				// 경우의 수 (C[i] * ((C[i] -1) /2)
				result += ( sameValCheck[i] * (sameValCheck[i] -1) /2);
			}
			
			System.out.println(result);
			
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			try { br.close(); } catch (Exception e) { }
		}
	}	
}
