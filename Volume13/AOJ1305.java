import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class AOJ1305 {
	public static void main(String[] args){
		new AOJ1305().start();
	}

	/*
	 * グループ名:グループメンバー
	 * という入力が与えられる。
	 * グループメンバーには、メンバーの名前もしくは子グループの名前が,で区切られて入力される。
	 * 
	 * 一番初めに入力されたグループの子グループまで含めた全てのメンバーは何人いるかを答える問題。
	 * ただし同じ名前の人がいるので重複は削除、子グループはメンバーじゃない。
	 * 同じ名前のグループは存在しないという条件。
	 * 
	 * グラフを作って検索するだけ。
	 * 入力列の最後に.があるので、それを削除するのを忘れずに。
	 * グループ内に同じ名前が出てくるので、子グループを毎回調べてしまうとメモリがパンクする。
	 * 一回で良いように調べたものはメモるべし。
	 */
	private void start(){
		
		Scanner sc = new Scanner(System.in);

		while(true){
			int n = sc.nextInt();
			if(n == 0) break;
			
			String firstString = null;
			
			HashMap<String, Integer> groupName = new HashMap<String, Integer>();
			ArrayList<String[]> groups = new ArrayList<String[]>();
			for(int i=0; i<n; i++){
				String string = sc.next();
				String name[] = string.split(":");
				groupName.put(name[0], i);
				if(firstString == null) firstString = name[0];

				groups.add(name[1].substring(0, name[1].length()-1).split(","));
			}
			
			HashSet<String> ansGroupMember = new HashSet<String>();
			HashSet<String> ansGroupName = new HashSet<String>();
			LinkedList<String> list = new LinkedList<String>();
			
			list.add(firstString);
			while(!list.isEmpty()){
				String string = list.poll();
				
				if(ansGroupMember.contains(string))continue;
				else if(ansGroupName.contains(string)) continue;
				else if(groupName.containsKey(string)){
					int groupNum = groupName.get(string);
					String[] member = groups.get(groupNum);
					
					ansGroupName.add(string);
					
					for (String memberString : member) 
						list.add(memberString);
				}else{
					ansGroupMember.add(string);
				}
			}
			
			System.out.println(ansGroupMember.size());
			
			

		}
	}

}