package sdet.week_17.classwork;

import org.junit.Assert;
import org.junit.Test;

public class AlienDictionary {

	@Test
	public void example1() {
		String[] words= {"hello","leetcode"};
		String order="hlabcdefgijkmnopqrstuvwxyz";
		Assert.assertEquals(true, isLexicographicalySorted(words, order));
	}
	
	@Test
	public void example2() {
		String[] words= {"word","world","row"};
		String order="worldabcefghijkmnpqstuvxyz";
		Assert.assertEquals(false, isLexicographicalySorted(words, order));
	}
	
	@Test
	public void example3() {
		String[] words= {"apple","app"};
		String order="abcdefghijklmnopqrstuvwxyz";
		Assert.assertEquals(false, isLexicographicalySorted(words, order));
	}
	
	private boolean isLexicographicalySorted(String[] words,String order) {
		int[] orderPos=new int[26];
		
		for (int i = 0; i < orderPos.length; i++)
			orderPos[order.charAt(i)-'a']=i;
		
		
		return false;
	}
}
