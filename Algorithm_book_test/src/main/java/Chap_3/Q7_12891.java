package Chap_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

// 슬라이딩 윈도우
public class Q7_12891 {
	
	public static void main(String[] args) {

		int result = 0;
		
		BufferedReader br = null;
		StringTokenizer st = null;
		
		char[] dna = {'A','C','G','T'};
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer(br.readLine());

			int txtLength = Integer.parseInt(st.nextToken());
			int keyLength = Integer.parseInt(st.nextToken());
			
			String DNA = br.readLine();
			st = new StringTokenizer(br.readLine());
	        
	        
	        // HashMap의 구조 : (DNA문자, {현재 카운트, 최소 조건})
			Map<Character, int[]> requireMap = new HashMap<>();
			for (char c : dna) {
				requireMap.put(c, new int[] {0, Integer.parseInt(st.nextToken())});
			}
	        
	        // 처음 keyLength만큼 자른 문자열을 카운트하고 조건을 만족하는지 체크
			for (int i = 0; i < keyLength; i++) {
				requireMap.get(DNA.charAt(i))[0]++;
			}
			if(isFull(dna, requireMap)) {
				result++;		
			}
	        
	        // 인덱스를 1씩 증가시켜가며 가장 왼쪽 문자 삭제, 가장 오른쪽 문자 추가
	        // 카운트를 모두 새로 하는것이 아닌 왼쪽 끝은 -1 오른쪽 끝은 +1한다.
			for (int i = 0; i < txtLength-keyLength; i++) {
				requireMap.get(DNA.charAt(i))[0] -= 1;
				requireMap.get(DNA.charAt(i + keyLength))[0] += 1;
				
				if(isFull(dna, requireMap)) {
					result++;		
				}
			}
			System.out.println(result);
			
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			try { br.close(); } catch (Exception e) { }
		}
	}
	
	public static boolean isFull(char[] dna, Map<Character, int[]> requireMap) {
		for (char c : dna) {
			if (requireMap.get(c)[0] < requireMap.get(c)[1]) return false;
		}
		return true;

	}
}
