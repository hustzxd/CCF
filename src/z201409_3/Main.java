package z201409_3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner fin = new Scanner(System.in);
		
		String str0 = fin.nextLine();
		int flag  = fin.nextInt();
		int n = fin.nextInt();
		fin.nextLine();
		String[] strings = new String[n];
		for(int i=0;i<n;i++){
			strings[i] = fin.nextLine();
		}
		fin.close();
		for(int i=0;i<n;i++){
			if(flag == 1){
				if(strings[i].contains(str0)){
					System.out.println(strings[i]);
				}
			}
			else{
				if(strings[i].toLowerCase().contains(str0.toLowerCase())){
					System.out.println(strings[i]);
				}
			}
			
		}
	}

}
