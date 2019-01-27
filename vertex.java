/*
 * This class creates a node class.It creates a individual vertex/nodes in the graph with 
 * some of the attributes that re used to implement the dijkstras algorithm.
 * Author: Aayush Ghimire
 */
import java.util.HashMap;

public class vertex {
	//stores distnace
	private int distFromOrigin;
	//checks if visited
	private boolean visited;
	//hashmap to store edges
	private HashMap<vertex, Integer> edges;
	//stores parent node
	private vertex parentNode;
	//name of the node
	private String vName;
	//index of the heap
	private int heapIndex;

	//constructors	
	public vertex(String name) {
		this.vName = name;
		this.visited = false;
		this.parentNode = null;
		this.edges = new HashMap<vertex, Integer>();
		this.distFromOrigin = Integer.MAX_VALUE;
		heapIndex = -1;
	}
	/*
	 * setter for distance
	 */
	public void setDistance(int distance) {
		this.distFromOrigin = distance;
	}
	/*
	 * getter for distance
	 */
	public int getDistance() {
		return this.distFromOrigin;
	}
	/*
	 * getter for string
	 */
	public String getName() {
		return this.vName;
	}
	
	/*
	 * setter to change visited
	 */
	public void setVisited(boolean bool) {
		this.visited = bool;
	}
	/*
	 * getter to get visited
	 */
	public boolean getVisited() {
		return this.visited;
	}
	/*
	 * getter to get the hasmap for edges
	 */
	public HashMap<vertex, Integer> getEdge() {
		return this.edges;
	}
	/*
	 * setter to set the index
	 */
	public void setIndex(int index) {
		this.heapIndex = index;
	}
	/*
	 * getter to get the index
	 */
	public int getIndex() {
		return this.heapIndex;
	}
	/*
	 * setter to set the parent vertex
	 */
	public void setParent(vertex newParent) {
		this.parentNode = newParent;
	}
	/*
	 * getter to get the parent vertex
	 */
	public vertex getParent() {
		return this.parentNode;
	}
}
