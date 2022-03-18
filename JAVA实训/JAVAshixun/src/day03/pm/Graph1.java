package day03.pm;

import java.util.Scanner;

public class Graph1 {
	private GList[] lists;
	private int nodenumber;
	private char[] nodechar;
	private int edgenumber;

	/**
	 * 使用邻接矩阵存储图
	 */
	public Graph1() {
		System.out.println("请输入图形结构:");
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入图的顶点数:");
		nodenumber = sc.nextInt();
		lists = new GList[nodenumber];
		nodechar = new char[nodenumber];
		System.out.println("请输入节点字符集合:"); // "ABCDEF"
		String nodestr = sc.next();
		for (int i = 0; i < nodestr.length(); i++) {
			nodechar[i] = nodestr.charAt(i);
			lists[i] = new GList(nodechar[i]);
		}
		System.out.println("请输入图的边数:");
		edgenumber = sc.nextInt();
		for (int i = 1; i <= edgenumber; i++) {
			System.out.println("请输入图的第" + i + "条边:"); // "AB5" "BE17"
			String edgestr = sc.next();
			char startchar = edgestr.charAt(0);
			char endchar = edgestr.charAt(1);
			String numsubstr = edgestr.substring(2, edgestr.length());
			int edgenum = Integer.parseInt(numsubstr);
			int startindex = location(startchar);
			int endindex = location(endchar);
			lists[startindex].insert(endchar, edgenum);
			lists[endindex].insert(startchar, edgenum);
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
		for (GList gList : lists) {
			gList.printGList();
			System.out.println();
		}

	}

}
