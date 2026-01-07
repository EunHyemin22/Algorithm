import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] dr = {0,1};//오른쪽, 아래
        int[] dc = {1,0};
        
        int[][] game = new int[N][N];
        long[][] dp = new long[N][N];
        
        for(int i = 0; i<N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++) {
            	game[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;
        for(int i = 0; i<N; i++) {
        	for(int j = 0; j<N; j++) {
        		int k = game[i][j];
        		
        		if(dp[i][j] == 0) continue;
    			if(k==0) continue;
        			
    			for(int d = 0; d<2; d++) {
    				
    				int nr = i + dr[d] * k;
    				int nc = j + dc[d] * k;
    				
    				if(nr >= N || nr < 0 || nc >= N || nc < 0) continue;
    				
    				dp[nr][nc] += dp[i][j];
    			
    			}//for
        	}//j
        }//i
     System.out.println(dp[N-1][N-1]);   
    }
}