import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int L = Integer.parseInt(br.readLine());
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		int D = Integer.parseInt(br.readLine());
		
		int korean = 0;
		if(A%C!=0) {
			korean = (A/C)+1;
		}else {
			korean = A/C;
		}
				
		int math = 0;
		if(B%D!=0) {
			math = (B/D)+1;
		}else {
			math = B/D;
		}
		
		if(korean>math) {
			System.out.println(L-korean);
		}else {
			System.out.println(L-math);
		}
	}
}