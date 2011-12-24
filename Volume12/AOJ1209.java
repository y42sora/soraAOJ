import java.util.Scanner;

public class AOJ1209 {
	public static void main(String[] args){
		new AOJ1209().start();
	}

	/*
	 * DP
	 * i*iまでのコインを使ってnを作る方法が、この通りだけありますよという表を作る。
	 * 
	 * (i-1)*(i-1)のコインまででx通り表せるなら、i*iのコインを加えてもx通りは必ず表すことが出来る。
	 * さらに、n-i*iを表せるなら、i*iのコインを加えることでnを表すことが出来る。
	 * 
	 * 表の更新は
	 * i-1まででnを表現する通り+ (使えるなら) n-i*iの通り
	 * で更新していく
	 * 最後に17枚全部使ったときに入力のnを作る通りの数を出力する
	 */
	private void start(){
		Scanner sc = new Scanner(System.in);
		
		int dp[][] = new int[18][300];
		dp[0][0] = 1;

		for(int i=1; i<18; i++){
			for(int j=0; j<300; j++){
				if(0 <= j-i*i )
					dp[i][j] = dp[i][j-i*i]; 
				dp[i][j]+= dp[i-1][j];
			}
		}

		while(true){
			int n = sc.nextInt();
			if(n == 0) break;
			
			System.out.println(dp[17][n]);
		}
	}
}