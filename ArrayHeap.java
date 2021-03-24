
/**
 * An array heap that represent priority queue as a heap
 * @author nhan
 *
 * @param <T>
 */
public class ArrayHeap<T> {
	
	@SuppressWarnings("unchecked")
	//An array of priority queue node
	private PriorityQueueNode<T>[] a = new PriorityQueueNode[10000];
	
	//A temporary node
	private PriorityQueueNode<T> temp;
	
	// The number of the element in the array
	int n = 0;
	
	/**
	 * An empty constructor
	 */
	public ArrayHeap() {
		
	}
	
	/**
	 * A method to add the element in the array
	 * @param node
	 */
	public void addElement(PriorityQueueNode<T> node) {
		int i = 0;
		
		a[n] = node;
		i = n;
		
		n++;
		
		//A loop to swap the element in the right position in the array
		while(i != 0 && (i-1)/2 >= 0) {
			
			// Check condition to swap
			if(a[i].compareTo(a[(i-1)/2]) == -1) {
				temp = a[i];
				a[i] = a[(i-1)/2];
				a[(i-1)/2] = temp;
				
			}
			i = (i-1)/2;

		}
		
		
		
	}
	
	/**
	 * Method to remove the minimum element in the array
	 * @return return the removed element
	 */
	public PriorityQueueNode<T> removeMin() {
		boolean v = true;
		int i = 0;
		
		PriorityQueueNode<T> m = a[0];
		a[0] = a[n-1];
		n--;
		i = 0;
		
		//A loop to heapify after remove the element
		while((2*i) + 1 <= n && v) {
			if((2*i) + 1 < n && (2*i) + 2 < n) {
				PriorityQueueNode<T> left = a[(2*i) + 1];
				PriorityQueueNode<T> right = a[(2*i) + 2];
				if(left.compareTo(a[i]) == 1 && right.compareTo(a[i]) == 1) {
					v = false;
					
				}else if(left.compareTo(right) == 1) {
						temp = a[i];
						a[i] = right;
						a[(2*i) + 2] = temp;
						i = (2*i) + 2;
				}else if(right.compareTo(left) == 1) {
					temp = a[i];
					a[i] = left;
					a[(2*i) + 1] = temp;
					i = (2*i) + 1;
					
				}
			}else {
				PriorityQueueNode<T> left2 = a[(2*i) + 1];
				if(a[i].compareTo(left2) == 1) {
					temp = a[i];
					a[i] = left2;
					a[(2*i) + 1] = temp;
					i = (2*i) + 1;
					
				}else {
					v = false;
					
				}
			}

		}

		return m;
	}
	
	// Return the size of the queue
	public Integer getSize() {
		return n;
	}
	
	// Return the minimum of the queue
	public PriorityQueueNode<T> getPeek() { 
		return a[0];
	}
	


}
