package z201503_1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,m;
		Scanner scanner = new Scanner(System.in);
		n  = scanner.nextInt();
		m = scanner.nextInt();
		int[][]nums = new int[n][m];
		for(int i = 0;i<n;i++){
			for(int j = 0;j<m;j++){
				nums[i][j] = scanner.nextInt();
			}
		}
		for(int i = 0 ;i<m;i++){
			for(int j= 0;j<n;j++){
				System.out.print(nums[j][m-i-1]+" ");
			}
			System.out.println();
		}
	}

}
