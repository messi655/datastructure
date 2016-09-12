package com.datastructure;

/**
 * Created by tinhv on 08/09/2016.
 */
public class LinkedListDemo {
    private Node head;

    private static class Node{
        private int data;
        private Node next;

        Node(int data){
            this.data = data;
        }
    }

    public void addNodetoList(Node node){
        if(head == null){
            head = node;
        } else{
            Node temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }
    
    public Node deleteheadNode(){
        Node temp = head;

        head = temp.next;

        return temp;
    }

    public Node deletePositionNode(Node head, int position){
        if(head == null){
            return head;
        }
        if(position == 0){
            head = head.next;
            return head;
        }

        int counter = 0;
        Node temp = head;
        while(temp != null){
            if((counter + 1) == position){
                temp.next = temp.next.next;
                break;
            }
            counter++;
            temp = temp.next;
        }
        return head;
    }


    public void printList(){
        Node temp = head;

        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println();
    }

    public boolean isLoop(){
        Node fast = head;
        Node slow = head;

        while (fast != null && slow != null & fast.next != null){
            fast = fast.next;
            slow = slow.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        LinkedListDemo link = new LinkedListDemo();

        link.addNodetoList(new Node(5));
        link.addNodetoList(new Node(6));
        //link.addNodetoList(node);
        link.addNodetoList(new Node(7));
        link.addNodetoList(new Node(8));
        //link.addNodetoList(node);

        link.printList();
        System.out.println(link.isLoop());
    }
}

