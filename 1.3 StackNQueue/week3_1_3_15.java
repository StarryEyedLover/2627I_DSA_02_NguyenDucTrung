import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class week3_1_3_15 {
    public static void main(String[] args){
        int k = Integer.parseInt(args[0]);
        Queue<String> queue = new Queue<String>();

        while (!StdIn.isEmpty()) {
            queue.enqueue(StdIn.readString());
        }

        int n = queue.size();

        for (int i = 0; i < n - k; i++) {
            queue.dequeue();
        }

        StdOut.println(queue.dequeue());
    }
}
