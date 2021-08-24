import edu.princeton.cs.algs4.In;

import java.util.ArrayList;

public class Permutation {
    private ArrayList<Integer> usedIndex = new ArrayList<>();

    Permutation(int n, String[] s) {
        int tem;
        while(usedIndex.size() <= s.length) {
            tem =(int)(Math.random()*s.length);

            for(int i = 0; i < usedIndex.size(); i++) {
                if(usedIndex.get(i) == tem) {
                    continue;
                }
            }

            usedIndex.add(tem);
            System.out.print(s[tem]);
        }


    }

    public static void main(String[] args) {

    }
}