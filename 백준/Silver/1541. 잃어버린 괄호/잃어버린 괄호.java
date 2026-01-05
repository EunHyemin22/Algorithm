import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sik = br.readLine();

		String[] parts = sik.split("-");
		
		int result = sumOfPlus(parts[0]); //첫 덩어리는 더
		for(int i = 1; i<parts.length; i++) {
			result -= sumOfPlus(parts[i]); //나머지는 전부 빼
		}
		System.out.println(result);
	}

	private static int sumOfPlus(String s) {
		String[] nums = s.split("\\+");
		int sum = 0;
		for(String num: nums) {
			sum += Integer.parseInt(num);
		}
		return sum;
	}
}