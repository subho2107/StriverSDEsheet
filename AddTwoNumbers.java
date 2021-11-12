//problem link:https://leetcode.com/problems/add-two-numbers/
import java.io.*;
import java.util.*;

public class AddTwoNumbers {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //Time Complexity:O(max(m, n))
    //Space complexity: O(max(m, n))
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode ans = new ListNode(), dup = ans, prev = ans;
        while(l1 != null || l2 != null || carry != 0){
            int num = (l1 != null?l1.val:0)+ (l2!=null?l2.val:0) + carry;
            carry = num/10;
            ans.val = num%10;
            ans.next = new ListNode();
            prev = ans;
            ans = ans.next;
            l1 = l1 != null?l1.next:null;
            l2 = l2 != null?l2.next:null;
        }
        prev.next = null;
        return dup;
    }
}
