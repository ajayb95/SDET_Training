package sdet.week_17.weekwork;

import java.util.stream.IntStream;

import org.junit.Test;

//write a program to accept an integer and print closest prime number to it
public class FindClosestPrime {

	@Test
	public void example1() {
		int n = 12;
		System.out.println(findNearPrime(n));
	}

	@Test
	public void example2() {
		int n = 84;
		System.out.println(findNearPrime(n));
	}

	@Test
	public void example3() {
		int n = 66;
		System.out.println(findNearPrime(n));
	}

	@Test
	public void example4() {
		int n = 26;
		System.out.println(findNearPrime(n));
	}

	private int findNearPrime(int n) {
		int neg = 0;

		while (true) {
			if (isPrime(n - neg))
				return n - neg;
			if (isPrime(n + neg))
				return n + neg;
			
			neg++;
		}

		//return -1;
	}

	private boolean isPrime(int n) {
			
		return (n % 2 != 0) && IntStream.rangeClosed(3, (int) Math.sqrt(n)).filter(each -> (each % 2 != 0))
				.noneMatch(div -> (n % div == 0));
	}
}
