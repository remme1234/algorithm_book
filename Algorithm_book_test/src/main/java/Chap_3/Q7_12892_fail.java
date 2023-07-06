package Chap_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

// 슬라이딩 윈도우
public class Q7_12892_fail {
	
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
			char[] txtArr = txt.toCharArray();

			st = new  StringTokenizer(br.readLine());
			
			Map<String, Integer> tokenMap = getDNAmap(st);
			System.out.println("### token Map : " + tokenMap);
			
			// 첫루프에서 값 확인하기
			String targetTxt = null;
			Map<String, Integer> targetTokenMap = new HashMap<>();
			for (int i = 0; i < keyLength; i++) {
				targetTxt = txt.substring(i, i+1);
				checkAndAddCount(targetTokenMap, targetTxt);
			}
			
			if(compareDNA(tokenMap, targetTokenMap)) {
				result++;
			}
			
			
			for (int i = 0; i <= txtLength-keyLength; i++) {
				
				String firstStr = Character.toString(txtArr[i]);
				String lastStr = Character.toString(txtArr[i+keyLength]);
				
				System.out.println("## firstStr : " + firstStr);
				System.out.println("## lastStr : " + lastStr);
				
				checkAndAddCount(targetTokenMap, targetTxt);
				if(compareDNA(tokenMap, targetTokenMap)) {
					result++;
				}
			}
			
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			try { br.close(); } catch (Exception e) { }
		}
	}
	
    private static boolean compareDNA(Map<String, Integer> tokenMap, Map<String, Integer> targetTokenMap) {

    	boolean result = true;
    	String[] targets = new String[] {"A", "C", "G", "T"};
    	
    	for(String target : targets) {
    		
    		if(targetTokenMap.containsKey(target)) {
    			if(targetTokenMap.get(target) < tokenMap.get(target)) {
    				result = false;
    				break;
    			}
    		}
    	}
    	
		return result;
	}

	private static void checkAndAddCount(Map<String, Integer> targetTokenMap, String targetKey) {
    	if(targetTokenMap.containsKey(targetKey)) {
			targetTokenMap.put(targetKey, targetTokenMap.get(targetKey) + 1);
		} else {
			targetTokenMap.put(targetKey, 1);
		}		
	}

	private static Map<String, Integer> getDNAmap(StringTokenizer st) {
    	
    	Map<String, Integer> tokenMap = new HashMap<>();
    	for (int i = 0; i < 4; i++) {
    		
    		int tempVal = Integer.parseInt(st.nextToken());
    		
			switch (i) {
				case 0: {
					tokenMap.put("A", tempVal);
					break;
				}
				case 1: {
					tokenMap.put("C", tempVal);
					break;
				}
				case 2: {
					tokenMap.put("G", tempVal);
					break;
				}
				case 3: {
					tokenMap.put("T", tempVal);
					break;
				}
			default:
			}
		}
    	return tokenMap;
	}
}
