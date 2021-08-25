import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.In;

public class Permutation {

    public static void main(String[] args) {
        RandomizedQueue<String> rQ = new RandomizedQueue<String>();
        int cnt;

        while (!StdIn.isEmpty())
        {
            rQ.enqueue(StdIn.readString());
        }
        cnt = Integer.parseInt(args[0]);

        int i = 0;
        while (i < cnt) {
            System.out.print(rQ.dequeue() + " \n");
            i++;
        }


    }

    /*
    private Permutation(int n, String[] s) {
        int tem = n;
        RandomizedQueue<String> rQ;
        rQ = new RandomizedQueue<>();
        for (int i = 0; i < s.length; i++) {
            rQ.enqueue(s[i]);
        }

        while (n != 0) {
            System.out.print(rQ.dequeue());
        }

    }
     */

}