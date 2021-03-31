package DataStructures.List;

import java.util.StringJoiner;

class Node{
    int value;
    Node next;
    Node(){
        this.next = null;
    }

    Node(int value){
        this.value = value;
    }
    Node(int value,Node next){
        this.value = value;
        this.next = next;
    }
}
public class SinglyLinkedList {
    // 虚拟头节点，不存放元素
    private Node head;
    private int size;

    private SinglyLinkedList(){
        head = new Node();
        size = 0;
    }
    private SinglyLinkedList(Node head,int size){
        this.head = head;
        this.size = size;
    }

    public boolean inBounds(int index, int start, int end){
        if(index<start || index > end){
            throw new IndexOutOfBoundsException(index + "");
        }else
            return true;
    }

    public void insertHead(int data){
        insertByindex(0,data);
    }
    public void insertTail(int data){
        insertByindex(size+1,data);
    }
    public void insertByindex(int index,int data){
        inBounds(index,0,size+1);
        Node node = new Node(data);
        if(head.next == null){
            head.next = node;
        }else if(index == 0){
            node.next = head.next;
            head.next = node;
        }else {
            Node cur = head;
            for(int i=0;i<index-1;i++){
                cur = cur.next;
            }
            node.next = cur.next;
            cur.next = node;
        }
        size++;
    }

    public void deleteHead(){
        deleteByindex(1);
    }
    public void deleteTail(){
        deleteByindex(size);
    }
    public void deleteByindex(int index){
        inBounds(index,1,size);
        Node cur = head;
        for(int i=0;i<index-1;i++){
            cur = cur.next;
        }
        Node destroy = cur.next;
        cur.next = cur.next.next;
        destroy = null;
        size--;
    }
    public void clear(){
        Node cur = head;
        while(cur != null){
            Node prev = cur;
            cur = cur.next;
            prev = null;
        }
        head = null;
        size =0;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){
        return size;
    }
    public Node getHead(){
        return head;
    }
    public boolean search(int data){
        Node cur = head.next;
        while (cur!=null){
            if(cur.value==data)
                return true;
        }
        return false;
    }
    public int getByindex(int index){
        Node cur = head;
        for(int i=0;i<index;i++){
            cur = cur.next;
        }
        return cur.value;
    }
    public String toString(){
        StringJoiner joiner = new StringJoiner("->");
        Node cur = head.next;
        while(cur!=null){
            joiner.add(cur.value + "");
            cur = cur.next;
        }
        return joiner.toString();
    }
    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

        singlyLinkedList.insertTail(1);
        singlyLinkedList.insertTail(2);


        singlyLinkedList.insertHead(9);
        singlyLinkedList.insertHead(8);

        singlyLinkedList.insertByindex(3,7);

        System.out.println(singlyLinkedList.toString());
        System.out.println(singlyLinkedList.getByindex(3));

        singlyLinkedList.deleteHead();
        System.out.println(singlyLinkedList.toString());

        singlyLinkedList.deleteTail();
        System.out.println(singlyLinkedList.toString());

        singlyLinkedList.deleteByindex(1);
        System.out.println(singlyLinkedList.toString());

    }
}
