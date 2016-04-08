package z201503_2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner fin = new Scanner(System.in);
		int n = fin.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = fin.nextInt();
			b[i] = 1;
		}
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int temp = a[i];
				if (temp == a[j]) {
					b[i] += b[j];
					b[j] = 0;
				}
			}
		}
		//sort
		for(int i =0;i<n;i++){
			for(int j = i;j<n;j++){
				if(b[j]>b[i] | (b[j]==b[i] && a[j] < a[i])){
					int tempa,tempb;
					tempa = a[i];
					a[i] = a[j];
					a[j] = tempa;
					tempb = b[i];
					b[i] = b[j];
					b[j] = tempb;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			if (b[i] != 0)
				System.out.println(a[i] + " " + b[i]);
		}
	}
}
