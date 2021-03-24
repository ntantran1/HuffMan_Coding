import java.util.Map;
/**
 * The class that create the huffman tree using frequency table
 * @author nhan
 *
 */
public class HuffmanTree {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private PriorityQueue<PriorityQueueNode> q = new PriorityQueue();
	private HuffmanTreeNode root = new HuffmanTreeNode();
	private HuffmanTreeNode temp1 = new HuffmanTreeNode();
	private HuffmanTreeNode temp2 = new HuffmanTreeNode();
	private HuffmanFrequencyTable f = new HuffmanFrequencyTable();
	
	/**
	 * A constructor the pass in the frequency table
	 * @param theF
	 */
	public HuffmanTree(HuffmanFrequencyTable theF) {
		f = theF;
		
		SetQ();
		CreateTree();
		
	}
	
	/**
	 * Method the set the queue
	 */
	@SuppressWarnings("rawtypes")
	public void SetQ() {
		//Loop thorugh the frequency table then add to the queue
		for (Map.Entry<Character,Integer> e : f.getMap().entrySet()) {
			HuffmanTreeNode node = new HuffmanTreeNode(e.getKey(), e.getValue());
			
			
			q.addElement(new PriorityQueueNode<PriorityQueueNode<PriorityQueueNode>>(node,e.getValue()));
		}
	}
	
	/**
	 * Method that use the queue to build the tree
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void CreateTree() {
		
		//Loop through the queue
		while(q.getSize() > 1) {
			int l = 0;
			int r = 0;
			int t = 0;
			
			HuffmanTreeNode n = new HuffmanTreeNode();
			temp1 = q.removeNext();
			temp2 = q.removeNext();
			l = temp1.getFreq();
			r = temp2.getFreq();
			t = l+r;
			n.setFreq(t);
			n.setLeft(temp1);
			n.setRight(temp2);
			q.addElement(new PriorityQueueNode(n, n.getFreq()));
		}
		try {
			root = q.getPeek().getElement();
		}catch(NullPointerException e) {
			System.out.println("Invalid Empty String");
		}
		
	}
	
	/**
	 * Method that get the root for the tree
	 * @return
	 */
	public HuffmanTreeNode getRoot() {
		return root;
	}
	

}
