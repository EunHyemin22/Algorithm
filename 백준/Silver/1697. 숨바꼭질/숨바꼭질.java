import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        final int MAX = 100000;
        boolean[] visited = new boolean[MAX + 1];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{N, 0});
        visited[N] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int position = current[0];
            int time = current[1];

            if (position == K) {
                System.out.println(time);
                return;
            }

            // x - 1
            if (position - 1 >= 0 && !visited[position - 1]) {
                visited[position - 1] = true;
                queue.add(new int[]{position - 1, time + 1});
            }

            // x + 1
            if (position + 1 <= MAX && !visited[position + 1]) {
                visited[position + 1] = true;
                queue.add(new int[]{position + 1, time + 1});
            }

            // x * 2
            if (position * 2 <= MAX && !visited[position * 2]) {
                visited[position * 2] = true;
                queue.add(new int[]{position * 2, time + 1});
            }
        }
    }
}