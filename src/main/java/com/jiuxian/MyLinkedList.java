package com.jiuxian;

/**
 * @author: liuzejun
 * *
 * @email: 857591294@qq.com
 * *
 * @date: 2019-07-04 17:34:54
 * *
 * @description:
 **/
public class MyLinkedList<T> {

    private Node<T> first;
    private Node<T> last;

    public void addLast(T data) {
        final Node<T> l = last;
        final Node<T> newNode = new Node<>(data, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
    }

    public void print() {
        if (this.last == null) {
            return;
        }
        Node node = this.first;
        while (node != null) {
            System.out.print(node.data + "\t");
            node = node.next;
        }
    }


    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }


    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.addLast("A");
        list.addLast("b");
        list.addLast("C");
        list.print();
    }
}
