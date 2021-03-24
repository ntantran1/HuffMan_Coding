/**
 * A class to decode the bit code back to the original string
 * @author nhan
 *
 */
public class Decode {
	//The root of the huffman tree
	private HuffmanTreeNode root;

	
	
	/**
	 * A Constructor that pass in the frequency table
	 * @param f
	 */
	public Decode(HuffmanFrequencyTable f) {
		root = new HuffmanTree(f).getRoot();
		
	}
	
	/**
	 * Method to decode the code to the string
	 * @param code
	 * @return
	 */
	public String decode(String code) {
		
		StringBuilder sb1= new StringBuilder();
		HuffmanTreeNode node;
		node = root;
		char z = '0';
		char o = '1';
		
		//Loop through string code
		for (int i = 0, n = code.length(); i < n; i++) {
			
		    char c = code.charAt(i);
		    
		    //Check condition to traverse through the tree
		    if(c == z && root.getLeft() != null) {
		    	
		    	node = node.getLeft();
		    	
		    	//Check if the node is the last leaf node
		    	if(node.getRight() == null && node.getLeft() == null) {
		    		sb1.append(node.getChar());
		    		node = root;
		    		
		    	}
		    }else if(c == o && root.getRight() != null) {
		    	node = node.getRight();
		    	if(node.getRight() == null && node.getLeft() == null) {
		    		sb1.append(node.getChar());
		    		node = root;
		    		
		    	}
		    }else if(root.getRight() == null && root.getLeft() == null) {
		    	
		    	sb1.append(root.getChar());
		    	
		    }
		}
		
		//return back the decoded string
		return sb1.toString();
	}

}
