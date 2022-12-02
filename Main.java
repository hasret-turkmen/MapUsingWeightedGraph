import java.util.ArrayList;
import java.util.Scanner;

//MAIN CLASS FOR FIRST PROJECT 

public class Main {
	public static void main(String[] args)
    {
		Scanner bili = new Scanner(System.in);
		//Enter vertices
		int vertices = bili.nextInt();
		//Enter edges
		int edges = bili.nextInt();
		
		char first, second;
		int weight,src,dest;
		
		//Create a double arraylist for the adjacency list implementation
		 ArrayList<ArrayList<WeightedGraph> > graph= new ArrayList<>();
		 //Create sub-lists for each list
		 //A: B-D     
		 //B: A-C...
		 for (int i = 0; i < vertices; i++) {
         graph.add(new ArrayList<>());
		 }
     
		 
		for (int i = 0; i < edges; i++) {
			//Enter first city
			first = bili.next().charAt(0);
			//Since city names are given as A,B,C... Their ASCII values start from 65.
			//If i use their original values, there will be an indexoutofbounds exception since
			//the length of my array is 6(vertex number)
			//So i modify their values for them to start from 0,1,2...
			src=first-65;
			
			//Enter second city
			second = bili.next().charAt(0);
			//modify it as an integer
			dest=second-65;
			
			//Enter weight
			weight = bili.nextInt();
			
			//Create an undirected graph with given cities
			graph.get(src).add(new WeightedGraph(dest,weight));
			graph.get(dest).add(new WeightedGraph(src,weight));
		}
		
		//this array will hold the shortest paths after dijkstra
		int[] holdDistance;
		
		char start,end;
		int s,e;
		
		//these arrays will hold the source cities and destination cities
		//the lenght is given like this because of the input examples on HW manual
		int[] sourcepath = new int[(vertices-1)*2];
		int[] endpath = new int[(vertices-1)*2];
		
		for(int i=0;i<vertices-1;i++) {
			//Enter source city
			 start = bili.next().charAt(0);
			 //Modify it
			 s=start-65;
			 //Add the path to the array
			 sourcepath[i]=s;
			 
			 //Enter destination
			 end = bili.next().charAt(0);
			 //Modify
			 e=end-65;
			 //Add the city to the array
			 endpath[i]=e;
		}
		
		//Prints the shortest paths for wanted cities
		for(int i=0; i<vertices-1;i++) {
			//call dijkstra starting from the source
			holdDistance = ShortestPath.dijkstra(sourcepath[i],vertices, graph);
			//print the corresponding destination's distance
		     System.out.println(holdDistance[endpath[i]]);
		}
		
       
    }
}
