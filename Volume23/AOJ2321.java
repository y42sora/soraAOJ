/*
	AOJ 2321
	Butterfly
	この人怖い…
*/

import java.util.Scanner;

public class AOJ2321 {
	void run() {
		Scanner sc = new Scanner(System.in);
		int TIME = (int)Math.pow(2,17)-1;
		
		while(true) {
			int n = sc.nextInt();
			if(n==0)break;
			
			int[] date = new int[n];
			long[] sat = new long[n];
			
			for(int i = 0; i < n; i++) {//男性それぞれに対して
				int m = sc.nextInt();
				int l = sc.nextInt();
				sat[i] = l;
				for(int j = 0; j < m; j++) {//デートそれぞれに対して
					int s = sc.nextInt();
					int t = sc.nextInt();
					for(int k = s; k < t; k++)
						date[i] += Math.pow(2, (k-6));
				}
			}
						
			long[][] dp = new long[n][TIME+1];
			for(int j = 0; j <= TIME; j++) {//一人目
				if((date[0]&j)!=date[0]) {
					dp[0][j] = 0;
				}
				else {
					dp[0][j] = sat[0];
				}
			}
			for(int i = 1; i < n; i++) {//二人目以降
				for(int j = 0; j <= TIME; j++) {
					if((date[i]&j)!=date[i]) { //デートできなかったら
						dp[i][j] = dp[i-1][j];
					}
					else {//デートできるなら
						dp[i][j] = Math.max(dp[i-1][j-date[i]]+sat[i]
								, dp[i-1][j]);
					}
				}
			}
			
			long max = 0;
			for(int j = 0; j <= TIME; j++) {
				max = Math.max(max, dp[n-1][j]);
			}
			System.out.println(max);
		}
	}

	public static void main(String[] args) {
		(new AOJ2321()).run();
	}
}
