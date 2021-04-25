package sdet.week_22.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]
*/

public class P3_AnagramIndices {
	
	@Test
	public void example1() {
		String s="cbaebabacd";
		String p="abc";
		System.out.println(findAnagrams(s, p));
	}
	
	@Test
	public void example2() {
		String s="abab";
		String p="ab";
		System.out.println(findAnagrams(s, p));
	}
	
	private List<Integer> findAnagrams(String s, String p) {
        int slen=s.length(),plen=p.length();
        int start=0,end=0;
        
        List<Integer> output=new ArrayList<>();
        
        int[] sarr=new int[26];
        int[] parr=new int[26];
        
        while(end<slen){
            if(end<plen)
                parr[p.charAt(end)-'a']++;
            sarr[s.charAt(end++)-'a']++;
            
            if(end>=plen){
                if(Arrays.equals(sarr,parr))
                    output.add(start);
                sarr[s.charAt(start++)-'a']--;
            }
        }
        
        return output;
    }
}
