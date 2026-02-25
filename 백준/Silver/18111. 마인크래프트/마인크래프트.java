import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[][] mineCraft = new int[N][M];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				mineCraft[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		
		int H = 0;
		int a = 0;
		int T = 0;
		int bestT = Integer.MAX_VALUE;
		int bestH = 0;
		while(H<=256) {
			int remove = 0;
			int add = 0;
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<M; j++) {
					a = mineCraft[i][j];
					if(a > H) {
						remove += a-H;
					}else if(a < H) {
						add += H-a;
					}else {
						continue;
					}
				}
			}
			if(B + remove < add) {
				H++;
				continue;
			}else {
				T = 2*remove + add;
			}
			if(T<bestT || (T==bestT && H>bestH)) {
				bestT = T;
				bestH = H;
			}
			H++;
		}//while
		System.out.println(bestT + " " + bestH);
	}
}