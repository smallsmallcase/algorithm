package com.huj;

/**
 * @package: com.huj
 * @date: 2019/4/9 19:57
 * @author: smallcase
 * @description 各种版本的链表反转
 */
public class reverseList {

    static class Node{

        private Node next;
        private int val;
        Node(Node next,int val){
            this.next = next;
            this.val = val;
        }
    }

    /**
     * 普通循环，不会利用额外空间
     *
     * @param head
     * @return
     */
    public Node noSpace(Node head) {
        Node p = head;
        Node pre = null;
        Node next;
        while (p != null) {
            next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return pre;

    }

    public static void main(String[] args) {
        reverseList reverseList = new reverseList();
        Node node = new Node(new Node(new Node(new Node(null, 3), 4), 2), 1);
        Node node1 = reverseList.noSpace(node);
        System.out.println(node1);
        Node node2 = reverseList.noSpace(node1);
        System.out.println(111);

    }


    /**
     * 头插法，利用额外空间
     *
     * @param head
     * @return
     */
    public Node insertHead(Node head) {
        Node node = new Node(null, -1);
        Node next, preNext;
        while (head != null) {
            next = head.next;

            preNext = node.next;
            node.next = head;
            head.next = preNext;

            head = next;
        }

        return node.next;
    }


    /**
     * 递归法
     *
     * @param node
     * @return
     */
    public Node reverse(Node node) {
        if (node.next == null) {

            return node;
        }

        Node head = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return head;
    }

}
