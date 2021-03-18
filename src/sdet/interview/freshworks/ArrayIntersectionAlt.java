package sdet.interview.freshworks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/*
 * Given of lists with K lists, find intersection between them
 */

public class ArrayIntersectionAlt {

	ArrayList<Integer> temp = new ArrayList<>();

	ArrayIntersectionAlt(ArrayList<Integer> temp) {
		this.temp.addAll(temp);
	}

	public void findIntersection(ArrayList<Integer> list) {
		Iterator<Integer> itr = temp.iterator();

		while (itr.hasNext()) {
			Integer temp = itr.next();
			if (!list.contains(temp)) {
				itr.remove();
				list.remove(temp);
			}
		}
	}

	public void print() {
		System.out.println(temp);
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> input = new ArrayList<>();
		input.add(new ArrayList<>(Arrays.asList(-5, -4, 1, 6, 2)));
		input.add(new ArrayList<>(Arrays.asList(1, 2, 5, -5, 4)));
		input.add(new ArrayList<>(Arrays.asList(-4, -5, 10, 1, 2)));

//		for (int i = 1; i < input.size(); i++)
//			input.get(0).retainAll(input.get(i));
//		
//		System.out.println(input.get(0));

		ArrayIntersectionAlt ob = new ArrayIntersectionAlt(input.get(0));

		for (int i = 1; i < input.size(); i++)
			ob.findIntersection(input.get(i));

		ob.print();
	}
}
