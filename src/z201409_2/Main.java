package z201409_2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner fin = new Scanner(System.in);
		int[][] a = new int[102][102];
		int  n = fin.nextInt();
		int[] rec = new int[4];
		for(int i = 0;i<n;i++){
			for(int j = 0;j<4;j++){
				rec[j] = fin.nextInt();
			}
			//a rectangle
			for(int j = rec[0];j<rec[2];j++){
				for(int k = rec[1];k<rec[3];k++){
					a[j][k] =1;
				}
			}
		}
		fin.close();
		int counter=0;
		for(int i = 0;i<102;i++){
			for(int j=0;j<102;j++){
				if(a[i][j]==1){
					counter++;
				}
			}
		}
		System.out.println(counter);
	}
	
}
