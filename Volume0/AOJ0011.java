import java.util.Scanner;

public class AOJ0011 {
	public static void main(String[] args){
		new AOJ0011().start();
	}
	
	/*
	 * 横棒の高さが指定されてないし、上から順番に横棒が与えられるという事でいいのかな？
	 * だとすると、出て来た順に入れ替えるだけ。
	 */
	
	private void start(){
		Scanner sc = new Scanner(System.in);

		int w = sc.nextInt();
		int list[] = new int[w+1];
		for(int i=0; i < list.length; i++)
			list[i]= i; 
		
		int n = sc.nextInt();
		for(int i=0; i<n; i++){
			String string = sc.next();
			String[] strings = string.split(",");
			int a = Integer.parseInt(strings[0]);
			int b = Integer.parseInt(strings[1]);
			
			int c = list[a];
			list[a] = list[b];
			list[b]= c; 
		}
		
		for (int i = 1; i < list.length; i++) 
			System.out.println(list[i]);
	}
}