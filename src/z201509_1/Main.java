package z201509_1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] a = new int[n];
		int result = 1;
		for (int i = 0; i < n; i++) {
			a[i] = scan.nextInt();
		}
		int temp = a[0];
		for (int i = 1; i < n; i++) {
			if(a[i] != temp){
				result ++;
				temp = a[i];
			}
		}
		System.out.println(result);
	}
}
