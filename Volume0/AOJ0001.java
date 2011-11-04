import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class AOJ1001 {
	public static void main(String[] args) throws IOException {
		new AOJ1001().start();
	}

	private void start() throws IOException{
		Scanner sc = new Scanner(System.in);
		
		int[] num = new int[10];
		for(int i=0; i<num.length; i++)
			num[i] = sc.nextInt();
		
		Arrays.sort(num);
		
		System.out.println(num[9]);
		System.out.println(num[8]);
		System.out.println(num[7]);
	}
}