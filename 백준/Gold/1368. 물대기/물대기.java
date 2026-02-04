import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        int size = n + 1; // 0..n (0 is virtual node)
        int[][] cost = new int[size][size];

        // 0 -> i : digging well cost
        for (int i = 1; i <= n; i++) {
            int w = Integer.parseInt(br.readLine().trim());
            cost[0][i] = w;
            cost[i][0] = w;
        }

        // channel costs between fields
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // Prim's algorithm on (n+1) nodes
        boolean[] visited = new boolean[size];
        int[] minEdge = new int[size];
        Arrays.fill(minEdge, Integer.MAX_VALUE);
        minEdge[0] = 0;

        long total = 0;

        for (int iter = 0; iter < size; iter++) {
            int u = -1;
            int best = Integer.MAX_VALUE;

            for (int v = 0; v < size; v++) {
                if (!visited[v] && minEdge[v] < best) {
                    best = minEdge[v];
                    u = v;
                }
            }

            visited[u] = true;
            total += best;

            for (int v = 0; v < size; v++) {
                if (!visited[v] && cost[u][v] < minEdge[v]) {
                    minEdge[v] = cost[u][v];
                }
            }
        }

        System.out.println(total);
    }
}