package org.example.datastruct;

/**
 * 双向链表
 * <p>
 * 双向链表的优点：
 * 1.如果我们有指向任何节点的指针，那么我们可以进行反向查询。仅需一个指针，我们就可以
 * 查看当前Node，下一个node以及前一个node。
 * 在很多情况下，查看上一个node的能力使我们的生活变得更轻松，甚至删除等某一些操作的实现也变得容易得多。
 * 如果仅使用一个指针，即指向要删除得节点得指针。
 * <p>
 * 缺点： 我们必须为上一个节点指针使用额外得内存。对于整型得链表，假设整形在典型体系结构中占用4个字节，
 * <p>
 * 指针也占用4个字节，指针变量也占用4个字节，则 在单链表中每个节点将是8个字节：4个用于数据，4个用于链接到下一个节点，
 * 在双向链表中，每个节点为12个字节。我们将使用4个字节得数据和8个字节的链接，对于整型的链表，链接要比数据花 两倍的空间
 */
public class DoubleLinkedList {

    Node head;

    public Node structNode(int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.pre = null;
        newNode.next = null;
        return newNode;
    }

    public void insertAtHead(int data) {
        Node newNode = structNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        // 置换， 当前头部节点的 前置节点指向 创建的节点
        head.pre = newNode;
        //新节点的后置节点指向 当前的头部节点
        newNode.next = head;
        // 全局变量 head 指向新的节点
        head = newNode;
        return;
    }

    public void print() {
        Node tempNode = head;
        while (tempNode != null) {
            System.out.println(tempNode.data);
            tempNode = tempNode.next;
        }
        System.out.println(10);
    }


    class Node {
        private int data;
        private Node pre;
        private Node next;
    }

}
