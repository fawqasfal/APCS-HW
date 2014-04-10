import java.io.*;
import java.util.*;

public class RPN {
	final static String[] operators = {"+","-","*","/"};
	final static String instructions = "\nTo use this postfix calculator, insert evaluations line-by-line.\n" +
	"The program will compute your instruction after you hit enter.\n" + 
	"To quit, simply Ctrl-C.\n" +
	"The program parses your instruction as a list of tokens, seperated by spaces. Each token must be either a number or an operator.\n" +
	"Start your instruction with a token - if you insert a space or any other character other than a number (you can't start with an operator; this" +
	"is postfix), the program will break. Operators are evaluated on the previous 2 numbers.\n" +
	"You need to end your instruction with an operator in order to return a final number.";
	public RPN() {
	}
	public static void main(String[] args) {
		System.out.println(instructions);
		Scanner consoleIn = new Scanner(System.in); 
		while(true) {
			System.out.println(parse(consoleIn.nextLine()));
		}
	}
	public static String parse(String str) {
		//why doesn't String implement Iterable? 

		//checking to see if errythang's legal
		if (!str.contains(" ")) return "Incorrect formatting." + instructions;
		String[] tokens = str.split(" ");
		for (int i = 0; i < tokens.length; i++) 
			if (!tokens[i].matches("-?\\d+(\\.\\d+)?") && !isOp(tokens[i])) return "Incorrect formatting." + instructions; 
			//regex magic is to check if the str is a digit

		if (tokens.length < 3 || !isOp(tokens[tokens.length - 1]) || isOp(tokens[0])) return "Incorrect formatting." + instructions;
		
		/*... still sort of possibly illegal. the only thing insured here is you have a list of tokens, each token is either 
		a number or an operator, you have 3 or more tokens, the last token is an operator and the first token is a number.
		as of here in the method, you can still do stuff like this '5 / ' or '1 2 + 3 4 /' which isnt a final number.  
		*/
		MyStack eval = new MyStack();
		for (int i = 0; i < tokens.length; i++) {
			if (!isOp(tokens[i])) eval.push(tokens[i]);
			else {
				if (eval.size() < 2 ) return "Incorrect formatting. " + instructions;
				float op1 = Float.parseFloat(eval.pop());
				float op2 = Float.parseFloat(eval.pop());
				if (tokens[i].equals("+")) eval.push(String.valueOf(op2 + op1));
				if (tokens[i].equals("-")) eval.push(String.valueOf(op2 - op1));
				if (tokens[i].equals("/")) eval.push(String.valueOf(op2 / op1));
				if (tokens[i].equals("*")) eval.push(String.valueOf(op2 * op1));

			}
		}
		if (eval.size() != 1) return "Incorrect formatting." + instructions;
		return eval.pop();

	}
	public static boolean isOp(String token) {
		for (int i = 0; i < operators.length; i++) if (operators[i].equals(token)) return true;
		return false;
	}

}