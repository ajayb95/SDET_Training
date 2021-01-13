package sdet.week_18.weekwork;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ReverseNumber {

	@Test
	public void example1() {
		int num = 123;
		Assert.assertEquals(321, reverseNum(num));
	}

	@Test
	public void example2() {
		int num = -123;
		Assert.assertEquals(-321, reverseNum(num));
	}

	@Test
	public void example3() {
		int num = 120;
		Assert.assertEquals(21, reverseNum(num));
	}

	@Test
	public void example4() {
		int num = 1534236469;
		Assert.assertEquals(0, reverseNum(num));
	}

	@Test
	public void example5() {
		int num = -2147483648;
		Assert.assertEquals(0, reverseNum(num));
	}
	
	@Test
	public void example6() {
		int num = 1563847412;
		Assert.assertEquals(0, reverseNum(num));
	}
	
	private int reverseNum(int num) {
		int sign = (num < 0) ? -1 : 1;
		int temp=Math.abs(num);
		long op=0;
		
		while(temp>0) {
			op=(op*10)+temp%10;
			temp/=10;
		}
		
		if(op>Integer.MAX_VALUE)
			return 0;
		
		return (int)op*sign;
	}
	
	private int reverseNum1(int num) {
		List<Integer> list = new ArrayList<Integer>();
		int sign = (num < 0) ? -1 : 1;
		num = Math.abs(num);
		while (num > 0) {
			list.add(num % 10);
			num /= 10;
		}

		int len = list.size();

		if (len > 10 || len == 10 && list.get(0) > 2 || num<0)
			return 0;

		for (int i = 0; i < list.size(); i++)
			num = num * 10 + list.get(i);
		
		if(num<0)
			return 0;
		
		return num * sign;
	}
}
