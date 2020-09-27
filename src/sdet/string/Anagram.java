package sdet.string;

import org.junit.Test;

public class Anagram {
	
	@Test
	public void example1() {
		String input="acbbabccaabcab";
		String anagram="abc";
		getAnagram(input, anagram);
	}
	
	private void getAnagram(String input,String anagram) {
		int anagramValue=0;
		for(char c:anagram.toCharArray())
			anagramValue+=(int)c;
		System.out.println(anagramValue);
		
		int op=0;
		for (int i = 0; i < anagram.length(); i++) {
			op+=(int)input.charAt(i);
		}
		for (int i = anagram.length(); i < input.length()-anagram.length(); i++) {
			
		}
	}
}
