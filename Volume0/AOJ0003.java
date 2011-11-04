import java.io.IOException;
import java.util.Scanner;

public class AOJ1003 {
	public static void main(String[] args) throws IOException {
		new AOJ1003().start();
	}
	
	boolean isTriangle(int a,int b,int c){
		return a*a+b*b==c*c;
	}

	private void start() throws IOException{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			if (isTriangle(a, b, c))
				System.out.println("YES");
			else if (isTriangle(c, b, a))
				System.out.println("YES");
			else if (isTriangle(a, c, b))
				System.out.println("YES");
			else 
				System.out.println("NO");
		}
	}
}