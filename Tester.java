import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Main method to test the huffman code
 * @author nhan
 *
 */

public class Tester {
	public static void main(final String[] theArgs) throws IOException{
		String s = "Eerie eyes seen near lake.";
		
		
		
		FileWriter fileWriter = new FileWriter("output.txt");
		PrintWriter printWriter = new PrintWriter(fileWriter);

		HuffmanFrequencyTable f = new HuffmanFrequencyTable(s);


		Encode e = new Encode(f, s);

		f.printTable(printWriter);

		System.out.println("Encoded bit stream:");
		printWriter.println("Encoded bit stream:");

		System.out.println(e.getBits());
		printWriter.println(e.getBits());
		
		System.out.println("\nTotal number of bits without Huffman coding (8-bits per character): "
				+ e.getNormalBits());
		printWriter.println("\nTotal number of bits without Huffman coding (8-bits per character): "
				+ e.getNormalBits());
		
		
		System.out.println("Total number of bits with Huffman coding: " 
				+ e.getNumberOfBits(e.getBits()));
		printWriter.println("Total number of bits with Huffman coding: " 
				+ e.getNumberOfBits(e.getBits()));
		
		
		
		Decode d = new Decode(f);
		
		System.out.println("Decoded String: " + d.decode(e.getBits()));
		printWriter.println("Decoded String: " + d.decode(e.getBits()));
		printWriter.close();
		
		
	}

}
