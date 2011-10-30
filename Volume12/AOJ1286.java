import java.util.Scanner;

public class AOJ1286 {
	public static void main(String[] args) {
		AOJ1286 m = new AOJ1286();
		m.start();
	}
	
	private void start(){
		Scanner sc = new Scanner(System.in);
		
		while(true){
			int inN = sc.nextInt();
			int inM = sc.nextInt();
			int inK = sc.nextInt();
			if((inN|inM|inK) == 0) break;
			
			int num[][] = new int[inN+1][inM*inN+1];
			
			for (int i = 1; i <= inM; i++) 
				num[1][i] = 1;
			
			for(int i=1; i<= inN; i++)
				for(int j=1; j<=inN*inM; j++)
					for(int k=1; k<=inM; k++)
						if(j+k <= inN*inM)
							num[i][j+k] += num[i-1][j];
			
			double ans = 0.0;
			double all = Math.pow(inM, inN);
			for(int i=1; i<= inK; i++)
				ans += (double)num[inN][i] / all;
		
			for(int i=inK+1; i <= inM*inN; i++)
				ans += (i - inK) * (double)num[inN][i] / all;
			
			System.out.println(ans);
		}
	}
}