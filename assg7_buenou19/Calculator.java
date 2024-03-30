/*
 * A class for calculator
 * @Author - Ulysses Bueno
 */
package assg7_buenou19;

import java.util.Stack;

public class Calculator {

	private String infixExp = "";
	private String result = "";
	private Stack<Character> stack = new Stack<>();

	/*
	 * Default constructor for Calculator
	 * 
	 * @param exp The expression
	 * 
	 * @param infixExp The infix expression
	 * 
	 * @param result The expression evaluated and its answer
	 */
	public Calculator(String exp) {
		this.infixExp = exp;
		this.result = "";
	}

	/*
	 * A method to print the expression to a string
	 */
	public String toString() {
		return this.infixExp;
	}

	/*
	 * A method to convert the expression to Postfix
	 * 
	 * @param result The string of the Postfix expression
	 * 
	 * @param stack The variable for the stack
	 */
	private boolean convertPostfix() {
		for (int i = 0; i < infixExp.length(); i++) {
			if (Character.isLetter(infixExp.charAt(i))) {
				return false;
			} else if (Character.isDigit(infixExp.charAt(i))) {
				result += infixExp.charAt(i);

				if (i < infixExp.length() - 1) {
					if (!Character.isDigit(infixExp.charAt(i + 1))) {
						result += " ";
					}
				}

				if (i == infixExp.length() - 1) {
					result += " ";
				}

			}
			switch (infixExp.charAt(i)) {
			case '+':
			case '-':
			case '*':
			case '/':
				while (!stack.isEmpty() && stack.peek() != '(' && Prec(infixExp.charAt(i)) <= Prec(stack.peek())) {
					result = result + stack.pop() + " ";
				}
				stack.push(infixExp.charAt(i));
				break;
			case '(':
				stack.push(infixExp.charAt(i));
				break;
			case ')':
				while (!stack.isEmpty() && stack.peek() != ('('))
					result = result + stack.pop() + " ";
				stack.pop();
				break;
			case ' ':
				break;
			}

		}
		if (stack.isEmpty() && result == "") {
			System.out.println("Invalid Expression");
			return false;
		}
		while (!stack.isEmpty()) {
			result = result + stack.pop() + " ";
		}
		return true;
	}

	/*
	 * A method to get the Postfix
	 * 
	 * @return result The result after conversion
	 */
	public String getPostfix() throws IllegalStateException {
		if (convertPostfix())
			return result;
		else {
			throw new IllegalStateException();
		}
	}

	/*
	 * A method to evaluate and produce answer
	 * 
	 * @param eStack The variable for the evaluate stack
	 * 
	 * @param IllegalStateException This exception is thrown if illegal state
	 */
	public int evaluate() throws IllegalStateException {
		int value = 0;
		int val1;
		int val2;
		int multi = 0;
		char o;

		Stack<Integer> eStack = new Stack<Integer>();
		if (!convertPostfix() || result == null || result == " ") {
			throw new IllegalStateException();
		} else {
			for (int i = 0; i < result.length(); i++) {
				o = result.charAt(i);
				if (Character.isDigit(o)) {
					// Handle if is multidigit
					while (Character.isDigit(o)) {
						multi = multi * 10;
						multi = multi + (int) (o - '0');
						i++;
						o = result.charAt(i);
					}
					i--;
					eStack.push(multi);
					multi = 0;
				} else if (isOperator(o)) {
					val1 = eStack.pop();
					val2 = eStack.pop();
					if (o == '+') {
						value = val1 + val2;
					}
					if (o == '-') {
						value = val2 - val1;
					}
					if (o == '*') {
						value = val1 * val2;
					}
					if (o == '/') {
						value = val2 / val1;
					}

					eStack.push(value);

				}
			}
			return eStack.pop();
		}
	}

	/**
	 * A method to set the precedence of the operands
	 * 
	 * @param ch The character that represents what operand is used
	 * @return 1 Level of precedence
	 * @return 2 Level of precedence
	 * @return -1 Level of precedence
	 */
	private int Prec(char ch) {
		switch (ch) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		}
		return -1;

	}

	/**
	 * A method to figure out if a character is an operator
	 * 
	 * @param o The character in question
	 * @return true If the character is
	 * @return false If the character is not
	 */
	private boolean isOperator(char o) {
		if (o == '+' || o == '-' || o == '*' || o == '/') {
			return true;
		}
		return false;
	}

}