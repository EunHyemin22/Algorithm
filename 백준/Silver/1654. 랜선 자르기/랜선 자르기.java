import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long[] line = new long[K];
        long max = 0;
        for (int i = 0; i < K; i++) {
            line[i] = Long.parseLong(br.readLine());
            if (line[i] > max) max = line[i];
        }

        long low = 1;
        long high = max;
        long answer = 0;

        while (low <= high) {
            long mid = (low + high) / 2; // 후보 길이
            long cnt = 0;

            for (int i = 0; i < K; i++) {
                cnt += (line[i] / mid);
            }

            if (cnt >= N) {          // N개 이상 만들 수 있으면 더 길게 도전
                answer = mid;
                low = mid + 1;
            } else {                 // 부족하면 길이를 줄임
                high = mid - 1;
            }
        }

        System.out.println(answer);
    }
}