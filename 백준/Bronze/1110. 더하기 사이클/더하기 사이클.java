import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cur = N;
        int count = 0;

        do {
            int a = cur / 10;        // 십의 자리
            int b = cur % 10;        // 일의 자리
            int c = (a + b) % 10;    // 합의 일의 자리

            cur = b * 10 + c;
            count++;

        } while (cur != N);

        System.out.println(count);
    }
}