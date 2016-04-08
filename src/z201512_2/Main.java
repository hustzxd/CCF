package z201512_2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int n, m;
		Scanner fin = new Scanner(System.in);
		n = fin.nextInt();
		m = fin.nextInt();
		int[][][] a = new int[n][m][3];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				a[i][j][0] = fin.nextInt();// data
				a[i][j][1] = 1;// flag row
				a[i][j][2] = 1;// flag column
			}
		}
		fin.close();
		// <handle
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (j >= 1) {
					if (a[i][j][0] == a[i][j - 1][0]) {
						//is same to last one
						a[i][j][1] += a[i][j-1][1];
						for(int k=1;k<a[i][j][1];k++){
							a[i][j-k][1]=a[i][j][1];
						}
					}
				}
			}
		}

		
		for(int i = 0;i< m;i++){
			for(int j = 0;j<n;j++){
				if(j >=1){
					if(a[j][i][0]==a[j-1][i][0]){
						//is same to last one
						a[j][i][2]+=a[j-1][i][2];
						for(int k =1;k<a[j][i][2];k++){
							a[j-k][i][2] = a[j][i][2];
						}
					}
				}
			}
		}
		// handle>

		// <display
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(a[i][j][1]>=3 | a[i][j][2]>=3){
					System.out.print(0+" ");
				}else {
					System.out.print(a[i][j][0] + " ");
				}
				
			}
			System.out.println();
		}
		// display>

	}
}
