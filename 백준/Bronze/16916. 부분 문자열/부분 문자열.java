import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String P = br.readLine();
		
		int n = S.length();
		int m  = P.length();
		
		int[] pi = new int[m];
		int j = 0;
		
		for(int i = 1; i<m; i++) {
			while(j>0 && P.charAt(i) != P.charAt(j)) {
				j = pi[j-1];
			}
			if(P.charAt(i) == P.charAt(j)) {
				j++;
				pi[i] = j;
			}
		}
		
		j = 0;
		for(int i = 0; i<n; i++) {
			while(j>0&&S.charAt(i) != P.charAt(j)) {
				j = pi[j-1];
			}
			if(S.charAt(i)==P.charAt(j)) {
				j++;
				if(j==m) {
					System.out.println(1);
					return;
				}
			}
		}
		System.out.println(0);
	}
}