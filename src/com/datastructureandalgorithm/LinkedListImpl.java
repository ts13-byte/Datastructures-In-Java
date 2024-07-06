package com.datastructureandalgorithm;

import java.util.Scanner;

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
                while(current.next!=null && current.next.data!=data){
                    current=current.next;
                }
                current.next=current.next.next;
            }
        }

        public void reverse(){
            Node current=head;
            Node nextNode=head;
            Node prev=null;
            while(current!=null)
            {
                nextNode=current.next;
                current.next=prev;
                prev=current;
                current=nextNode;
            }
            head=prev;
        }

        public void deleteAtAPos(int pos){
            if(pos==1){
                head=head.next;
            }else {
                Node current = head;
                for (int i = 1; i < pos - 1; i++) {
                    current = current.next;
                }
                current.next=current.next.next;
            }
        }
        public static void main(String[] args) {
          Scanner scanner=new Scanner(System.in);
          LinkedListImpl linkedList=new LinkedListImpl();

//          while(true){
//              System.out.println("enter an integer or press \"exit\" to exit: ");
//              String input=scanner.nextLine();
//              if(input.equalsIgnoreCase("exit")){
//                  break;
//              }
//              int number=Integer.parseInt(input);
//              linkedList.insertNewNode(number);
//          }

            while(true){
                System.out.println("enter an integer or type -1 to exit");
                int input= scanner.nextInt();
                if(input==-1){
                    break;
                }
                linkedList.insertNewNode(input);

            }
            scanner.close();
            linkedList.display();
            linkedList.deleteAtAPos(1);
            linkedList.display();

        }
    }


