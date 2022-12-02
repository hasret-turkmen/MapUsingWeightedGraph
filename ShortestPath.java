public class ShortestPath {
	
	//--------------------------------------------------------
	 // Summary: Finds the shortest path from a source to all vertices
	 // Precondition: vertexNo and src are integers
	//graph is a double arraylist and it is WeightedGraph type
	 // Postcondition: The shortest paths are found.
	 //--------------------------------------------------------
    public static int[] dijkstra(int src, int vertexNo, ArrayList<ArrayList<WeightedGraph>> graph)
    {
    	//distance array will be updated when a shorter path is found
        int[] dist = new int[vertexNo];
        
        //First, assume every distance is infinite
        for (int b = 0; b < vertexNo; b++)
            dist[b] = Integer.MAX_VALUE;
        
        //Create a PQ which will store the minimum distances from the source
        //The function can also be written as:
        /* 
         PriorityQueue<WeightedGraph> queue = new PriorityQueue<>(){
         public int difference(WeightedGraph source, WeightedGraph destination){
         return source.getWeight()-destination.getWeight();
         }
         };
         */
        PriorityQueue<WeightedGraph> queue = new PriorityQueue<>((source, destination)->source.getWeight()-destination.getWeight());
        queue.add(new WeightedGraph(src, 0));
       //Only the source's distance is zero
        dist[src] = 0;
        
        while (!queue.isEmpty()) {
        	//Get the first entered element
        	WeightedGraph checkMin = queue.poll();
        	//Check every neighbor of the current source
            for (WeightedGraph cities:graph.get(checkMin.getSource())) {
            	//if current distance is longer than the new distance
                if (dist[cities.getSource()]> (dist[checkMin.getSource()]+ cities.getWeight())) {
                	//change the distance with the new shorter distance
                	dist[cities.getSource()] = cities.getWeight()+ dist[checkMin.getSource()];
                	//and add it to the priority queue
                    queue.add(new WeightedGraph(cities.getSource(),dist[cities.getSource()]));
                }
            }
        }
        return dist;
    }
 
}
