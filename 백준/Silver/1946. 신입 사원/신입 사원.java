import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][2];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken()); // 서류
                arr[i][1] = Integer.parseInt(st.nextToken()); // 면접
            }

            //서류 기준 정렬
            Arrays.sort(arr, (a, b) -> a[0] - b[0]);

            //면접 최솟값 갱신
            int count = 1; // 서류 1등은 무조건 합격
            int minInterview = arr[0][1];

            for (int i = 1; i < N; i++) {
                if (arr[i][1] < minInterview) {
                    count++;
                    minInterview = arr[i][1];
                }
            }
            System.out.println(count);
        }
    }
}