package z201503_3;

import java.util.Scanner;

public class Main {
	static int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	static int[] months2 = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a, b, c, y1, y2;
		Scanner fin = new Scanner(System.in);
		a = fin.nextInt();
		b = fin.nextInt();
		c = fin.nextInt();
		y1 = fin.nextInt();
		y2 = fin.nextInt();
		fin.close();
		int[] years = new int[y2 - y1 + 1];
		int[] sum = new int[years.length];
		for (int i = 0; i < years.length; i++) {
			years[i] = y1 + i;
			sum[i] = 0;
			for (int j = 1850; j < years[i]; j++) {
				if (isBigYear(j)) {
					sum[i] += 366;
				} else {
					sum[i] += 365;
				}
			}
			for (int j = 0; j < a - 1; j++) {
				if (isBigYear(years[i])) {
					sum[i] += months2[j];
				}
				else{
					sum[i] += months[j];
				}
				
			}

			if (isBigYear(years[i])) {
				int counter = 0;
				int resultday = 0;
				for (int j = 0; j < months2[a - 1]; j++) {
					if (getDay(sum[i] + j) == c) {
						counter++;
						if (counter == b) {
							resultday = j + 1;
							break;
						}
					}
				}
				if (resultday == 0)
					System.out.println("none");
				else
					System.out.printf("%04d" + "/" + "%02d" + "/" + "%02d\n", years[i], a, resultday);
			} else {
				int counter = 0;
				int resultday = 0;
				for (int j = 0; j < months[a - 1]; j++) {
					if (getDay(sum[i] + j) == c) {
						counter++;
						if (counter == b) {
							resultday = j + 1;
							break;
						}
					}
				}
				if (resultday == 0)
					System.out.println("none");
				else
					System.out.printf("%04d" + "/" + "%02d" + "/" + "%02d\n", years[i], a, resultday);
			}
		}
	}

	 public static boolean isBigYear(int year) {
		// TODO Auto-generated method stub
		if ((year % 4 == 0 & year % 100 != 0) | year % 400 == 0) {
			return true;
		} else
			return false;
	}

	static int getDay(int sum) {
		int day = (sum % 7 + 2) % 7;
		if (day == 0)
			return 7;
		return day;
	}
}
