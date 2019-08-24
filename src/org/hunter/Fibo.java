package org.hunter;

public class Fibo {

    //0, 1, 1, 2, 3, 5, 8
    public static void main(String [] args) {
        Fibo f = new Fibo();

        System.out.println(f.fiboDp(1));
        System.out.println(f.fiboDp(2));
        System.out.println(f.fiboDp(3));
        System.out.println(f.fiboDp(4));
        System.out.println(f.fiboDp(5));
        System.out.println(f.fiboDp(6));
        System.out.println(f.fiboDp(7));
        System.out.println(f.fiboDp(8));
        System.out.println(f.fiboDp(9));
    }

    //O(N) = N
    public int fiboDp(int n) {
        int [] mem = new int[n + 1];

        for (int i = 1; i <= n; ++i) {
            if (i == 1) {
                mem[1] = 0;
                if (n > 1) {
                    mem[2] = 1;
                }

                i = 2;
            }
            else {
                mem[i] = mem[i - 1] + mem[i - 2];
            }
        }

        return mem[n];
    }

    //O(N) = 2^N
    public int fibo(int n) {
        if (n == 1) {
            return 0;
        }

        if (n == 2) {
            return 1;
        }

        return fibo(n - 1) + fibo(n - 2);
    }
}
