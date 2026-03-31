import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(br.readLine());
		int tmp = 1;
		
		for(int i = 0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cup1 = Integer.parseInt(st.nextToken());
			int cup2 = Integer.parseInt(st.nextToken());
			
			// 공이 cup1에 있으면 cup2로 이동
            if (tmp == cup1) {
            	tmp = cup2;
            }
            // 공이 cup2에 있으면 cup1로 이동
            else if (tmp == cup2) {
            	tmp = cup1;
            }
			
		}
		System.out.println(tmp);
	}
}