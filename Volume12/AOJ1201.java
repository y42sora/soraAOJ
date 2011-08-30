import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class AOJ1201 {
	public static void main(String[] args) {
		new AOJ1201().start();
	}
	
	private void start(){
		Scanner sc = new Scanner(System.in);
		while(true){
			String string = sc.next();
			if(string.equals("END")) break;
			
			int[] particles = new int[10];
			particles[0] = Integer.valueOf(string, 2);
			for(int i=1; i<10; i++)
				particles[i] = Integer.valueOf(sc.next(), 2);
			
			
			Set<Integer> solution = new TreeSet<Integer>();
			int  used[] = new int[5];
			for (int i = 0; i < 5; i++) 
				used[i] = -1;
			makeSolution(0, used, particles, solution);
			
			int count = countAnswer(solution);
			System.out.println(count/2);
		}
	}
	
	int countAnswer(Set<Integer> solution){
		int count = 0;
		Set<Integer> duplicate = new TreeSet<Integer>();
		for (Integer integer : solution) {
			int[] rot = getAllState(integer);
			
			boolean flag = true;
			for(int i=0; i<rot.length; i++)
				if(duplicate.contains(rot[i]))
					flag = false;
			
			for(int i=0; i<rot.length; i++)
				duplicate.add(rot[i]);
			
			if(flag)
				count++;
		}
		return count;
	}
	
	private int[] getAllState(int x){
		int state[] = new int[8];
		
		int bottom[] = new int[5];
		for(int i=4; 0 <= i; i--)
			bottom[i] = (x >> (i*5))% 32;
		int[] rot = getRotate(bottom);
		
		for(int i=0; i<4; i++)
			state[i]= rot[i];
		
		for (int j = 0; j < bottom.length; j++) 
			bottom[j] = reverse(bottom[j]); 
		
		rot = getRotate(bottom);
		for(int i=0; i<4; i++)
			state[i+4]= rot[i];
		
		return state;
	}

	private void makeSolution(int num, int[] used, int[] particles, Set<Integer> solution) {
		if(num == 5){
			solv(used, particles, solution);
			return;
		}
		
		for(int i=0; i<10; i++){
			boolean flag = true;
			for(int j=0; j<num; j++)
				if(used[j] == i )
					flag = false;
			
			if(!flag) continue;
			
			used[num] = i;
			makeSolution(num+1, used, particles, solution);
			used[num] = -1;
			
		}
	}

	private void solv(int[] used, int[] particles, Set<Integer> solution) {
		
		int unUsedNum = 0;
		int unUsed[] =new int[5];
		
		for(int i=0; i<10; i++){
			boolean flag = true;
			for(int j=0; j<5; j++)
				if(used[j] == i)
					flag = false;
			if(flag)
				unUsed[unUsedNum++] = i;
		}

		for(int i=0; i<32; i++)
			checkSolution(i, used, unUsed, particles, solution);
	}

	private void checkSolution(int flag, int[] used, int[] unUsed, int[] particles,
			 Set<Integer> solution) {
		int [] nowBottom = new int[5];
		int [] nowUp = new int[5];
		int x = 0;
		for(int i=0; i<5; i++){
			if(flag%2 == 0){
				nowBottom[i] = particles[used[i]];
			}else{
				nowBottom[i] = reverse(particles[used[i]]);
			}
			x = x << 5;
			x += nowBottom[i];
			flag = flag / 2;
			
			nowUp[i] = particles[unUsed[i]];
		}
		
		if(solution.contains(x)) return;
		
		int[] bottom = new int[5];
		for (int i = 0; i < bottom.length; i++) {
			bottom[i] = getRow(nowBottom, i+1);
		}
		
		boolean flags[] = new boolean[5];
		if(checkEquals(0, flags, bottom, nowUp))
			addAnswer(nowBottom,solution);
	}
	
	

	private void addAnswer(int[] nowBottom, Set<Integer> solution) {
		int[] rot = getRotate(nowBottom);
		
		for (int i = 0; i < rot.length; i++) 
			solution.add(rot[i]);
	}

	int[] getRotate(int[] nowBottom) {
		int[] rot = new int[4];
		
		int x = 0;
		for(int i=0; i<5; i++)
			x = (x << 5) + nowBottom[i];
		rot[0] = x;

		int check[] = new int[5];
		
		//rotet90
		x = 0;
		for(int i=0; i<5; i++)
			check[i] = getRow(nowBottom, 5-i);
		for(int i=0; i<5; i++)
			x = (x << 5) + check[i];
		rot[1] = x;
		
		//rotet270
		x = 0;
		for(int i=0; i<5; i++)
			check[i] = reverse(getRow(nowBottom, i+1));
		for(int i=0; i<5; i++)
			x = (x << 5) + check[i];
		rot[2] = x;
		
		//mirror
		x = 0;
		for(int i=0; i<5; i++)
			check[i] = reverse(nowBottom[4-i]);
		for(int i=0; i<5; i++)
			x = (x << 5) + check[i];
		rot[3] = x;
		
		return rot;
	}

	boolean checkEquals(int num, boolean[] flags, int[] nowBottom, int[] nowUp) {
		if(num == 5) return true;
		
		for(int i=0; i<5; i++){
			if(!flags[i]){
				if(nowBottom[num] == (nowUp[i] ^ 31) || nowBottom[num] == (reverse(nowUp[i]) ^ 31)){
					flags[i] = true;
					if(checkEquals(num+1, flags, nowBottom, nowUp))
						return true;
					flags[i] = false;
				}
			}
		}
		return false;
	}

	int getRow(int[] nowBottom, int b) {
		int x = 1 << (b-1);
		
		int ans = 0;
		for(int i=0; i<5; i++)
			ans += ((nowBottom[i]&x) >> (b-1)) << i;
		
		return ans;
	}
	
	int reverse(int x){
		int ans = 0;
		for(int i=0; i<5; i++){
			ans = ans << 1;
			ans += (x&(1 << i)) >> i;
		}
		return ans;
	}
}