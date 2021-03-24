/**
 * A class for the huffman node
 * @author nhan
 *
 */
public class HuffmanTreeNode {
	private char myChar;
	private int myFrequency;
	private HuffmanTreeNode myLeft, myRight;
	
	/**
	 * A constructor for root with no left and right
	 */
	public HuffmanTreeNode() {
		myLeft = null;
		myRight = null;
		
	}
	
	/**
	 * The constructor that set the char and frequency
	 * @param theC
	 * @param theF
	 */
	public HuffmanTreeNode(char theC, int theF) {
	
		myChar = theC;
		myFrequency = theF;
	}
	
	/**
	 * Method to get the character
	 * @return
	 */
	public Character getChar() {
		return myChar;
		
	}
	
	/**
	 * Method to get the frequency value
	 */
	public int getFreq() {
		return myFrequency;
		
	}
	/**
	 * Method to get the character
	 * @param theC
	 */
	public void setChar(char theC) {
		this.myChar = theC;
		
	}
	
	/**
	 * Method to set the frequency
	 * @param theF
	 */
	public void setFreq(int theF) {
		this.myFrequency = theF;
		
	}
	/**
	 * Method to set the left node
	 * @param theN
	 */
	public void setLeft(HuffmanTreeNode theN) {
		this.myLeft = theN;
		
	}
	/**
	 * Method to set the right node
	 * @param theN
	 */
	public void setRight(HuffmanTreeNode theN) {
		this.myRight = theN;
		
	}
	/**
	 * Method to get the left node
	 * @return
	 */
	public HuffmanTreeNode getLeft() {
		return myLeft;
		
	}
	/**
	 * Method to get the right node
	 * @return
	 */
	public HuffmanTreeNode getRight() {
		return myRight;
		
	}
}
