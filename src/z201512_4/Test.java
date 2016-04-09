package z201512_4;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner fin = new Scanner(System.in);
		int n;
		int m;
		n = fin.nextInt();
		m = fin.nextInt();
		Graph g = new Graph(n, m);
		for (int i = 0; i < m; i++) {
			g.addEdge(new Edge(fin.nextInt(), fin.nextInt()));
		}
		fin.close();
		// g.disGraph();
		System.out.println(g.findRoute());
	}

}
