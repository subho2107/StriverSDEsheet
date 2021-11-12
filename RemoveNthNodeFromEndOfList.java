//problem link:https://leetcode.com/problems/remove-nth-node-from-end-of-list/
import java.io.*;
import java.util.*;

public class RemoveNthNodeFromEndOfList {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //Time Complexity:O(2*n)
    //Space complexity: O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode dup = head;
        while(dup != null){
            length++;
            dup = dup.next;
        }
        if(n == length)
            return head.next;
        dup = head;
        int cnt = 0;
        while(dup != null){
            cnt++;
            if(cnt == length-n){
                dup.next = dup.next.next;
                break;
            }
            dup = dup.next;
        }
        return head;
    }
    //Time Complexity:O(n)
    //Space complexity: O(1)
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        for(int i = 0; i < n; i++)
            fast = fast.next;
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
