import edu.princeton.cs.algs4.*;

public class week3_1_3_12 {
    public static Stack<String> copy(Stack<String> stack) {
        Stack<String> temp = new Stack<String>();
        Stack<String> result = new Stack<String>();

        for (String s : stack) {
            temp.push(s);
        }

        for (String s : temp) {
            result.push(s);
        }

        return result;
    }

    public static void main(String[] args) {
        Stack<String> original = new Stack<String>();
        original.push("K70I_CS5");
        original.push("UET");
        original.push("Hello");

        Stack<String> copied = copy(original);

        StdOut.println("Original stack:");
        for (String s : original) {
            StdOut.print(s + " ");
        }
        StdOut.println("\n");

        StdOut.println("Copied stack:");
        for (String s : copied) {
            StdOut.print(s + " ");
        }
        StdOut.println();
    }
}
