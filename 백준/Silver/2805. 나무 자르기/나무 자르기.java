import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		long[] tree = new long[N];
		long max = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			if(max <= tree[i]) {
				max = tree[i];
			}
		}
		
		long low = 0;
		long high = max;
		long key = 0;
		
		while(low<=high) {
			long mid = low+(high-low)/2;
			long cnt = 0;
			for(int i = 0; i<N; i++) {
				if(mid <= tree[i]) {
					cnt += (tree[i]-mid);
				}
			}
			if(cnt >= M) {
				key = mid;
				low = mid+1;
			}else {
				high = mid-1;
			}
			
		}
		System.out.println(key);
	}
}