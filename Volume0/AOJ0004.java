import java.io.IOException;
import java.util.Scanner;

public class AOJ1004 {
	public static void main(String[] args) throws IOException {
		new AOJ1004().start();
	}
	
	private void start() throws IOException{
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()){
			double rotA[][] = new double[2][2];
			double rotB[] = new double[2];
			
			double a = sc.nextDouble();
			double b = sc.nextDouble();
			rotB[0] = sc.nextDouble();
			
			double c = sc.nextDouble();
			double d = sc.nextDouble();
			rotB[1] = sc.nextDouble();
			
			
			double bottom = a*d-b*c;
			rotA[0][0] = d;
			rotA[0][1] = -b;
			rotA[1][0] = -c;
			rotA[1][1] = a;
					
			double x = (rotB[0]*rotA[0][0]+rotB[1]*rotA[0][1]) / bottom;
			double y = (rotB[0]*rotA[1][0]+rotB[1]*rotA[1][1]) / bottom;
			
			if(x == 0.0) x = 0.0;
			if(y == 0.0) y = 0.0;
			
			System.out.printf("%.3f %.3f\n", x,y);
		}
	}
}