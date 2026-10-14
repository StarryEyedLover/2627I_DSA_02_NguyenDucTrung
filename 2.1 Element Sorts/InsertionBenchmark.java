import edu.princeton.cs.algs4.*;
import java.util.Arrays;

public class InsertionBenchmark {


    static void insertionSort(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }


    static double timeAvg(int[] data, int runs) {
        double total = 0;
        for (int r = 0; r < runs; r++) {
            int[] a = data.clone();
            long start = System.nanoTime();
            insertionSort(a);
            long end = System.nanoTime();
            total += (end - start) / 1e6;
        }
        return total / runs;
    }

    static int[] randomData(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = StdRandom.uniformInt(-1_000_000, 1_000_000);
        return a;
    }

    static int[] sortedData(int[] src) {
        int[] a = src.clone();
        Arrays.sort(a);
        return a;
    }

    static int[] reverseData(int[] src) {
        int[] a = sortedData(src);
        for (int i = 0; i < a.length / 2; i++) {
            int t = a[i]; a[i] = a[a.length - 1 - i]; a[a.length - 1 - i] = t;
        }
        return a;
    }

    static int[] equalData(int n) {
        int[] a = new int[n];
        Arrays.fill(a, 7);
        return a;
    }

    public static void main(String[] args) {
        String dir = "F:\\algs4-data\\";
        String[] files = {"1Kints.txt", "2Kints.txt", "4Kints.txt",
                "8Kints.txt", "16Kints.txt", "32Kints.txt"};


        for (int i = 0; i < 5; i++) insertionSort(randomData(5000));

        System.out.printf("%-12s %10s %12s %12s %12s %12s%n",
                "Kich thuoc", "File(1)", "Random(2)", "Sorted(3)", "Reverse(4)", "Equal(5)");

        for (String f : files) {
            int[] fileData = new In(dir + f).readAllInts();
            int n = fileData.length;

            double t1 = timeAvg(fileData, 3);
            double t2 = timeAvg(randomData(n), 5);
            double t3 = timeAvg(sortedData(fileData), 3);
            double t4 = timeAvg(reverseData(fileData), 3);
            double t5 = timeAvg(equalData(n), 3);
            System.out.printf("%-12d %10.3f %12.3f %12.3f %12.3f %12.3f%n",
                    n, t1, t2, t3, t4, t5);
        }
    }
}