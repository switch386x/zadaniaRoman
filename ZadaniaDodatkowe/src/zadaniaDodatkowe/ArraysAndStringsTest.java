package zadaniaDodatkowe;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ArraysAndStringsTest {

	@Test
	public void testUniqueCharacters() {
		
		//testdata
		String testS1 = "abcoeaw";
		
		ArraysAndStrings test = new ArraysAndStrings();
		assertEquals(test.uniqueCharacters(testS1),false);	
	}
	
	@Test
	public void testArePermutation(){
		
		//testdata
		
		String testS1 = "abc";
		String testS2 = "cbe";
		
		ArraysAndStrings test = new ArraysAndStrings(); //should i create new object for each test? or is it redundant
		equals(test.arePermutation(testS1, testS2)); //reference not a primitive type?
	}
	
	@Test
	public void testURLifyString(){
		
		//testdata
		String inputTestString = "Hello My  Dear   Friend ";
		String outputTestString = "Hello%20My%20%20Dear%20%20%20Friend%20";
		
		ArraysAndStrings test = new ArraysAndStrings();
		assertEquals(test.URLifyString(inputTestString),outputTestString);
	}
	
	@Test
	public void testIsEditDistanceOne(){
	    
	    //testdata
	    String testString1 = "bar";
	    String testString2 = "cro";
	    String testString3 = "spark";
	    String testString4 = "psark";
	    String testString5 = "sparky";
	    String testString6 = "park";
	    String testString7 = "bbbbbbspark";
	    String testString8 = "bspark";
	    
	    ArraysAndStrings test = new ArraysAndStrings();
	    assertEquals(test.isEditDistanceOne(testString1, testString2),false);
	    assertEquals(test.isEditDistanceOne(testString3, testString4),false);
	    assertEquals(test.isEditDistanceOne(testString3, testString5),true);
	    assertEquals(test.isEditDistanceOne(testString3, testString6),true);
	    assertEquals(test.isEditDistanceOne(testString3, testString7),false);
	    assertEquals(test.isEditDistanceOne(testString3, testString8),true);
	    
	}
	
	@Test
	public void testStringCompression(){
		
		//testdata
		
		String testS1 = "aaabbbccccaadd";
		String testS2 = "aa";
		
		ArraysAndStrings test = new ArraysAndStrings();
		assertEquals(test.stringCompression(testS1),"a3b3c4a2d2");
		assertEquals(test.stringCompression(testS2),"aa");
	}
	
	@Test
	public void testRotateMatrix90Degree(){
		
		//testdata
		//NxN dimensional matrix
		int [][] testMatrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
		int [][] resultMatrix = {{21,16,11,6,1},{22,17,12,7,2},{23,18,13,8,3},{24,19,14,9,4},{25,20,15,10,5}};
		
		ArraysAndStrings test = new ArraysAndStrings();
		assertArrayEquals(test.rotateMatrix90Degree(testMatrix, 5),resultMatrix);		
	}
	
	
	@Test
	public void testSetMatrixValuesToZero(){
		
		//testdata
		
		int [][] testMatrix = {{1,1,1,1},{1,0,1,1},{1,1,1,1}};
		int [][] resultMatrix = {{1,0,1,1},{0,0,0,0},{1,0,1,1}};
		
		ArraysAndStrings test = new ArraysAndStrings();
		assertArrayEquals(test.setMatrixValuesToZero(testMatrix,3,4),resultMatrix);
	}
	
	@Test
	public void testIsRotation(){
		
		//testdata
		
		String testS1 = "waterbottle";
		String testS2 = "erbottlewat";
		
		ArraysAndStrings test = new ArraysAndStrings();
		assertEquals(test.isRotation(testS1, testS2),true);
		
	}
}
