package Chap_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 
 * 오류가 있었던 부분은 아래와 같다.
 * 문제의 조건에서 L의 조건이 있는데 이는 윈도우사이즈를 의미하며
 * 예를들어 
 *  node (index, value),L을 3으로 가정하
 *  (3,2), (4,3), (5,6) 
 *  그 다음 (6,2)가 들어오는 경
 *  인덱스 4와 5의 밸류가 각각 3,6 이므로 2보다 크기 때문에 삭제되고
 *  
 *  남은 인덱스3의 경우 그대로 남아있지 않고,
 *  새로 들어온 인덱스6이랑 L크기만큼 차이가 나기 때문에 제외하여
 * (6,2) 만 deque에 남게된다. 
 *   
 * 
 * 12 3
1 5 2 3 6 2 3 7 3 5 2 6
#######4 size : 1, window : 3
#######4 size : 2, window : 3
#######4 size : 2, window : 3
#######4 size : 2, window : 3
#######4 size : 3, window : 3
#######4 size : 1, window : 3
#######4 size : 2, window : 3
#######4 size : 3, window : 3
#######4 size : 2, window : 3
#######4 size : 2, window : 3
#######4 size : 1, window : 3
#######4 size : 2, window : 3
1 1 1 2 2 2 2 2 3 3 2 2 


==============================

12 3
1 5 2 3 6 2 3 7 3 5 2 6
#######4 size : 1, window : 3
#######4 size : 2, window : 3
#######4 size : 2, window : 3
#######4 size : 3, window : 3
#######4 size : 3, window : 3
#######4 size : 2, window : 3
#######4 size : 3, window : 3
#######4 size : 3, window : 3
#######4 size : 3, window : 3
#######4 size : 3, window : 3
#######4 size : 1, window : 3
#######4 size : 2, window : 3
1 1 1 1 2 2 2 2 2 3 2 2 
 * 
 * @author shinu_o
 *
 */
public class Q8_11004_node_class_ver {

	public static void main(String[] args) {
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		StringTokenizer st = null;
		
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			st = new StringTokenizer(br.readLine());
			
			int numLength = Integer.parseInt(st.nextToken());
			int windowSize = Integer.parseInt(st.nextToken());
			
			Deque<Integer> deque = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < numLength; i++) {
				
				int tempVal = Integer.parseInt(st.nextToken());
				
				// 덱의 마지막 위치에서부터 now 보다 큰 값은 덱에서 제거하기
				while(!deque.isEmpty() && deque.getLast() > tempVal){
					deque.removeLast();
				}
				
				
				// 덱의 마지막 위치에서 now 값 저장하기
				deque.addLast(tempVal);
				
				
				// 덱의 1번째 위치에서부터 L의 범위를 벗어난 값을 덱에서 제거하기
				if(deque.size() > windowSize) {
					deque.removeFirst();
				}
				System.out.println(String.format("#######4 size : %d, window : %d", deque.size(), windowSize));
				
				// 덱의 1번째 데이터 출력하기
				bw.write(deque.getFirst() + " ");
			}
			
			bw.flush();
			
			
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			try { br.close(); } catch (Exception e) { }
			try { bw.close(); } catch (Exception e) { }
		}
	}
	
}
