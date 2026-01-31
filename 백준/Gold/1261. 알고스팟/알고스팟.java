import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1_000_000_000;
	
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken()); //가로(열)
		int N = Integer.parseInt(st.nextToken()); //세로(행)
		int[][] maze = new int[N][M];
		
		for(int i = 0; i<N; i++) {
			String line = br.readLine();
			for(int j = 0; j<M; j++) {
				maze[i][j] = line.charAt(j)-'0';
			}
		}
		
		int[][] dist = new int[N][M];
		for(int i = 0; i<N; i++)Arrays.fill(dist[i], INF);
		
		Deque<int[]> dq = new ArrayDeque<>();
        dist[0][0] = 0;
        dq.addFirst(new int[]{0, 0});

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int r = cur[0], c = cur[1];

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;

                int w = maze[nr][nc]; // 0이면 비용 0, 1이면 벽 부수기 비용 1
                int nd = dist[r][c] + w;

                if (nd < dist[nr][nc]) {
                    dist[nr][nc] = nd;
                    if (w == 0) dq.addFirst(new int[]{nr, nc}); // 0 가중치 → 앞
                    else dq.addLast(new int[]{nr, nc});         // 1 가중치 → 뒤
                }
            }
        }

        System.out.println(dist[N - 1][M - 1]);
    }
}