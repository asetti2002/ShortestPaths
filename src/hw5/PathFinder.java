package hw5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class PathFinder {

	public HashMap<Integer, Node> nodes = new HashMap<>();

	private int numberOfInter = 0;

	public PathFinder() {
	}

	public void readInput(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
		Scanner scanner = new Scanner(file);
		int lineNumber = 0;
		int numberOfEdges = 0;

		boolean partOne = true;
		int partTwoCounter = 0;

		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			Scanner lineScanner = new Scanner(line);
			if (lineNumber == 0) {
				numberOfInter = lineScanner.nextInt();
				numberOfEdges = lineScanner.nextInt();
				lineNumber++;
				continue;
			}

			if (!lineScanner.hasNextInt()) {
				partOne = false;
				continue;
			}

			if (partOne) {
				int key = lineScanner.nextInt();
				int x = lineScanner.nextInt();
				int y = lineScanner.nextInt();
				Node node = new Node(key, x, y);
				nodes.put(key, node);
			} else {
				if (partTwoCounter >= numberOfEdges) {
					break;
				}
				int num1 = lineScanner.nextInt();
				int num2 = lineScanner.nextInt();

				nodes.get(num1).addNeighbors(num2);
				nodes.get(num2).addNeighbors(num1);
				partTwoCounter++;
			}

		}

		scanner.close();
	}

	public double distToDest(int sid, int did, int k) {
		ArrayList<Integer> list = fromSrcToDest(sid, did, k);

		if (list == null)
			return -1;

		double totalDist = 0;

		for (int i = 0; i < list.size() - 1; i++) {
			totalDist += distance(nodes.get(list.get(i)).getX(), nodes.get(list.get(i)).getY(),
					nodes.get(list.get(i + 1)).getX(), nodes.get(list.get(i + 1)).getY());
		}

		return totalDist;
	}

	public int noOfShortestPaths(int sid, int did, int k) {
		MinHeap heap = new MinHeap(k);
		int[] paths = new int[numberOfInter];

		for (Node node : nodes.values()) {
			if (node.getKey() == sid) {
				node.adjList = nodes.get(node.getKey()).adjList;
				node.setdValue(0);
				heap.setDummys(node.getX(), node.getY(), node);
				node.setParent(null);
				heap.add(node.getKey(), 0);
			} else {
				node.adjList = nodes.get(node.getKey()).adjList;
				node.setdValue(Double.MAX_VALUE);
				heap.setDummys(node.getX(), node.getY(), node);
				node.setParent(null);
				heap.add(node.getKey(), Double.MAX_VALUE);
			}

		}

		paths[sid] = 1;
		while (!heap.nodeList.isEmpty()) {
			Node u = heap.extractMin();

			if (u.getKey() == did) {
				break;
			}
			if (nodes.get(u.getKey()).adjList.size() == 0) {
				return 0;
			}
			for (int i = 0; i < nodes.get(u.getKey()).adjList.size(); i++) {
				Node nei = nodes.get(nodes.get(u.getKey()).adjList.get(i));
				double du = u.getDVal();
				double dv = nodes.get(nodes.get(u.getKey()).adjList.get(i)).getDVal();
				double wt = distance(nodes.get(u.getKey()).getX(), nodes.get(u.getKey()).getY(), nei.getX(),
						nei.getY());

				if (heap.nodeList.contains(nei) && dv > du + wt) {
					dv = du + wt;
					nei.setdValue(dv);
					if (heap.indexMap.containsValue(nei)) {
						heap.heapify(heap.nodeList.indexOf(nei));
					}
					paths[nei.getKey()] = paths[u.getKey()];

				} else if (heap.nodeList.contains(nei) && dv == du + wt) {
					paths[nei.getKey()] = paths[nei.getKey()] + paths[u.getKey()];

				}

			}

		}

		return paths[did];
	}

	public ArrayList<Integer> fromSrcToDest(int sid, int did, int k) {
		MinHeap heap = new MinHeap(k);
		for (Node node : nodes.values()) {
			if (node.getKey() == sid) {
				node.adjList = nodes.get(node.getKey()).adjList;
				node.setdValue(0);
				heap.setDummys(node.getX(), node.getY(), node);
				node.setParent(null);
				heap.add(node.getKey(), 0);
			} else {
				node.adjList = nodes.get(node.getKey()).adjList;
				node.setdValue(Double.MAX_VALUE);
				heap.setDummys(node.getX(), node.getY(), node);
				node.setParent(null);
				heap.add(node.getKey(), Double.MAX_VALUE);
			}

		}

		while (!heap.nodeList.isEmpty()) {
			Node u = heap.extractMin();
			if (u.getKey() == did) {
				break;
			}
			if (nodes.get(u.getKey()).adjList.size() == 0) {
				return null;
			}

			for (int i = 0; i < nodes.get(u.getKey()).adjList.size(); i++) {
				Node nei = nodes.get(nodes.get(u.getKey()).adjList.get(i));
				if (nei.getParent() == null) {
					nei.setParent(u);
				}
				double du = u.getDVal();
				double dv = nodes.get(nodes.get(u.getKey()).adjList.get(i)).getDVal();
				double wt = distance(nodes.get(u.getKey()).getX(), nodes.get(u.getKey()).getY(), nei.getX(),
						nei.getY());

				if (heap.nodeList.contains(nei) && dv > du + wt) {
					dv = du + wt;
					nei.setdValue(dv);
					if (heap.indexMap.containsValue(nei)) {
						heap.heapify(heap.nodeList.indexOf(nei));
					}
				}

			}

		}
		ArrayList<Integer> list = new ArrayList<Integer>();

		Node node;
		node = nodes.get(did);
		while (true) {
			if (node == null)
				return null;
			list.add(node.getKey());
			if (node.getKey() == sid) {
				break;
			} else {
				node = node.getParent();
			}
		}

		Collections.reverse(list);
		return list;
	}

	public double distance(int x1, int y1, int x2, int y2) {
		return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}

}

class MinHeap {
	private int k;
	private ArrayList<Integer> keyList = new ArrayList<>();
	public HashMap<Integer, Node> indexMap = new HashMap<>();
	public ArrayList<Node> nodeList = new ArrayList<>();
	private int helper = 0;
	private int x;
	private int y;
	private Node node;

	public MinHeap() {
		k = 2;
	}

	public MinHeap(int k) {
		this.k = k;
	}

	private void swap(int indx) {
		Node node = nodeList.get(indx);
		Node node2 = nodeList.get((indx - 1) / k);

		nodeList.set(indx, node2);
		nodeList.set((indx - 1) / k, node);

		indexMap.put(indx, node2);
		node2.setIndx(indx);
		indexMap.put((indx - 1) / k, node);
		node.setIndx((indx - 1) / k);
	}

	public void heapify(int indx) {
		while (true) {
			if (nodeList.get(indx).getDVal() < nodeList.get((indx - 1) / k).getDVal()) {
				swap(indx);
				indx = (indx - 1) / k;
			} else if (nodeList.get(indx).getDVal() == nodeList.get((indx - 1) / k).getDVal()) {
				if (nodeList.get(indx).getKey() < nodeList.get((indx - 1) / k).getKey()) {
					swap(indx);
					indx = (indx - 1) / k;
				} else {
					break;
				}
			} else {
				break;
			}
		}
	}

	public Node extractMin() {
		swap2();
		Node node = nodeList.remove(nodeList.size() - 1);

		heapifyDown(0);

		return node;
	}

	public void swap3(int indx1, int indx2) {
		Node node = nodeList.get(indx1);
		Node node2 = nodeList.get(indx2);

		nodeList.set(indx1, node2);
		nodeList.set(indx2, node);

		indexMap.put(indx1, node2);
		node2.setIndx(indx1);
		indexMap.put(indx2, node);
		node.setIndx(indx2);

	}

	public void heapifyDown(int i) {

		int j = 0;
		int len = 0;
		if ((k * i) + 1 > nodeList.size() - 1)
			return;
		if ((k * i) + 2 > nodeList.size() - 1) {
			j = k * i + 1;
		}

		if ((i + 1) * k < nodeList.size()) {
			len = ((i + 1) * k) + 1;
		} else {
			len = nodeList.size();
		}

		j = k * i + 1;
		for (int f = k * i + 1; f < len; f++) {
			if (nodeList.get(j).getDVal() > nodeList.get(f).getDVal()) {
				j = f;
			}
			if (nodeList.get(j).getDVal() == nodeList.get(f).getDVal()) {
				if (nodeList.get(j).getKey() > nodeList.get(f).getKey()) {
					j = f;
				}
			}
		}
		if (nodeList.get(i).getDVal() < nodeList.get(j).getDVal()) {
			return;
		}

		if (nodeList.get(i).getDVal() == nodeList.get(j).getDVal()) {
			if (nodeList.get(i).getKey() < nodeList.get(j).getKey()) {
				return;
			}
		}

		swap3(i, j);
		heapifyDown(j);

	}

	private void swap2() {
		Node node = nodeList.get(0);
		Node node2 = nodeList.get(nodeList.size() - 1);

		nodeList.set(0, node2);
		nodeList.set(nodeList.size() - 1, node);

		indexMap.put(0, node2);
		node2.setIndx(0);
		indexMap.put(nodeList.size() - 1, node);
		node2.setIndx(nodeList.size() - 1);

	}

	public void setDummys(int x, int y, Node node) {
		this.x = x;
		this.y = y;
		this.node = node;
	}

	public void setNode(int key, double val) {
		node = new Node(key, 1, 1);
		node.setdValue(val);
		helper = 1;

	}

	public void add(int key, double value) {
		if (node == null || helper == 1) {
			setNode(key, value);
		}

		Node no = node;
		no.adjList = node.adjList;
		no.setdValue(value);
		nodeList.add(no);

		indexMap.put(nodeList.size() - 1, no);
		no.setIndx(nodeList.size() - 1);

		if (nodeList.get(nodeList.size() - 1).getDVal() <= nodeList.get(((nodeList.size() - 2) / k)).getDVal()) {
			heapify(nodeList.size() - 1);
		}

	}

	public ArrayList<Integer> getHeap() {

		for (int i = 0; i < nodeList.size(); i++) {
			keyList.add(nodeList.get(i).getKey());
		}

		return keyList;
	}
}

class Node {
	private int x;
	private int y;
	private int key;
	private double dValue;
	private Node parent;
	private int indx;
	public ArrayList<Integer> adjList = new ArrayList<>();

	public Node(int key, int x, int y) {
		this.key = key;
		this.x = x;
		this.y = y;
		indx = -1;
	}

	public int getX() {
		return x;
	}

	public int getIndex() {
		return indx;
	}

	public void setIndx(int indx) {
		this.indx = indx;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public void setdValue(double dVal) {
		dValue = dVal;
	}

	public double getDVal() {
		return dValue;
	}

	public int getY() {
		return y;
	}

	public int getKey() {
		return key;
	}

	public void addNeighbors(int neighbor) {
		adjList.add(neighbor);
	}
}
