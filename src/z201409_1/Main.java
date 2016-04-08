package z201409_1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner fin = new Scanner(System.in);
		int n = fin.nextInt();
		int[] a = new int[n];
		for(int i =0 ;i<n;i++){
			a[i] = fin.nextInt();
		}
		fin.close();
		int counter = 0;
		for(int i = 0;i<n;i++){
			for(int j=i;j<n;j++){
				if(Math.abs(a[i]-a[j])==1){
					counter++;
				}
			}
		}
		System.out.println(counter);
	}

}
