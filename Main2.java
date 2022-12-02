import java.util.Scanner;
//MAIN CLASS FOR SECOND PROJECT 
public class Main2{
	public static void main(String[] args)

	{
		Scanner bili = new Scanner(System.in);
		//Enter vertices
		int vertices = bili.nextInt();
		//Enter edges
		int edges = bili.nextInt();
		
		//create tree object
		MinSpanningTree tree = new MinSpanningTree();
		
		//these are for inputs
		char first, second;
		int weight,src,dest;
	
		//creates graph as adjacency matrix
		int graph[][] = new int[vertices][vertices];
		
		
		for (int i = 0; i < edges; i++) {
			//Enter first city
			first = bili.next().charAt(0);
			//Since city names are given as A,B,C... Their ASCII values start from 65.
			//So i modify their values for them to start from 0,1,2...
			src=first-65;
			
			//Enter second city
			second = bili.next().charAt(0);
			//modify it as an integer
			dest=second-65;
			
			//Enter weight
			weight = bili.nextInt();
			
			//create undirected graph
			graph[src][dest]=weight;
			graph[dest][src]=weight;
	}

		//
				char start,end;
				int s,e;
				
				
					//Enter source city
					 start = bili.next().charAt(0);
					 //Modify it
					 s=start-65;
					 
					 //Enter destination
					 end = bili.next().charAt(0);
					 //Modify
					 e=end-65;
					
					 
						// Print the solution
						tree.createMST(graph,vertices,edges);

	
	}
}
