package app;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class RLEconverter {
   private final static int DEFAULT_LEN = 100; // used to create arrays.	
   
   /*
    *  This method reads in an uncompressed ascii image file that contains 
    *  2 characters. It stores each line of the file in an array.
    *  It then calls compressAllLines to get an array that stores the compressed
    *  version of each uncompressed line from the file. The compressed array
    *  is then passed to the getCompressedFileStr method which returns a String
    *  of all compressed lines (the two charcaters are written in the first line)
    *  in CSV format. This String is written to a text file with the prefix "RLE_"
    *  added to the original, uncompressed file name.
    *  Note that dataSize keeps track of the number of lines in the file. The array 
    *  that holds the lines of the file is initialized to the DEFAULT_LEN, which 
    *  is assumed to be << the number of lines in the file.
    */   
  public void compressFile(String fileName) throws IOException{
    Scanner scan = new Scanner(new FileReader(fileName));
    String line = null;
    String[] decompressed = new String [DEFAULT_LEN];
    int dataSize = 0;
    while(scan.hasNext()){
      line = scan.next();
      if(line != null && line.length()>0)
        decompressed[dataSize]=line;
        dataSize++;
    }
    scan.close();
    char[] fileChars = discoverAsciiChars(decompressed, dataSize); 
    String[] compressed = compressAllLines(decompressed, dataSize, fileChars);
    writeFile(getCompressedFileStr(compressed, fileChars), "RLE_"+fileName);
  }
  
   
/*
 * This method implements the RLE compression algorithm. It takes a line of uncompressed data
 * from an ascii file and returns the RLE encoding of that line in CSV format.
 * The two characters that make up the image file are passed in as a char array, where
 * the first cell contains the first character that occurred in the file.
*/
public String compressLine(String line, char[] fileChars){
   //TODO: Implement this method
	/* I implemented this method by first checking whether the first line was equal to the 
	 * second file char, which if it was, would need to have "0," concatenated. 
	 * I then made a for loop which iterates through the line, and indexes or zeros
	 * certain ascii character counters whenever the characters alternate. When the characters,
	 * alternate, the count is concatenated to the return String compress, and zeroed. 
	 * At the end, the last number (which ever counter is not zero) is concatenated
	 * back to the string.
	 * */
	char[] chArr = line.toCharArray();
	int asciiOne = 0; 
	int asciiTwo = 0; 
	String compress = "";
	
	if (chArr[0] == fileChars[1]) {
		compress += "0,"; 
	}
	
	
	for (int i = 0; i < chArr.length; i++) {
		if (chArr[i] == fileChars[0]) {
			if (asciiTwo != 0 && i+2 == chArr.length) {
				compress += asciiTwo; 
			}
			else if (asciiTwo != 0) {
				compress += asciiTwo + ","; 
			}
			asciiTwo = 0; 
			asciiOne++; 
		}
		
		else if (chArr[i] == fileChars[1]) {
			if (asciiOne != 0 && i+2 == chArr.length) {
				compress += asciiOne; 
			}
			else if (asciiOne != 0) {
				compress += asciiOne + ","; 
			}
			asciiOne = 0; 
			asciiTwo++; 
		}
		
	}
	
	if (asciiOne != 0) {
		compress += asciiOne; 
	}
	
	if (asciiTwo != 0) {
		compress += asciiTwo; 
	}
	
	return compress;
}

  /*
   *  This method discovers the two ascii characters that make up the image. 
   *  It iterates through all of the lines and writes each compressed line
   *  to a String array which is returned. The method compressLine is called on 
   *  each line.
   *  The dataSize is the number of lines in the file, which is likely to be << the length of lines.
   */
  public String[] compressAllLines(String[] lines, int dataSize, char[] fileChars){
      //TODO: Implement this method
	  
	  /*
	   * I simply created a new string array, and added the compressed version of each
	   * line in String[] lines using the previous compressLine method. 
	   * */
	  
	  String[] compressed = new String[dataSize]; 
	  for (int i = 0; i < dataSize; i++) {
		  compressed[i] = compressLine(lines[i], fileChars); 
	  }
      return compressed;
}

/*
 *  This method assembles the lines of compressed data for
 *  writing to a file. The first line must be the 2 ascii characters
 *  in comma-separated format. 
 */
public String getCompressedFileStr(String[] compressed, char[] fileChars) {
    //TODO: Implement this method
	
	/*
	 * I first created a new string called decompressed and added the first 
	 * ascii charecters to the first line of the string followed by a line break.
	 * I then iterated through the compressed array through a for loop, and concatenated
	 * each line to one string, followed by a line break every time except when the 
	 * index was nearing the actual length of the array.  
	 * */
	
	String decompressed = Character.toString(fileChars[0]) + "," + Character.toString(fileChars[1]) + "\n";
	
    for (int i = 0; i < compressed.length; i++) {
    	 if (i+1 == compressed.length) {
    		 decompressed += compressed[i]; 
    	 }
    	 else {
    		 decompressed += compressed[i] + "\n"; 
    	 }
    }
    
    
    return decompressed; 
}
   /*
    *  This method reads in an RLE compressed ascii image file that contains 
    *  2 characters. It stores each line of the file in an array.
    *  It then calls decompressAllLines to get an array that stores the decompressed
    *  version of each compressed line from the file. The first row contains the two 
    *  ascii charcaters used in the original image file. The decompressed array
    *  is then passed to the getDecompressedFileStr method which returns a String
    *  of all decompressed lines, thus restoring the original, uncompressed image.
    *  This String is written to a text file with the prefix "DECOMP_"
    *  added to the original, compressed file name.
    *  Note that dataSize keeps track of the number of lines in the file. The array 
    *  that holds the lines of the file is initialized to the DEFAULT_LEN, which 
    *  is assumed to be << the number of lines in the file.
    */   
  public void decompressFile(String fileName) throws IOException{
    Scanner scan = new Scanner(new FileReader(fileName));
    String line = null;
    String[] compressed = new String [DEFAULT_LEN];
    int dataSize =0;
    while(scan.hasNext()){
      line = scan.next();
      if(line != null && line.length()>0)
        compressed[dataSize]=line;
        dataSize++;
    }
    scan.close();
    String[] decompressed = decompressAllLines(compressed, dataSize);
    writeFile(getDecompressedFileStr(decompressed), "DECOMP_"+fileName);
  }
 
   /*
   * This method decodes lines that were encoded by the RLE compression algorithm. 
   * It takes a line of compressed data and returns the decompressed, or original version
   * of that line. The two characters that make up the image file are passed in as a char array, 
   * where the first cell contains the first character that occurred in the file.
   */
   public String decompressLine(String line, char[] fileChars){
      //TODO: Implement this method
	   
	   /*
	    * I split the line into an array using split, and using a for loop I
	    * added the ascii character to the new decompressed string by the number
	    * */
	   
	   String[] chArr = line.split(",");
	   String original = "";
	   int num = 0;
	   for (int i = 0; i < chArr.length; i++) {
		   num = i%2; 
		   for (int j = 0; j < Integer.parseInt(chArr[i]); j++) {
			   original += fileChars[num]; 
		   }
	   }
	   
	   return original; 
   }
    /*
   *  This method iterates through all of the compressed lines and writes 
   *  each decompressed line to a String array which is returned. 
   *  The method decompressLine is called on each line. The first line in
   *  the compressed array passed in are the 2 ascii characters used to make
   *  up the image. 
   *  The dataSize is the number of lines in the file, which is likely to be << the length of lines.
   *  The array returned contains only the decompressed lines to be written to the decompressed file.
   */
  public String[] decompressAllLines(String[] lines, int dataSize){
     //TODO: Implement this method
	  /*
	   * I simply create a asciiTwo array which stores the first two ascii characters in 
	   * the first line. I then use a forloop to add the decompressed lines by inputting 
	   * lines from the array list of compressed lines. 
	   * */
	  String[] decompressed = new String[dataSize]; 
	  String[] ascii = lines[0].split(",");
	  char[] asciiTwo = new char[2]; 
	  asciiTwo[0] = ascii[0].charAt(0); 
	  asciiTwo[1] = ascii[1].charAt(0); 
	  
	  for (int i = 1; i < dataSize; i++) {
		 decompressed[i] = decompressLine(lines[i],asciiTwo); 
	  }
	  
	  return decompressed;
  }
  
  /*
   *  This method assembles the lines of decompressed data for
   *  writing to a file. 
   */
  public String getDecompressedFileStr(String[] decompressed){
     /*
      * For this method, I took the exact same approach as I did for getCompressedFileStr.
      * 
      * */
	  
	  String data = "";
   //TODO: Implement this method
     
     
     for (int i = 0; i < decompressed.length; i++) {
    	 if (i+1 == decompressed.length) {
    		 data += decompressed[i]; 
    	 }
    	 else {
    		 data += decompressed[i] + "\n"; 
    	 }
    }
     
      return data;
  }

  // assume the file contains only 2 different ascii characters.
  public char[] discoverAsciiChars(String[] decompressed, int dataSize){
	//TODO: Implement this method
	  /*
	   * For this method I simply iterated through each char in each string in each
	   * index of the inputted array with two nested for loops in order to 
	   * search for different ascii letters, and break after finding two unique ascii
	   * letters. 
	   * */
	  char[] ascii = new char[2];
	  ArrayList<Character> asciiList = new ArrayList<Character>(); 
	  for (int i = 0; i < decompressed.length; i++) {
		  for (int j = 0; j < decompressed[i].length()-1; j++) {
			  if (!asciiList.contains(decompressed[i].charAt(j))) {
				  asciiList.add(decompressed[i].charAt(j));
			  }
			  if (asciiList.size() == 2) {
				  break;
			  }
		  }
		  if (asciiList.size() == 2) {
			  break;
		  }
	  }
	  
	  ascii[0] = asciiList.get(0);
	  ascii[1] = asciiList.get(1);
	  
	  return ascii; 
}



   
   public void writeFile(String data, String fileName) throws IOException{
		PrintWriter pw = new PrintWriter(fileName);
      pw.print(data);
      pw.close();
   }
}