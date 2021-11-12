//problem link:https://leetcode.com/problems/reverse-linked-list/
import java.io.*;
import java.util.*;

public class ReverseLinkedList {
    //Time Complexity:O(n)
    //Space complexity: O(1)
    class ListNode{
        int val;
        ListNode next;
    }
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
