/**
 * @Author - Ulysses Bueno
 * A class for ComplexNum
 */
package assg2_buenou19;

public class ComplexNum {

	double num;
	double iNum;
/**
 * The default constructor
 */
	public ComplexNum() {
		num = 0;
		iNum = 0;
	}
/**
 * A constructor for ComplexNum
 * @param num The real num
 */
	public ComplexNum(double num) {
		this.num = num;
		iNum = 0;
	}
/**
 * A constructor for ComplexNum
 * @param num The real num
 * @param iNum The imaginary num
 */
	public ComplexNum(double num, double iNum) {
		this.num = num;
		this.iNum = iNum;
	}
/**
 * getReal The method to get the real number
 * @return num The real number
 */
	public double getReal() {
		return num;
	}
/**
 * The method to get the imaginary number
 * @return iNum The imaginary number
 */
	public double getImaginary() {
		return iNum;
	}
/**
 * The method to set the real number
 * @param num The new number
 */
	public void setReal(double num) {
		this.num = num;
	}
/**
 * The method to set the imaginary number
 * @param iNum The new imaginary number
 */
	public void setImaginary(double iNum) {
		this.iNum = iNum;
	}
/**
 * A method to add ComplexNum's together
 * @param a The complex number to add
 * @return ComplexNum The new ComplexNum created from the two CM's
 */
	public ComplexNum add(ComplexNum a) {
		return new ComplexNum(this.num + a.num, this.iNum + a.iNum);
	}
/**
 * A method to subtract ComplexNum's
 * @param a The complex number to subtract
 * @return ComplexNum The new ComplexNum created after subtraction
 */
	public ComplexNum sub(ComplexNum a) {
		return new ComplexNum(this.num - a.num, this.iNum - a.iNum);
	}
/**
 * A method to multiply ComplexNum's
 * @param a The complex number to multiply
 * @return ComplexNum The new ComplexNum created after multiplication
 */
	public ComplexNum mul(ComplexNum a) {
		return new ComplexNum(this.num * a.num - (this.iNum * a.iNum), this.num * a.iNum + (this.iNum * a.num));
	}
/**
 * A method to negate ComplexNum's
 * @return ComplexNum The new ComplexNum created after negating
 */
	public ComplexNum neg() {
		return new ComplexNum(-this.num, -this.iNum);
	}
/**
 * A method for toString
 * Will not return the real or imaginary if one is 0
 */
	@Override
	public String toString() {
		if (iNum > 0) {
			if (Double.compare(0, num) == 0) {
				return iNum + "i";
			}
			return num + "+" + iNum + "i";
		} else if (iNum < 0) {
			if (Double.compare(0, num) == 0) {
				return iNum + "i";
			}
			return num + "" + iNum + "i";
		} else {
			return String.valueOf(num);
		}
	}
/**
 * A method for equals
 * Compares two ComplexNum's to each other and compares both the imaginary and real number
 */
	@Override
	public boolean equals(Object obj) {
		ComplexNum temp = (ComplexNum) obj;
		if (obj == null) {
			return false;
		} else if (!(obj instanceof ComplexNum)) {
			return false;
		} else if (Double.compare(this.num, temp.num) == 0 && (Double.compare(this.iNum, temp.iNum) == 0)) {
			return true;
		} else {
			return false;
		}
	}

}