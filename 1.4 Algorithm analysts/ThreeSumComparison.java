import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class ThreeSumComparison {

    public static int countNaive(int[] a) {
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                for (int k = 0; k < N; k++)
                    if (i < j && j < k)
                        if (a[i] + a[j] + a[k] == 0)
                            cnt++;
        return cnt;
    }
    public static int countStandard(int[] a) {
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = i + 1; j < N; j++)
                for (int k = j + 1; k < N; k++)
                    if (a[i] + a[j] + a[k] == 0)
                        cnt++;
        return cnt;
    }

    public static void main(String[] args) {
        StdOut.println(" N       Naive(s)    Standard(s)   Ratio (Naive/Standard)");
        StdOut.println("---------------------------------------------------------");

        for (int N = 250; true; N += N) {
            int[] a = new int[N];
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform(-1000000, 1000000);
            }

            Stopwatch timerNaive = new Stopwatch();
            countNaive(a);
            double timeNaive = timerNaive.elapsedTime();

            Stopwatch timerStandard = new Stopwatch();
            countStandard(a);
            double timeStandard = timerStandard.elapsedTime();

            double ratio = 0.0;
            if (timeStandard > 0) {
                ratio = timeNaive / timeStandard;
            }

            StdOut.printf("%-7d %-11.3f %-13.3f %.2f\n", N, timeNaive, timeStandard, ratio);
        }
    }
}

