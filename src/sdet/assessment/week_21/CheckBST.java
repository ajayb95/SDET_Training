package sdet.assessment.week_21;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class CheckBST {
	@Test
	public void example1() {
		int[] tree = { 2, 1, 3, 4, 5 };
		Assert.assertEquals(true, checkBST(tree));
	}

	@Test
	public void example2() {
		int[] tree = { 1, 3, 2 };
		Assert.assertEquals(true, checkBST(tree));
	}

	@Test
	public void example3() {
		int[] tree = { 2, 1, 3 };
		Assert.assertEquals(true, checkBST(tree));
	}

	@Test
	public void example4() {
		int[] tree = { 3, 2, 1, 5, 4, 6 };
		Assert.assertEquals(true, checkBST(tree));
	}

	@Test
	public void example5() {
		int[] tree = { 1, 3, 4, 2 };
		Assert.assertEquals(false, checkBST(tree));
	}

	@Test
	public void example6() {
		int[] tree = { 3, 4, 5, 1, 2 };
		Assert.assertEquals(false, checkBST(tree));
	}

	@Test
	public void example7() {
		int[] tree = { 10, 7, 5, 4, 1, 2, 3, 6, 9, 8, 11, 12 };
		Assert.assertEquals(true, checkBST(tree));
	}

	@Test
	public void example8() {
		int[] tree = { 13, 2, 1, 8, 7, 10, 6, 11, 9, 12, 4, 5, 3 };
		Assert.assertEquals(false, checkBST(tree));
	}

	private boolean checkBST(int[] tree) {
		Stack<Integer> s = new Stack<Integer>();
		int root = Integer.MIN_VALUE;
		for (int i = 0; i < tree.length; i++) {
			if (tree[i] < root) {
				return false;
			}
			while (!s.empty() && s.peek() < tree[i]) {
				root = s.peek();
				s.pop();
			}
			s.push(tree[i]);
		}
		return true;
	}
}
