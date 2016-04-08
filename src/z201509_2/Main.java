package z201509_2;

import java.util.Scanner;

public class Main {
	public static int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 30, 31 };

	public static void main(String[] args) {
		int year;
		int d;
		Scanner scanner = new Scanner(System.in);
		year = scanner.nextInt();
		d = scanner.nextInt();
		if (isBigYear(year)) {
			months[1] = 29;
		}
		int month = 1, date = 1;
		for(int i =0;i<12;i++){
			if(d<= months[i]){
				date = d;
				month = i+1;
				break;
			}else{
				d -=months[i];
			}
		}
		System.out.println(month);
		System.out.println(date);
	}

	public static boolean isBigYear(int year) {
		if ((year % 4 == 0 & year % 100 != 0) | (year % 400 == 0)) {
			return true;
		}
		return false;
	}
}
