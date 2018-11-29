package zadaniaDodatkowe;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArraysAndStringsTest {

	@Test
	public void testUniqueCharactersBit() {
		
		//testdata
		String testS1 = "abcoeaw";
		
		ArraysAndStrings test = new ArraysAndStrings();
		assertEquals(test.uniqueCharactersBit(testS1),false);	
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
		String testS1 = "Hello My  Dear   Friend ";
		
		ArraysAndStrings test = new ArraysAndStrings();
		assertEquals(test.URLifyString(testS1),"Hello%20My%20%20Dear%20%20%20Friend%20");
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
		
		int [][] testMatrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int [][] resultMatrix = {{13,9,5,1},{14,10,6,2},{15,11,7,3},{16,12,8,4}};
		
		ArraysAndStrings test = new ArraysAndStrings();
		assertArrayEquals(test.rotateMatrix90Degree(testMatrix, 4),resultMatrix);		
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
