/**
 * @Author - Ulysses Bueno
 * A class for ComplexNumDemo
 */
package assg2_buenou19;

public class ComplexNumDemo {

	public static void main(String[] args) {
		
		ComplexNum c1 = new ComplexNum();
		ComplexNum c2 = new ComplexNum(1.0);
		ComplexNum c3 = new ComplexNum(1.0, 2.5);
		ComplexNum c4 = new ComplexNum(3.7, 4.4);
		ComplexNum c5 = new ComplexNum(0, 1.0);
		
		System.out.println("The complex numbers are: ");
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		System.out.println(c3.toString());
		System.out.println(c4.toString());
		System.out.println(c5.toString());
		
		System.out.print('\n');
		System.out.println("What is the real number for CM 3?: " + c3.getReal());
		System.out.println("What is the imaginary number for CM 3?: " + c3.getImaginary() + "i");
		
		System.out.print('\n');
		System.out.println("Set the real number for CM 3?: " + c3.getReal());
		System.out.println("Set the imaginary number for CM 3?: " + c3.getImaginary() + "i");
		
		System.out.print('\n');
		System.out.println("Add c2 to c3:");
		System.out.println(c2.add(c3));
	
		System.out.print('\n');
		System.out.println("Sub c2 from c3:");
		System.out.println(c2.sub(c3));
		
		System.out.print('\n');
		System.out.println("Multiply c3 and c3:");
		System.out.println(c3.mul(c3));
		
		System.out.print('\n');
		System.out.println("Negate c3:");
		System.out.println(c3.neg());
		
		System.out.print('\n');
		System.out.println("Does c3 equal c3?");
		System.out.println(c3.equals(c3));
		
		System.out.print('\n');
		System.out.println("Does c2 equal c3?");
		System.out.println(c2.equals(c3));
		
	}

}
