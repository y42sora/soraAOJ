import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AOJ1210 {
	public static void main(String[] args){
		new AOJ1210().start();
	}

	/*
	 * 問題文が無駄に長いけど、言われたとおりにダイスを転がすだけ
	 * テーブルからも落ちない、回数は1000回程度。
	 * ライブラリがあればイチコロ
	 */
	private void start(){
		Scanner sc = new Scanner(System.in);

		while(true){
			int n = sc.nextInt();
			if(n == 0) break;
			
			Dice<Integer> dice = new Dice<Integer>(1, 6, 2, 5, 4, 3);
			
			for (int i = 0; i < n; i++) {
				String string = sc.next();
				switch(string.charAt(0)){
				case 'n':
					dice = dice.rollNorth();
					break;
				case 's':
					dice = dice.rollSouth();
					break;
				case 'w':
					dice = dice.rollWest();
					break;
				case 'e':
					dice = dice.rollEast();
					break;
				}
			}
			System.out.println(dice.get(Face.TOP));
		}
		

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