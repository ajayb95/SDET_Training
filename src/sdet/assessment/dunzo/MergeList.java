package sdet.assessment.dunzo;

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
    for(int i = 1; i < b; i++){
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

}
