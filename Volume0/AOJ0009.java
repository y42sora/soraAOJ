import java.util.Scanner;

public class AOJ0009 {
	
	public static void main(String[] args) {
		new AOJ0009().start();
	}

	private void start() {
		Scanner sc = new Scanner(System.in);
		
		boolean map[] = makeMap();
		

		while(sc.hasNext()){
			int n = sc.nextInt();
			int count = 0;
			
			for(int i=0; i<=n; i++)
				if(!map[i])
					count++;
			count-=2;
			
			System.out.println(count);
		}
	}

	private boolean[] makeMap() {
		boolean map[] = new boolean[1000000];;
		
		for(int i=2; i<map.length; i++)
			if(!map[i])
				for(int j=2; i*j < map.length; j++)
					map[i*j] = true;

		return map;
	}

	private boolean isPrime(int n) {
		if(n % 2 == 0) return false;
		
		for(int i=3; i*i <= n; i++)
			if(n % i == 0)
				return false;

		return true;
	}
}
