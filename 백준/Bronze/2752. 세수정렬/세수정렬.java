import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] sortNum = new int[3];
		for(int i = 0; i<3; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			sortNum[i] = num;
		}
		
		Arrays.sort(sortNum);
		
		for(int n: sortNum) {
			System.out.print(n + " ");
		}
	}
}