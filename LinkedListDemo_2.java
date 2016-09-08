package com.datastructure;

/**
 * Created by tinhv on 08/09/2016.
 */
public class LinkedListDemo {
    private Node head;

    private static class Node{
        int data;
        Node next;

        public Node(){}

        public Node(int data){
            this.data = data;
        }
    }


    Node insertNodeToHead(Node head,int x) {
        Node node1 =new Node();

        node1.data = x;
        node1.next= head;
        return node1;
    }


    Node insertNodeToLast(Node head,int data) {

        Node tmp = new Node();
        tmp.data = data;
        tmp.next = null;
        if(head == null) {
            head = tmp;
            return head;
        }

        Node current = head;
        while(current.next != null) {
            current = current.next;
        }
        current.next = tmp;
        return head;

    }

    void printNode(Node head) {
        Node temp = head;

        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public boolean hasCycle(){
        Node fast = head;
        Node slow = head;

        while(slow != null && fast != null && fast.next != null){
            slow = slow.next.next;
            fast = fast.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        LinkedListDemo list = new LinkedListDemo();

        //Node node1 = new Node(2);



        //list.addNode(new Node(1));
        //list.addNode(node1);
        //list.addNode(new Node(2));
        //list.addNode(new Node(3));
        //list.addNode(new Node(4));
        //list.addNode(node1);



       //list.printNode();
        System.out.println(list.hasCycle());
    }
}

