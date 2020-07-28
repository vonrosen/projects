package org.hunter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Primes{

	public static void main(String [] args) {
		primes(50);
	}

	public static void primes(int n) {
		List<Integer> previous = new ArrayList<>();
		Stream.iterate(1, i -> i += 2).filter(i -> {
			boolean isPrime;
			if (previous.stream().anyMatch(p -> i % p == 0)) {
				isPrime = false;
			}
			else {
				isPrime = true;
			}
			if (i != 1) {
				previous.add(i);
			}
			return isPrime;
		}).limit(n).forEach(System.out::println);
	}

}
