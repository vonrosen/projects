package org.hunter;

public class Fibo2 {

	public static void main(String [] args) {
		Fibo2 f = new Fibo2();
		
		System.out.println(f.fibo(21));
		System.out.println(f.fiboDp(21));
	}
	
	//O(2^N)
	public long fibo(int n) {
		if (n == 1) {
			return 0;
		}
		
		if (n <= 2) {
			return 1;
		}
		
		return fibo(n - 1) + fibo(n - 2);
	}
	
	//O(N)
	public long fiboDp(int n) {
		long [] mem = new long[n + 1];
		
		mem[1] = 0;
		mem[2] = 1;
		
		for (int i = 3; i <= n; ++i) {			
			mem[i] = mem[i - 1] + mem[i - 2];			
		}
		
		return mem[n];		
	}	
	
}
