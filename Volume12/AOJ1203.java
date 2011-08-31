import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class AOJ1203 {
	public static void main(String[] args) {
		new AOJ1203().start();
	}
	
	private void start(){
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()){
			String line = sc.nextLine().toUpperCase().replaceAll("[^A-Z]", "");
			
			Set<String> palindromes = new TreeSet<String>();
			
			for(int i=1; i<line.length(); i++){
				makePalindromesOdd(i,1,line,palindromes);
				makePalindromesEven(i, 1, line, palindromes);
			}
			
			ArrayList<String> answers = new ArrayList<String>();
			for (String child : palindromes) 
				if(checkInString(child, answers))
					answers.add(child);
			
			for (String string : answers) 
				System.out.print(string + " ");
			System.out.println();
		}
	}
	
	boolean checkInString(String child, ArrayList<String> answers){
		for(int i=0; i<answers.size();i++){
			if(isIn(answers.get(i), child)){
				return false;
			}else if(isIn(child, answers.get(i))){
				answers.set(i, child);
				return false;
			}
		}
		return true;
	}

	boolean isIn(String mother, String child){
		if(mother.length()%2 != child.length()%2) return false;
		if(mother.length() < child.length()) return false;
		
		int len = (mother.length()-child.length()) /2;
		String checkString = mother.substring(len, child.length()+len);
		
		return child.equals(checkString);
	}

	void makePalindromesEven(int x, int size, String line,
			Set<String> palindromes) {
		int start = x-size;
		int end = x+1+size;
		if(0 <= start && end < line.length()){
			String checkString = line.substring(start, end+1);
			if(isPalindrome(checkString)){
				palindromes.add(checkString);
				makePalindromesEven(x, size+1, line, palindromes);
			}
		}
	}

	void makePalindromesOdd(int x, int size, String line, Set<String> palindromes) {
		int start = x-size;
		int end = x+size;
		if(0 <= start && end < line.length()){
			String checkString = line.substring(start, end+1);
			if(isPalindrome(checkString)){
				palindromes.add(checkString);
				makePalindromesOdd(x, size+1, line, palindromes);
			}
		}
	}
	
	boolean isPalindrome(String str){
		for(int i=0; i<str.length(); i++)
			if(str.charAt(i) != str.charAt(str.length()-1-i))
				return false;
		return true;
	}
}