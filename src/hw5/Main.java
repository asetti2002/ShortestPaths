package hw5;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
//		
//		PathFinder pf = new PathFinder();
//		try {
//			pf.readInput("/Users/akashsetti/eclipse-workspace/311Homework5/src/hw5/input.txt");
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		Node list = pf.nodes.get(5);
//		
//		for (int i =0; i < list.adjList.size(); i++) {
//			System.out.println(list.adjList.get(i));
//		}
//	

		PathFinder pf = new PathFinder();
		try {
			pf.readInput("/Users/akashsetti/eclipse-workspace/311Homework5/src/hw5/input.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
////
//		ArrayList<Integer> path = pf.fromSrcToDest(7, 4, 2);
//
//		if (path == null)
//			System.out.println("No path to destination");
//		else {
//			for (int i = 0; i < path.size(); i++)
//				System.out.printf(path.get(i) + " ");
//			System.out.println();
//		}
////		
////		
////		
//		System.out.println("Number of shortest paths: " + pf.noOfShortestPaths(1, 0, 2));
//		System.out.println("Shortest path distance: " + pf.distToDest(1, 0, 2));
		
		
		
//		PathFinder pf = new PathFinder();
//        pf.readInput("input.txt");
        for(int start = 0; start <= 9; start++) {
            for(int end = 0; end <= 9; end++) {
                if(start == end) continue;
                int k = 2;
                System.out.println("\n\nstart = " + end + " end = " + start);
                System.out.println("Shortest path distance: " + pf.distToDest(start, end, k));
                System.out.println("Number of paths: " + pf.noOfShortestPaths(start, end, k));
                ArrayList<Integer> path = pf.fromSrcToDest(start, end, k);
                if (path == null)
                    System.out.println("No path to destination");

                else {
                    for (Integer key : path) System.out.printf(key + " ");
                }
            }
        }
		
		
		
//		PathFinder pf = new PathFinder();
//		pf.readInput("/Users/akashsetti/eclipse-workspace/311Homework5/src/hw5/input.txt");
//		for(int end = 0; end <= 9; end++) {
//            int start = 9;
//                int k = 2;
//                System.out.println("\n\nstart = " + start + " end = " + end);
//                System.out.println("Shortest path distance: " + pf.distToDest(start, end, k));
//                System.out.println("Number of paths: " + pf.noOfShortestPaths(start, end, k));
//                ArrayList<Integer> path = pf.fromSrcToDest(start, end, k);
//                if (path == null)
//                    System.out.println("No path to destination");
//
//                else {
//                    for (Integer key : path) System.out.printf(key + " ");
//                }
//            }

//
//		Node n = new Node(1,1,1);
//		Node n2 = new Node(2,1,1);
//		Node n3 = new Node(3,1,1);
//		Node n4 = new Node(4,1,1);
//		Node n5 = new Node(5,1,1);
////		
//		MinHeap m = new MinHeap();
//		m.nodeList.add(n5);
//		m.nodeList.add(n4);
//		m.nodeList.add(n3);
//		m.nodeList.add(n2);
//		m.nodeList.add(n);
////		
////		
////		
//		m.heapifyDown(0);
////		
//		ArrayList<Integer> elements = m.getHeap();
//		
//		System.out.println("MinHeap with default degree");
//		for (int i = 0; i < elements.size(); i++) {
//			System.out.printf(elements.get(i) + " ");
//		}
//		System.out.println();

//		MinHeap mH = new MinHeap(4);
//		mH.add(1, 5);
//		mH.add(11, 6);
//		mH.add(2, 6);
//		mH.add(3, 4);
//		mH.add(10, 3);
//		mH.add(9, 6);
////		
//		ArrayList<Integer> elements1 = mH.getHeap();
////		
//		System.out.println("MinHeap with default degree");
//		for (int i = 0; i < elements1.size(); i++) {
//			System.out.printf(elements1.get(i) + " ");
//		}
//		System.out.println();

	}

}
