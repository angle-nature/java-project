package day03.pm;

import java.util.Scanner;

public class Graph {
	private int[][] data;
	private char[] nodechar;
	private int nodenumber;
	private int edgenumber;

	/**
	 * 使用邻接矩阵存储图
	 */
	public Graph() {                         
		System.out.println("请输入图形结构:");
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入图的顶点数:");
		nodenumber = sc.nextInt();
		data = new int[nodenumber][nodenumber];
		nodechar = new char[nodenumber];
		System.out.println("请输入节点字符集合:"); // "ABCDEF"
		String nodestr = sc.next();
		for (int i = 0; i < nodestr.length(); i++) {
			nodechar[i] = nodestr.charAt(i);
		}
		System.out.println("请输入图的边数:");
		edgenumber = sc.nextInt();
		for (int i = 1; i <= edgenumber; i++) {
			System.out.println("请输入图的第" + i + "条边:"); // "AB"
			String edgestr = sc.next();
			char startchar = edgestr.charAt(0);
			char endchar = edgestr.charAt(1);
			int startindex = location(startchar);
			int endindex = location(endchar);
			data[startindex][endindex] = 1;
			data[endindex][startindex] = 1;
		}
	}

	private int location(char ch) {
		int index = -1;
		for (int i = 0; i < nodechar.length; i++) {
			if (nodechar[i] == ch) {
				index = i;
				break;
			}
		}
		return index;
	}

	public void printGraph() {
		for (int i = 0; i < nodenumber; i++) {
			for (int j = 0; j < nodenumber; j++) {
				System.out.print(data[i][j] + "   ");
			}
			System.out.println();
		}

	}

}
