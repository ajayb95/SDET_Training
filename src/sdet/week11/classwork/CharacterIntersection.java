package sdet.week11.classwork;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/*
Given an array of strings made only from lowercase letters, 
return a list of all characters that show up in all strings within the list (including duplicates).  
For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.
You may return the answer in any order.
Input: ["bella","label","roller"]
Output: ["e","l","l"]
Input: ["cool","lock","cook"]
Output: ["c","o"]
*/

//Pseudo code
/*
 * Iterate through each and every character from first string
 * check if the character is present in second and third string
 * if yes, add it to a list
 * for next iteration if the character is already present in the list then send the count to subsequent loop and iterate till it reaches the count
 * if character present in first string not present either or neither in second and third string, it is not intersection character
 * return the list of intersection character
 * Space complexity: O[N]
 * Time complexity: O[N^3]
 */

/*
 * Very native solution. We use the first String char_count as a reference.
for example, "bella" will count into arr[26] with all letter's count. [b]=1, [e]=1,[l]=2,[a]=1 will be the reference.
Then we loop the rest String: for each string ,we did the same new arr[26] count, then scan reference with the new arr count. If count not match, then we need to update the reference count with smaller count. like "label" has same char_count, then "roller" will update reference as [e]=1, [l]=2;
After loop the whole string array, we only need to scan the reference count [e]=1, [l]=2 and add the letter into a list respectively with the count number.
 */
public class CharacterIntersection {

	@Test
	public void example1() {
		String[] inp= {"bella","label","roller"};
		charIntersection(inp);
	}
	
	@Test
	public void example2() {
		String[] inp= {"cool","lock","cook"};
		charIntersection(inp);
	}
	
	private void charIntersection(String[] inp) {
		Map<Character, Integer> map=new HashMap<>();
		
		for (char c : inp[0].toCharArray())
			map.put(c, map.getOrDefault(c, 0)+1);
		
		int cnt=0;
		
		for (int i = 1; i < inp.length; i++) {
			char[] cArr = inp[1].toCharArray();
			
		}
	}
}
