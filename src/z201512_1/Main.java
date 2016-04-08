package z201512_1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner fin = new Scanner(System.in);
		Long n = fin.nextLong();
		fin.close();
//		System.out.println("n = "+ n);
		int result = 0;
		Long res = (long) -1;
		int rem = 0;
		while(res!=0){
			rem = (int) (n%10);
			result +=rem;
			res = n /10;
			n = res;
		}
		System.out.println(result);
	}

}
