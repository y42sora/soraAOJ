import java.util.Scanner;

public class AOJ0008 {
	
	public static void main(String[] args) {
		new AOJ0008().start();
	}

	private void start() {
		Scanner sc = new Scanner(System.in);

		while(sc.hasNext()){
			int n = sc.nextInt();
			
			int num[] = new int[51];
			for(int i=0; i<10; i++)
				for(int j=0; j<10; j++)
					num[i+j]++;
	
			int count = 0;
			for(int i=0; i<25; i++)
				if(0<= n-i)
					count += num[i] * num[n-i];
			
			System.out.println(count);
		}
	}
}
