/*
 * Implementation of minimum heap
 * Author : Aayush Ghimire
 * 
 */
public class Heap {
	//array for heap
	private vertex[] heap;
	private int totalSize;
	
	//constructor of th class
	public Heap(int numberOfElements, vertex gNode) {
		this.heap = new vertex[numberOfElements];
		this.heap[0] = gNode;
		gNode.setIndex(0);
		this.totalSize = 1;
	}
	
	/*
	 * This function checks if the total size is 0 or not
	 */
	public boolean isEmpty() {
		if (this.totalSize == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * This function removes the minimun. As we create the minimum heap
	 * its the first element of array that is being removed
	 */
	public vertex removeMin() {
		vertex retNode = this.heap[0];
		retNode.setIndex(-1);
		retNode.setVisited(true);
		if (this.totalSize > 1) {
			this.heap[0] = this.heap[(this.totalSize - 1)];
			this.heap[0].setIndex(0);
		}
		this.heap[totalSize - 1] = null;
		this.totalSize -= 1;

		if (this.totalSize > 0) {
			bubbleDown(0);
		}
		return retNode;//removed node
	}
	
	/*
	 * It is the function that passed node of the graph as a paameter
	 * and calls the helper method to bubble up.
	 */
	public void updateHeap(vertex gNode) {
		if (gNode.getIndex() == -1) {
			gNode.setIndex(totalSize);
			this.heap[this.totalSize] = gNode;
			totalSize += 1;
		}
		bubbleUp(gNode.getIndex());
	}
	/*
	 * this function  is used to bubble up the element 
	 * in heap. It calls swap function so that it will
	 * be able to swap the values of given index and 
	 * parent index
	 * Private function and only visible to this class
	 */
	private void bubbleUp(int upIndex) {

		if (upIndex == 0) {
			return;
		}
		int temp = (upIndex - 1) / 2;
		if (heap[temp].getDistance() > heap[upIndex].getDistance()) {
			swap(temp, upIndex);
			bubbleUp(temp);
		}
	}
	/*
	 * this function  is used to bubble down the element 
	 * in heap. It calls swap function so that it will
	 * be able to swap the values of given index and 
	 * parent index.
	 * Private function and only visible to this class
	 */
	private void bubbleDown(int downIndex) {
		int leftSide = downIndex * 2 + 1;
		int rightSide = downIndex * 2 + 2;

		if (leftSide >= this.totalSize) {
			return;
		}

		if (rightSide < this.totalSize) {
			//if(this.heap[downIndex].getDistance() > this.heap[rightSide].getDistance());
			if (this.heap[rightSide].getDistance() < this.heap[leftSide].getDistance()
					&& this.heap[rightSide].getDistance() < this.heap[downIndex].getDistance()) {
				swap(downIndex, rightSide);
				bubbleDown(rightSide);
			}
		} else if (this.heap[leftSide].getDistance() < this.heap[downIndex].getDistance()) {
			swap(downIndex, leftSide);
			bubbleDown(leftSide);
		}
	}
	/*
	 * This is the helper function called in bubble up and down.
	 * It swaps the element in the while performing heap operation
	 */
	private void swap(int temp, int parent) {
		vertex tempVer = this.heap[temp];

		this.heap[temp] = this.heap[parent];
		heap[parent] = tempVer;

		heap[temp].setIndex(temp);
		heap[parent].setIndex(parent);
	}
}
