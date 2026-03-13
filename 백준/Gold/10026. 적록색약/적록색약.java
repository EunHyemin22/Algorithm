import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N;
	static Character[][] color;
	static int[] dr = {0,0,-1,1};
	static int[] dc = {-1,1,0,0};
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		color = new Character[N][N];
		
		for(int i = 0; i<N; i++) {
			String line = br.readLine();
			for(int j = 0; j<N; j++) {
				char c = line.charAt(j);
				color[i][j] = c;
			}
		}
		
		int normal = countAreaNormal();

        // 적록색약용으로 G를 R로 바꾸기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (color[i][j] == 'G') {
                    color[i][j] = 'R';
                }
            }
        }

        int blind = countAreaBlind();

        System.out.println(normal + " " + blind);
    }

	// 일반인 기준 영역 수
    public static int countAreaNormal() {
        visited = new boolean[N][N];
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                    count++;
                }
            }
        }

        return count;
    }
	
    // 적록색약 기준 영역 수
    public static int countAreaBlind() {
        visited = new boolean[N][N];
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                    count++;
                }
            }
        }

        return count;
    }
    
    public static void bfs(int sr, int sc) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        visited[sr][sc] = true;

        char baseColor = color[sr][sc];

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (visited[nr][nc]) continue;
                if (color[nr][nc] != baseColor) continue;

                visited[nr][nc] = true;
                q.add(new int[]{nr, nc});
            }
        }
    }
}