package com.sss;

/**
 * package: com.sss
 * date: 2019/3/26 19:11
 *
 * @author smallcase
 * @since JDK 1.8
 */


public class reverseLinkedList {
    class Node{
        private Node next;
        private int val;

        public Node( int val) {
            this.val = val;
        }
    }

    /**
     * 头插法实现
     * @param root
     * @return
     */
    public Node headInsert(Node root){
        if (root==null||root.next==null) return root;
        Node head = new Node(-1);
        Node node,next;
        while (root.next!=null){
            node = root.next;
            next = head.next;
            head.next = root;
            root.next = next;
            root = node;
        }
        return head.next;
    }

    /**
     * 遍历方法实现
     * @param root
     * @return
     */
    public Node reverseList(Node root){
        if(root==null||root.next==null) return root;
        Node p = root.next;
        Node pre = root;
        Node next;
        while (p!=null){
            next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        root.next = null;
        return pre;
    }

    /**
     * 递归实现
     * @param head
     * @return
     */
    public Node reverRecursive(Node head){
        if (head==null||head.next==null) return head;
        Node node = recursive(head);
        head.next = null;
        return node;
    }
    private Node recursive(Node p){
        if (p.next==null){
            return p;
        }
        Node next = p.next;
        Node dot = recursive(next);
        next.next = p;
        return dot;
    }
}
