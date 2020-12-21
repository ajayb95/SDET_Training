package sdet.week13.weekwork;

import org.junit.Test;

public class DecodedString {

	@Test
	public void example1() {
		String s="leet2code3";
		int k=10;
		System.out.println(findKthCharacter(s, k));
	}
	
	@Test
	public void example2() {
		String s="ha22";
		int k=5;
		System.out.println(findKthCharacter(s, k));
	}
	
	@Test
	public void example3() {
		String s="a2b3c4d5e6f7g8h9";
		int k=10;
		System.out.println(findKthCharacter(s, k));
	}
	
	@Test
	public void example4() {
		String s="y959q969u3hb22odq595";
		int k=222280369;
		System.out.println(findKthCharacter(s, k));
	}
	
	private char findKthCharacter(String s,int k) {
		String op="";
		for(char ch:s.toCharArray()) {
			if(Character.isDigit(ch)) {
				String temp=op;
				for (int i = 1; i < Character.getNumericValue(ch); i++)
					op+=temp;
			}else {
				op+=ch;
			}
			if(op.length()>=k) {
				System.out.println(op);
				return op.charAt(k-1);
			}
		}
		
		return 0;
	}
}
