import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int S = Integer.parseInt(br.readLine());
		String str = br.readLine();

		int count = 0;
		int answer = 0;

		for(int i = 0; i < S-2; i++) {

			if(str.charAt(i)=='I' && str.charAt(i+1)=='O' && str.charAt(i+2)=='I') {
				count++;
				i++; // O 건너뜀
				
				if(count == N) {
					answer++;
					count--;
				}

			}else {
				count = 0;
			}
		}

		System.out.println(answer);
	}
}