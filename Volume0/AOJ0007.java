import java.util.Scanner;


public class AOJ0007 {
	
	public static void main(String[] args) {
		new AOJ0007().start();
	}

	private void start() {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		long money = 100000;
		for(int i=0; i<n; i++){
			money *= 1.05;
			
			money += 999;
			money /= 1000;
			money *= 1000;
		}
		
		System.out.println(money);
	}
}
