public class RPN {
	MyStack stack; 
	public RPN() {
		stack = new MyStack();
	}
	public static void main(String[] args) {
		RPN calc = new RPN();
		System.out.println(calc.stack);
		calc.stack.push("+");
		System.out.println(calc.stack);
		calc.stack.pop();
		System.out.println(calc.stack);
		calc.stack.push("-");
		System.out.println(calc.stack);
		calc.stack.push("1");
		System.out.println(calc.stack);
		calc.stack.pop();
		System.out.println(calc.stack);
	}

}