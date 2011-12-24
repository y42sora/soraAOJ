import java.util.LinkedList;
import java.util.Scanner;

public class AOJ1147 {
	
	public static void main(String[] args) {
		new AOJ1147().start();
	}
	private void start() {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0) break;
			
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			int sum = 0;
			for(int i=0; i<n; i++){
				int x = sc.nextInt();
				max = Math.max(max, x);
				min = Math.min(x, min);
				sum += x;
			}
			
			sum -= max;
			sum -= min;
			System.out.println(sum/(n-2));
			
		}
	
	}

}