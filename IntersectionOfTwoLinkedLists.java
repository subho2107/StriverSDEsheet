//problem link:https://leetcode.com/problems/intersection-of-two-linked-lists/
import java.io.*;
import java.util.*;

public class IntersectionOfTwoLinkedLists {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //Time Complexity:O(2*(m+n))
    //Space complexity: O(1)
    public ListNode getIntersectionNode4(ListNode headA, ListNode headB) {
        ListNode dupA = headA, dupB = headB;
        while(dupA != dupB)
        {
            dupA = dupA == null ? headB:dupA.next;
            dupB = dupB == null?headA:dupB.next;
        }
        return dupA;
    }
    //Time Complexity:O(m+n)
    //Space complexity: O(max(m, n))
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        ListNode dupA = headA, dupB = headB;
        Set<ListNode>addresses = new HashSet<>();
        while(dupA != null){
            addresses.add(dupA);
            dupA = dupA.next;
        }
        while(dupB != null){
            if(addresses.contains(dupB))
                return dupB;
            dupB = dupB.next;
        }
        return null;
    }
    //Time Complexity:O(m*n)
    //Space complexity: O(1)
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode dupA = headA, dupB = headB;
        while(dupA != null){
            dupB = headB;
            while(dupB != null){
                if(dupA == dupB)
                    return dupA;
                dupB = dupB.next;
            }
            dupA = dupA.next;
        }
        return null;
    }
    //Time Complexity:O(2*(m+n))
    //Space complexity: O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ans = null;
        if(headA == null || headB == null)
            return null;
        ListNode dupA = headA, dupB = headB;
        while(dupA != null || dupB != null){
            if((dupA != null && dupB != null) && dupA == dupB){
                ans = dupA;
                break;
            }
            else if(dupA != null && dupA.val < 0){
                ans = dupA;
                break;
            }
            else if(dupB != null && dupB.val < 0){
                ans = dupB;
                break;
            }
            if(dupB != null)
            {
                dupB.val *= -1;
                dupB = dupB.next;
            }
            if(dupA != null)
            {
                dupA.val *= -1;
                dupA = dupA.next;
            }
        }
        dupA = headA;
        dupB = headB;
        while(dupA != null || dupB != null){
            if(dupA != null && dupA.val < 0)
                dupA.val *= -1;
            if(dupB != null && dupB.val < 0)
                dupB.val *= -1;

            if(dupB != null)
                dupB = dupB.next;

            if(dupA != null)
                dupA = dupA.next;
        }
        return ans;
    }

}
