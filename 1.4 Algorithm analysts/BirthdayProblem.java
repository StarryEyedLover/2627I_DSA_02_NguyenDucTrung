import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class BirthdayProblem {
    public static int runExperiment(int n) {
        boolean[] seen = new boolean[n];
        int count = 0;
        while (true) {
            int val = StdRandom.uniform(n);
            count++;
            if (seen[val]) {
                break;
            }
            seen[val] = true;
        }

        return count;
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            StdOut.println("Vui lòng nhập tham số N từ dòng lệnh.");
            return;
        }

        int n = Integer.parseInt(args[0]);
        int trials = 10000;
        long totalCount = 0;

        for (int t = 0; t < trials; t++) {
            totalCount += runExperiment(n);
        }

        double averageCount = (double) totalCount / trials;
        double expectedCount = Math.sqrt(Math.PI * n / 2.0);

        StdOut.printf("N = %d\n", n);
        StdOut.printf("Số lượng trung bình (thực tế) : %.4f\n", averageCount);
        StdOut.printf("Số lượng dự đoán (lý thuyết): %.4f\n", expectedCount);
    }
}
