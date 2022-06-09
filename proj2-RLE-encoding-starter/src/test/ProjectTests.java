package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import app.*;


public class ProjectTests {
   RLEconverter conv;
   
   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
     conv = new RLEconverter();  
   }

  //compress tests
  @Test 
  public void compressLineTest1()  {
    char[] fileChars = {'0','1'};
    String line = "000000";
    String correctRes = "6";
    String actualRes = conv.compressLine(line, fileChars);
    assertEquals("Test 1: Test the compressLine method.", correctRes, actualRes);
  }

  @Test 
  public void compressLineTest2() {
    char[] fileChars = {'0','1'};
    String line = "11111111";
    String correctRes = "0,8";
    String actualRes = conv.compressLine(line, fileChars);
    assertEquals("Test 2: Test the compressLine method.", correctRes, actualRes);
  }

  @Test 
  public void compressLineTest3() {
    char[] fileChars = {'0','1'};
    String line = "1111111111000";
    String correctRes = "0,10,3";
    String actualRes = conv.compressLine(line, fileChars);
    assertEquals("Test 3: Test the compressLine method.", correctRes, actualRes);
  }

  @Test 
  public void compressLineTest4() {
    char[] fileChars = {'1','0'};
    String line = "1111111111000";
    String correctRes = "10,3";
    String actualRes = conv.compressLine(line, fileChars);
    assertEquals("Test 4: Test the compressLine method.", correctRes, actualRes);
  }

  @Test 
    public void compressLineTest5()  {
    char[] fileChars = {'0','1'};
    String line = "11111111110001";
    String correctRes = "0,10,3,1";
    String actualRes = conv.compressLine(line, fileChars);
    assertEquals("Test 5: Test the compressLine method.", correctRes, actualRes);
  }

  @Test 
    public void compressLineTest6()  {
    char[] fileChars = {'_','$'};
    String line = "___________$$$$$$$$$$$$$$$______________";
    String correctRes = "11,15,14";
    String actualRes = conv.compressLine(line, fileChars);
    assertEquals("Test 6: Test the compressLine method.", correctRes, actualRes);
  }

  // compressedFileStr tests

  @Test 
  public void compressedFileStrFirstLineTest()  {
    String[] compressed = {"11,15,14", "8,4,6,8,14"};
    char[] fileChars = {'_','$'};
    String correctRes = "_,$";
    String actualRes = conv.getCompressedFileStr(compressed, fileChars).split("\n")[0];
    assertEquals("Test 7: Test the compressedFileStr method.", correctRes, actualRes);
  }  

  @Test 
  public void compressedFileStrLengthTest()  {
    String[] compressed = {"1,2,3", "4,5,0,1,2", "3,4", "5,0,1", "2"};
    char[] fileChars = {'s','t'};
    int correctRes = compressed.length + 1;
    int actualRes = conv.getCompressedFileStr(compressed, fileChars).split("\n").length;
    assertEquals("Test 8: Test the compressedFileStr method.", correctRes, actualRes);
  } 

  @Test 
  public void compressedFileStrCSVOutputTest()  {
    String[] compressed = {"2,3,1", "9,1", "982,4,6"};
    char[] fileChars = {'b','a'};

    String correctRes = "b,a\n2,3,1\n9,1\n982,4,6";
    String actualRes = conv.getCompressedFileStr(compressed, fileChars);
    assertEquals("Test 9: Test the compressedFileStr method.", correctRes, actualRes.toString().trim());
  }

  // decompress tests 

  @Test 
  public void decompressLineTest1()  {
    char[] fileChars = {'0','1'};
    String line = "8";
    String correctRes = "00000000";
    String actualRes = conv.decompressLine(line, fileChars);
    assertEquals("Test 10: Test the decompressLine method.", correctRes, actualRes);
  }

  @Test 
  public void decompressLineTest2() {
    char[] fileChars = {'0','1'};
    String line =  "0,10";
    String correctRes = "1111111111";
    String actualRes = conv.decompressLine(line, fileChars);
    assertEquals("Test 11: Test the decompressLine method.", correctRes, actualRes);
  }

  @Test 
  public void decompressLineTest3() {
    char[] fileChars = {'0','1'};
    String line = "0,9,3";
    String correctRes = "111111111000";
    String actualRes = conv.decompressLine(line, fileChars);
    assertEquals("Test 12: Test the decompressLine method.", correctRes, actualRes);
  }

  @Test 
  public void decompressLineTest4() {
    char[] fileChars = {'1','0'};
    String line = "9,4";
    String correctRes = "1111111110000";
    String actualRes = conv.decompressLine(line, fileChars);
    assertEquals("Test 13: Test the decompressLine method.", correctRes, actualRes);
  }

  @Test  
  public void decompressLineTest5()  {
    char[] fileChars = {'0','1'};
    String line = "0,11,3,1";
    String correctRes = "111111111110001";
    String actualRes = conv.decompressLine(line, fileChars);
    assertEquals("Test 14: Test the decompressLine method.", correctRes, actualRes);
  }

  @Test 
  public void decompressLineTest6()  {
    char[] fileChars = {'_','$'};
    String line = "9,14,14"; 
    String correctRes = "_________$$$$$$$$$$$$$$______________";
    String actualRes = conv.decompressLine(line, fileChars);
    assertEquals("Test 15: Test the decompressLine method.", correctRes, actualRes);
  }  

}