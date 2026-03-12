import java.io.*;
import java.util.*;

public class Main {
    static int M, N, H;
    static int[][][] box;
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};

    static class Tomato {
        int z, x, y;

        Tomato(int z, int x, int y) {
            this.z = z;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로
        H = Integer.parseInt(st.nextToken()); // 높이

        box = new int[H][N][M];
        Queue<Tomato> q = new ArrayDeque<>();

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    box[h][n][m] = Integer.parseInt(st.nextToken());

                    // 처음부터 익은 토마토는 모두 큐에 넣기
                    if (box[h][n][m] == 1) {
                        q.offer(new Tomato(h, n, m));
                    }
                }
            }
        }

        bfs(q);

        int maxDay = 0;
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    // 아직 안 익은 토마토가 남아 있으면 실패
                    if (box[h][n][m] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    maxDay = Math.max(maxDay, box[h][n][m]);
                }
            }
        }

        // 처음 익은 토마토가 1부터 시작하므로 1 빼기
        System.out.println(maxDay - 1);
    }

    static void bfs(Queue<Tomato> q) {
        while (!q.isEmpty()) {
            Tomato cur = q.poll();

            for (int d = 0; d < 6; d++) {
                int nz = cur.z + dz[d];
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nz < 0 || nz >= H || nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                // 안 익은 토마토만 익히기
                if (box[nz][nx][ny] == 0) {
                    box[nz][nx][ny] = box[cur.z][cur.x][cur.y] + 1;
                    q.offer(new Tomato(nz, nx, ny));
                }
            }
        }
    }
}