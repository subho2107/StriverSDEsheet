//problem link:https://leetcode.com/problems/merge-two-sorted-lists/
import java.io.*;
import java.util.*;

public class MergeTwoSortedLists {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //Time Complexity:O(n1+n2)
    //Space complexity: O(n1+n2)
    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        else if(l2 == null)
            return l1;
        ListNode ans = new ListNode(), head = ans, prev = ans;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                ans.val = l1.val;
                l1 = l1.next;
            }
            else{
                ans.val = l2.val;
                l2 = l2.next;
            }
            prev = ans;
            ans.next = new ListNode();
            ans = ans.next;
        }
        while(l1 != null){
            ans.val = l1.val;
            l1 = l1.next;
            prev = ans;
            ans.next = new ListNode();
            ans = ans.next;
        }
        while(l2!= null){
            ans.val = l2.val;
            l2 = l2.next;
            prev = ans;
            ans.next = new ListNode();
            ans = ans.next;
        }
        prev.next = null;
        return head;
    }
    //Time Complexity:O(n1+n2)
    //Space complexity: O(1)
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        else if(l2 == null)
            return l1;
        ListNode ans = new ListNode(0);
        if (l1.val > l2.val){
            ListNode temp = l1;
            l1 = l2;
            l2 =  temp;
        }
        ans = l1;
        while (l1 != null && l2 != null){
            ListNode temp = null;
            while (l1 != null && l1.val <= l2.val){
                temp = l1;
                l1 = l1.next;
            }
            temp.next = l2;

            temp = l1;
            l1 = l2;
            l2 = temp;
        }
        return ans;
    }
    //Time Complexity:O(n1+n2)
    //Space complexity: O(1)
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        else if(l2 == null)
            return l1;
        ListNode ans = null, ansDup;
        if(l1.val < l2.val){
            ans = l1;
            l1 = l1.next;
        }
        else{
            ans = l2;
            l2 = l2.next;
        }
        ansDup = ans;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                ans.next = l1;
                l1 = l1.next;
            }
            else{
                ans.next = l2;
                l2 = l2.next;
            }
            ans = ans.next;
        }
        if(l1 != null)
            ans.next = l1;
        else
            ans.next = l2;
        return ansDup;
    }
}
