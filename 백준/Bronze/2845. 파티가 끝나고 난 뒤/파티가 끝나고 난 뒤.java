import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int L = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		int[] people = new int[5];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<5; i++) {
			people[i] = Integer.parseInt(st.nextToken());
			people[i] -= L*P;
		}
		for(int n: people) {
			System.out.print(n + " ");
		}
	}
}