import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[M];
        StringBuilder sb = new StringBuilder();

        // 재귀를 위한 람다
        class DFS {
            void run(int depth, int start) {
                if (depth == M) {
                    for (int i = 0; i < M; i++) {
                        sb.append(arr[i]).append(" ");
                    }
                    sb.append("\n");
                    return;
                }

                for (int i = start; i <= N; i++) {
                    arr[depth] = i;
                    run(depth + 1, i);  // i 그대로 → 중복 허용 + 비내림차순
                }
            }
        }

        new DFS().run(0, 1);

        System.out.print(sb);
    }
}