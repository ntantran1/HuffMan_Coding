
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
/**
 * The frequency table is the class that take in a string and check
 * the occurrence of the character in the string
 * @author nhan
 *
 */
public class HuffmanFrequencyTable {
	
	private HashMap<Character, Integer> map = new LinkedHashMap<>();
	private HashMap<Character, String> map2 = new LinkedHashMap<>();
	private String str;
	
	/**
	 * An empty constructor
	 */
	public HuffmanFrequencyTable() {
		
	}
	
	/**
	 * A constructor that pass in a string
	 * @param theS the input string
	 */
	public HuffmanFrequencyTable(String theS) throws IOException {
		
		str = theS;
		CalculateF(str);
		
		
	}
	
	/**
	 * Method to find the frequency of each character
	 * @param s the input string
	 */
	private void CalculateF(String s) {
		int freq = 0;
		
		// The outer loop that loop through the string
		for (int i = 0, n = s.length(); i < n; i++) {
			
			freq = 0;
		    char c = s.charAt(i);
		    
		    //The inner loop that loop through the string to compare the character
		    for (int ind = 0, n2 = s.length(); ind < n2; ind++) {
		    	char c2 = s.charAt(ind);
			    if(c == c2) {
			    	freq++;
			    	
			    }
		    }
		    map.put(c, freq);
		    
		}
		
		// Check to see the string have the minimum of 2 unique characters
		try {
			if(map.size()<2) {
				throw new IllegalArgumentException("");
			}
		}catch(IllegalArgumentException e) {
			System.out.println("The string must have at least 2 distinct character!!");
			System.exit(1);
		}
		
	}

	
	/**
	 * update the map that contain the bit code for each character after the encode
	 * @param theM
	 */
	public void updateMap2(HashMap<Character, String> theM) {
		for (Map.Entry<Character,String> e : theM.entrySet()) {
			map2.put(e.getKey(), e.getValue());
			
		}
		
		
	}
	
	/**
	 * Method to print out the frequency table
	 * @throws IOException 
	 */
	public void printTable(PrintWriter printWriter) throws IOException {
		
	
		if(!map2.isEmpty()) {
			System.out.println("% java Tester " + "\"" + str + "\"");
			printWriter.println("% java Tester " + "\"" + str + "\"");
			
			System.out.println("======================================");
			printWriter.println("======================================");
			
			System.out.println("char     frequency     code");
			printWriter.println("char     frequency     code");
			
			System.out.println("--------------------------------------");
			printWriter.println("--------------------------------------");
			
			for (Entry<Character, Integer> ele : map.entrySet()) {
				System.out.print(ele.getKey());
				printWriter.print(ele.getKey());
				
				System.out.printf("%-8s", "");
				printWriter.printf("%-8s", "");
				
				System.out.printf("%-14d%-10s" ,ele.getValue(),map2.get(ele.getKey()));
				printWriter.printf("%-14d%-10s" ,ele.getValue(),map2.get(ele.getKey()));
				
				System.out.println("");
				printWriter.println("");
				
			}
			System.out.println("======================================");
			printWriter.println("======================================");
			
		}else {
			System.out.println("% java Tester " + str);
			System.out.println("====================================== ");
			System.out.println("char      frequency     code ");
			System.out.println("--------------------------------------");
			for (Map.Entry<Character,Integer> e : map.entrySet()) {
				
				System.out.print(e.getKey());
				System.out.printf("%10d",e.getValue());
	
				System.out.print("\n");
			}
			System.out.println("======================================");
		}
		

	}
	
	/**
	 * Method to return the map of frequency table
	 */
	public HashMap<Character, Integer> getMap() {
		return map;
	}
}
