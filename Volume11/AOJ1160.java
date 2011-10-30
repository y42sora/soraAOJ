import java.util.Scanner;

public class AOJ1160 {
	public static void main(String[] args) {
		new AOJ1160().start();
	}

	private void start() {
		Scanner sc = new Scanner(System.in);

		while(true){
			int w = sc.nextInt();
			int h = sc.nextInt();
			
			if(w==h && w==0)
				break;
			
			boolean map[][] = new boolean[h][w];
			boolean flags[][] = new boolean[h][w];
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					flags[i][j]= false;
					if(sc.nextInt() == 1)
						map[i][j]=true;
					else {
						map[i][j]= false; 
					}
				}
			}
			
			int ans = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if(check(i,j,w,h,map,flags)){
						ans++;
					}
				}
			}
			System.out.println(ans);
		}
	}
	
	int move[][] = {
			{-1,-1},
			{-1,0},
			{-1,1},
			{0,-1},
			{0,0},
			{0,1},
			{1,-1},
			{1,0},
			{1,1}
	};

	private boolean check(int i, int j, int w, int h, boolean[][] map, boolean[][] flags) {
		if(i < 0) return false;
		if(h <= i) return false;
		if(j < 0) return false;
		if(w <= j) return false;
		if(!map[i][j]) return false;
		if(flags[i][j]) return false;
		
		flags[i][j] = true;
		
		for (int k = 0; k < move.length; k++) 
			check(i+move[k][0], j+move[k][1], w, h, map, flags);
		
		return true;
	}
}