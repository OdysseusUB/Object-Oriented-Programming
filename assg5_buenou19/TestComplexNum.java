/**
 * @author Ulysses Bueno
 */
package assg5_buenou19;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import assg2_buenou19.ComplexNum;

public class TestComplexNum {

	private ComplexNum x, y, z;
	
	@Before
	public void setUp() {
		x = new ComplexNum();
		y = new ComplexNum(2.0);
		z = new ComplexNum(3.0, 3.5);
	}

	@Test
	public void testDefaultConstructor() {
		assertEquals("Real value: ", 0.0, x.getReal(), 0.001);
		assertEquals("Imaginary number: ", 0.0, x.getImaginary(), 0.001);
	}
	
	@Test 
	public void testOneParameterConstructor() {
		assertEquals("Real value: ", 2.0, y.getReal(), 0.001);
		assertEquals("Imaginary value: ", 0.0, y.getImaginary(), 0.001);
	}
	
	@Test
	public void testTwoParamConstructor() {
		assertEquals("Real value", 3.0, z.getReal(), 0.001);
		assertEquals("Imaginary value: ", 3.5, z.getImaginary(), 0.001);
	}
	
	@Test
	public void testGetReal() {
		assertEquals("Real number is: ", 3.0, z.getReal(), 0.001);
	}
	
	@Test
	public void testGetImaginary() {
		assertEquals("Imaginary number is: ", 3.5, z.getImaginary(), 0.001);
	}
	
	@Test
	public void testSetReal() {
		x.setReal(1.0);
		assertEquals(1.0, x.getReal(), 0.001);
	}
	
	@Test
	public void testSetImaginary() {
		x.setImaginary(1.0);
		assertEquals(1.0, x.getImaginary(), 0.001);
	}
	
	@Test
	public void testAdd() {
		assertEquals(new ComplexNum(5.0,3.5), y.add(z));
		assertEquals(new ComplexNum(6.0, 7.0), z.add(z));
	}
	
	@Test
	public void testSub() {
		assertEquals(new ComplexNum(1.0, 3.5), z.sub(y)); 
		assertEquals(new ComplexNum(0.0, 0.0), y.sub(y)); 
	}

	@Test
	public void testMul() {
		assertEquals(new ComplexNum(6.0, 7.0), y.mul(z));
		assertEquals(new ComplexNum(-3.25, 21.0), z.mul(z));
	}
	
	@Test
	public void testNeg() {
		assertEquals(new ComplexNum(-3.0, -3.5), z.neg());
	}	
	@Test
	public void testToString() {
		assertEquals("3.0+3.5i", z.toString());
		assertEquals("2.0", y.toString());
	}
	
	@Test
	public void testEquals() {
		assertEquals(false, z.equals(x));
		assertEquals(true, z.equals(z));
	}
}

