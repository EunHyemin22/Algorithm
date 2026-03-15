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

        int[] move = new int[101];      // 사다리/뱀 정보
        boolean[] visited = new boolean[101];
        int[] dist = new int[101];      // 주사위 횟수

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            move[x] = y;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            move[u] = v;
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == 100) {
                System.out.println(dist[cur]);
                return;
            }

            for (int dice = 1; dice <= 6; dice++) {
                int next = cur + dice;

                if (next > 100) continue;

                // 사다리 또는 뱀이 있으면 즉시 이동
                if (move[next] != 0) {
                    next = move[next];
                }

                if (!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[cur] + 1;
                    q.offer(next);
                }
            }
        }
    }
}