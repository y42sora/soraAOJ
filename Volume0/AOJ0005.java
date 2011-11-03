import java.util.Scanner;


public class AOJ0005 {
	
	public static void main(String[] args) {
		new AOJ0005().start();
	}

	private void start() {
		Scanner sc = new Scanner(System.in);

		while(sc.hasNext()){
			long a = sc.nextLong();
			long b = sc.nextLong();
		
			long gcd = gcd(a,b);
		
			long lcm = a*b/gcd;
			System.out.println(gcd + " " + lcm);
		}
	}

	private long gcd(long a, long b) {
		if(a < b) return gcd(b,a);
		
		if(b == 0) return a;
		return gcd(b, a%b);
	}

}
