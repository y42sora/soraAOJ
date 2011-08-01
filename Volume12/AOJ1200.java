import java.util.Scanner;

public class AOJ1200 {
	public static void main(String[] args) {
		AOJ1200 m = new AOJ1200();
		m.start();
	}

	boolean isPrime(int n){
		if(n < 1) return false;
		if(n == 2) return true;
		if(n % 2 == 0) return false;
		for(int i=3; i*i <= n; i+=2)
			if(n % i == 0) return false;
		return true;
	}
	
	private void start(){
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n ==0) break;
			int count = 0;
			if(isPrime(n-2))count++;
			
			for(int i=3; i <= n/2; i+=2)
				if(isPrime(i))
					if(isPrime(n-i))
						count++;
						
			System.out.println(count);
		}
	}
}