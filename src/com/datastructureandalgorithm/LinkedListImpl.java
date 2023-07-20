package com.datastructureandalgorithm;
class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next=null;
        }
    }
    public class LinkedListImpl {
        Node head;

        public LinkedListImpl() {
            this.head = null;
        }

        public void insertNewNode(int data){
            Node newNode=new Node(data);
            if(head==null) {
                head=newNode;
            }else {
                Node current=head;
                while(current.next!=null){
                    current=current.next;
                }
                current.next=newNode;
            }

        }
        public void display() {
            Node current = head;
            if (current == null) {
                System.out.println("No node is present in the linked list!");
            } else {
                while (current.next != null) {
                    System.out.print(current.data + "->");
                    current = current.next;
                }
                System.out.print(current.data);
                System.out.println();
            }
        }
        public void delete(int data){
            if(head==null) {
                System.out.println("This linked list is empty!!");

            }
            else if(head.data==data){
                head=head.next;
            }
            else{
                Node current=head;
                Node previous=null;
                while(current!=null && current.data!=data){
                    previous=current;
                    current=current.next;
                }
                if(current!=null){
                    previous.next=current.next;
                }else{
                    System.out.println("Node could not be found!!");
                }
            }

        }



        public static void main(String[] args) {
            LinkedListImpl linkedList=new LinkedListImpl();
            linkedList.insertNewNode(1);
            linkedList.insertNewNode(2);
            linkedList.insertNewNode(3);
            linkedList.insertNewNode(4);
            linkedList.delete(3);
            linkedList.delete(1);
            linkedList.delete(2);
            linkedList.delete(4);
            linkedList.display();

        }
    }


