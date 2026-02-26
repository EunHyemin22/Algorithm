import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] tang = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			tang[i] = Integer.parseInt(st.nextToken());
		}

		Map<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int max = 0;

        for (int right = 0; right < N; right++) {
            map.put(tang[right], map.getOrDefault(tang[right], 0) + 1);

            while (map.size() > 2) {
                map.put(tang[left], map.get(tang[left]) - 1);
                if (map.get(tang[left]) == 0) {
                    map.remove(tang[left]);
                }
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        System.out.println(max);
	}
}