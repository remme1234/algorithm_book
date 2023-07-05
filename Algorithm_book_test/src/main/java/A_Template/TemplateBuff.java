package A_Template;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TemplateBuff {

	
	public static void main(String[] args) {
		
		BufferedReader br = null;
		StringTokenizer st = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer(br.readLine());
			
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			try { br.close(); } catch (Exception e) { }
		}
	}
}
