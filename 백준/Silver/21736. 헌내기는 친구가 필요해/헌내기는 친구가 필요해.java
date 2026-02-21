import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] campus = new int[N][M];
		// 0: 빈 공간, X: 벽 => 1 , I: 도연 => 2, P: 사람 =>3
		// 상하좌우 3이 몇개인지 
		
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		int di = 0;
		int dj = 0;
		
		for(int i = 0; i<N; i++) {
			String line = br.readLine();
			for(int j = 0; j<M; j++) {
				Character c = line.charAt(j);
				if(c =='X') {
					campus[i][j] = 1; //wall
				}else if(c =='I') {
					campus[i][j] = 2; //me
					di = i;
					dj = j;
				}else if(c =='P') {
					campus[i][j] = 3; //person
				}else {
					campus[i][j] = 0;
				}
			}
		}
		
		int count = 0;
		
		boolean[][] visited = new boolean[N][M];
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] {di,dj});
		visited[di][dj] = true;

		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			
			for(int d = 0; d<4; d++) {
				
				int nr = r +dr[d];
				int nc = c +dc[d];
				
				if(nr>=N|| nr<0 || nc>=M|| nc<0)continue;
				if(visited[nr][nc])continue;
				if(campus[nr][nc] == 1)continue;
				visited[nr][nc] = true;
				q.add(new int[] {nr,nc});
				if(campus[nr][nc]==3) {
					count++;
				}
				
			}//d
		}//while
		
		if(count == 0) {
			System.out.println("TT");
		}else {
			System.out.println(count);
		}
	}
}