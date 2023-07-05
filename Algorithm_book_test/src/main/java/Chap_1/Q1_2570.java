package Chap_1;

import java.util.Arrays;
import java.util.Scanner;

public class Q1_2570 {

	
	public static void main(String[] args) {
		
		Scanner in = null;
		
		try {
			in = new Scanner(System.in);
			int n = in.nextInt();
			int[] arr = new int[n];
			
			for(int i = 0; i < n; i++) {
				arr[i] = in.nextInt();
			}
			
			// 정렬 메소드
			Arrays.sort(arr);
			
			for(int val : arr) {
				System.out.println(val);
			}
			
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			in.close();
		}
	}
}
