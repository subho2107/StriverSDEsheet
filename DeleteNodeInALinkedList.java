//problem link:https://leetcode.com/problems/delete-node-in-a-linked-list/
import java.io.*;
import java.util.*;

public class DeleteNodeInALinkedList {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //Time Complexity:O(1)
    //Space complexity: O(1)
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
