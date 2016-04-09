package z201512_4;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Main {

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

class Graph {
	static int oldx, oldy;
	int m;
	int[] nodes;
	Map<Integer, List<Edge>> map;

	public String findRoute() {
		Stack<Integer> s = new Stack<>();
		int numOdd = numberOfOdd();
		if (numOdd == 0) {
			s.push(1);
			handleFindRoute(s);
		} else if (numOdd == 2) {
			for (int i = 0; i < nodes.length; i++) {
				if (getDegree(i + 1) % 2 != 0) {// odd little
					s.push(i + 1);
					handleFindRoute(s);
					String str = "";
					for (int ii = 0; ii < s.size(); ii++) {
						str += s.get(ii) + " ";
					}
					return str;
				}
			}
		}
		return "-1";

	}

	private boolean handleFindRoute(Stack<Integer> s) {
		// TODO Auto-generated method stub
		// System.out.println(s);
		int top = s.get(s.size() - 1);
		List<Integer> nodes = findNext(top);
		for (int i = 0; i < nodes.size(); i++) {
			if (s.size() == m + 1) {// find a route
				return true;
			}
			s.push(nodes.get(i));
			// set visited
			setVisited(top, nodes.get(i), true);
			if (!handleFindRoute(s)) {
				oldx = s.pop();
				oldy = s.get(s.size() - 1);
				setVisited(oldx, oldy, false);
				;
			}
		}
		if (s.size() == m + 1) {// find a route
			return true;
		}
		return false;

	}

	private void setVisited(int x, int y, boolean b) {
		// TODO Auto-generated method stub
		List<Edge> edges = map.get(x);
		for (int i = 0; i < edges.size(); i++) {
			if (edges.get(i).x == y || edges.get(i).y == y) {
				edges.get(i).isVisited = b;
			}
		}
	}

	private List<Integer> findNext(int top) {
		// TODO Auto-generated method stub
		List<Edge> list = map.get(top);
		List<Integer> nodes = new LinkedList();
		for (int i = 0; i < list.size(); i++) {
			int node;
			if (!getVisited(list.get(i))) {
				if (list.get(i).x == top)
					node = list.get(i).y;
				else {
					node = list.get(i).x;
				}
				nodes.add(node);
			}
		}
		Collections.sort(nodes);
		return nodes;
	}

	private boolean getVisited(Edge edge) {
		// TODO Auto-generated method stub
		List<Edge> edges = map.get(edge.x);
		for (int i = 0; i < edges.size(); i++) {
			if (edges.get(i).y == edge.y) {
				return edges.get(i).isVisited;
			}
		}
		return false;
	}

	private int numberOfOdd() {
		// TODO Auto-generated method stub
		int result = 0;
		for (int key : map.keySet()) {
			if (map.get(key).size() % 2 != 0)
				result++;
		}
		return result;
	}

	private int getDegree(int i) {
		// TODO Auto-generated method stub
		return map.get(i).size();
	}

	public Graph(int n, int m) {
		this.m = m;
		nodes = new int[n];
		map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			List<Edge> edges = new LinkedList<>();
			map.put(i + 1, edges);
			nodes[i] = i + 1;
		}
	}

	public Map<Integer, List<Edge>> getMap() {
		return map;
	}

	public List<Edge> getEdges(int node) {
		return map.get(node);
	}

	public void addEdge(Edge e) {
		int x = e.x;
		int y = e.y;
		if (map.get(x) == null) {
			List<Edge> edges = new LinkedList<>();
			edges.add(e);
		} else {
			map.get(x).add(e);
		}
		if (map.get(y) == null) {
			// Edge ee = new Edge(e.y,e.x);
			List<Edge> edges = new LinkedList<>();
			edges.add(e);
		} else {
			// Edge ee = new Edge(e.y,e.x);
			map.get(y).add(e);
		}
	}

	public void disGraph() {
		System.out.println("print the graph:");
		for (int i = 0; i < map.size(); i++) {
			System.out.println(map.get(nodes[i]).toString());
		}
	}
}

class Edge {
	int x, y;
	boolean isVisited;

	public Edge() {
		x = 0;
		y = 0;
		isVisited = false;
	}

	public Edge(int xx, int yy) {
		isVisited = false;
		x = xx;
		y = yy;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "(" + x + "," + y + "," + isVisited + ")";
	}
}
