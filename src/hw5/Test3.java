package hw5;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Test3 {
    public static void main(String[] args) throws FileNotFoundException {
    	final long startTime = System.currentTimeMillis();
    	PathFinder pf = new PathFinder();

        pf.readInput("/Users/akashsetti/Desktop/sample2.txt");

        int from, to, k,numPath;
        double distance;


        from = 3;
        to = 0;
        k = (int) ((Math.random() * (50 - 1)) + 1);
        distance = 114.54687620684422;
        numPath = 1;
        System.out.println("\nShortest path dist between "+ from + " and " + to + " ("+distance+"): " + pf.distToDest(from, to, k));
        System.out.println("Number of shortest paths between" + from + " and " + to + " ("+numPath+"): " + pf.noOfShortestPaths(from, to, k));
        
        ArrayList<Integer> path = pf.fromSrcToDest(from, to, k);
        
		if (path == null)
			System.out.println("No path to destination");
		else {
			for (int i = 0; i < path.size(); i++)
				System.out.printf(path.get(i) + " ");
			System.out.println();
		}
		

        from = 23;
        to = 14;
        k = (int) ((Math.random() * (50 - 1)) + 1);
         ;
        distance = -1.0;
        numPath = 0;
        System.out.println("\nShortest path dist between "+ from + " and " + to + " ("+distance+"): " + pf.distToDest(from, to, k));
        System.out.println("Number of shortest paths between" + from + " and " + to + " ("+numPath+"): " + pf.noOfShortestPaths(from, to, k));
        ArrayList<Integer> path2 = pf.fromSrcToDest(from, to, k);
		if (path2 == null)
			System.out.println("No path to destination");
		else {
			for (int i = 0; i < path2.size(); i++)
				System.out.printf(path2.get(i) + " ");
			System.out.println();
		}
		
        
        
        
        
        from = 19;
        to = 17;
        k = (int) ((Math.random() * (50 - 1)) + 1);
         ;
        distance = 27.215697297096273;
        numPath = 1;
        System.out.println("\nShortest path dist between "+ from + " and " + to + " ("+distance+"): " + pf.distToDest(from, to, k));
        System.out.println("Number of shortest paths between" + from + " and " + to + " ("+numPath+"): " + pf.noOfShortestPaths(from, to, k));
//
        from = 34;
        to = 2;
        k = (int) ((Math.random() * (50 - 1)) + 1);
         ;
        distance = 20.12461179749811;
        numPath = 1;
        System.out.println("\nShortest path dist between "+ from + " and " + to + " ("+distance+"): " + pf.distToDest(from, to, k));
        System.out.println("Number of shortest paths between" + from + " and " + to + " ("+numPath+"): " + pf.noOfShortestPaths(from, to, k));
//
        from = 3;
        to = 9;
        k = (int) ((Math.random() * (50 - 1)) + 1);
         ;
        distance = 16.601470508735446;
        numPath = 1;
        System.out.println("\nShortest path dist between "+ from + " and " + to + " ("+distance+"): " + pf.distToDest(from, to, k));
        System.out.println("Number of shortest paths between" + from + " and " + to + " ("+numPath+"): " + pf.noOfShortestPaths(from, to, k));
//
        from = 27;
        to = 48;
        k = (int) ((Math.random() * (50 - 1)) + 1);
         ;
        distance = 44.72783595871428;
        numPath = 2;
        System.out.println("\nShortest path dist between "+ from + " and " + to + " ("+distance+"): " + pf.distToDest(from, to, k));
        System.out.println("Number of shortest paths between" + from + " and " + to + " ("+numPath+"): " + pf.noOfShortestPaths(from, to, k));

        from = 24;
        to = 22;
        k = (int) ((Math.random() * (50 - 1)) + 1);
         ;
        distance = 33.380078811574904;
        numPath = 1;
        System.out.println("\nShortest path dist between "+ from + " and " + to + " ("+distance+"): " + pf.distToDest(from, to, k));
        System.out.println("Number of shortest paths between" + from + " and " + to + " ("+numPath+"): " + pf.noOfShortestPaths(from, to, k));


        from = 12;
        to = 16;
        k = (int) ((Math.random() * (50 - 1)) + 1);
         ;
        distance = 5.47213595499958;
        numPath = 1;
        System.out.println("\nShortest path dist between "+ from + " and " + to + " ("+distance+"): " + pf.distToDest(from, to, k));
        System.out.println("Number of shortest paths between" + from + " and " + to + " ("+numPath+"): " + pf.noOfShortestPaths(from, to, k));

        from = 28;
        to = 48;
        k = (int) ((Math.random() * (50 - 1)) + 1);
         ;
        distance = 3.6502815398728847;
        numPath = 2;
        System.out.println("\nShortest path dist between "+ from + " and " + to + " ("+distance+"): " + pf.distToDest(from, to, k));
        System.out.println("Number of shortest paths between" + from + " and " + to + " ("+numPath+"): " + pf.noOfShortestPaths(from, to, k));


        from = 0;
        to = 25;
        k = (int) ((Math.random() * (50 - 1)) + 1);
         ;
        distance = 165.94617868093448;
        numPath = 1;
        System.out.println("\nShortest path dist between "+ from + " and " + to + " ("+distance+"): " + pf.distToDest(from, to, k));
        System.out.println("Number of shortest paths between" + from + " and " + to + " ("+numPath+"): " + pf.noOfShortestPaths(from, to, k));
        
        ArrayList<Integer> path21 = pf.fromSrcToDest(from, to, k);
        
		if (path21 == null)
			System.out.println("No path to destination");
		else {
			for (int i = 0; i < path21.size(); i++)
				System.out.printf(path21.get(i) + " ");
			System.out.println();
		}
        
        from = 4;
        to = 7;
        k = (int) ((Math.random() * (50 - 1)) + 1);
         ;
        distance = -1;
        numPath = 0;
        System.out.println("\nShortest path dist between "+ from + " and " + to + " ("+distance+"): " + pf.distToDest(from, to, k));
        System.out.println("Number of shortest paths between" + from + " and " + to + " ("+numPath+"): " + pf.noOfShortestPaths(from, to, k));

        from = 9;
        to = 36;
        k = (int) ((Math.random() * (50 - 1)) + 1);
         ;
        distance = -1;
        numPath = 0;
        System.out.println("\nShortest path dist between "+ from + " and " + to + " ("+distance+"): " + pf.distToDest(from, to, k));
        System.out.println("Number of shortest paths between" + from + " and " + to + " ("+numPath+"): " + pf.noOfShortestPaths(from, to, k));



        from = 42;
        to = 28;
        k = (int) ((Math.random() * (50 - 1)) + 1);
        distance = 36.784448883401495;
        numPath = 8;
        System.out.println("\nShortest path dist between "+ from + " and " + to + " ("+distance+"): " + pf.distToDest(from, to, k));
        System.out.println("Number of shortest paths between" + from + " and " + to + " ("+numPath+"): " + pf.noOfShortestPaths(from, to, k));

        from = 28;
        to = 42;
        k = (int) ((Math.random() * (50 - 1)) + 1);
        distance = 36.784448883401495;
        numPath = 8;
        System.out.println("\nShortest path dist between "+ from + " and " + to + " ("+distance+"): " + pf.distToDest(from, to, k));
        System.out.println("Number of shortest paths between" + from + " and " + to + " ("+numPath+"): " + pf.noOfShortestPaths(from, to, k));

        from = 3;
        to = 25;
        k = (int) ((Math.random() * (50 - 1)) + 1);
        distance = 51.39930247409028;
        numPath = 1;
        System.out.println("\nShortest path dist between "+ from + " and " + to + " ("+distance+"): " + pf.distToDest(from, to, k));
        System.out.println("Number of shortest paths between" + from + " and " + to + " ("+numPath+"): " + pf.noOfShortestPaths(from, to, k));
        
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
        


    }
}