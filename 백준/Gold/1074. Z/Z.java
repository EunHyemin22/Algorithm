import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		solve(N,r,c);
		System.out.println(answer);
	}

	static void solve(int n, int r, int c) {
		if(n==0) return;
		
		int half = 1 << (n-1);
		int area = half * half;
		
		if (r < half && c < half) {           // 1사분면(좌상단)
            solve(n - 1, r, c);
        } else if (r < half && c >= half) {   // 2사분면(우상단)
            answer += area;
            solve(n - 1, r, c - half);
        } else if (r >= half && c < half) {   // 3사분면(좌하단)
            answer += area * 2;
            solve(n - 1, r - half, c);
        } else {                              // 4사분면(우하단)
            answer += area * 3;
            solve(n - 1, r - half, c - half);
        }
		
	}
}