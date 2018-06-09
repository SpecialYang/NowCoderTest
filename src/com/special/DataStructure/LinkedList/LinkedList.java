package com.special.DataStructure.LinkedList;

import java.util.Scanner;

/**
 * Created by Special on 2018/6/8 11:43
 */
public class LinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
    static ListNode head;

    /**
     * 仅用一个指针删除指定节点
     * @param value
     * @return
     */
    public static ListNode removeListNode(int value) {
        if(head == null) {
            return null;
        }
        ListNode removedNode = null;
        //当链表的第一个节点就是目标节点
        if(head.val == value) {
            removedNode = head;
            head = head.next; //修改头指针
        } else { //目标节点不是第一个节点的情况
            ListNode p = head;
            //找到目标节点的前一个节点
            while(p.next != null && p.next.val != value) {
                p = p.next;
            }
            if(p.next != null) {
                removedNode = p.next;
                p.next = p.next.next;
            }
        }
        return removedNode;
    }

    /**
     * 打印链表
     * @param p
     * @return
     */
    public static String toString(ListNode p){
        StringBuilder sb = new StringBuilder();
        while(p != null) {
            sb.append(p.val);
            sb.append(" ");
            p = p.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()) {
            int n = input.nextInt();
            head = new ListNode(input.nextInt());
            //头插法构成链表
            for(int i = 1; i < n; i++) {
                ListNode node = new ListNode(input.nextInt());
                node.next = head;
                head = node;
            }
            System.out.println(toString(head));
            int target = input.nextInt();
            ListNode removedNode = removeListNode(target);
            System.out.println(removedNode.val);
            System.out.println(toString(head));
        }
    }
}
