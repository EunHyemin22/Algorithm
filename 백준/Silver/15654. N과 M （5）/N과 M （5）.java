import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] nums;
    static int[] pick;
    static boolean[] used;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(pick[i]).append(i + 1 == M ? '\n' : ' ');
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (used[i]) continue;
            used[i] = true;
            pick[depth] = nums[i];
            dfs(depth + 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        pick = new int[M];
        used = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(nums); // 사전순 출력 위해 정렬 :contentReference[oaicite:5]{index=5}
        dfs(0);

        System.out.print(sb.toString());
    }
}