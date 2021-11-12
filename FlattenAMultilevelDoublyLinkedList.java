//problem link:https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
import java.io.*;
import java.util.*;

public class FlattenAMultilevelDoublyLinkedList {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
    //Time Complexity:O(n)
    //Space complexity: O(1)
    public Node flatten(Node head) {
        if(head == null)
            return head;
        Node dup = head;
        while(dup != null){
            if(dup.child != null){
                Node temp = dup.child;
                while(temp.next != null)
                    temp = temp.next;
                temp.next = dup.next;
                if(dup.next != null)
                    dup.next.prev = temp;
                dup.next = dup.child;
                dup.child.prev = dup;
                dup.child = null;
            }
            dup = dup.next;
        }
        return head;
    }
}
