/*
Interface created for the implementation
of Dijkstra's algorithm
*/

public interface Dijkstra{
	//methods that are used on dijsktra_implementation class
	void addNode(String s);
	void addEdge(String from, String to, int weight);
	void runDijkstra(String startNodeName);
	void printDijkstraResults(String startNodeName);
}

