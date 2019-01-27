
/*
 *This class creates a map and finds the shortest path from the given nodes to
 *all the other nodes.It also prints the shortest path and best path.It used min heap 
 *instead of priority queue.It is the implementation ofDijkstra algorithm.
 *Author: Aayush Ghimire
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Dijkstra_Implementation implements Dijkstra {
	// declaration of variable for this class
	private HashMap<String, vertex> myVertex;
	private boolean digraph;
	private int fileNum;

	// constructors for the class
	public Dijkstra_Implementation(boolean isDigraph) {
		this.digraph = isDigraph;
		this.myVertex = new HashMap<>();
		this.fileNum = 0;
	}

	/*
	 * This function adds a node. The nodes are stored in hash map Keys are the
	 * string and values are the each node object.
	 */
	@Override
	public void addNode(String s) {
		myVertex.put(s, new vertex(s));

	}

	/*
	 * Adds a edge in the node. two conditons either it can be digraph or not.
	 * Prams: String-> to and from starting from and ending nodes; int->weight of
	 * the path.
	 */
	@Override
	public void addEdge(String from, String to, int weight) {
		vertex fromVertex = myVertex.get(from);
		vertex toVertex = myVertex.get(to);
		// if digraph
		if (digraph) {
			fromVertex.getEdge().put(toVertex, weight);
		}
		// not digraph so other direction too;
		else {
			fromVertex.getEdge().put(toVertex, weight);
			toVertex.getEdge().put(fromVertex, weight);

		}
	}

	/*
	 * It will run the dijkstra's algorithm in the graph we made from addNodes and
	 * addEdge function.Min heap is used to do the same task as a priority queue.
	 */
	@Override
	public void runDijkstra(String startNodeName) {
		// gets the start node to start from
		vertex startNode = myVertex.get(startNodeName);
		startNode.setDistance(0);// starting point is set as 0

		// creates a heap that has a property of min heap, passed a int for the size of
		// array
		// that we are suppose to create and first node to start from.
		Heap newHeap = new Heap(myVertex.size(), startNode);

		while (!newHeap.isEmpty()) {
			vertex heapNode = newHeap.removeMin();//
			// heapNode.setVisited(true);//it is visited

			// loop through the hashmap where we store edges
			for (Map.Entry<vertex, Integer> entry : heapNode.getEdge().entrySet()) {
				// looped such that we got both key and value pair
				vertex currVertex = entry.getKey();
				int currentDist = entry.getValue();

				int shortest = heapNode.getDistance() + currentDist;

				if (shortest < currVertex.getDistance()) {
					currVertex.setDistance(shortest);
					// sets the parent
					currVertex.setParent(heapNode);
					newHeap.updateHeap(currVertex);
				}
			}
		}
	}

	/*
	 * This function prints the result to console.If the path cant be found then it
	 * will print no path else it will print best distance and path
	 */
	@Override
	public void printDijkstraResults(String startNodeName) {
		for (String allnode : myVertex.keySet()) {
			vertex gNode = myVertex.get(allnode);
			int currDistance = gNode.getDistance();

			if (currDistance == Integer.MAX_VALUE) {
				System.out.println(startNodeName + " -> " + allnode + ": NO PATH");
			} else {
				String path = getPathString(gNode);
				System.out.println(startNodeName + " -> " + allnode + ": best " + currDistance + ":" + path);
			}
		}
	}

	/*
	 * helper function to get the string of all the path. It loops through the nodes
	 * and gives all the nodes visited.
	 */
	private String getPathString(vertex gNode) {
		String path = "";
		while (gNode != null) {
			path = " " + gNode.getName() + path;
			gNode = gNode.getParent();
		}
		return path;
	}
	
}
