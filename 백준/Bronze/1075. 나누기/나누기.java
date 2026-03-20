import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int F = Integer.parseInt(br.readLine());
		
		// 뒤 두 자리를 00으로 바꾸기
        N = (N / 100) * 100;

        // 00 ~ 99 중에서 가장 작은 값 찾기
        for (int i = 0; i < 100; i++) {
            if ((N + i) % F == 0) {
                System.out.printf("%02d\n", i);
                break;
            }
        }
	}
}