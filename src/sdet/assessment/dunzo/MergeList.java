package sdet.assessment.dunzo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

import org.junit.Test;

/*
Method 1:
	ListNode dummy = new ListNode(-1);
	dummy.next = list1;
	ListNode fast = dummy;
    ListNode slow = dummy;
    
    while(a-- > 0) slow = slow.next;
    while(b-- >= 0) fast = fast.next;
    
    ListNode p = list2;
    while(p.next != null) p = p.next;
    
    slow.next = list2;
    p.next = fast.next;
    fast.next = null;
    return dummy.next;
*/

/*
Method 2:

	if(list1 == null && list2 == null){
        return null;
    }
    else if(list1 == null){
        return list2;
    }
    else if(list2 == null){
        return list1;
    }
    
    ListNode dummy = new ListNode(0);
    dummy.next = list1;
    ListNode back = dummy;
    ListNode front = dummy;
    
    for(int i = 1; i < a; i++){
        back = back.next;
    }
    for(int i = 0; i < b; i++){
        front = front.next;
    }
    back.next = front.next;
    
    back.next = list2;
    while(list2.next != null){
        list2 = list2.next;
    }
    
    list2.next = front.next;
    
    return dummy.next;
 */

public class MergeList {

	@Test
	public void example1() {
		LinkedList<Integer> list1 = new LinkedList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(5);

		LinkedList<Integer> list2 = new LinkedList<>();
		list2.add(6);
		list2.add(7);
		list2.add(8);
		list2.add(9);

		int a = 2, b = 3;

		mergeList(list1, list2, a, b);
	}
	
	@Test
	public void example2() {
		LinkedList<Integer> list1 = new LinkedList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(5);

		LinkedList<Integer> list2 = new LinkedList<>();
		list2.add(6);
		list2.add(7);
		list2.add(8);
		list2.add(9);

		int a = 2, b = 3;

		mergeList(list1, list2, a, b);
	}

	private LinkedList<Integer> mergeList(LinkedList<Integer> list1, LinkedList<Integer> list2, int a, int b) {
		if(list1==null && list2==null)
			return null;
		else if(list2==null || a>list1.size())
			return list1;
		else if(list1==null)
			return list2;
		
		LinkedList<Integer> output = new LinkedList<>();
		int p1 = 0, p2 = 0;

		while (p1 < list1.size()) {
			if (p1 < a - 1 || p1 >= b)
				output.add(list1.listIterator(p1++).next());
			else {
				while (p2 < list2.size())
					output.add(list2.listIterator(p2++).next());
				p1 = b;
			}
		}

		return output;
	}
}
