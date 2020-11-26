package sdet.week10.assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SwapAlphabets {

	@Test
	public void example1() {
		String inp = "BdAcbCaD"; // BbdDAacC
		System.out.println(swapAlphabets(inp));
	}
	
	@Test
	public void example2() {
		String inp = "BdcbCaD"; 
		System.out.println(swapAlphabets(inp));
	}
	
	private String swapAlphabets(String inp) {
		String s="";
		
		return "";
	}
	
	private String swapAlphabets1(String inp) {
		if (inp.length() == 0 || inp.length() == 1 || inp == null)
			return inp;

		StringBuilder sb = new StringBuilder(inp);

		for (int i = 0; i < inp.length(); i++) {
			char c = Character.isUpperCase(sb.charAt(i)) ? Character.toLowerCase(sb.charAt(i))
					: Character.toUpperCase(sb.charAt(i));
			for (int j = i + 1; j < inp.length(); j++) {
				if (sb.charAt(j) == c) {
					sb.deleteCharAt(j);
					sb.insert(i + 1, c);
					i++;
					break;
				}
			}
		}

		return sb.toString();
	}
}
