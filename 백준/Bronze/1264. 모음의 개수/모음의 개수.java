import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String line = br.readLine();

			if (line.equals("#")) break;

			int count = 0;

			for (char c : line.toCharArray()) {
				c = Character.toLowerCase(c);

				if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
					count++;
				}
			}

			System.out.println(count);
		}
	}
}