class MinSpanningTree {

	int findMinimumDist(int val[], int vertex,  Boolean inMST[])
	//--------------------------------------------------------
	 // Summary: Finds the minimum value vertex 
	 // Precondition: val is a integer array, V is an integer
	// and inMST is a boolean array
	 // Postcondition: Returns the minimum value
	 //--------------------------------------------------------
	{
		
		int min = Integer.MAX_VALUE;
		int minVertex = -1;
		int i=0;
		
		while(i<vertex) {
		//update minimum vertex if a smaller one is found.
			if (inMST[i] == false && val[i] < min) {
				min = val[i];
				minVertex = i;
			}
			i++;
		}
		return minVertex;
	}
	
	
		void createMST(int graph[][], int vertex, int edges)
		//--------------------------------------------------------
		 // Summary: Creates a MST using Prim's Algorithm
		 // Precondition: graph is an integer matrix, vertex
		//and edges are integers
		 // Postcondition: MST is created
		 //--------------------------------------------------------
		
		{
			
			int weight[] = new int[vertex]; //holds the weight
			
			int parent[] = new int[vertex]; //holds the parent of min weights
			
			 // holds the parent of the edge which
			//we did not include because we found smaller weights
			int excludedParent[]=new int[vertex];
			
			// holds the child of the edge which
			//we did not include because we found smaller weights
			int excludedChild[]=new int[vertex];
			
			//index to store excludedParent and excludedChild
			int p=0;
		
			//Checks if the edge is in MST
			Boolean inMST[] = new Boolean[vertex];

			//All distances are infinite first
			for (int i = 0; i < vertex; i++) {
				weight[i] = Integer.MAX_VALUE;
				inMST[i] = false;
			}

			//the distance of a chosen vertex to itself is 0
			weight[0] = 0; 
			
			parent[0] = -1; //chosen vertex is the root so has no parent
			
			int c=0; //this will count the unused paths
			
			//it will run vertex-1 times because a MST has
			//vertex-1 edges
			for (int count = 0; count < vertex - 1; count++) {
				
				//check chosen vertices' edges
				int chosen = findMinimumDist(weight,vertex, inMST);
				
				inMST[chosen] = true; //Add to MST

			
				//Checks neighbours of the chosen vertex
				for (int v = 0; v < vertex; v++) {
				
		//if v's distance is already updated && we found something smaller && it is a neighbour		
if(weight[v]!=Integer.MAX_VALUE && graph[chosen][v] < weight[v] && graph[chosen][v]!=0) {
					//this means we will exclude this edge since we found something smaller
						excludedParent[p]=parent[v];
						excludedChild[p]=v;
						p++;
					}
	//if current position is a neighbor && still not included in MST && has a weight less than its previous weight				
			if (graph[chosen][v] != 0 && inMST[v] == false && graph[chosen][v] < weight[v]) {
					//update MST
					parent[v] = chosen;
					//update edge
					weight[v] = graph[chosen][v];
					}
					}
				c++; 	//counts how many edges are excluded
				
			}

			//print the MST
			printMST(parent,vertex, graph,edges,c,excludedParent, excludedChild);
		}
		
		
		

	void printMST(int parent[],int V, int graph[][], int edge, int c, int[] exparent, int[]exchild)
	//--------------------------------------------------------
		 // Summary: Prints the needed outputs for HW-3
		 // Precondition: parent, exparent and exchild are integer arrays, 
		// V,c and edge are integers, graph is an integer matrix
		 // Postcondition: Prints the output
		 //--------------------------------------------------------

	{
		// Prints the total length of MST
		int sum =0;
		for (int i = 1; i < V; i++)
			 sum = sum + graph[i][parent[i]];
		System.out.println(sum); 
		System.out.println(edge-c); //Prints number of edges that are not used
		
		//Prints excluded paths
		//By converting it to char and capital letters
		for(int i=0;i<(edge-c);i++) {
			System.out.println((char)(exparent[i]+65) + " " + (char)(exchild[i]+65));
		}
		
	}

	
}
