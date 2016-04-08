package z201512_3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner fin = new Scanner(System.in);
		int m;// width
		int n;// height
		int q;// number of operation
		m = fin.nextInt();
		n = fin.nextInt();
		q = fin.nextInt();
		Picture picture = new Picture(m, n);

		for (int i = 0; i < q; i++) {
			int flag = fin.nextInt();
			if (flag == 0) {// draw line
				int x1, y1, x2, y2;
				x1 = fin.nextInt();
				y1 = fin.nextInt();
				x2 = fin.nextInt();
				y2 = fin.nextInt();
				picture.drawLine(x1, y1, x2, y2);
//				System.out.println("draw line");
//				picture.displayPic();
			} else {// fill
				int x, y;
				String cs;
				x = fin.nextInt();
				y = fin.nextInt();
				cs = fin.next();
				char c = cs.charAt(0);
				picture.fill(x, y, c);
//				System.out.println("fill");
//				picture.displayPic();
			}
		}
		fin.close();

		// <display
		picture.displayPic();
		// display>
	}

}

class Picture {
	int width, height;
	A a;

	public Picture(int m, int n) {
		this.width = m;
		this.height = n;
		a = new A(m, n);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				a.setA(x, y, '.');
			}
		}
	}

	public void fill(int x, int y, char c) {
		// TODO Auto-generated method stub
		if (a.getA(x, y) == '|' | a.getA(x, y) == '-' || a.getA(x, y) == '+') {
			return;
		} else {
			a.setA(x, y, c);
			handleFill(x, y, c);
			
		}
	}

	private void handleFill(int x, int y, char c) {
		// TODO Auto-generated method stub
		a.setA(x, y, c);
		Map<Integer, Integer> neighbors = a.getNeighbor(x, y, c);
		if (neighbors.size() == 0)
			return;
		for (int x1 : neighbors.keySet()) {
			handleFill(x1, neighbors.get(x1), c);
//			displayPic();
		}
	}

	public void drawLine(int x1, int y1, int x2, int y2) {
		// TODO Auto-generated method stub
		if (x1 == x2) {// vertical '|'
			int x = x1;
			for (int y = Math.min(y1, y2); y <= Math.max(y1, y2); y++) {
				if (a.getA(x, y) == '-') {
					a.setA(x, y, '+');
				} else {
					a.setA(x, y, '|');
				}
			}
		} else {// horizontal '-' '+'
			int y = y1;
			for (int x = Math.min(x1, x2); x <= Math.max(x1, x2); x++) {
				if (a.getA(x, y) == '|') {
					a.setA(x, y, '+');
				} else {
					a.setA(x, y, '-');
				}
			}
		}
	}

	public void displayPic() {
		for (int y = height - 1; y >= 0; y--) {
			for (int x = 0; x < width; x++) {
				System.out.print(a.getA(x, y));
			}
			System.out.println();
		}

	}
}

class A {
	int height, width;
	char[][] a;

	public A(int m, int n) {
		height = n;
		width = m;
		a = new char[n][m];
	}

	public Map<Integer, Integer> getNeighbor(int x, int y, char c) {
		// TODO Auto-generated method stub
		Map<Integer, Integer> neighbors = new HashMap<>();
		if (x - 1 >= 0) {
			if (getA(x - 1, y) != '|' && getA(x - 1, y) != '-' && getA(x - 1, y) != '+') {
				if (getA(x - 1, y) != c)
					neighbors.put(x - 1, y);
			}
		}
		if (y + 1 < height) {
			if (getA(x, y + 1) != '|' && getA(x, y + 1) != '-' && getA(x, y + 1) != '+') {
				if (getA(x, y + 1) != c)
					neighbors.put(x, y + 1);
			}
		}
		if (y - 1 >= 0) {
			if (getA(x, y - 1) != '|' && getA(x, y - 1) != '-' && getA(x, y - 1) != '+') {
				if (getA(x, y - 1) != c)
					neighbors.put(x, y - 1);
			}
		}
		if (x + 1 < width)
			if (getA(x + 1, y) != '|' && getA(x + 1, y) != '-' && getA(x + 1, y) != '+') {
				if (getA(x + 1, y) != c)
					neighbors.put(x + 1, y);
			}
		return neighbors;
	}

	public char getA(int x, int y) {
		return a[y][x];
	}

	public void setA(int x, int y, char c) {
		a[y][x] = c;
	}
}