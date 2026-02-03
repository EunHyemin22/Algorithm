import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().trim();

        // 출력용 StringBuilder (스택처럼 사용)
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            // 현재 문자 추가
            sb.append(input.charAt(i));

            // 길이가 4 이상인 경우
            if (sb.length() >= 4) {
                int len = sb.length();
                // 마지막 4문자가 "PPAP"인지 체크
                if (sb.charAt(len - 4) == 'P' &&
                    sb.charAt(len - 3) == 'P' &&
                    sb.charAt(len - 2) == 'A' &&
                    sb.charAt(len - 1) == 'P') {
                    // PPAP → P로 치환
                    sb.delete(len - 4, len);
                    sb.append("P");
                }
            }
        }

        // 최종적으로 하나의 'P'만 남아야 PPAP 문자열
        if (sb.toString().equals("P")) {
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        }
    }
}