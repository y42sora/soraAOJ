import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class AOJ1290 {
	public static void main(String[] args) {
		new AOJ1290().start();
	}
	
	private void start(){
		Scanner sc = new Scanner(System.in);
		
		Dice<Character> mainDice = new Dice<Character>('r','c','g','m','b','y');
		List<Dice<Character>> dices = mainDice.getAllState();
		
		int movex[] = {1,-1,0,0};
		int movey[] = {0,0,1,-1};
		
		while(true){
			int width = sc.nextInt();
			int height = sc.nextInt();
			if((width|height) == 0) break;
			
			char map[][] = new char[height][width];
			for(int i=0; i<height; i++)
				map[i] = sc.next().toCharArray();
			
			char order[] = sc.next().toCharArray();
			
			int sx = -1;
			int sy = -1;
			int gx = -1;
			int gy = -1;
			for(int i=0; i<height; i++){
				for(int j=0; j<width; j++){
					if(map[i][j]== '#'){
						sx = i;
						sy = j;
						map[i][j] = 'w';
					}
					if(map[i][j] == order[order.length-1] ){
						gx = i;
						gy = j;
					}
				}
			}
			
			int flag[][][][] = new int[height][width][7][24];
			Queue<Integer[]> list = new LinkedList<Integer[]>();
			list.add(new Integer[]{sx,sy,0,0});
			
			while(!list.isEmpty()){
				Integer[] now = list.poll();
				int nowx = now[0];
				int nowy = now[1];
				int nowState = now[2];
				int nowColor = now[3];
				if(nowColor == 6)
					break;
			
				Dice<Character> dice = dices.get(nowState);
				Dice<Character> nextDice = null;
				int numx = 0;
				int numy = 0;
				
				nextDice = dice.rollSouth();
				moveDice(nowx + movex[numx++], nowy + movey[numy++], width, height, dices.indexOf(nextDice), dices.indexOf(dice), nowColor, nextDice.get(Face.TOP), flag, list, map, nowx, nowy, order);
				
				nextDice = dice.rollNorth();
				moveDice(nowx + movex[numx++], nowy + movey[numy++], width, height, dices.indexOf(nextDice), dices.indexOf(dice), nowColor, nextDice.get(Face.TOP), flag, list, map, nowx, nowy, order);
				
				nextDice = dice.rollEast();
				moveDice(nowx + movex[numx++], nowy + movey[numy++], width, height, dices.indexOf(nextDice), dices.indexOf(dice), nowColor, nextDice.get(Face.TOP), flag, list, map, nowx, nowy, order);
				
				nextDice = dice.rollWest();
				moveDice(nowx + movex[numx++], nowy + movey[numy++], width, height, dices.indexOf(nextDice), dices.indexOf(dice), nowColor, nextDice.get(Face.TOP), flag, list, map, nowx, nowy, order);
			}
			
			int f = -1;
			for(int i=0; i<24; i++){
				if(flag[gx][gy][6][i]!= 0){
					f = flag[gx][gy][6][i];
					break;
				}
			}
			
			if(f==-1)System.out.println("unreachable");
			else System.out.println(f);
		}
	}
	
	private void moveDice(int nextx, int nexty, int width, int height, int diceID, int beforeDiceID, int nowColor, char diceTop, int[][][][] flag, Queue<Integer[]> list, char[][] map, int nowx, int nowy, char[] order) {
		if(isIn(nextx, nexty, width, height)){
			if(diceTop == map[nextx][nexty] && order[nowColor] == map[nextx][nexty]){
				if(flag[nextx][nexty][nowColor+1][diceID] == 0){
					flag[nextx][nexty][nowColor+1][diceID] = flag[nowx][nowy][nowColor][beforeDiceID]+1;
					list.add(new Integer[]{nextx, nexty, diceID, nowColor+1});
				}
			}else if(flag[nextx][nexty][nowColor][diceID] == 0){
				if(map[nextx][nexty] == 'w'){
					flag[nextx][nexty][nowColor][diceID] = flag[nowx][nowy][nowColor][beforeDiceID]+1;
					list.add(new Integer[]{nextx, nexty, diceID, nowColor});
				}
			}
		}
	}

	boolean isIn(int x,int y,int w,int h){
		if(0 <= x && x < h)
			if(0 <= y && y < w)
				return true;
		return false;
	}
	
	// 各面を表す
	static enum Face{TOP, BOTTOM, NORTH, SOUTH, EAST, WEST};
	
	class Dice <T>{
		// 各面に書かれている情報
		public T[] id;
		
		// 指定された面に書かれている情報を返す
		public T get(Face face){
			return id[face.ordinal()];
		}
		
		public Dice(T t, T b, T n,T s,T e,T w){
			@SuppressWarnings("unchecked")
			T[] tid = (T[])new Object[6];
			id = tid;
			id[Face.TOP.ordinal()] = t;
			id[Face.BOTTOM.ordinal()] = b;
			id[Face.NORTH.ordinal()] = n;
			id[Face.SOUTH.ordinal()] = s;
			id[Face.EAST.ordinal()] = e;
			id[Face.WEST.ordinal()] = w;
		}
		
		@Override
		public boolean equals(Object object){
			if(!(object instanceof Dice<?>)) return false;
			@SuppressWarnings("unchecked")
			Dice<T> dice = (Dice<T>)object;
			for(Face face : Face.values())
				if(!id[face.ordinal()].equals(dice.id[face.ordinal()]))
					return false;
			return true;
		}
		
		@Override
		public String toString(){
			String string = "";
			for(int i=0; i<id.length; i++)
				System.out.println(id[i]);
			return string;
		}
		
		// ダイスの全状態(24通り)を返す
		List<Dice<T>> getAllState(){
			List<Dice<T>> list = new ArrayList<Dice<T>>();
			Dice<T> d = copy();
			for(int i=0; i<6; i++){
				for(int j=0; j<4; j++){
					list.add(d);
					d = d.rollClockwise();
				}
				if(i%2 == 0) d = d.rollSouth();
				else d = d.rollEast();
			}
			return list;
		}
		
		// 同じものを作成する
		public Dice<T> copy(){
			return makeNewDice(0,1,2,3,4,5);
		}

		// 指定された面で新しくさいころを作る
		Dice<T> makeNewDice(int a,int b,int c,int d,int e,int f){
			return new Dice<T>(id[a],id[b],id[c],id[d],id[e],id[f]);
		}

		// さいころの数字から実際の添え字に変換
		Dice<T> makeNewDiceNum(int a,int b,int c,int d,int e,int f){
			return makeNewDice(a-1,b-1,c-1,d-1,e-1,f-1);
		}

		// 北側に回す
		Dice<T> rollNorth(){
			return makeNewDiceNum(4,3,1,2,5,6);
		}

		// 南側に回す
		Dice<T> rollSouth(){
			return makeNewDiceNum(3, 4, 2, 1, 5, 6);
		}

		// 東側に回す
		Dice<T> rollEast(){
			return makeNewDiceNum(6, 5, 3, 4, 1, 2);
		}

		// 西側に回す
		Dice<T> rollWest(){
			return makeNewDiceNum(5, 6, 3, 4, 2, 1);
		}

		//　反時計回りに90度回す
		Dice<T> rollReverseClockwise(){
			return makeNewDiceNum(1, 2, 5, 6, 4, 3);
		}

		// 時計回りに90度回す
		Dice<T> rollClockwise(){
			return makeNewDiceNum(1, 2, 6, 5, 3, 4);
		}
		
		// 180度回す
		Dice<T> rollTurn(){
			return makeNewDiceNum(1, 2, 4, 3, 6, 5);
		}
	}
}