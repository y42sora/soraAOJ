import java.util.Scanner;

public class AOJ0006 {
	
	public static void main(String[] args) {
		new AOJ0006().start();
	}

	private void start() {
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		
		StringBuffer sb = new StringBuffer(str);
		
		sb.reverse();
		System.out.println(sb);
	}
}
