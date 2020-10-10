package sdet.week2.string;

import java.util.Arrays;

import org.junit.Test;

public class Anagram {
	
	@Test
	public void example1() {
		String input="acbbabccaabcab";
		String anagram="abc";
		//getAnagram(input, anagram);
		System.out.println(getAnagram(input, anagram));
	}
	
	@Test
	public void example2() {
		String input="acbbabccaabcab";
		String anagram="abd";
		//getAnagram(input, anagram);
		System.out.println(getAnagram(input, anagram));
	}
	
	private void getAnagram1(String input,String anagram) {
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
	
	private boolean getAnagram(String input,String anagram) {
		int[] ana=new int[26];
		
		for (char c:anagram.toCharArray()) {
			ana[c-'a']++;
		}
		
		int[] inp=new int[26];
		char[] charArray = input.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			inp[charArray[i]-'a']++;
			if(i>=anagram.length())
				inp[charArray[i-anagram.length()]-'a']--;
			if(Arrays.equals(ana, inp))
				return true;
		}
		return false;
	}
}
