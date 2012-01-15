import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class AOJ1002 {
	public static void main(String[] args) throws IOException {
		new AOJ1002().start();
	}

	private void start() throws IOException{
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String str1 = sc.next();
			String str2 = sc.next();
			
			BigInteger aBigInteger = new BigInteger(str1);
			BigInteger bBigInteger = new BigInteger(str2);
			
			BigInteger cBigInteger = aBigInteger.add(bBigInteger);
			
			System.out.println(cBigInteger.toString().length());
		}
	}
}