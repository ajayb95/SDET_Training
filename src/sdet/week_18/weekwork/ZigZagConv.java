package sdet.week_18.weekwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.Test;

public class ZigZagConv {

	@Test
	public void example1() {
		String inp = "PAYPALISHIRING";
		int row = 3;
		convert(inp, row);
	}

	@Test
	public void example2() {
		String inp = "PAYPALISHIRING";
		int row = 4;
		convert(inp, row);
	}

	private void convert(String inp, int row) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		int ind = 1;
		boolean vert = true;
		for (int i = 0; i < inp.length(); i++) {
			if (!map.containsKey(ind))
				map.put(ind, "" + inp.charAt(i));
			else {
				String temp = map.get(ind) + inp.charAt(i);
				map.put(ind, temp);
			}

			if (ind == row)
				vert = false;
			else if (ind == 1)
				vert = true;

			if (vert)
				ind++;
			else
				ind--;
		}
		String temp = "";

		for (int i = 1; i <= row; i++)
			temp += map.get(i);
		
		System.out.println(temp);
	}
}
