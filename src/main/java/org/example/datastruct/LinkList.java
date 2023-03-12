package org.example.datastruct;

public class LinkList {

    /**
     * 头部节点
     */
    public Node head;

    /**
     * 在头部插入节点
     * 时间复杂度O(1), 因为所有节点的插入都是从头部开始 ，
     * 也就是当新节点插入时，先把新节点的 next节点连接到原来的头部，然后再把新节点 设置为头部节点
     *
     * @param data
     */
    public void insert(int data) {
        Node temp = new Node();
        temp.data = data;
        temp.next = head;
        head = temp;
    }

    /**
     * 指定位置插入节点
     *
     * @param data
     * @param n
     */
    public void insert(int data, int n) {
        //先创建节点
        Node temp1 = new Node();
        temp1.data = data;
        temp1.next = null;
        //case1：当指定位置时 1 , 那应该插入头部节点
        if (n == 1) {
            temp1.next = head;
            head = temp1;
            return;
        }
        //case2: 指定位置>1 ,  要插入的位置应该时 position - 1 , 相当于把position 原来的节点往后移
        Node temp2 = head;
        for (int i = 0; i < n - 2; i++) {
            temp2 = temp2.next;
        }
        // 将新节点链接到 指定位置的节点的后置节点
        temp1.next = temp2.next;
        // 断开指定位置节点的链接，将原节点的链接指向 新节点
        temp2.next = temp1;

    }

    /**
     * 插入尾部节点
     *
     * @param head
     * @param data
     * @return
     */
    public Node insert(Node head, int data) {
        Node temp = new Node();
        temp.data = data;
        temp.next = null;
        if (head == null) {
            head = temp;
        } else {
            Node temp1 = head;
            while (temp1.next != null) temp1 = temp1.next;
            temp1.next = temp;
        }
        return head;
    }


    /**
     * 删除指定位置的节点
     *
     * @param n
     */
    public void delete(int n) {
        if (n == 1) {
            Node temp = head;
            head = head.next;
            temp = null;
            return;
        }
        //找到指定位置所在节点
        Node temp1 = head;
        for (int i = 0; i < n - 2; i++) {
            temp1 = temp1.next;
        }
        // temp1.next 是要删除的节点，缓存temp1的 next节点，以便修复链表
        Node temp2 = temp1.next;
        //修复节点，链接到被删除节点的后置节点
        temp1.next = temp2.next;
        //GC 回收
        temp2 = null;
        return;
    }

    /**
     * 打印节点信息
     */
    public void print() {
        Node temp = head;
        while (temp.next != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print(temp.data);
    }

    /**
     * 递归打印节点信息
     *
     * @param p
     */
    public void print(Node p) {
        if (p == null) return;
        System.out.print(p.data);
        if (p.next != null) System.out.print(" -> ");
        print(p.next);
    }

    /**
     * 链表反转
     * 方式1  用迭代进行反转
     * 方式2 用叠轨进行反转
     * <p>
     * 输入： head -> 2 -> 4 -> 6 -> 5 -> null
     * 输出： null <- 2 <- 4 <- 6 <- 5 <- head
     */
    public Node reverse() {
        Node current, pre, next;
        current = head;
        pre = null;
        while (current != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        head = pre;
        return head;
    }

    /**
     * 链表节点
     */
    class Node {
        int data;
        Node next;
    }

    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        /**
         *

        linkList.insert(2);
        linkList.insert(5);
        linkList.insert(7);
        linkList.insert(8);
        linkList.insert(9);
        linkList.print();

        linkList.reverse();
        System.out.println("\n");

         */
        Node head = null;
        head = linkList.insert(head, 2);
        head = linkList.insert(head, 5);
        head = linkList.insert(head, 7);
        head = linkList.insert(head, 8);
        head = linkList.insert(head, 9);
        linkList.print(head);

    }
}
