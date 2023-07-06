package Chap_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q7_12892_timeover {
	
	public static void main(String[] args) {

		int result = 0;
		
		BufferedReader br = null;
		StringTokenizer st = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer(br.readLine());

			
			int txtLength = Integer.parseInt(st.nextToken());
			int keyLength = Integer.parseInt(st.nextToken());
			
			st = new  StringTokenizer(br.readLine());
			String txt = st.nextToken();

			st = new  StringTokenizer(br.readLine());
			int[] tokenMinCount = new int[4]; // A C G T의 최소 개
			for (int i = 0; i < 4; i++) {
				tokenMinCount[i] = Integer.parseInt(st.nextToken());
			}
			
			
			for (int i = 0; i <= txtLength-keyLength; i++) {
				String target = txt.substring(i, i + keyLength);
				
				long aCount = countChar(target, 'A');
				long cCount = countChar(target, 'C');
				long gCount = countChar(target, 'G');
				long tCount = countChar(target, 'T');
				
				if(aCount >= tokenMinCount[0]
						&& cCount >= tokenMinCount[1]
						&& gCount >= tokenMinCount[2]
						&& tCount >= tokenMinCount[3]) {
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
	
    public static long countChar(String str, char ch) {
        return str.chars()
                .filter(c -> c == ch)
                .count();
    }
}
