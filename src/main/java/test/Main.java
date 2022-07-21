package test;

import org.github.eboubaker.AVLTree.Tree;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static double log(int x, int base) {
        return Math.log(x) / Math.log(base);
    }

    public static void main(String[] args) {
        Random r = new Random();
        Tree<Integer> numberTree = new Tree<>();
        long start = System.currentTimeMillis();
        int insertions = 10_000_000;
        for (int i = 0; i < insertions; i++) {
            numberTree.insert(r.nextInt());
        }
        System.out.println("AVLTree: Log(n)= " + log(numberTree.size(), 2)
                + " ,height=" + numberTree.getHeight()
                + " ,size=" + numberTree.size()
                + " ,insertions=" + insertions
                + " ,time=" + (System.currentTimeMillis() - start) + "ms"
                + " ,insertions-per-second=" + (insertions / (System.currentTimeMillis() - start) * 1000) + " insertions/s");
        start = System.currentTimeMillis();
        int tests = 500_000;
        for(int i = 0; i < tests; i++)
        {
            numberTree.contains(r.nextInt());
        }
        System.out.println("AVLTree: tests=" + tests
                + " ,time=" + (System.currentTimeMillis() - start) + "ms"
                + " ,tests-per-second=" + (tests / (System.currentTimeMillis() - start) * 1000) + " tests/s");
        var arr = new ArrayList<>();
        for (int i = 0; i < insertions; i++) {
            arr.add(r.nextInt());
        }
        tests = 100;
        start = System.currentTimeMillis();
        for(int i = 0; i < tests; i++)
        {
            arr.contains(r.nextInt());
        }
        System.out.println("ArrayList: tests=" + tests
                + " ,time=" + (System.currentTimeMillis() - start) + "ms"
                + " ,tests-per-second=" + (int)(1.0f * tests / (System.currentTimeMillis() - start) * 1000) + " tests/s");
    }
}
