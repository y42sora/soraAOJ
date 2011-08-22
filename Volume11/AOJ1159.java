import java.util.Scanner;

public class AOJ1159 {
	public static void main(String[] args) {
		new AOJ1159().start();
	}

	private void start(){
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			int p = sc.nextInt();
			if(n==0 && p==0) break;
			
			int h[] = new int[n];
			int stones = p;
			int ans = 0;
			while(h[ans]!= p ){
				if(stones != 0){
					h[ans]++;
					stones--;
					ans = (ans+1) % n;
				}else{
					stones = h[ans];
					h[ans] = 0; 
					ans = (ans+1) % n;
				}
			}
			System.out.println(ans);
		}
	}
}