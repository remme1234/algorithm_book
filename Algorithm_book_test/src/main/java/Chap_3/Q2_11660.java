package Chap_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2_11660 {

	public static void main(String[] args) {

		
		BufferedReader br = null;
		StringTokenizer st = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer(br.readLine());
			
			
			int sizeX = Integer.parseInt(st.nextToken());
			int sizeY = sizeX;
			int qCount = Integer.parseInt(st.nextToken());
			
			// 데이터 배열화 하기
			int[][] dataArr = new int[sizeX+1][sizeY+1];
			dataArr[0][0] = 0;
			
			for (int i = 1; i <= sizeX; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= sizeY; j++) {
					int value = Integer.parseInt(st.nextToken());
					dataArr[i][j] = value;
				}
			}

			
			// 부분합 데이터 구하기
			// D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + A[i][j]
			int[][] sumDataArr = new int[sizeX+1][sizeY+1];
			sumDataArr[0][0] = 0; 
			
			for (int i = 1; i <= sizeX; i++) {
				for (int j = 1; j <= sizeY; j++) {
					sumDataArr[i][j] = sumDataArr[i][j-1] + sumDataArr[i-1][j] - sumDataArr[i-1][j-1] + dataArr[i][j]; 
				}
			}
			
			

			// 실제 요구사항 계산하기,
			for (int i = 0; i < qCount; i++) {
				
				st = new StringTokenizer(br.readLine());

				int x1 = Integer.parseInt(st.nextToken());
				int y1 = Integer.parseInt(st.nextToken());
				
				int x2 = Integer.parseInt(st.nextToken());
				int y2 = Integer.parseInt(st.nextToken());
				
				
				// 부분합 계산에서 구간단위로 계산
				// D[x2][y2] - D[x1-1][y2] -D[x2][y1-1] + D[x1-1][y1-1]
				
				int result = sumDataArr[x2][y2] - sumDataArr[x1-1][y2] -sumDataArr[x2][y1-1] + sumDataArr[x1-1][y1-1];
				
				System.out.println(result);
				
				
			}
			
			
		} catch (Throwable t) {
			t.getStackTrace();
		} finally {
			try { br.close(); } catch (IOException e) { e.printStackTrace(); }
		}
	}
	
}
