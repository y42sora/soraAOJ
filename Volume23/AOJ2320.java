/*
	AOJ 2320
	Infinity Maze
	ループ検出がカギ
*/

import java.util.Scanner;

public class AOJ2320 {
	
	int[][] move = {{-1,0},{0,1},{1,0},{0,-1}};
	char[] str = {'N','E','S','W'};
	
	int h, w;
	long L;
	
	void run()  {
		Scanner sc = new Scanner(System.in);
		for(;;){
			h = sc.nextInt(); w = sc.nextInt(); L = sc.nextLong();
			if((h|w|L)==0)break;
			char[][] map = new char[h][w];
			int si = 0, sj = 0, d = 0;
			for(int i=0;i<h;i++){
				map[i] = sc.next().toCharArray();
				for(int j=0;j<w;j++){
					if(map[i][j]=='N'){
						map[i][j] = '.';
						si = i; sj = j; d = 0;
					}
					else if(map[i][j]=='E'){
						map[i][j] = '.';
						si = i; sj = j;d = 1;
					}
					else if(map[i][j]=='S'){
						map[i][j] = '.';
						si = i; sj = j;d = 2;
					}
					else if(map[i][j]=='W'){
						map[i][j] = '.';
						si = i; sj = j;d = 3;
					}
				}
			}
			long[][][] u = new long[h][w][4];
			for(int i=0;i<h;i++)for(int j=0;j<w;j++)for(int k=0;k<4;k++)u[i][j][k] = -1;
			u[si][sj][d] = 0;
			long step = 1;
			boolean skip = false;
			while(step<=L){
				int ni = si+move[d][0], nj = sj+move[d][1];
				for(;;){
					if(0<=ni&&ni<h&&0<=nj&&nj<w&&map[ni][nj]!='#')break;
					d = (d+1)%4;
					ni = si+move[d][0]; nj = sj+move[d][1];
				}
				si = ni; sj = nj;
				if(u[ni][nj][d]==-1||skip){
					u[ni][nj][d] = step;
				}
				else{
					skip = true;
					long dif = step-u[si][sj][d];
					long x = L - step;
					x%=dif;
					step = L-x;
				}
				step++;
			}
			System.out.println((si+1)+" "+(sj+1)+" "+str[d]);
		}
	}

	public static void main(String[] args) {
		new AOJ2320().run();
	}
}
