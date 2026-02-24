import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] day = new int[N];
		int[] pay = new int[N];
		
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			day[i] = Integer.parseInt(st.nextToken());
			pay[i] = Integer.parseInt(st.nextToken());
			
		}
		
		//dp[i] = i일부터 마지막까지 얻을 수 있는 최대 돈
		int[] dp = new int[N+1];
		
		for(int i = N-1; i>=0; i--) {
			if(i+day[i] <= N) {
				dp[i] = Math.max(dp[i+1], pay[i] + dp[i+day[i]]);
			}else {
				dp[i] = dp[i+1];
			}
		}
		
		System.out.println(dp[0]);
	}
}