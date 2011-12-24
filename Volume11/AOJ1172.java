import java.util.LinkedList;
import java.util.Scanner;

public class AOJ1172 {
	
	public static void main(String[] args) {
		new AOJ1172().start();
	}
	private void start() {
		Scanner sc = new Scanner(System.in);
		
		boolean map[] = new boolean[123456*2+3];
		
		map[0] = true;
		map[1] = true;
		
		for(int i=2; i*2< map.length; i++)
			map[2*i] = true;
		
		for(int j=3; j<map.length; j+=2)
			for(int i=2; i*j< map.length; i++)
				map[j*i] = true;
		
		while(true){
			int n = sc.nextInt();
			if(n==0) break;
			int count = 0;
			for(int i=n+1; i<=2*n; i++)
				if(!map[i])
					count++;
			
			System.out.println(count);
			
			
		}
	
	}

}