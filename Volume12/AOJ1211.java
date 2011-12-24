import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class AOJ1211 {
	public static void main(String[] args){
		new AOJ1211().start();
	}

	/*
	 * 与えられた図形の中に含まれる台形の面積と、その面積の台形の個数を数える。
	 * 中に台形を含む場合でも無視して面積を計算する。
	 * 
	 * 左上から順に見て行けば、見つけた辺は必ず上辺。
	 * 台形は決して隣接しないらしいので、比較的容易に調べられる。
	 * 後は計算するだけ
	 * 実装ゲー
	 */
	private void start(){
		
		Scanner sc = new Scanner(System.in);

		boolean flag = false;
		while(true){
			int n = sc.nextInt();
			if(n == 0) break;
			if(flag)
				System.out.println("----------");
			else 
				flag = true;
			
			sc.nextLine();
			String string = sc.nextLine();
			string = string.replace(' ', '0');
			string = string.replace('*', '1');
			boolean map[][] = new boolean[n][90];
			
			
			for(int j=0; j<string.length(); j++)
				if(string.charAt(j) == '0')
					map[0][j]= false;
				else 
					map[0][j] = true;
			
			for(int i=1; i<n ; i++){
				string = sc.nextLine();
				string = string.replace(' ', '0');
				string = string.replace('*', '1');
				
				for(int j=0; j<string.length(); j++)
					if(string.charAt(j) == '0')
						map[i][j]= false;
					else 
						map[i][j] = true;
			}
			
			solv(map, n, 90);
		}
	}

	private void solv(boolean[][] map, int h, int w) {
		TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
		
		for(int i=0; i<h; i++)
			for(int j=0; j<w; j++)
				if(map[i][j])
					addTree(treeMap,j,i,h,w,map);
					
		Set<Integer> keySet = treeMap.keySet();
		for (Integer i : keySet)
			System.out.println((i/2) + " " + treeMap.get(i));
	}
	void printall(boolean[][] map){
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if(map[i][j])
					System.out.print(1);
				else 
					System.out.print(0);
				
			}
			System.out.println("");
		}
		System.out.println("");
		System.out.println("");

	}

	private void addTree(TreeMap<Integer, Integer> treeMap, int x, int y, int h, int w, boolean[][] map) {
		int xl = 0;
		while(x+xl < w && map[y][x+xl]) map[y][x+xl++] = false;
		
		
		int nowx = x+xl-1;
		
		int dict = 0;
		if(nowx+1 < w && map[y+1][nowx+1])
			dict = 1;
		else if(map[y+1][nowx])
			dict = 0;
		else
			dict = -1;

		nowx += dict;
		
		int yl = 1;
		while(true){
			if( 0<= nowx && nowx < w){
				if( y+yl < h){
					if(map[y+yl][nowx]){
						map[y+yl][nowx] = false;
						yl++;
						nowx+=dict;
						continue;
					}
				}
			}
			break;
		}
		
		
		int nowy = y+yl-1;
		map[nowy][nowx-=dict] = true;
				
		int x2l = 0;
		while(0 <= nowx+x2l && map[nowy][nowx+x2l]) map[nowy][nowx+x2l--] = false;
		
		x2l = -x2l;
		

		
		dict = 0;
		if(map[y+1][x+1])
			dict = 1;
		else if(map[y+1][x])
			dict = 0;
		else
			dict = -1;

		nowx = x+dict;
		
		int y2l = 1;
		while(true){
			if( 0<= nowx && nowx < w){
				if( y+y2l < h){
					if(map[y+y2l][nowx]){
						map[y+y2l][nowx] = false;
						y2l++;
						nowx+=dict;
						continue;
					}
				}
			}
			break;
		}

		int rect = (xl+x2l)*yl;
		if(treeMap.containsKey(rect))
			treeMap.put(rect, treeMap.get(rect)+1);
		else 
			treeMap.put(rect, 1);
	}
}