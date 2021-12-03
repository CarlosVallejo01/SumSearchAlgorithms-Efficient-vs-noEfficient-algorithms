import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class ThreeSum {
    private int  [] n;
    private int initialValue;

    public ThreeSum() {
        initialValue = 250;
        while (true){
            n = new int[initialValue];
            fillArray();
            Stopwatch stopwatch = new Stopwatch();
            StdOut.println("Size: " + initialValue+ " Counter: " + count() + " Time elapsed: " + stopwatch.elapsedTime());
            initialValue = initialValue * 2;
        }


    }

    public int count() {  // Count triples that sum to 0.
        int N = n.length;
        int counter = 0;
        for (int i = 0; i < N; i++)
            for (int j = i+1; j < N; j++)
                for (int k = j+1; k < N; k++)
                    if (n[i] + n[j] + n[k] == 0)
                        counter++;
        return counter;
    }


    public void fillArray(){
        for (int i = 0; i < n.length; i++)
            n[i] = StdRandom.uniform(-1001,1001);
    }
}


class Main{
    public static void main(String [] args){
        ThreeSum ts = new ThreeSum();
    }
}
