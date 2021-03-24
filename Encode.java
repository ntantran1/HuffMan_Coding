import java.util.HashMap;

/**
 * A class that turn the string into bit code stream
 * @author nhan
 *
 */
public class Encode {
	
	private String s = "";
	private String bitStream;
	private HuffmanTreeNode root;
	private HashMap<Character, String> map = new HashMap<>();
	
	/**
	 * A constructor that set up the root and the string
	 * @param f the frequency table to build the tree
	 * @param theS the string to encode
	 */
	public Encode(HuffmanFrequencyTable f, String theS) {

		
		root = new HuffmanTree(f).getRoot();
		compress(root, s);
		setBitStream(theS);
		f.updateMap2(map);
		
	}


	 /**
	  * A method to get the bit code for each character
	  * @param node
	  * @param s
	  */
	 public void compress(HuffmanTreeNode node, String s) { 
	  
		 	//Check if at the leaf node
	        if (node.getLeft() 
	                == null
	            && node.getRight() == null) { 
	        	if(root.getLeft() == null && root.getRight() == null) {
	        		map.put(node.getChar(), s + "0");
	        		
	        	}else {
	        		map.put(node.getChar(), s);
	        		
	        	}


	            
	  
	            return; 
	        } 
	  
	    
	        compress(node.getLeft(), s + "0"); 
	        compress(node.getRight(), s + "1"); 
	    } 
	 	
	    /**
	     * Converting string to the bit code stream
	     * @param s
	     */
	    public void setBitStream(String s) {
	    	StringBuilder sb = new StringBuilder();
	    	for (int i = 0, n = s.length(); i < n; i++) {
				
			    char c = s.charAt(i);
			    
			    
			    sb.append(map.get(c));
			    
				
			}
	    	bitStream = sb.toString();
	    }
	    
	    /**
	     * Method to get the bit code stream
	     * @return
	     */
	    public String getBits() {
	    	return bitStream;
	    }
	    
	    /**
	     * Getting the number of bits
	     * @param b
	     * @return
	     */
	    public Integer getNumberOfBits(String b) {
	    	int bits = 0;
	    	for (int i = 0, n = b.length(); i < n; i++) {
				bits++;
			    
			    
				
			}
	    	return bits;
	    	
	    }
	    
	    /**
	     * Getting the map of the character and the bit code
	     * @return
	     */
		public HashMap<Character, String> getCode() {
			return map;
		}
		
		/**
		 * Getting the number of bits of the normal bit code without huffman tree
		 * @return
		 */
		
		public Integer getNormalBits() {
			return root.getFreq() * 8;
		}
	

}
