package org.homework;


import org.w3c.dom.Node;


//
//public class Hw3 {
//    public static Node reverseLinkedList(Node head) {
//        Node prev = null;
//        Node current = head;
//        Node next = null;
//        while (current != null) { // пока не дойдем до конца списка
//            next = current.next; // сохраняем следующий узел
//            current.next = prev; // меняем указатель next текущего узла на предыдущий узел
//            prev = current; // предыдущий узел теперь равен текущему узлу
//            current = next; // текущий узел теперь равен следующему узлу
//        }
//        return prev; // возвращаем новую голову списка
//    }
//
//    public static int nthNodeFromEnd(Node head, int n) {
//        if (head == null) {
//            return -1;
//        }
//        Node p = head;
//        Node q = head;
//        int count = 0;
//        while (count < n) {
//            if (q == null) {
//                return -1; // список содержит меньше n узлов
//            }
//            q = q.next;
//            count++;
//        }
//        while (q != null) {
//            p = p.next;
//            q = q.next;
//        }
//        return p.data;
//    }
//
//
//    public static void Main(String[] args) {
//
//
//        Node head = new Node(1);
//        head.next = new Node(2);
//        head.next.next = new Node(3);
//        head.next.next.next = new Node(4);
//
//        head = reverseLinkedList(head);
//
//        int nthFromEnd = nthNodeFromEnd(head, 2);
//        System.out.println(nthFromEnd); // выводит 2
//    }
//}