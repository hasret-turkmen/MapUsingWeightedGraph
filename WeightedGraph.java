class WeightedGraph {
		private int source;
		private int destination;
		private int weight;

		//Constructor with source, destination and weight
		public WeightedGraph(char source, char destination, int weight) {
			this.source = source;
			this.destination = destination;
			this.weight = weight;
		}
		

		//Constructor with source and weight
		public WeightedGraph(int source, int weight) {
			this.source = source;
			this.weight = weight;
		}

		//Get methods for private variables
		int getSource() {
			return source;
		}
		
		int getDest() {
			return destination;
		}

		int getWeight() {
			return weight;
		}
		
	}
