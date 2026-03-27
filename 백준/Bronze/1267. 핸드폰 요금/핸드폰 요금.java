import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int costY = 0;
	    int costM = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			int time = Integer.parseInt(st.nextToken());

            costY += (time / 30 + 1) * 10;
            costM += (time / 60 + 1) * 15;
		}
			
		if(costY > costM) {
			System.out.println("M " + costM);
		}else if(costY==costM) {
			System.out.println("Y M " + costY);
		}else {
			System.out.println("Y " + costY);
		}
		
	}
}