import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class week3_1_3_11 {
    public static void main(String[] args) {
        Stack<Double> stack = new Stack<Double>();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (s.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (s.equals("-")) {
                double right = stack.pop();
                stack.push(stack.pop() - right);
            } else if (s.equals("/")) {
                double right = stack.pop();
                stack.push(stack.pop() / right);
            } else {
                stack.push(Double.parseDouble(s));
            }
        }

        StdOut.println(stack.pop());
    }
}