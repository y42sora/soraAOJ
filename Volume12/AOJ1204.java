import java.util.LinkedList;
import java.util.Scanner;

public class AOJ1204 {
	/*
	 * ある時点でタスクを開始したとき、次のタスクはそのすぐ後〜最大でもn後のどこかに入る。
	 * タスクの長さは固定のため、ある時点でタスクを開始したとき、そのタスクの末尾より後ろは全て空いている時間である。
	 * そのため、次のタスクの場所判定はその位置からnまでを覚えておけば行える。
	 * 
	 * 現在実行したタスクの数
	 * 現在時刻
	 * 前のタスクのスタートからｎ個までの状態
	 * 
	 * で覚えてDFSを行う。
	 * 
	 * ただしメモリの上限を簡単に超えてしまうため枝刈りを行う。
	 * 残りのタスクの数がx個だった場合、同時に始めることは出来ないため最低でもx時間はかかる
	 * というのを元に、一番初めに見つかった回答より長くなりそうなら枝切りをしている。
	 * 
	 * 本来なら、仮に一個ずつずらしたとしても最後のタスクにnの時間が取られるので、(x-1)+nで枝刈りすべきだがAOJはAcceptした。
	 */
	
	public static void main(String[] args) {
		new AOJ1204().start();
	}
	private void start() {
		Scanner sc = new Scanner(System.in);
		
		while(true){
			int n = sc.nextInt();
			if(n == 0) break;
			
			int[] task = new int[5];
			for(int i=0; i<5; i++){
				String str = sc.next();
				str = str.replace('.', '0');
				str = str.replace('X', '1');
				task[i] = Integer.valueOf(str, 2);
			}
			
			System.out.println(solv(n, task));
		}
	}
	private int solv(int n,int[] task) {
		int ans = Integer.MAX_VALUE;
		
		LinkedList<Data> ar = new LinkedList<Data>();
		ar.add(new Data(1, 1, task));
		
		while(!ar.isEmpty()){
			Data d = ar.removeLast();
			if(d.num == 10){
				ans = Math.min(ans, d.time + (n-1));
				continue;
			}
			
			for(int i=0; i<n; i++){
				if(ans < d.time + i + (9-d.num) ) break;
				int[] tasks = d.getMoveTask(i);
				if(isBooking(task,tasks)){
					ar.add(new Data(d.time+i, d.num+1, mergeTask(task,tasks)));
				}
			}
		}
		return ans;
	}
	
	int[] mergeTask(int[] task, int[] newtask){
		int[] res = new int[5];
		for(int i=0; i<5; i++){
			res[i] = task[i] + newtask[i];
		}
		return res;
	}
	
	boolean isBooking(int[] task, int[] newtask){
		for(int i=0; i<5; i++)
			if((task[i] & newtask[i]) != 0)
				return false;
		return true;
	}
	
	class Data{
		int[] task;
		int num;
		int time = 0;
		
		Data(int time,int num, int[] task){
			this.num = num;
			this.task = task;
			this.time = time;
		}
		
		int[] getMoveTask(int x){
			int[] newtask = new int[5];
			for(int i=0; i<5; i++)
				newtask[i] = task[i] >> x;
			
			return newtask;
		}
		
	}
}