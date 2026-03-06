import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int ans;
	static boolean[] selected;
	static int[][] route;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		route = new int[N][N];
		selected = new boolean[N];
		
		for(int i =0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				route[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = Integer.MAX_VALUE;
		
		comb(0, 0);
		System.out.println(ans);
	}
	
	static void comb(int idx, int pickedCnt) {
		
		int diff = 0;
		
		if(idx == N) {
			return;
		}
		
		if(pickedCnt == N/2) {
			int teamA = 0;
			int teamB = 0;
			
			for(int i = 0; i<N; i++) {
				for(int j=i+1; j<N; j++) {
					if(selected[i] && selected[j]) {
						teamA += route[i][j];
						teamA += route[j][i];
					}else if(!selected[i] && !selected[j]){
						teamB += route[i][j];
						teamB += route[j][i];
					}
				}
			}
			
			diff = Math.abs(teamA-teamB);
			ans = Math.min(ans, diff);
			return;
		}
		
		selected[idx] = true;
        comb(idx + 1, pickedCnt + 1);

        selected[idx] = false;
        comb(idx + 1, pickedCnt);
	}
}