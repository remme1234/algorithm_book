package Chap_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q8_11003 {

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
			
			Deque<Node> deque = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < numLength; i++) {
				
				int tempVal = Integer.parseInt(st.nextToken());
				
				// 덱의 마지막 위치에서부터 now 보다 큰 값은 덱에서 제거하기
				while(!deque.isEmpty() && deque.getLast().value > tempVal){
					deque.removeLast();
				}
				
				
				// 덱의 마지막 위치에서 now 값 저장하기
				deque.addLast(new Node(tempVal, i));
				
				// 덱의 1번째 위치에서부터 L의 범위를 벗어난 값을 덱에서 제거하기
				if (deque.getFirst().index <= i - windowSize) {
					deque.removeFirst();
				}
				System.out.println(String.format("#######4 size : %d, window : %d", deque.size(), windowSize));
				
				// 덱의 1번째 데이터 출력하기
				bw.write(deque.getFirst().value + " ");
			}
			
			bw.flush();
			
			
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			try { br.close(); } catch (Exception e) { }
			try { bw.close(); } catch (Exception e) { }
		}
	}
	
	static class Node {
		public int value;
		public int index;
		
		Node(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}
}


