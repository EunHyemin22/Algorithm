import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		//R(뒤집기), D(버리기)
		for(int t = 0; t<T; t++) {
			String order = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String arr = br.readLine();
			
			Deque<Integer> dq = new ArrayDeque<>();
			
			arr = arr.substring(1, arr.length()-1);

			// n이 0이 아닐 때만 파싱
            if (n > 0) {
                String[] temp = arr.split(",");
                for (int i = 0; i < n; i++) {
                    dq.offer(Integer.parseInt(temp[i]));
                }
            }

            boolean reversed = false;
            boolean error = false;

            for (int i = 0; i < order.length(); i++) {
                char cmd = order.charAt(i);

                if (cmd == 'R') {
                    reversed = !reversed;
                } else if (cmd == 'D') {
                    if (dq.isEmpty()) {
                        error = true;
                        break;
                    }

                    if (!reversed) {
                        dq.pollFirst();
                    } else {
                        dq.pollLast();
                    }
                }
            }

            if (error) {
                answer.append("error\n");
            } else {
                answer.append("[");
                while (!dq.isEmpty()) {
                    if (!reversed) {
                        answer.append(dq.pollFirst());
                    } else {
                        answer.append(dq.pollLast());
                    }

                    if (!dq.isEmpty()) {
                        answer.append(",");
                    }
                }
                answer.append("]\n");
            }
        }

        System.out.print(answer);
    }
}