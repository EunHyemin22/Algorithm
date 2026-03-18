import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());//시 
		int B = Integer.parseInt(st.nextToken());//분 
		int C = Integer.parseInt(st.nextToken());//초 
		
		int D = Integer.parseInt(br.readLine());//추가할 초
		
		// 1. 초 더하기
		C += D;
				
		// 2. 초 -> 분
		B += C / 60;
		C = C % 60;
				
		// 3. 분 -> 시
		A += B / 60;
		B = B % 60;
		
		// 4. 24시간 처리
		A = A % 24;
		
		System.out.println(A + " " + B + " " + C);
	}
}